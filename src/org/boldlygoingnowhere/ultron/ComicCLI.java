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
package org.boldlygoingnowhere.ultron;

import java.io.File;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String appname = ComicCLI.class.getSimpleName();
        CommandLine line;

        // create the parser
        CommandLineParser parser = new PosixParser();

        Options options = new Options();
        options.addOption("h", "help", false, "Display this help message");
        options.addOption("d", "directory", true, "The directory to scan");
        options.getOption("d").setRequired(true); //File is mandatory.
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
            if (!line.hasOption("d")) {
                System.err.println("Directory option (-d) must be specified!");
                formatter.printHelp(appname, options, true);
                return;
            }
            File direct = new File(line.getOptionValue("d"));
            if (!direct.isDirectory()) {
                System.err.println("Parsing failed. -d must be a directory.");
            }
        } catch (org.apache.commons.cli.ParseException exp) {
            // oops, something went wrong
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
        }

    }

}
