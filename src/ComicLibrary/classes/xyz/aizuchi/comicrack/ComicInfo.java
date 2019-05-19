package xyz.aizuchi.comicrack;



/**
 * <p>Java class for ComicInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComicInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Series" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Count" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Volume" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="AlternateSeries" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AlternateNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AlternateCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Summary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Year" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Month" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Writer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Penciller" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Inker" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Colorist" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Letterer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CoverArtist" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Editor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Publisher" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Imprint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Genre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Web" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PageCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="LanguageISO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Format" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BlackAndWhite" type="{}YesNo" minOccurs="0"/>
 *         &lt;element name="Manga" type="{}YesNo" minOccurs="0"/>
 *         &lt;element name="Pages" type="{}ArrayOfComicPageInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class ComicInfo {

    protected String title;
    protected String series;
    protected String number;
    protected Integer count;
    protected Integer volume;
    protected String alternateSeries;
    protected String alternateNumber;
    protected Integer alternateCount;
    protected String summary;
    protected String notes;
    protected Integer year;
    protected Integer month;
    protected String writer;
    protected String penciller;
    protected String inker;
    protected String colorist;
    protected String letterer;
    protected String coverArtist;
    protected String editor;
    protected String publisher;
    protected String imprint;
    protected String genre;
    protected String web;
    protected Integer pageCount;
    protected String languageISO;
    protected String format;
    protected YesNo blackAndWhite;
    protected YesNo manga;
    protected ArrayOfComicPageInfo pages;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the series property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeries() {
        return series;
    }

    /**
     * Sets the value of the series property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeries(String value) {
        this.series = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the count property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCount(Integer value) {
        this.count = value;
    }

    /**
     * Gets the value of the volume property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVolume(Integer value) {
        this.volume = value;
    }

    /**
     * Gets the value of the alternateSeries property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlternateSeries() {
        return alternateSeries;
    }

    /**
     * Sets the value of the alternateSeries property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlternateSeries(String value) {
        this.alternateSeries = value;
    }

    /**
     * Gets the value of the alternateNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlternateNumber() {
        return alternateNumber;
    }

    /**
     * Sets the value of the alternateNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlternateNumber(String value) {
        this.alternateNumber = value;
    }

    /**
     * Gets the value of the alternateCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAlternateCount() {
        return alternateCount;
    }

    /**
     * Sets the value of the alternateCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAlternateCount(Integer value) {
        this.alternateCount = value;
    }

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSummary(String value) {
        this.summary = value;
    }

    /**
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotes(String value) {
        this.notes = value;
    }

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYear(Integer value) {
        this.year = value;
    }

    /**
     * Gets the value of the month property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMonth(Integer value) {
        this.month = value;
    }

    /**
     * Gets the value of the writer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWriter() {
        return writer;
    }

    /**
     * Sets the value of the writer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWriter(String value) {
        this.writer = value;
    }

    /**
     * Gets the value of the penciller property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPenciller() {
        return penciller;
    }

    /**
     * Sets the value of the penciller property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPenciller(String value) {
        this.penciller = value;
    }

    /**
     * Gets the value of the inker property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInker() {
        return inker;
    }

    /**
     * Sets the value of the inker property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInker(String value) {
        this.inker = value;
    }

    /**
     * Gets the value of the colorist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColorist() {
        return colorist;
    }

    /**
     * Sets the value of the colorist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColorist(String value) {
        this.colorist = value;
    }

    /**
     * Gets the value of the letterer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLetterer() {
        return letterer;
    }

    /**
     * Sets the value of the letterer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLetterer(String value) {
        this.letterer = value;
    }

    /**
     * Gets the value of the coverArtist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverArtist() {
        return coverArtist;
    }

    /**
     * Sets the value of the coverArtist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverArtist(String value) {
        this.coverArtist = value;
    }

    /**
     * Gets the value of the editor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditor() {
        return editor;
    }

    /**
     * Sets the value of the editor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditor(String value) {
        this.editor = value;
    }

    /**
     * Gets the value of the publisher property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the value of the publisher property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublisher(String value) {
        this.publisher = value;
    }

    /**
     * Gets the value of the imprint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImprint() {
        return imprint;
    }

    /**
     * Sets the value of the imprint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImprint(String value) {
        this.imprint = value;
    }

    /**
     * Gets the value of the genre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the value of the genre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenre(String value) {
        this.genre = value;
    }

    /**
     * Gets the value of the web property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeb() {
        return web;
    }

    /**
     * Sets the value of the web property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeb(String value) {
        this.web = value;
    }

    /**
     * Gets the value of the pageCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * Sets the value of the pageCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPageCount(Integer value) {
        this.pageCount = value;
    }

    /**
     * Gets the value of the languageISO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageISO() {
        return languageISO;
    }

    /**
     * Sets the value of the languageISO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageISO(String value) {
        this.languageISO = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the blackAndWhite property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getBlackAndWhite() {
        return blackAndWhite;
    }

    /**
     * Sets the value of the blackAndWhite property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setBlackAndWhite(YesNo value) {
        this.blackAndWhite = value;
    }

    /**
     * Gets the value of the manga property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getManga() {
        return manga;
    }

    /**
     * Sets the value of the manga property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setManga(YesNo value) {
        this.manga = value;
    }

    /**
     * Gets the value of the pages property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfComicPageInfo }
     *     
     */
    public ArrayOfComicPageInfo getPages() {
        return pages;
    }

    /**
     * Sets the value of the pages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfComicPageInfo }
     *     
     */
    public void setPages(ArrayOfComicPageInfo value) {
        this.pages = value;
    }

}
