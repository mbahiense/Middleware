package test.asterisk.cases;

import static org.junit.Assert.fail;

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
import test.asterisk.integration.SuiteCallService;

/**
 * 
 * This class is responsible for run test of integration with Asterisk and GSAN.
 * evaluate service:
 * 		Pesquisar Cliente.
 * 
 * Simulate send call with parameters fixed valid.
 * 
 * @author Marcos Bahiense
 *
 */
public class TestPesquisarCliente  {

	ManagerConnection manager;
	
	@Before
	public void login(){
		SuiteCallService.getInstance().login();
		manager = SuiteCallService.getInstance().getManager();
		SuiteAsteriskListener.getInstance();
	}
	
	@Test
	public void test() {
        
        ManagerResponse originateResponse;       
        
        OriginateAction originateAction = new OriginateAction();
        // Local Channel - extesion/context
        originateAction.setChannel("LOCAL/s@TESTE_PESQUISAR_CLIENTE");
        originateAction.setContext("disc-from-test");
        originateAction.setCallerId("7000");
        originateAction.setExten("1");
        originateAction.setPriority(new Integer(1));
        originateAction.setVariable(ServicosEnum.CLIENTE_IMOVEL, "13701843");
 
        try {
			
        	originateResponse = manager.sendAction(originateAction, 30000);
        	System.out.println("Status:"  + originateResponse.getResponse());
        	
        	AsteriskChannel canal = SuiteAsteriskListener.getInstance().getChannel();
        	
        	Assert.assertTrue("SUCESSO".equals(canal.getVariable(ServicosEnum.SITUACAO)));
        	Assert.assertNotNull(canal.getVariable(ServicosEnum.ID_IMOVEL));
        	Assert.assertNotNull(canal.getVariable(ServicosEnum.RA));
        	
        } catch (Exception e) {
			fail("Falha no servico de pesquisar cliente.\n" + e.getLocalizedMessage());
		}
	}
	
	@After
	public void logoff(){
		SuiteCallService.getInstance().logoff();
	}
}
