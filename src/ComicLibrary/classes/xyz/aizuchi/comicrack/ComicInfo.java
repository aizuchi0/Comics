package xyz.aizuchi.comicrack;

//<?xml version="1.0"?>
//<ComicInfo xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
//  <Title>Why We Fight Part 2 of 3</Title>
//  <Series>War of the Realms: Spider-Man &amp; the League of Realms</Series>
//  <Number>2</Number>
//  <StoryArc>The War of the Realms</StoryArc>
//  <Summary>WAR OF THE REALMS TIE-IN!
//
//In order to win the War of the Realms, we need a LEAGUE OF REALMS!
//
//Thor once led this team with one representive from each fantastical realm, but the League has a NEW leader and representative of Midgard- SPIDER-MAN!
//
//Spider-Man must Frodo-Up and lead this ragtag group of SCREWBEARD THE DWARF, UD THE TROLL, RO BLOODROOT THE WIZARD, SIR IVORY HONEYSHOT THE LIGHT ELF and TITANYA THE MOUNTAIN GIANT! But who will represent ASGARD?!
//
//And, as Spidey is a terrible leader, could this team possibly achieve ANYTHING?!
//
//*List of covers and their creators:*
// Cover | Name          | Creator(s)                             | Sidebar Location |
//--------------------------------------------------------------------------------
// Reg   | Regular Cover | Ken Lashley &amp; Brian Reber              | 1                |
// Var   | Variant Cover | Lan Medina, John Livesay &amp; Brian Reber | 2                |</Summary>
//  <Notes>Tagged with ComicTagger 1.1.31-rc1 using info from Comic Vine on 2019-06-07 16:10:18.  [Issue ID 710123]</Notes>
//  <Year>2019</Year>
//  <Month>7</Month>
//  <Day>1</Day>
//  <Writer>Sean Ryan</Writer>
//  <Penciller>Nico Leon</Penciller>
//  <Inker>Nico Leon</Inker>
//  <Colorist>Carlos Lopez</Colorist>
//  <Letterer>Joe Caramagna</Letterer>
//  <CoverArtist>Brian Reber, John Livesay, Ken Lashley, Lan Medina</CoverArtist>
//  <Editor>Kathleen Wisneski, Nick Lowe</Editor>
//  <Publisher>Marvel</Publisher>
//  <Web>https://comicvine.gamespot.com/war-of-the-realms-spider-man-and-the-league-of-rea/4000-710123/</Web>
//  <PageCount>23</PageCount>
//  <Characters>Fernande, Ivory Honeyshot, Lady Waziria, Malekith, Ro Bloodroot, Screwbeard, Spider-Man, Titanya Vaetilda Vinnsuvius, Ud</Characters>
//  <Teams>Angels, Dark Elves, League of Realms</Teams>
//  <Locations>Lagos, Vatican City</Locations>
//  <Pages>
//    <Page Image="0" ImageSize="478646" Type="FrontCover" />
//    <Page Image="1" ImageSize="378615" />
//    <Page Image="2" ImageSize="371011" />
//    <Page Image="3" ImageSize="407768" />
//    <Page Image="4" ImageSize="439718" />
//    <Page Image="5" ImageSize="429793" />
//    <Page Image="6" ImageSize="520203" />
//    <Page Image="7" ImageSize="462895" />
//    <Page Image="8" ImageSize="504911" />
//    <Page Image="9" ImageSize="531466" />
//    <Page Image="10" ImageSize="507467" />
//    <Page Image="11" ImageSize="408003" />
//    <Page Image="12" ImageSize="549867" />
//    <Page Image="13" ImageSize="517200" />
//    <Page Image="14" ImageSize="504189" />
//    <Page Image="15" ImageSize="569167" />
//    <Page Image="16" ImageSize="554710" />
//    <Page Image="17" ImageSize="449546" />
//    <Page Image="18" ImageSize="502302" />
//    <Page Image="19" ImageSize="558219" />
//    <Page Image="20" ImageSize="519566" />
//    <Page Image="21" ImageSize="605531" />
//    <Page Image="22" ImageSize="371151" />
//  </Pages>
//</ComicInfo>


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


}
