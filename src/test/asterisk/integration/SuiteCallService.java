package test.asterisk.integration;

import java.io.IOException;

import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;

import test.asterisk.constant.Config;

/**
 * Class responsible for create connection with server Asterisk.
 * @author Marcos Bahiense
 *
 */
public class SuiteCallService {

	private static SuiteCallService service = new SuiteCallService();
	private ManagerConnection managerConnection;
	
	private SuiteCallService(){
		ManagerConnectionFactory factory = new ManagerConnectionFactory(Config.URL_SERVER, Config.USER, Config.PASS);
        this.managerConnection = factory.createManagerConnection();
	}
	
	public static SuiteCallService getInstance(){
		return service;
	}
	
	public ManagerConnection getManager(){
		return managerConnection;
	}
	
	public void login(){
		try {
			managerConnection.login();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void logoff(){
		managerConnection.logoff();
	}
	
	public ManagerResponse sendAction(OriginateAction action, Integer timeout) throws IllegalArgumentException, IllegalStateException, IOException, Exception{
		return managerConnection.sendAction(action, 30000);
	}
}
