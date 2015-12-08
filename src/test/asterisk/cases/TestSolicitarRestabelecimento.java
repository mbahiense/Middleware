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
import test.asterisk.integration.RAHelper;
import test.asterisk.integration.SuiteCallService;

/**
 * 
 * This class is responsible for run test of integration with Asterisk and GSAN.
 * evaluate service:
 * 		Solicitar Restabelecimento.
 * 
 * Simulate send call with parameters fixed valid.
 * 
 * @author Marcos Bahiense
 *
 */
public class TestSolicitarRestabelecimento implements PropertyChangeListener {

	ManagerConnection manager;
	boolean hasResponse = false; 
	String imovelTest; // 79545,79612,79616,1369352
	
	@Before
	public void login(){
		SuiteCallService.getInstance().login();
		manager = SuiteCallService.getInstance().getManager();
		SuiteAsteriskListener.getInstance();
	}
	
	@Test
	public void primeiroCenariotest() {
		imovelTest = "1239723";
		executarContextTest(imovelTest);
	}
	
	@Test
	public void segundoCenariotest() {
		imovelTest = "80166";
		executarContextTest(imovelTest);
	}
	
	@Test
	public void terceiroCenariotest() {
		imovelTest = "13702572";
		executarContextTest(imovelTest);
	}
	
	public void executarContextTest(String imovelTest) {
        ManagerResponse originateResponse;       
        OriginateAction originateAction = new OriginateAction();
        originateAction.setChannel("LOCAL/s@TESTE_SOLICITAR_RESTABELECIMENTO");
        originateAction.setContext("disc-from-test");
        originateAction.setCallerId("7000");
        originateAction.setExten("1");
        originateAction.setPriority(new Integer(1));
        originateAction.setVariable(ServicosEnum.ID_IMOVEL, imovelTest);
        originateAction.setVariable(ServicosEnum.RA, RAHelper.obterRA(imovelTest));
 
        try {
			
        	originateResponse = manager.sendAction(originateAction, 30000);
        	System.out.println("Status:"  + originateResponse.getResponse());
        	
        	Thread.sleep(1000);
        	SuiteAsteriskListener.getInstance().addListener(this);
            
        	while(!hasResponse()){
            	 // aguarda response
              }
        	
             final String situacaoText = SuiteAsteriskListener.getInstance().getVariavel(ServicosEnum.SITUACAO);
     		
         	//verifica o resultado da solicitação
         	Assert.assertTrue("SUCESSO".equals(situacaoText));
        	
        } catch (Exception e) {
			fail("Falha no servico - Solicitar Restabelecimento da Ligacao.\n" + e.getLocalizedMessage());
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
	 * Set status of response.
	 * @param status
	 */
	private synchronized void setResponse(boolean status){
		this.hasResponse = status;
	}
	
	/**
	 * Get status of response.
	 * @return status
	 */
	private synchronized boolean hasResponse(){
		return this.hasResponse;
	}
	
}
