package gcom.agi;

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
 * Classe responsável em tratar o serviço de Falta de Agua.
 * 
 * @author Marcos Bahiense
 * @data 01/05/2015
 * @version 1.0
 * */
public class FaltaAguaAgi extends BaseAgiScript {

	public void service(AgiRequest request, AgiChannel channel)
			throws AgiException {

		// atende a ligacao.
		answer();

		// obtem um instancia do WebService cliente.
		WSRegistroAtendimentoImpl ws = WebServiceUtil.getInstance();

		// resgata o parametro de id Imovel.
		String strIdImovel = channel.getVariable("ID_IMOVEL");
		
		// resgata o parametro de numero do RA gerado.
		String strNumeroRa = channel.getVariable("NUMERO_RA");

		if (strIdImovel == null || strNumeroRa == null) {
			// adiciona a situacao.
			channel.setVariable(IntegradorConstants.SITUACAO, SituacaoEnum.NAO_INFORMADO.getTexto());
			return;
		}

		// realiza a comunicação com o WebService do GSAN.
		Resposta retorno = ws.informarFaltaAgua(strIdImovel, strNumeroRa);

		// verifica se ocorreu falha no consumo do servico.
		if (!retorno.isSucesso()) {
			// executa o audio de erro.
			exec("Playback", IntegradorConstants.AUDIO_ERRO);
			
			// adiciona a situacao
			channel.setVariable(IntegradorConstants.SITUACAO, SituacaoEnum.ERRO.getTexto());
			return;
		}
		
		// informe sucesso for testes.
		channel.setVariable(IntegradorConstants.SITUACAO, SituacaoEnum.SUCESSO.getTexto());
		
		// executa a mensagem de sucesso.
		exec("Playback", IntegradorConstants.AUDIO_SUCESSO);

	}

}
