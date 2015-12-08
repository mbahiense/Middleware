package test.asterisk.cases;

import static org.junit.Assert.fail;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import test.asterisk.constant.ServicosEnum;
import test.asterisk.integration.SuiteAsteriskListener;
import test.asterisk.integration.SuiteCallService;

/**
 * 
 * This class is responsible for run test of integration with Asterisk and GSAN.
 * evaluate service:
 * 		Obter 2ª via de Conta.
 * 
 * Simulate send call with parameters fixed valid.
 * 
 * @author Marcos Bahiense
 *
 */
public class TestObterSegundaViaConta implements PropertyChangeListener{
	
	private ManagerConnection manager;
	private SuiteCallService callService;
	private boolean hasResponse = false; 

	@Before
	public void login(){
		System.out.println("Login");
		SuiteCallService.getInstance().login();
		callService = SuiteCallService.getInstance();
	}
	
	@Test
	public void primeiroCenarioTest() {
		System.out.println("Obter 2º via de conta - Cenário 1");
		final String imovelTest = "1368124"; 
		executeContextTest(imovelTest);
	}
	
	@Test
	public void segundoCenarioTest() {
		System.out.println("Obter 2º via de conta - Cenário 2");
		final String imovelTest = "80864";
		executeContextTest(imovelTest);
	}
	
	@Test
	public void terceiroCenarioTest() {
		System.out.println("Obter 2º via de conta - Cenário 3");
		final String imovelTest = "13704001"; 
		executeContextTest(imovelTest);
	}
	
	private void executeContextTest(final String imovelTest ){
		
        ManagerResponse originateResponse;       
        OriginateAction originateAction = new OriginateAction();
        originateAction.setChannel("LOCAL/s@TESTE_OBTER_SEGUNDA_VIA");
        originateAction.setContext("disc-from-test");
        originateAction.setCallerId("7000");
        originateAction.setExten("1");
        originateAction.setPriority(new Integer(1));
        originateAction.setVariable(ServicosEnum.ID_IMOVEL, imovelTest);
        
        try {
			
        	// envia a originate action e aguarda no máximo 30 segunso a resposta do Asterisk.
        	originateResponse = callService.sendAction(originateAction, 30000);
        	System.out.println("Status:"  + originateResponse);
        	// important for wait close old clannels
        	Thread.sleep(1000);
        	SuiteAsteriskListener.getInstance().addListener(this);
        	 
            while(!hasResponse()){
//            	 aguarda criação do channel
            }

            final String situacaoText = SuiteAsteriskListener.getInstance().getVariavel(ServicosEnum.SITUACAO);
    		
        	//verifica o resultado da solicitação
        	Assert.assertTrue("SUCESSO".equals(situacaoText));
        	
        } catch (Exception e) {
        	e.printStackTrace();
			fail("Falha no servico - Obter 2.via de conta.\n" + e.getLocalizedMessage());
		}
	}
	
	
	@After
	public void logoff(){
		System.out.println("Logoff");
		SuiteCallService.getInstance().logoff();
	}

	/* (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent event) {
		System.out.println(event);
		setResponse(true);
		SuiteAsteriskListener.getInstance().removeListener(this);
	}
	
	/**
	 * Set o status do response.
	 * @param status
	 */
	private synchronized void setResponse(boolean status){
		this.hasResponse = status;
	}
	
	/**
	 * Get o status do response.
	 * @return status
	 */
	private synchronized boolean hasResponse(){
		return this.hasResponse;
	}
}
