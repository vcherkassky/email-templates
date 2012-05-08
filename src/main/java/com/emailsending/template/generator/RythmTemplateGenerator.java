package com.emailsending.template.generator;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.greenlaw110.rythm.Rythm;

public class RythmTemplateGenerator implements TemplateGenerator {

    private static final Logger logger = LoggerFactory.getLogger(RythmTemplateGenerator.class);

    private List<String> dataList;

    private File templateFile;

    public RythmTemplateGenerator(List<String> data, String templateFileName) {

        this.dataList = data;
        try {
            this.templateFile = new File(ClassLoader.getSystemResource(templateFileName).toURI());
        } catch (URISyntaxException e) {
            logger.error("Wrong file name", e);
            throw new IllegalArgumentException(e);
        }
    }

    public String generate() {

        return Rythm.render(templateFile, dataList);
    }
}
