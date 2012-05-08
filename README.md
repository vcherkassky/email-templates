email-templates
===============

# Generating email templates: mustache and rythm comparison

To build the code use the following command

	mvn clean compile
	
## mustache test

Run com.emailsending.template.MustacheTemplateTest

*100000* templates created in *~4.3 sec* 

## Rythm test

Run com.emailsending.template.RythmTemplateTest

*100000* templates created in *~3.8 sec* for the first time and *~1.85* for each time further - see generators comparison test results 

## generators comparison test results

To get the results run com.emailsending.template.TemplateGeneratorComparizonTest

	DEBUG [main] (TemplateGeneratorComparizonTest.java:54) - Round 0 results:
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - MustacheTemplateGenerator : 4014025797 nanos, 4014 millis, 4.014025797 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - RythmTemplateGenerator : 3867947813 nanos, 3867 millis, 3.867947813 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:54) - Round 1 results:
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - MustacheTemplateGenerator : 3941178066 nanos, 3941 millis, 3.941178066 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - RythmTemplateGenerator : 1837061869 nanos, 1837 millis, 1.837061869 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:54) - Round 2 results:
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - MustacheTemplateGenerator : 3934682496 nanos, 3934 millis, 3.934682496 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - RythmTemplateGenerator : 1851167495 nanos, 1851 millis, 1.851167495 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:54) - Round 3 results:
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - MustacheTemplateGenerator : 3952877822 nanos, 3952 millis, 3.952877822 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - RythmTemplateGenerator : 1846164723 nanos, 1846 millis, 1.846164723 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:54) - Round 4 results:
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - MustacheTemplateGenerator : 3958079695 nanos, 3958 millis, 3.958079695 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - RythmTemplateGenerator : 1857473208 nanos, 1857 millis, 1.857473208 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:54) - Round 5 results:
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - MustacheTemplateGenerator : 3964217659 nanos, 3964 millis, 3.964217659 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - RythmTemplateGenerator : 1871934698 nanos, 1871 millis, 1.871934698 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:54) - Round 6 results:
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - MustacheTemplateGenerator : 4007177133 nanos, 4007 millis, 4.007177133 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - RythmTemplateGenerator : 1895318071 nanos, 1895 millis, 1.895318071 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:54) - Round 7 results:
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - MustacheTemplateGenerator : 4055259757 nanos, 4055 millis, 4.055259757 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - RythmTemplateGenerator : 1863210670 nanos, 1863 millis, 1.86321067 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:54) - Round 8 results:
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - MustacheTemplateGenerator : 4013157070 nanos, 4013 millis, 4.01315707 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - RythmTemplateGenerator : 1849399575 nanos, 1849 millis, 1.849399575 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:54) - Round 9 results:
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - MustacheTemplateGenerator : 4010468331 nanos, 4010 millis, 4.010468331 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - RythmTemplateGenerator : 1842973494 nanos, 1842 millis, 1.842973494 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:58) - 
	Average results in 10 rounds:
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - MustacheTemplateGenerator : 3985112380 nanos, 3985 millis, 3.98511238 seconds
	DEBUG [main] (TemplateGeneratorComparizonTest.java:78) - RythmTemplateGenerator : 2058265159 nanos, 2058 millis, 2.058265159 seconds

