package test.asterisk.integration;

import java.beans.PropertyChangeListener;
import java.util.List;

import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.live.AsteriskQueueEntry;
import org.asteriskjava.live.AsteriskServer;
import org.asteriskjava.live.AsteriskServerListener;
import org.asteriskjava.live.DefaultAsteriskServer;
import org.asteriskjava.live.MeetMeUser;
import org.asteriskjava.live.internal.AsteriskAgentImpl;

import com.sun.tools.ws.wsdl.document.jaxws.Exception;

import test.asterisk.constant.Config;

public class SuiteAsteriskListener implements AsteriskServerListener{

	private static SuiteAsteriskListener listener = new SuiteAsteriskListener();

	private AsteriskServer asteriskServer;

	/**
	 * Get instance this class.
	 * 
	 * @return listener.
	 */
	public static SuiteAsteriskListener getInstance() {
		return listener;
	}

	/**
	 * Construct private for singleton.
	 */
	private SuiteAsteriskListener() {
		asteriskServer = new DefaultAsteriskServer(Config.URL_SERVER,
				Config.USER, Config.PASS);
		asteriskServer.addAsteriskServerListener(this);
	}

	/**
	 * Get current channel.
	 * 
	 * @return channel
	 */
	public AsteriskChannel getChannel() {
		AsteriskChannel canal = null;
		System.out.println("Canais: " + asteriskServer.getChannels().size());
		while (canal == null) {
			for (AsteriskChannel asteriskChannel : asteriskServer.getChannels()) {
				canal = asteriskChannel;
			}
		}
		return canal;
	}

	/**
	 * Register listener.
	 * 
	 * @return channel
	 * @throws InterruptedException 
	 */
	public void addListener(PropertyChangeListener listener) throws InterruptedException {
		System.out.println("Canais: " + asteriskServer.getChannels().size());
		while(asteriskServer.getChannels().size() != 2){
			Thread.sleep(100);
		}
		
		for (AsteriskChannel asteriskChannel : asteriskServer.getChannels()) {
			System.out.println(asteriskChannel.getName() + " - " + asteriskChannel.getId());
			asteriskChannel.addPropertyChangeListener(listener);
		}
	}
	
	/**
	 * Remove listener.
	 * 
	 * @return channel
	 */
	public void removeListener(PropertyChangeListener listener) {
		System.out.println("Canais: " + asteriskServer.getChannels().size());
		for (AsteriskChannel asteriskChannel : asteriskServer.getChannels()) {
			System.out.println(asteriskChannel.getName() + " - " + asteriskChannel.getState().name());
			asteriskChannel.removePropertyChangeListener(listener);
		
		}
	}

	/**
	 * Add listener.
	 * 
	 * @return channel
	 */
	public String getVariavel(String variavel) {
		StringBuilder build = new StringBuilder();
//		System.out.println("Check Variavel - Canais: " + asteriskServer.getChannels().size());
		for (AsteriskChannel asteriskChannel : asteriskServer.getChannels()) {
//			System.out.println(asteriskChannel.getName() + " - " + asteriskChannel.getVariable(variavel) );
			build.append(asteriskChannel.getVariable(variavel));
		}
		return build.toString();
	}
	
	private boolean checkVar(String result){
		return (result.contains("SUCESSO") || result.contains("ERRO"));
	}
	
	/**
	 * Add listener.
	 * 
	 * @return channel
	 * @throws java.lang.Exception 
	 */
	public AsteriskChannel getChannel(String variavel) throws java.lang.Exception {
		AsteriskChannel channel = null;
		if(asteriskServer.getChannels().size() == 0){
			throw new java.lang.Exception("");
		}
		for (AsteriskChannel asteriskChannel : asteriskServer.getChannels()) {
			if(asteriskChannel.getVariable(variavel).contains("SUCESSO") || asteriskChannel.getVariable(variavel).contains("ERRO")){
					System.out.println("OK - " + asteriskChannel.getName() + " - " + asteriskChannel.getVariable(variavel) );
					channel = asteriskChannel;
					break;
				}
			}
		return channel;
	}
	
	/**
	 * Desligar canal
	 */
	public void hangupCall() {
		System.out.println("Desligando Canais: " + asteriskServer.getChannels().iterator().next().getName());
		for (AsteriskChannel asteriskChannel : asteriskServer.getChannels()) {
			asteriskChannel.hangup();
		}
	}
	
	public int size(){
		System.out.println("Channels: " + asteriskServer.getChannels().size());
		return asteriskServer.getChannels().size();
	}

	public void onNewAgent(AsteriskAgentImpl arg0) {
		System.out.println("New Agent : " + arg0);
	}

	public void onNewAsteriskChannel(AsteriskChannel arg0) {
		System.out.println("onNewAsteriskChannel : " + arg0);
	}

	public void onNewMeetMeUser(MeetMeUser arg0) {
		System.out.println("onNewMeetMeUser : " + arg0);
	}

	public void onNewQueueEntry(AsteriskQueueEntry arg0) {
		System.out.println("onNewMeetMeUser: " + arg0);
	}
	
}
