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
 * Classe respons�vel em tratar da pesquisa do Im�vel, 
 * a partir do CPF do cliente ou matr�cula do Im�vel.
 * 
 * @author Marcos Bahiense
 * @data 01/05/2015
 * @version 1.0
 * */
public class ImovelClienteAgi extends BaseAgiScript {

	public void service(AgiRequest request, AgiChannel channel) throws AgiException {

		// atende a liga��o
		answer();

		// obt�m o parametro informado pelo cliente
		String valorInformado = channel.getVariable("CLIENTE_IMOVEL");

		if (valorInformado == null) {
			// executa o audio de valor n�o informado
			exec("Playback", IntegradorConstants.AUDIO_VALOR_NAO_INFORMADO);
			
			// adiciona a situacao.
			channel.setVariable(IntegradorConstants.SITUACAO, SituacaoEnum.NAO_INFORMADO.getTexto());
			return;
		}

		// obt�m uma instacia do servico disponibilizado no GSAN
		WSRegistroAtendimentoImpl ws = WebServiceUtil.getInstance();

		// dispara a requisi��o para o GSAN
		Resposta retorno = ws.pesquisarImovelOuUsuario(valorInformado);
		
		//trata o retorno obtido;
		setarInformacoes(retorno, channel);
	}

	
	/**
	 * M�todo responsavel em tratar o retorno do WebService
	 * */
	private void setarInformacoes(Resposta retorno, AgiChannel channel)
			throws AgiException {

		if ( retorno.isSucesso() && retorno.getMensagem() != null) {
			
			String[] valores = retorno.getMensagem().split(",");

			if (valores.length > -1) {
				channel.setVariable("ID_IMOVEL",
						valores[IntegradorConstants.ID_IMOVEL]);
			}

			if (valores.length > 0) {
				channel.setVariable("ID_CLIENTE",
						valores[IntegradorConstants.ID_CLIENTE]);
			}

			if (valores.length > 1) {
				channel.setVariable("NUMERO_RA",valores[IntegradorConstants.NUMERO_RA]);
			}
			
			// adiciona a situacao.
			channel.setVariable(IntegradorConstants.SITUACAO, SituacaoEnum.SUCESSO.getTexto());
			
		}else{
			
			// executa o audio de erro.
			exec("Playback", IntegradorConstants.AUDIO_ERRO);
			
			// adiciona a situacao.
			channel.setVariable(IntegradorConstants.SITUACAO, SituacaoEnum.ERRO.getTexto());
		}
	}

}
