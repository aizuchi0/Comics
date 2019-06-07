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
import static java.io.File.separator;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.aizuchi.comicrack.ComicInfo;
import xyz.aizuchi.comicrack.FileTree;
import static java.nio.file.Files.move;
import static xyz.aizuchi.comicutility.ComicRack.formatCBName;

/**
 *
 * @author Daniel Crawford <daniel-crawford@uiowa.edu>
 */
public class Organize {

    static final Logger WOODY = Logger.getLogger("xyz.aizuchi.utility.Organize");

    public Organize() {
    }

    public static void moveComics(File direct, File outputDir, boolean keepLarger, boolean overWrite, boolean dryRun) {
        assert outputDir != null;
        FileTree cl = new FileTree();
        cl.setFileList(direct);
        for (File currentComic : cl.getFileList()) {
            ComicInfo comicBook = new ComicRack().loadComicRackXML(currentComic);
            if (comicBook == null) {
                WOODY.log(Level.INFO, "\"{0}\" has no ComicInfo; skipping.", currentComic);
                continue;
            }
            assert currentComic != null;
            String series;
            try {
                series = comicBook.getSeries().replaceAll("[^a-zA-Z0-9\\._]+", "_");
                assert series != null;
                File destDir = new File(outputDir.toString() + separator + series).getAbsoluteFile();
                destDir.mkdirs();
                File destFile = new File(outputDir.toString() + separator + series + separator + formatCBName(comicBook)).getAbsoluteFile();
                try {
                    WOODY.log(Level.INFO, "Move \"{0}\" to \"{1}\"", new Object[]{currentComic.getCanonicalPath(), destFile.getCanonicalPath()});
                    if (!dryRun) {
                        if (keepLarger) {
                            //If keepLarger, check for larger file. If currentComic is larger, REPLACE_EXISTING. Otherwise, keep destFile.
                            if (currentComic.length() > destFile.length() || !destFile.exists()) {
                                move(currentComic.toPath(), destFile.toPath(), REPLACE_EXISTING);
                            } else {
                                currentComic.delete();
                            }
                        }
                        if (overWrite) {
                            move(currentComic.toPath(), destFile.toPath(), REPLACE_EXISTING);
                        } else {
                            move(currentComic.toPath(), destFile.toPath());
                        }
                    }
                } catch (FileAlreadyExistsException ex) {
                    WOODY.log(Level.SEVERE, "File: {0} already exists. Retry with -R to clobber.", destFile.toString());
                } catch (IOException ex) {
                    WOODY.log(Level.SEVERE, "IOException on file \"{0}\"", destFile.toString());
                }
            } catch (NullPointerException e) {
                WOODY.log(Level.SEVERE, "{0} is bad!", currentComic);
//                e.printStackTrace();
            }
        }
    }

}
