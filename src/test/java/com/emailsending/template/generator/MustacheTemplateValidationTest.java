package com.emailsending.template.generator;

import org.junit.Test;

import com.emailsending.template.TemplateDataExtractor;

public class MustacheTemplateValidationTest extends AbstractTemplateValidationTest {

    private static final String templateFileName = "Template.mustache";

    @Test
    public void testTemplateGenerated() {
        
        TemplateGenerator mustacheTemplateGenerator = TemplateGeneratorFactory.getMustacheTemplateGenerator(
                TemplateDataExtractor.readData(), templateFileName);

        String generatedString = mustacheTemplateGenerator.generate();
        
        assertEqualsIgnoreWhitespaces(templateSource, generatedString);
    }
}
