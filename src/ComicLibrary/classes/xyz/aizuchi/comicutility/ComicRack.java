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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
        try {
            archive = new ZipFile(CBZFile);
            ZipEntry comicInfoXML = archive.getEntry("ComicInfo.xml");
            if (comicInfoXML == null) {
                return null;
            }
            comicInfoStream = archive.getInputStream(comicInfoXML);
            ComicInfo jc = new ComicInfo();
            try {
                DocumentBuilder builder;
                builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = builder.parse(comicInfoStream);
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

    /* Process all the nodes, recursively. */
    protected void doRecursive(Node p) {
        if (p == null) {
            return;
        }
        NodeList nodes = p.getChildNodes();
//        System.out.println("xml-tree", "Element has " + nodes.getLength() + " children");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            if (n == null) {
                continue;
            }
            doNode(n);
        }
    }

    protected void doNode(Node n) {
        switch (n.getNodeType()) {
            case Node.ELEMENT_NODE:
                System.out.println("ELEMENT<" + n.getNodeName() + ">");
                doRecursive(n);
                break;
            case Node.TEXT_NODE:
                String text = n.getNodeValue();
                if (text.length() == 0
                        || text.equals("\n") || text.equals("\\r")) {
                    break;
                }
                System.out.println("TEXT: " + text);
                break;
            default:
                System.err.println("OTHER NODE "
                        + n.getNodeType() + ": " + n.getClass());
                break;
        }
    }

}
