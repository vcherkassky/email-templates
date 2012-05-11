package com.emailsending.template.generator;

import org.junit.Test;

import com.emailsending.template.TemplateDataExtractor;

public class RhytmTemplateValidationTest extends AbstractTemplateValidationTest {

    private static final String templateFileName = "Template.rythm";

    @Test
    public void testTemplateGenerated() {
        
        TemplateGenerator mustacheTemplateGenerator = TemplateGeneratorFactory.getRythmTemplateGenerator(
                TemplateDataExtractor.readData(), templateFileName);

        String generatedString = mustacheTemplateGenerator.generate();
        
        assertEqualsIgnoreWhitespaces(templateSource, generatedString);
    }
}
