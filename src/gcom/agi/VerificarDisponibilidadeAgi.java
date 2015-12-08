package gcom.agi;
import gcom.util.IntegradorConstants;
import gcom.util.SituacaoEnum;
import gcom.util.WebServiceUtil;
import gcom.ws.atendimentopublico.impl.WSRegistroAtendimentoImpl;

import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.BaseAgiScript;


public class VerificarDisponibilidadeAgi extends BaseAgiScript{

	
	public void service(AgiRequest request, AgiChannel channel) throws AgiException {

		answer();
		
		System.out.println("Verificando disponibilidade do WebService!");
		
		WSRegistroAtendimentoImpl ws = WebServiceUtil.getInstance();
		
		try{
			
			ws.isOnline();
			
			// adiciona a situacao.
			channel.setVariable(IntegradorConstants.SITUACAO, SituacaoEnum.SUCESSO.getTexto());
			
			System.out.println("Serviço Online.");
		}catch(Exception e ){
			// adiciona a situacao.
			channel.setVariable(IntegradorConstants.SITUACAO, SituacaoEnum.ERRO.getTexto());
		}
		
	}
}
