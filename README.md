An example project that exports Java functions as a Sherpa [1] web API using the sherpa-servlet library [2].

See src/main/java/nl/irias/SherpaServletExample.java and the exported src/main/java/nl/irias/Example.java.

Run as follows:

	mvn clean install && java -jar target/SherpaServletExample-0.0.1.jar

Now open the API at:

	http://localhost:8080/example/

[1] https://www.ueber.net/who/mjl/sherpa/
[2] https://github.com/irias/sherpa-servlet

License: public domain, feel free to reuse this example code in any way you see fit.
