package test.gcom.cases;

import junit.framework.Assert;
import gcom.util.WebServiceUtil;
import gcom.ws.atendimentopublico.impl.WSRegistroAtendimentoImpl;

import org.junit.Test;

public class TestChecarDisponibilidade {

	@Test
	public void verificaDisponibilidadeWebService(){
		
		WSRegistroAtendimentoImpl ws = WebServiceUtil.getInstance();
		
		String retorno  = ws.isOnline();
		
		Assert.assertNotNull(retorno);
		
	}
	
}
