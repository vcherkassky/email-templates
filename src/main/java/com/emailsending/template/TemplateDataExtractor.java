package com.emailsending.template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemplateDataExtractor {

    private static final Logger logger = LoggerFactory.getLogger(TemplateDataExtractor.class);

    private static final String templateSourceFileName = "Template.Source.html";
    private static final String dataFileName = "Data.txt";
    private static final String dataFilePathInSrc = "/../../src/main/resources/" + dataFileName;
    
    private static final String lineEnding = System.getProperty("line.separator");

    public static List<String> readData() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(dataFileName)));
        List<String> result = new ArrayList<String>(37);
        try {
            String lineRead = reader.readLine();
            while (lineRead != null) {

                result.add(lineRead);

                lineRead = reader.readLine();
           }
            
        } catch (IOException e) {
            logger.error("error occured", e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                logger.error("error occured", e);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(templateSourceFileName)));

        Pattern pattern = Pattern.compile("src\\s*=\\s*([\"'])?([^ \"']*)");

        FileWriter writer = null;

        try {
            final String dataFilePath = new File(ClassLoader.getSystemResource(templateSourceFileName).getPath()).getParent() + dataFilePathInSrc;

            writer = new FileWriter(dataFilePath);
            logger.debug("writing to {}", dataFilePath);

            String lineRead = reader.readLine();
            while (lineRead != null) {

                Matcher matcher = pattern.matcher(lineRead);
                while (matcher.find()) {

                    String lineToWrite = matcher.group(2);
                    logger.debug("line written", lineToWrite);
                    writer.write(lineToWrite);
                    writer.write(lineEnding);
                }
                
                lineRead = reader.readLine();
           }

        } catch (IOException e) {
            logger.error("error occured", e);
        } finally {
            try {
                reader.close();
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
                logger.error("error occured", e);
            }
        }
    }
}
