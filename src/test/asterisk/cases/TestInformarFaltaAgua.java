package test.asterisk.cases;

import static org.junit.Assert.fail;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import test.asterisk.constant.ServicosEnum;
import test.asterisk.integration.SuiteAsteriskListener;
import test.asterisk.integration.RAHelper;
import test.asterisk.integration.SuiteCallService;

/**
 * 
 * This class is responsible for run test of integration with Asterisk and GSAN.
 * evaluate service:
 * 		Informar Falta de Agua.
 * 
 * Simulate send call with parameters fixed valid.
 * 
 * @author Marcos Bahiense
 *
 */
public class TestInformarFaltaAgua implements PropertyChangeListener{

	ManagerConnection manager;
	boolean hasResponse = false; 
	AsteriskChannel canal;
	String imovelTest;
	
	@Before
	public void login(){
		SuiteCallService.getInstance().login();
		manager = SuiteCallService.getInstance().getManager();
		SuiteAsteriskListener.getInstance();
	}
	
	@Test
	public void primeiroCenarioTest() {
		imovelTest = "1276833";
		executeContext(imovelTest);
	}
	
	@Test
	public void segundoCenarioTest() {
		imovelTest = "13702840";
		executeContext(imovelTest);
	}
	
	@Test
	public void terceiroCenarioTest() {
		imovelTest = "13704001";
		executeContext(imovelTest);
	}
	
	public void executeContext(String imovelTest) {
        
		final String RA = RAHelper.obterRA(imovelTest);
        ManagerResponse originateResponse;       
        
        OriginateAction originateAction = new OriginateAction();
        
        // Local Channel - extesion/context
        originateAction.setChannel("LOCAL/s@TESTE_INFORMAR_FALTA_AGUA");
        originateAction.setContext("disc-from-test");
        originateAction.setCallerId("7000");
        originateAction.setExten("1");
        originateAction.setPriority(new Integer(1));
        originateAction.setVariable(ServicosEnum.ID_IMOVEL, imovelTest);
        originateAction.setVariable(ServicosEnum.RA, RA );
 
        try {
			
        	// send action e wait for response server.
        	originateResponse = manager.sendAction(originateAction, 30000);
        	System.out.println("Status:"  + originateResponse.getResponse());
        	
        	
        	Thread.sleep(1000);
        	SuiteAsteriskListener.getInstance().addListener(this);
        	
            while(!hasResponse()){
           	 	//wait for update Parameter's in channel.
             }
        	
            String situacaoText = SuiteAsteriskListener.getInstance().getVariavel(ServicosEnum.SITUACAO);
    		System.out.println("SITUACAO: " + situacaoText);
    		
        	//verifica o resultado da solicitação
        	Assert.assertTrue("SUCESSO".equals(situacaoText));
        	
        } catch (Exception e) {
			fail("Falha no servico - Informar Falta de Agua.\n" + e.getLocalizedMessage());
		}
	}
	
	
	@After
	public void logoff(){
		SuiteCallService.getInstance().logoff();
	}

	/* (non-Javadoc)
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent event) {
		setResponse(true);
	}
	
	/**
	 * Set status.
	 * @param status
	 */
	private synchronized void setResponse(boolean status){
		this.hasResponse = status;
	}
	
	/**
	 * Get status.
	 * @return status
	 */
	private synchronized boolean hasResponse(){
		return this.hasResponse;
	}
}
