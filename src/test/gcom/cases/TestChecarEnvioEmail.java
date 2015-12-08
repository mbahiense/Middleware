package test.gcom.cases;
import gcom.email.ConfiguraEnvioEmail;
import gcom.ws.atendimentopublico.impl.Resposta;
import gcom.ws.atendimentopublico.impl.WSRegistroAtendimentoImpl;
import gcom.ws.atendimentopublico.impl.WebServiceRegistroAtendimento;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import junit.framework.Assert;

import org.junit.Test;


public class TestChecarEnvioEmail {

	// representa o id_imovel valido.
	// ex. imoveis com pendencias 79785, 598786, 1219368
	private final String ID_IMOVEL_TESTE = "1249668";
	
	@Test
	public void verificaEnvioEmail() {
		
		WebServiceRegistroAtendimento service = new WebServiceRegistroAtendimento();
		
		WSRegistroAtendimentoImpl ws = service.getPort(WSRegistroAtendimentoImpl.class);
		
		Resposta resposta = ws.obter2ViaConta(ID_IMOVEL_TESTE);
		
		Assert.assertEquals(Boolean.TRUE.booleanValue(), resposta.isSucesso());
		
		boolean sucesso = true;

		try {

			sucesso = ConfiguraEnvioEmail.enviar(null, resposta.getAnexo());
			
		} catch (Exception e) {
			sucesso = false;
		}
		
		Assert.assertEquals(Boolean.TRUE.booleanValue(), sucesso);
	}
	
}
