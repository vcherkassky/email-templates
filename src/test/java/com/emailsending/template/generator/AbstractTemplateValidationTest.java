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
            String lineRead = reader.readLine();
            while (lineRead != null) {
                
                sb.append(lineRead).append(lineEnding);
                
                lineRead = reader.readLine();
           }
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
        
        int i = 0, j = 0; 
        while(i < expected.length() && j < actual.length()) {
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
        
        // Now we can have one string ended and another one is not ended yet
        // Just check that the rest of characters in not ended string are all whitespaces
        String notEndedString = null;
        int notEndedStringIndex = 0;
        
        if(i < expected.length()) {
            notEndedString = expected;
            notEndedStringIndex = i;
        } else if(j < actual.length()) {
            notEndedString = actual;
            notEndedStringIndex = j;
        }
        
        if(notEndedString != null)
            while(notEndedStringIndex < notEndedString.length()) {
                
                char n = notEndedString.charAt(notEndedStringIndex);
                if(n == '\n' || n == '\r' || n == '\t' || n == ' ') {
                    notEndedStringIndex++;
                    continue;
                }
                return false;
            }
        
        return true;
    }
}
