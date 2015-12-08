package test.asterisk.integration;

import gcom.util.IntegradorConstants;
import gcom.util.WebServiceUtil;
import gcom.ws.atendimentopublico.impl.Resposta;
import gcom.ws.atendimentopublico.impl.WSRegistroAtendimentoImpl;

public class RAHelper {
	
	/**
	 * Service for create valid RA number.
	 * @param idClienteImovel
	 * @return
	 */
	public static String obterRA(String idClienteImovel){
		
		WSRegistroAtendimentoImpl ws = WebServiceUtil.getInstance();
		Resposta retorno =  ws.pesquisarImovelOuUsuario(idClienteImovel);
		
		if(retorno != null){
			String[] valores = retorno.getMensagem().split(",");
			if (valores.length > 1) {
				return valores[IntegradorConstants.NUMERO_RA];
			}
		}
		return null;
	}
	
}
