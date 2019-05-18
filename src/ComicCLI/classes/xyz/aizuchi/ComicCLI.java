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

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import static xyz.aizuchi.comicutility.Organize.moveComics;
import xyz.aizuchi.comicutility.Server;

/**
 *
 * @author Daniel Crawford <daniel-crawford@uiowa.edu>
 */
public class ComicCLI {

    private static boolean keepLarger = false;
    private static boolean overWrite = false;
    static final Logger WOODY = Logger.getLogger("xyz.aizuchi.ComicCLI");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String appname = ComicCLI.class.getSimpleName();
        CommandLine line;
        File direct = null;
        File outputDir = null;
        
        // create the parser
        CommandLineParser parser = new DefaultParser();

        Options options = new Options();
        options.addOption("h", "help", false, "Display this help message");
        options.addOption("d", "directory", true, "The directory to scan");
        options.getOption("d").setRequired(true); //File is mandatory.
        options.addOption("o", "output directory", true, "The directory to sort archives into");
        options.getOption("o").setRequired(true); //File is mandatory.
        options.addOption("R", "overwrite", false, "When moving files, clobber any existing files.");
        options.addOption("L", "keep-larger", false, "When moving files, overwrite if -d file is larger than -o file.");
        options.addOption("S", "Server", false, "Start the comics server.");
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
            if (line.hasOption("S")) {
                //Start the server
                Server.startServer();
                return;
            }
            if (line.hasOption("R")) {
                overWrite = true;
                WOODY.log(Level.INFO,"Turning on overwrite; will clobber files.");
            }
            if (line.hasOption("L")) {
                overWrite = false;
                keepLarger = true;
                WOODY.log(Level.INFO,"Turning on keep_larger; will clobber files.");
            }
            if (!line.hasOption("d")) {
                WOODY.log(Level.SEVERE,"Directory option (-d) must be specified!");
                formatter.printHelp(appname, options, true);
                return;
            }
            direct = new File(line.getOptionValue("d"));
            if (!direct.isDirectory()) {
                WOODY.log(Level.SEVERE,"Parsing failed. -d must be a directory.");
            }
            if (!line.hasOption("o")) {
                WOODY.log(Level.SEVERE,"Directory option (-o) must be specified!");
                formatter.printHelp(appname, options, true);
                return;
            }
            outputDir = new File(line.getOptionValue("o"));
            if (!outputDir.exists()) {
                WOODY.log(Level.SEVERE,"Output directory does not exist; creating now");
                outputDir.mkdirs();
            }
            if (!outputDir.isDirectory()) {
                WOODY.log(Level.SEVERE,"Parsing failed. -o must be a directory.");
            }
        } catch (org.apache.commons.cli.ParseException exp) {
            // oops, something went wrong
            WOODY.log(Level.SEVERE, "Parsing failed.  Reason: {0}", exp.getMessage());
        }

        moveComics( direct,  outputDir,  keepLarger,  overWrite);
    }
}
