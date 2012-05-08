package com.emailsending.template.generator;

import java.util.List;

public abstract class TemplateGeneratorFactory {

    public static TemplateGenerator getMustacheTemplateGenerator(List<String> data, String templateFileName) {

        return new MustacheTemplateGenerator(data, templateFileName);
    }

    public static TemplateGenerator getRythmTemplateGenerator(List<String> data, String templateFileName) {

        return new RythmTemplateGenerator(data, templateFileName);
    }
}
