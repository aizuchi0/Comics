/* 
 * Copyright (C) 2019 Daniel Crawford <daniel-crawford@uiowa.edu>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package xyz.aizuchi.comicutility;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.TreeWalker;
import org.xml.sax.SAXException;
import xyz.aizuchi.comicrack.ComicInfo;

/**
 *
 * @author Daniel Crawford <daniel-crawford@uiowa.edu>
 */
public class ComicRack {

    public ComicRack() {
    }

    public ComicInfo loadComicRackXML(File CBZFile) {
        ZipFile archive = null;
        InputStream comicInfoStream = null;
        DocumentBuilderFactory builder;
        DocumentBuilder parser;
        Document document;

        try {
            archive = new ZipFile(CBZFile);
            ZipEntry comicInfoXML = archive.getEntry("ComicInfo.xml");
            if (comicInfoXML == null) {
                return null;
            }
            comicInfoStream = archive.getInputStream(comicInfoXML);
            ComicInfo jc = new ComicInfo();
            try {
                builder = DocumentBuilderFactory.newInstance();
                builder.setValidating(false);
                builder.setNamespaceAware(true);
                builder.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                        XMLConstants.W3C_XML_SCHEMA_NS_URI);
                parser = builder.newDocumentBuilder();
                document = parser.parse(comicInfoStream);
                DocumentTraversal traversal = (DocumentTraversal) document;
                TreeWalker walker = traversal.createTreeWalker(
                        document.getDocumentElement(),
                        NodeFilter.SHOW_ELEMENT | NodeFilter.SHOW_TEXT,
                        null, true);
                traverseLevel(walker, "");
            } catch (ParserConfigurationException | SAXException ex) {
                Logger.getLogger(ComicRack.class.getName()).log(Level.SEVERE, null, ex);
            }
            return jc;
        } catch (IOException ex) {
            Logger.getLogger(ComicRack.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (archive != null) {
                    archive.close();
                }
                if (comicInfoStream != null) {
                    comicInfoStream.close();
                }
            } catch (IOException | NullPointerException ex) {
            }
        }
        return null;
    }

    public static String getNumber(ComicInfo comicBook) {
        String issueNumber = comicBook.getNumber();
        String fixedNumber;
        try {
            int rawInt = Integer.parseInt(issueNumber);
            fixedNumber = String.format(Locale.US, "%03d", rawInt);
        } catch (NumberFormatException ex) {
            fixedNumber = issueNumber;
        }
        return fixedNumber;
    }

    public static String getTitle(ComicInfo comicBook) {
        String title = comicBook.getTitle();
        if (title == null) {
            title = "";
        } else {
            title = " - " + title;
        }
        return title;
    }

    public static String getYear(ComicInfo comicBook) {
        try {
            int year = comicBook.getYear();
            return Integer.toString(year);
        } catch (NullPointerException ex) {
            return "unknown year";
        }
    }

    public static String formatCBName(ComicInfo comicBook) {
        //Template from comictagger for file rename: %series% (%year%) #%issue% - %title%
        //Bad charactersare \ / : * ? " < > |
        String newName = comicBook.getSeries() + " (" + ComicRack.getYear(comicBook) + ") #"
                + ComicRack.getNumber(comicBook)
                + ComicRack.getTitle(comicBook) + ".cbz";
        newName = newName.replaceAll("[^a-zA-Z0-9\\._]+", "_");
        return newName;
    }

    private static void traverseLevel(TreeWalker walker,
            String indent) {

        Node node = walker.getCurrentNode();

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(indent + node.getNodeName());
        }

        if (node.getNodeType() == Node.TEXT_NODE) {

            String content_trimmed = node.getTextContent().trim();

            if (content_trimmed.length() > 0) {
                System.out.print(indent);
                System.out.printf("%s%n", content_trimmed);
            }
        }

        for (Node n = walker.firstChild(); n != null;
                n = walker.nextSibling()) {

            traverseLevel(walker, indent + "  ");
        }

        walker.setCurrentNode(node);
    }
}
