package xyz.aizuchi.comicrack;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.boldlygoingnowhere.ultron package. 
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
public class ObjectFactory {

    private final static QName _ComicInfo_QNAME = new QName("", "ComicInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.boldlygoingnowhere.ultron
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ComicInfo }
     * 
     */
    public ComicInfo createComicInfo() {
        return new ComicInfo();
    }

    /**
     * Create an instance of {@link ArrayOfComicPageInfo }
     * 
     */
    public ArrayOfComicPageInfo createArrayOfComicPageInfo() {
        return new ArrayOfComicPageInfo();
    }

    /**
     * Create an instance of {@link ComicPageInfo }
     * 
     */
    public ComicPageInfo createComicPageInfo() {
        return new ComicPageInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComicInfo }{@code >}}
     * 
     * @param value
     * @return 
     */
    public JAXBElement<ComicInfo> createComicInfo(ComicInfo value) {
        return new JAXBElement<ComicInfo>(_ComicInfo_QNAME, ComicInfo.class, null, value);
    }

}
