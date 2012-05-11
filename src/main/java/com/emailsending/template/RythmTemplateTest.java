package com.emailsending.template;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.emailsending.template.generator.TemplateGenerator;
import com.emailsending.template.generator.TemplateGeneratorFactory;

public class RythmTemplateTest {

    private static final Logger logger = LoggerFactory.getLogger(RythmTemplateTest.class);

    private static final int numberOfTemplatesToGenerate = 100000;

    private static final String templateFileName = "Template.rythm";

    public static void main(String[] args) throws URISyntaxException, IOException {

        TemplateGenerator rythmTemplateGenerator = TemplateGeneratorFactory.getRythmTemplateGenerator(TemplateDataExtractor.readData(),
                templateFileName);

        long lStartTime = new Date().getTime(); // start time

        for (int i = 0; i < numberOfTemplatesToGenerate; i++) {
            String generatedTemplate = rythmTemplateGenerator.generate();
        }

        long lEndTime = new Date().getTime(); // end time

        long difference = lEndTime - lStartTime; // check different

        logger.info("Elapsed milliseconds: " + difference);
    }
}
