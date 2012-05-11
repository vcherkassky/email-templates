package com.emailsending.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.emailsending.template.generator.TemplateGenerator;
import com.emailsending.template.generator.TemplateGeneratorFactory;

public class TemplateGeneratorComparizonTest {

    private static final Logger logger = LoggerFactory.getLogger(TemplateGeneratorComparizonTest.class);

    private List<TemplateGenerator> templateGenerators;

    private static final int numberOfCheckRounds = 10;

    private static final int numberOfTemplatesToGenerateEachTime = 100000;

    public TemplateGeneratorComparizonTest() {

        List<String> data = TemplateDataExtractor.readData();

        templateGenerators = new ArrayList<TemplateGenerator>(2);
        templateGenerators.add(TemplateGeneratorFactory.getRythmTemplateGenerator(data, "Template.rythm"));
        templateGenerators.add(TemplateGeneratorFactory.getMustacheTemplateGenerator(data, "Template.mustache"));
    }

    public Map<Class<? extends TemplateGenerator>, Long> performMultiRoundCheck() {

        Map<Class<? extends TemplateGenerator>, Long> result = new HashMap<Class<? extends TemplateGenerator>, Long>();

        for (int i = 0; i < numberOfCheckRounds; i++) {

            Map<Class<? extends TemplateGenerator>, Long> oneRoundResult = performOneRoundCheck();
            if (i == 0) {
                result.putAll(oneRoundResult);
            } else {
                for (Entry<Class<? extends TemplateGenerator>, Long> resultEntry : oneRoundResult.entrySet()) {

                    Class<? extends TemplateGenerator> generatorClass = resultEntry.getKey();
                    // calculate average avg(x_0, ... ,x_i-1) = (avg(x_0, ...
                    // x_i-2) * (i - 1) + x_i-1) / i
                    long average = (long) ((result.get(generatorClass)) * (i / (i + 1d)) + (resultEntry.getValue() / (i + 1d)));
                    result.put(generatorClass, average);
                }
            }
            
            logger.debug("Round {} results:", i);
            logResults(oneRoundResult);
        }
        
        logger.debug("\nAverage results in {} rounds:", numberOfCheckRounds);
        logResults(result);

        return result;
    }

    public Map<Class<? extends TemplateGenerator>, Long> performOneRoundCheck() {
        Map<Class<? extends TemplateGenerator>, Long> result = new HashMap<Class<? extends TemplateGenerator>, Long>();

        for (TemplateGenerator generator : templateGenerators) {

            result.put(generator.getClass(), generateTemplatesGetTime(generator));
        }

        return result;
    }

    public void logResults(Map<Class<? extends TemplateGenerator>, Long> results) {
        
        for (Entry<Class<? extends TemplateGenerator>, Long> resultEntry : results.entrySet())
            logger.debug("{} : {} nanos, {} millis, {} seconds", 
                    new Object[]{ resultEntry.getKey().getSimpleName(), resultEntry.getValue(), resultEntry.getValue() / 1000000, resultEntry.getValue() / 1000000000d});
    }

    /**
     * @param generator
     * @return number of nanoseconds
     */
    private long generateTemplatesGetTime(TemplateGenerator generator) {

        long startTimeNano = System.nanoTime();

        for (int i = 0; i < numberOfTemplatesToGenerateEachTime; i++) {
            @SuppressWarnings("unused")
            String generatedString = generator.generate();
        }

        return System.nanoTime() - startTimeNano;
    }

    public static void main(String[] args) {

        new TemplateGeneratorComparizonTest().performMultiRoundCheck();
    }
}
