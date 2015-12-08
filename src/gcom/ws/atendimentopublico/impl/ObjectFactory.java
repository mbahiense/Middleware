
package gcom.ws.atendimentopublico.impl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gcom.ws.atendimentopublico.impl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IsOnline_QNAME = new QName("http://impl.atendimentopublico.ws.gcom/", "isOnline");
    private final static QName _PesquisarImovelOuUsuario_QNAME = new QName("http://impl.atendimentopublico.ws.gcom/", "pesquisarImovelOuUsuario");
    private final static QName _Obter2ViaConta_QNAME = new QName("http://impl.atendimentopublico.ws.gcom/", "obter2ViaConta");
    private final static QName _IsOnlineResponse_QNAME = new QName("http://impl.atendimentopublico.ws.gcom/", "isOnlineResponse");
    private final static QName _Obter2ViaContaResponse_QNAME = new QName("http://impl.atendimentopublico.ws.gcom/", "obter2ViaContaResponse");
    private final static QName _SolicitarRestabelecimentoResponse_QNAME = new QName("http://impl.atendimentopublico.ws.gcom/", "solicitarRestabelecimentoResponse");
    private final static QName _InformarFaltaAgua_QNAME = new QName("http://impl.atendimentopublico.ws.gcom/", "informarFaltaAgua");
    private final static QName _SolicitarRestabelecimento_QNAME = new QName("http://impl.atendimentopublico.ws.gcom/", "solicitarRestabelecimento");
    private final static QName _PesquisarImovelOuUsuarioResponse_QNAME = new QName("http://impl.atendimentopublico.ws.gcom/", "pesquisarImovelOuUsuarioResponse");
    private final static QName _InformarFaltaAguaResponse_QNAME = new QName("http://impl.atendimentopublico.ws.gcom/", "informarFaltaAguaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gcom.ws.atendimentopublico.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsOnline }
     * 
     */
    public IsOnline createIsOnline() {
        return new IsOnline();
    }

    /**
     * Create an instance of {@link PesquisarImovelOuUsuario }
     * 
     */
    public PesquisarImovelOuUsuario createPesquisarImovelOuUsuario() {
        return new PesquisarImovelOuUsuario();
    }

    /**
     * Create an instance of {@link Obter2ViaConta }
     * 
     */
    public Obter2ViaConta createObter2ViaConta() {
        return new Obter2ViaConta();
    }

    /**
     * Create an instance of {@link IsOnlineResponse }
     * 
     */
    public IsOnlineResponse createIsOnlineResponse() {
        return new IsOnlineResponse();
    }

    /**
     * Create an instance of {@link Obter2ViaContaResponse }
     * 
     */
    public Obter2ViaContaResponse createObter2ViaContaResponse() {
        return new Obter2ViaContaResponse();
    }

    /**
     * Create an instance of {@link SolicitarRestabelecimentoResponse }
     * 
     */
    public SolicitarRestabelecimentoResponse createSolicitarRestabelecimentoResponse() {
        return new SolicitarRestabelecimentoResponse();
    }

    /**
     * Create an instance of {@link SolicitarRestabelecimento }
     * 
     */
    public SolicitarRestabelecimento createSolicitarRestabelecimento() {
        return new SolicitarRestabelecimento();
    }

    /**
     * Create an instance of {@link InformarFaltaAgua }
     * 
     */
    public InformarFaltaAgua createInformarFaltaAgua() {
        return new InformarFaltaAgua();
    }

    /**
     * Create an instance of {@link PesquisarImovelOuUsuarioResponse }
     * 
     */
    public PesquisarImovelOuUsuarioResponse createPesquisarImovelOuUsuarioResponse() {
        return new PesquisarImovelOuUsuarioResponse();
    }

    /**
     * Create an instance of {@link InformarFaltaAguaResponse }
     * 
     */
    public InformarFaltaAguaResponse createInformarFaltaAguaResponse() {
        return new InformarFaltaAguaResponse();
    }

    /**
     * Create an instance of {@link Resposta }
     * 
     */
    public Resposta createResposta() {
        return new Resposta();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsOnline }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.atendimentopublico.ws.gcom/", name = "isOnline")
    public JAXBElement<IsOnline> createIsOnline(IsOnline value) {
        return new JAXBElement<IsOnline>(_IsOnline_QNAME, IsOnline.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PesquisarImovelOuUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.atendimentopublico.ws.gcom/", name = "pesquisarImovelOuUsuario")
    public JAXBElement<PesquisarImovelOuUsuario> createPesquisarImovelOuUsuario(PesquisarImovelOuUsuario value) {
        return new JAXBElement<PesquisarImovelOuUsuario>(_PesquisarImovelOuUsuario_QNAME, PesquisarImovelOuUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obter2ViaConta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.atendimentopublico.ws.gcom/", name = "obter2ViaConta")
    public JAXBElement<Obter2ViaConta> createObter2ViaConta(Obter2ViaConta value) {
        return new JAXBElement<Obter2ViaConta>(_Obter2ViaConta_QNAME, Obter2ViaConta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsOnlineResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.atendimentopublico.ws.gcom/", name = "isOnlineResponse")
    public JAXBElement<IsOnlineResponse> createIsOnlineResponse(IsOnlineResponse value) {
        return new JAXBElement<IsOnlineResponse>(_IsOnlineResponse_QNAME, IsOnlineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obter2ViaContaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.atendimentopublico.ws.gcom/", name = "obter2ViaContaResponse")
    public JAXBElement<Obter2ViaContaResponse> createObter2ViaContaResponse(Obter2ViaContaResponse value) {
        return new JAXBElement<Obter2ViaContaResponse>(_Obter2ViaContaResponse_QNAME, Obter2ViaContaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitarRestabelecimentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.atendimentopublico.ws.gcom/", name = "solicitarRestabelecimentoResponse")
    public JAXBElement<SolicitarRestabelecimentoResponse> createSolicitarRestabelecimentoResponse(SolicitarRestabelecimentoResponse value) {
        return new JAXBElement<SolicitarRestabelecimentoResponse>(_SolicitarRestabelecimentoResponse_QNAME, SolicitarRestabelecimentoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InformarFaltaAgua }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.atendimentopublico.ws.gcom/", name = "informarFaltaAgua")
    public JAXBElement<InformarFaltaAgua> createInformarFaltaAgua(InformarFaltaAgua value) {
        return new JAXBElement<InformarFaltaAgua>(_InformarFaltaAgua_QNAME, InformarFaltaAgua.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitarRestabelecimento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.atendimentopublico.ws.gcom/", name = "solicitarRestabelecimento")
    public JAXBElement<SolicitarRestabelecimento> createSolicitarRestabelecimento(SolicitarRestabelecimento value) {
        return new JAXBElement<SolicitarRestabelecimento>(_SolicitarRestabelecimento_QNAME, SolicitarRestabelecimento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PesquisarImovelOuUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.atendimentopublico.ws.gcom/", name = "pesquisarImovelOuUsuarioResponse")
    public JAXBElement<PesquisarImovelOuUsuarioResponse> createPesquisarImovelOuUsuarioResponse(PesquisarImovelOuUsuarioResponse value) {
        return new JAXBElement<PesquisarImovelOuUsuarioResponse>(_PesquisarImovelOuUsuarioResponse_QNAME, PesquisarImovelOuUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InformarFaltaAguaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.atendimentopublico.ws.gcom/", name = "informarFaltaAguaResponse")
    public JAXBElement<InformarFaltaAguaResponse> createInformarFaltaAguaResponse(InformarFaltaAguaResponse value) {
        return new JAXBElement<InformarFaltaAguaResponse>(_InformarFaltaAguaResponse_QNAME, InformarFaltaAguaResponse.class, null, value);
    }

}
