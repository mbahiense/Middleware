package gcom.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Classe responsavel em realizar a manipulação de arquivos.
 * 
 * @author Marcos Bahiense
 * @data 01/05/2015
 * @version 1.0
 * */
public class FileUtils {

	/**
	 * Representa do tipo de arquivo a ser criado.
	 * */
	public static final String TIPO_PDF = ".pdf";
	
	/**
	 * Representa o diretorio de arquivo temporário.
	 * */
	public static final String DIR_NAME = "/gcom/temp/";

	/**
	 * Metodo responsavel em criar o arquivo temporario e retorna a localização
	 * do mesmo.
	 * 
	 * @param img
	 *            - array de bytes das contas em pdf.
	 * @return texto - contendo a localização física do arquivo.
	 * */
	public static String writeContas(byte[] img) throws IOException {

		File novoFile = new File(DIR_NAME + obterNomeFile());

		if (!novoFile.getParentFile().exists()) {
			novoFile.getParentFile().mkdirs();
		}

		if (!novoFile.exists()) {
			FileOutputStream out = new FileOutputStream(novoFile);
			BufferedOutputStream buf = new BufferedOutputStream(out);
			buf.write(img);
			buf.flush();
			out.flush();
			out.close();
		}

		return novoFile.getAbsolutePath();
	}

	/**
	 * Metodo responsavel em criar nome dinamico para o arquivo.
	 * 
	 * @return nome randomico.
	 * */
	public static String obterNomeFile() {
		String name = UUID.randomUUID().toString();
		return name + TIPO_PDF;
	}

}
