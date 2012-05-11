package com.emailsending.template.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(JUnit4.class)
public abstract class AbstractTemplateGeneratorTest {
    
    private static final Logger logger = LoggerFactory.getLogger(AbstractTemplateGeneratorTest.class);
    
    protected static final String templateSourceFileName = "Template.Source.html";
    
    protected String templateSource;
    
    @Before
    public void setUp() {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(templateSourceFileName)));
        StringBuilder sb = new StringBuilder();
        try {
            String lineRead = null;
            do {
                lineRead = reader.readLine();
                if(lineRead != null && lineRead.trim().isEmpty())
                    break;
                sb.append(lineRead);
            } while (lineRead != null);
        } catch (IOException e) {
            logger.error("Error occured while reading file", e);
        } finally {
            try {
                reader.close();
            } catch(IOException e) {
                logger.error("Error occured while closing read stream", e);
            }
        }
        
        templateSource = sb.toString();
    }
}
