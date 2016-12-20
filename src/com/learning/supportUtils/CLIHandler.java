package com.learning.supportUtils;


import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.Map;

public class CLIHandler {
    private static Options options;
    private static CommandLine line;

    private CLIHandler() {

    }

    public static Options getOptions() {
        options = new Options();
        options.addOption("s", "source", true, "name of source file");
        options.addOption("d", "dest", true, "name of destination file");
        options.addOption("e", "encoding", true, "the encoding of the output file for example \"utf8\"");
        options.addOption("h", "help", false, "print help");
        return options;
    }

    public static Map parse(String[] args) {
        Map<String, String> result = new HashMap<>();
        CommandLineParser parser = new PosixParser();

        try {
            line = parser.parse(getOptions(), args);
            if (line.hasOption("h") || line.hasOption("help")) {
                printCLIHelp();
            }
            if (line.hasOption("s") || line.hasOption("source")) {
                result.put("s", line.getOptionValue("s"));
            } else {
                printCLIHelp();
            }
            if (line.hasOption("d") || line.hasOption("dest")) {
                result.put("d", line.getOptionValue("d"));
            } else {
                printCLIHelp();
            }
            if (line.hasOption("e") || line.hasOption("encoding")) {
                result.put("e", line.getOptionValue("e"));
            } else {
                printCLIHelp();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void printCLIHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Copy program", options);
    }

}
