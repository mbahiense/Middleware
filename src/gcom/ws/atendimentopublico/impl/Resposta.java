
package gcom.ws.atendimentopublico.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de resposta complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="resposta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TIPO_PDF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DIR_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mensagem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sucesso" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="anexo" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resposta", propOrder = {
    "tipopdf",
    "dirname",
    "mensagem",
    "sucesso",
    "anexo"
})
public class Resposta {

    @XmlElement(name = "TIPO_PDF")
    protected String tipopdf;
    @XmlElement(name = "DIR_NAME")
    protected String dirname;
    protected String mensagem;
    protected boolean sucesso;
    protected byte[] anexo;

    /**
     * Obtém o valor da propriedade tipopdf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIPOPDF() {
        return tipopdf;
    }

    /**
     * Define o valor da propriedade tipopdf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIPOPDF(String value) {
        this.tipopdf = value;
    }

    /**
     * Obtém o valor da propriedade dirname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDIRNAME() {
        return dirname;
    }

    /**
     * Define o valor da propriedade dirname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDIRNAME(String value) {
        this.dirname = value;
    }

    /**
     * Obtém o valor da propriedade mensagem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * Define o valor da propriedade mensagem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensagem(String value) {
        this.mensagem = value;
    }

    /**
     * Obtém o valor da propriedade sucesso.
     * 
     */
    public boolean isSucesso() {
        return sucesso;
    }

    /**
     * Define o valor da propriedade sucesso.
     * 
     */
    public void setSucesso(boolean value) {
        this.sucesso = value;
    }

    /**
     * Obtém o valor da propriedade anexo.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAnexo() {
        return anexo;
    }

    /**
     * Define o valor da propriedade anexo.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAnexo(byte[] value) {
        this.anexo = value;
    }

}
