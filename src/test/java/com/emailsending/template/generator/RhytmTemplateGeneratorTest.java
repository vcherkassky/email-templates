package com.emailsending.template.generator;

import junit.framework.Assert;

import org.junit.Test;

import com.emailsending.template.TemplateDataExtractor;

public class RhytmTemplateGeneratorTest extends AbstractTemplateGeneratorTest {

    private static final String templateFileName = "Template.rythm";

    @Test
    public void testTemplateGenerated() {
        
        TemplateGenerator mustacheTemplateGenerator = TemplateGeneratorFactory.getRythmTemplateGenerator(
                TemplateDataExtractor.readData(), templateFileName);

        String generatedString = mustacheTemplateGenerator.generate();
        
        Assert.assertEquals(templateSource, generatedString);
    }
}
