default:
	mvn -B clean install && java -Djava.util.logging.config.file=logging.properties -jar target/SherpaServletExample-0.2.1.jar

clean:
	-mvn -B clean
	-rm dependency-reduced-pom.xml
