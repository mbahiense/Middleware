package gcom.util;

/**
 * Enumerador representa as possiveis ocorrencias.
 * */
public enum SituacaoEnum {

	SUCESSO("SUCESSO"),
	NAO_INFORMADO("NAO_INFORMADO"),
	INVALIDO("INVALIDO"),
	ERRO("ERRO");
	
	private String texto;
	
	SituacaoEnum(String valor){
		this.texto = valor;
	}

	public String getTexto() {
		return texto;
	}
	
}
