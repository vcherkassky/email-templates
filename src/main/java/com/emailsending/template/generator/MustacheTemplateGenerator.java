package com.emailsending.template.generator;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

public class MustacheTemplateGenerator implements TemplateGenerator {

    private static final Logger logger = LoggerFactory.getLogger(MustacheTemplateGenerator.class);

    private Map<String, String> dataMap = new HashMap<String, String>();

    private Mustache mustache;

    MustacheTemplateGenerator(List<String> data, String templateFileName) {

        int j = 0;
        for (String dataItem : data)
            dataMap.put("img_src" + j++, dataItem);

        MustacheFactory mf = new DefaultMustacheFactory();
        mustache = mf.compile(templateFileName);
    }

    public String generate() {

        StringWriter writer = new StringWriter();
        try {
            mustache.execute(writer, dataMap).flush();
            return writer.toString();
        } catch (IOException e) {
            logger.error("Should never occur", e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                logger.error("Should never occur", e);
            }
        }

        return null;
    }
}
