package test.asterisk.constant;

/**
 * Represents context and parameters using in URA for Integration.
 * 
 * @author Marcos Bahiense
 */
public enum ServicosEnum {

	/**
	 * This context in Asterisk Server for perform request in ws. 
	 * */
	TESTE_PESQUISAR_CLIENTE,
	TESTE_OBTER_SEGUNDA_VIA,
	TESTE_INFORMAR_FALTA_AGUA,
	TESTE_SOLICITAR_RESTABELECIMENTO;
	
	// Parameter's using in Integration 
	public static final String SITUACAO = "SITUACAO";
	public static final String ID_IMOVEL = "ID_IMOVEL";
	public static final String CLIENTE_IMOVEL = "CLIENTE_IMOVEL";
	public static final String RA = "NUMERO_RA";
	
}
