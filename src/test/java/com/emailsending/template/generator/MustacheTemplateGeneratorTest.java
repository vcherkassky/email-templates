package com.emailsending.template.generator;

import junit.framework.Assert;

import org.junit.Test;

import com.emailsending.template.TemplateDataExtractor;

public class MustacheTemplateGeneratorTest extends AbstractTemplateGeneratorTest {

    private static final String templateFileName = "Template.mustache";

    @Test
    public void testTemplateGenerated() {
        
        TemplateGenerator mustacheTemplateGenerator = TemplateGeneratorFactory.getMustacheTemplateGenerator(
                TemplateDataExtractor.readData(), templateFileName);

        String generatedString = mustacheTemplateGenerator.generate();
        
        Assert.assertEquals(templateSource, generatedString);
    }
}
