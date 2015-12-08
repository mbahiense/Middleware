package gcom.agi;
import gcom.email.ConfiguraEnvioEmail;
import gcom.util.IntegradorConstants;
import gcom.util.SituacaoEnum;
import gcom.util.WebServiceUtil;
import gcom.ws.atendimentopublico.impl.Resposta;
import gcom.ws.atendimentopublico.impl.WSRegistroAtendimentoImpl;

import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.BaseAgiScript;


/**
 * Classe responsável em tratar a obtenção da 2ª via.
 * 
 * @author Marcos Bahiense
 * @data 01/05/2015
 * @version 1.0
 * */
public class SegundaViaContaAgi extends BaseAgiScript {

	public void service(AgiRequest request, AgiChannel channel) throws AgiException {

		// atende a ligacao.
		answer();
		
		// obtem um instancia do WebService cliente.
		WSRegistroAtendimentoImpl ws = WebServiceUtil.getInstance();
		
		// resgata o parametro de id Imovel.
		String strIdImovel = channel.getVariable("ID_IMOVEL");
		
		if (strIdImovel == null) {
			// adiciona a situacao.
			channel.setVariable(IntegradorConstants.SITUACAO, SituacaoEnum.NAO_INFORMADO.getTexto());
			return;
		}
		
		// realiza a comunicação com o WebService do GSAN.
		Resposta retorno = ws.obter2ViaConta(strIdImovel);
		
		// verifica se ocorreu falha no consumo do servico.
		if(!retorno.isSucesso()){
			channel.setVariable(IntegradorConstants.SITUACAO, SituacaoEnum.ERRO.getTexto());
			return;
		}
		
		// executa o audio de envio de email.
		exec("Playback", IntegradorConstants.AUDIO_ENVIANDO_EMAIL); 
		
		// obtem o email do cliente
		String email = retorno.getMensagem();
		
		// obtem os bytes do pdf de 2 via gerado.
		byte[] contas = (byte[])retorno.getAnexo();
		
		// varival de controle
		boolean enviado = true;
		
		try {
			
			//realiza o envio de email.
			enviado = ConfiguraEnvioEmail.enviar(email, contas);
			channel.setVariable(IntegradorConstants.SITUACAO, SituacaoEnum.SUCESSO.getTexto());
			
		} catch (Exception e) {
			enviado = false;
		}
		
		// verifica se foi enviado o email.
		if (enviado) {
			// executa o audio de sucesso.
			exec("Playback", IntegradorConstants.AUDIO_ENVIADO_COM_SUCESSO); 
	
		} else {
			// executa audio de falha no envio
			exec("Playback", IntegradorConstants.AUDIO_ENVIO_FALHA);
			channel.setVariable(IntegradorConstants.SITUACAO, SituacaoEnum.ERRO.getTexto());
		}
	}

}
