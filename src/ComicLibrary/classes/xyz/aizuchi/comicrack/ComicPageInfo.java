package xyz.aizuchi.comicrack;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ComicPageInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComicPageInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Image" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Type" type="{}ComicPageType" default="Story" />
 *       &lt;attribute name="DoublePage" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="ImageSize" type="{http://www.w3.org/2001/XMLSchema}long" default="0" />
 *       &lt;attribute name="Key" type="{http://www.w3.org/2001/XMLSchema}string" default="" />
 *       &lt;attribute name="ImageWidth" type="{http://www.w3.org/2001/XMLSchema}int" default="-1" />
 *       &lt;attribute name="ImageHeight" type="{http://www.w3.org/2001/XMLSchema}int" default="-1" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class ComicPageInfo {

    protected int image;
    protected List<String> type;
    protected Boolean doublePage;
    protected Long imageSize;
    protected String key;
    protected Integer imageWidth;
    protected Integer imageHeight;

    /**
     * Gets the value of the image property.
     * 
     * @return 
     */
    public int getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     */
    public void setImage(int value) {
        this.image = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the type property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     * @return 
     */
    public List<String> getType() {
        if (type == null) {
            type = new ArrayList<String>();
        }
        return this.type;
    }

    /**
     * Gets the value of the doublePage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDoublePage() {
        if (doublePage == null) {
            return false;
        } else {
            return doublePage;
        }
    }

    /**
     * Sets the value of the doublePage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDoublePage(Boolean value) {
        this.doublePage = value;
    }

    /**
     * Gets the value of the imageSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getImageSize() {
        if (imageSize == null) {
            return  0L;
        } else {
            return imageSize;
        }
    }

    /**
     * Sets the value of the imageSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setImageSize(Long value) {
        this.imageSize = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        if (key == null) {
            return "";
        } else {
            return key;
        }
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the imageWidth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getImageWidth() {
        if (imageWidth == null) {
            return -1;
        } else {
            return imageWidth;
        }
    }

    /**
     * Sets the value of the imageWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setImageWidth(Integer value) {
        this.imageWidth = value;
    }

    /**
     * Gets the value of the imageHeight property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getImageHeight() {
        if (imageHeight == null) {
            return -1;
        } else {
            return imageHeight;
        }
    }

    /**
     * Sets the value of the imageHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setImageHeight(Integer value) {
        this.imageHeight = value;
    }

}
