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
import java.util.logging.Level;
import xyz.aizuchi.comicrack.ComicInfo;
import xyz.aizuchi.comicrack.FileTree;
import static xyz.aizuchi.comicutility.Organize.WOODY;

/**
 *
 * @author Daniel Crawford <daniel-crawford@uiowa.edu>
 */
public class Server {

    public static void startServer() {
        FileTree cl = new FileTree();
        cl.setFileList(new File("/Users/dgcrawfo/Comics"));
        cl.getFileList().forEach((comicFile) -> {
            ComicInfo comicBook = new ComicRack().loadComicRackXML(comicFile);
            if (comicBook == null) {
                WOODY.log(Level.INFO, "\"{0}\" has no ComicInfo; skipping.", comicFile);
            }
            assert comicBook != null;
            System.out.println(comicBook.getSeries());
        });
    }

}
