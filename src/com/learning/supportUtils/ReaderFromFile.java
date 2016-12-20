package com.learning.supportUtils;

import static com.learning.supportUtils.CLIHandler.*;

import java.io.*;
import java.util.Map;

public class ReaderFromFile {
    private ReaderFromFile() {

    }

    public static void copyWithConvert(Map map) throws IOException {
        FileInputStream incomeLine = null;
        OutputStream outcomeLine = null;
        try {
            incomeLine = new FileInputStream(map.get("s").toString());
            outcomeLine = new FileOutputStream(map.get("d").toString());
            BufferedReader reader = new BufferedReader(new InputStreamReader(incomeLine));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outcomeLine, map.get("e").toString()));


            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
            printCLIHelp();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Wrong encode");
            printCLIHelp();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (incomeLine != null) {
                incomeLine.close();
            }
            if (outcomeLine != null) {
                outcomeLine.flush();
                outcomeLine.close();
            }
        }
    }
}
