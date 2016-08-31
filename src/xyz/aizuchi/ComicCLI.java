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
package xyz.aizuchi;

import xyz.aizuchi.ComicInfo;
import xyz.aizuchi.FileTree;
import xyz.aizuchi.ComicRack;
import java.io.File;
import static java.io.File.separator;
import java.io.IOException;
import static java.lang.System.err;
import static java.lang.System.out;
import java.nio.file.FileAlreadyExistsException;
import static java.nio.file.Files.move;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Locale;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;

/**
 *
 * @author Daniel Crawford <daniel-crawford@uiowa.edu>
 */
public class ComicCLI {

    private static boolean keepLarger = false;
    private static boolean overWrite = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String appname = ComicCLI.class.getSimpleName();
        CommandLine line;
        File direct = null;
        File outputDir = null;

        // create the parser
        CommandLineParser parser = new PosixParser();

        Options options = new Options();
        options.addOption("h", "help", false, "Display this help message");
        options.addOption("d", "directory", true, "The directory to scan");
        options.getOption("d").setRequired(true); //File is mandatory.
        options.addOption("o", "output directory", true, "The directory to sort archives into");
        options.getOption("o").setRequired(true); //File is mandatory.
        options.addOption("R", "overwrite", false, "When moving files, clobber any existing files.");
        options.addOption("L", "keep-larger", false, "When moving files, overwrite if -d file is larger than -o file.");
        // automatically generate the help statement
        HelpFormatter formatter = new HelpFormatter();

        try {
            // parse the command line arguments
            line = parser.parse(options, args);
            //Help flag, so print help
            if (line.hasOption("h")) {
                formatter.printHelp(appname, options, true);
                return;
            }
            if (line.hasOption("R")) {
                overWrite = true;
                out.println("Turning on overwrite; will clobber files.");
            }
            if (line.hasOption("L")) {
                overWrite = false;
                keepLarger = true;
                out.println("Turning on keep_larger; will clobber files.");
            }
            if (!line.hasOption("d")) {
                err.println("Directory option (-d) must be specified!");
                formatter.printHelp(appname, options, true);
                return;
            }
            direct = new File(line.getOptionValue("d"));
            if (!direct.isDirectory()) {
                err.println("Parsing failed. -d must be a directory.");
            }
            if (!line.hasOption("o")) {
                err.println("Directory option (-o) must be specified!");
                formatter.printHelp(appname, options, true);
                return;
            }
            outputDir = new File(line.getOptionValue("o"));
            if (!outputDir.exists()) {
                err.println("Output directory does not exist; creating now");
                outputDir.mkdirs();
            }
            if (!outputDir.isDirectory()) {
                err.println("Parsing failed. -o must be a directory.");
            }
        } catch (org.apache.commons.cli.ParseException exp) {
            // oops, something went wrong
            err.println("Parsing failed.  Reason: " + exp.getMessage());
        }

        assert outputDir != null;
        FileTree cl = new FileTree();
        cl.setFileList(direct);
        for (File currentComic : cl.getFileList()) {
            ComicInfo comicBook = new ComicRack().loadComicRackXML(currentComic);
            if (comicBook == null) {
                err.println("\"" + currentComic + "\" has no ComicInfo; skipping.");
                continue;
            }
            assert comicBook != null;
            assert currentComic != null;
            String series = comicBook.series.replaceAll(":", "：");
            File destDir = new File(outputDir.toString() + separator + series);
            destDir.mkdirs();
            //Template from comictagger for file rename: %series% (%year%) #%issue% - %title%
            //Bad charactersare '\ / : * ? " < > |'
            String newName = comicBook.series + " (" + comicBook.year + ") #"
                    + formatIssue(comicBook.number) + " - " + comicBook.title + ".cbz";
            newName = newName.replaceAll(":", "：");
            File destFile = new File(outputDir.toString() + separator + series + separator + newName);
            try {
                out.println("Move \"" + currentComic.getCanonicalPath() + "\" to \"" + destFile.getCanonicalPath() + "\"");
                if (keepLarger) {
                    //If keepLarger, check for larger file. If currentComic is larger, REPLACE_EXISTING. Otherwise, keep destFile.
                    if(currentComic.length() > destFile.length() || ! destFile.exists()) {
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
            } catch (FileAlreadyExistsException ex) {
                err.println("File: " + newName + " already exists. Retry with -R to clobber.");
            } catch (IOException ex) {
                err.println("IOException on file \"" + destFile.toString() + "\"");
            }
        }
    }

    private static String formatIssue(String issueNumber) {
        String fixedNumber;
        try {
            int rawInt = Integer.parseInt(issueNumber);
            fixedNumber = String.format(Locale.US, "%03d", rawInt);
        } catch (NumberFormatException ex) {
            fixedNumber = issueNumber;
        }
        return fixedNumber;
    }

}
