package com.emailsending.template.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import junit.framework.ComparisonFailure;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(JUnit4.class)
public abstract class AbstractTemplateValidationTest {
    
    private static final Logger logger = LoggerFactory.getLogger(AbstractTemplateValidationTest.class);
    
    protected static final String templateSourceFileName = "Template.Source.html";
    
    protected String templateSource;
    
    private static final String lineEnding = System.getProperty("line.separator");
    
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
                sb.append(lineRead).append(lineEnding);
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
    
    /**
     * Asserts that two Strings are equal ignoring all whitespace characters. 
     */
    public static void assertEqualsIgnoreWhitespaces(String message, String expected, String actual) {
            if (expected == null && actual == null)
                    return;
            if (expected != null && equalStringsIgnoreWhitespaces(expected, actual))
                    return;
            throw new ComparisonFailure(message, expected, actual);
    }
    
    /**
     * Asserts that two Strings are equal ignoring all whitespace characters. 
     */
    public static void assertEqualsIgnoreWhitespaces(String expected, String actual) {
        assertEqualsIgnoreWhitespaces(null, expected, actual);
    }
    
    /**
     * Compares the two Strings ignoring all whitespace characters.
     */
    protected static boolean equalStringsIgnoreWhitespaces(String expected, String actual) {
        
        for(int i = 0, j = 0; i < expected.length() && j < actual.length();) {
            char e = expected.charAt(i);
            if(e == '\n' || e == '\r' || e == '\t' || e == ' ') {
                i++;
                continue;
            }
            
            char a = actual.charAt(j);
            if(a == '\n' || a == '\r' || a == '\t' || a == ' ') {
                j++;
                continue;
            }

            if(e == a) {
                i++;
                j++;
            } else
                return false;
        }
        
        return true;
    }
}
