package gcom.util;

import gcom.ws.atendimentopublico.impl.WSRegistroAtendimentoImpl;
import gcom.ws.atendimentopublico.impl.WebServiceRegistroAtendimento;

/**
 * Classe responsavel em tratar o acesso ao WebService cliente, abstraindo a
 * forma de utilização.
 * 
 * @author Marcos Bahiense
 * @data 01/05/2015
 * @version 1.0
 * */
public class WebServiceUtil {

	/**
	 * Instancia do WebService cliente.
	 * */
	private static WSRegistroAtendimentoImpl ws;

	static {
		getInstance();
	}

	/**
	 * Método responsavel em prover a instancia de acesso aos WebServices do GSAN.
	 * @return Interface do webservice.
	 * */
	public static WSRegistroAtendimentoImpl getInstance() {
		if (ws == null) {
			WebServiceRegistroAtendimento service = new WebServiceRegistroAtendimento();
			ws = service.getPort(WSRegistroAtendimentoImpl.class);
		}
		return ws;
	}

}
