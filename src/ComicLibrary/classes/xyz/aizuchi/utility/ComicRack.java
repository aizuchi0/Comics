/*
 * Copyright (C) 2014 Daniel Crawford <daniel-crawford@uiowa.edu>
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
package xyz.aizuchi.utility;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.SAXParser;
import xyz.aizuchi.comicrack.ComicInfo;

/**
 *
 * @author Daniel Crawford <daniel-crawford@uiowa.edu>
 */
public class ComicRack {

    private Unmarshaller unmarshaller;
    private UnmarshallerHandler unmarshallerHandler;
    private JAXBContext jc;

    public ComicRack() {
    }

    public ComicInfo loadComicRackXML(File CBZFile) {
        ZipFile archive = null;
        InputStream comicInfoStream = null;
        SAXParser parser = null;
        try {
            archive = new ZipFile(CBZFile);
            ZipEntry comicInfo = archive.getEntry("ComicInfo.xml");
            if (comicInfo == null) {
                return null;
            }
            comicInfoStream = archive.getInputStream(comicInfo);
            jc = JAXBContext.newInstance(ComicInfo.class);
            unmarshaller = jc.createUnmarshaller();
            unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
            return (ComicInfo) unmarshaller.unmarshal(comicInfoStream);
        } catch (JAXBException | IOException | NullPointerException ex) {
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

    public void spitItOut() {
        try {
            Object root = unmarshallerHandler.getResult();
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(root, System.out);
        } catch (JAXBException | IllegalStateException ex) {
            Logger.getLogger(ComicRack.class.getName()).log(Level.SEVERE, null, ex);
        }

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
}
