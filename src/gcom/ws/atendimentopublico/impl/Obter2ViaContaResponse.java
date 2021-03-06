
package gcom.ws.atendimentopublico.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de obter2ViaContaResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="obter2ViaContaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://impl.atendimentopublico.ws.gcom/}resposta" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obter2ViaContaResponse", propOrder = {
    "_return"
})
public class Obter2ViaContaResponse {

    @XmlElement(name = "return")
    protected Resposta _return;

    /**
     * Obt�m o valor da propriedade return.
     * 
     * @return
     *     possible object is
     *     {@link Resposta }
     *     
     */
    public Resposta getReturn() {
        return _return;
    }

    /**
     * Define o valor da propriedade return.
     * 
     * @param value
     *     allowed object is
     *     {@link Resposta }
     *     
     */
    public void setReturn(Resposta value) {
        this._return = value;
    }

}
