default:
	mvn -B clean install && java -jar target/SherpaServletExample-0.2.0.jar

clean:
	-mvn -B clean
	-rm dependency-reduced-pom.xml
