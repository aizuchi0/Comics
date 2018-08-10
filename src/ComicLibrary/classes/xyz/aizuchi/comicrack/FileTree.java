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
package xyz.aizuchi.comicrack;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author Daniel Crawford <daniel-crawford@uiowa.edu>
 */
public class FileTree {

    /**
     * List of files as a Map.
     */
    private final TreeSet<File> fileList = new TreeSet<>();

    /**
     * Given a File directory, list all the CBZ files in it recursively.
     * @param dirRoot The directory to be listed, as a File object
     */
    public void setFileList(File dirRoot) {
        if (!dirRoot.isDirectory()) {
            return;
        }
        FilenameFilter ff;
        ff = new NestedFF();
        List<String> directories;
        directories = Arrays.asList(dirRoot.getAbsolutePath());
        for (String dir : directories) {
            fileList.addAll(Arrays.asList(new java.io.File(dir).listFiles(ff)));
            for (File listing : new java.io.File(dir).listFiles()) {
                if (listing.isDirectory()) {
                    this.setFileList(listing);
                }
            }
        }
    }

    /**
     * Given a String directory, list all the CBZ files in it recursively.
     * @param dirRoot The directory to be listed, e.g. "/tmp/foo".
     */
    public void setFileList(String dirRoot) {
        File root = new File(dirRoot);
        setFileList(root);
    }

    /**
     * @return the fileList
     */
    public TreeSet<File> getFileList() {
        return fileList;
    }

    /**
     * FilenameFilter for this class.
     */
    public static final class NestedFF implements FilenameFilter {

        @Override
        public boolean accept(File dir, String s) {
            return s.endsWith(".cbz");
        }
    }
    
    
}
