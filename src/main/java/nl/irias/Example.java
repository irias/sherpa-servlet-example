// Note: make the class and its functions public, or sherpadoc won't generate documentation.

package nl.irias;

import java.util.Random;
import nl.irias.sherpa.*;

/**
 * Welcome to the Example API. This is javadoc documentation that is turned into API documentation automatically by sherpadoc (run by pom.xml when building). The documentation is interpreted as markdown.
 *
 * Sherpa-servlet simply exports your Java functions, automatically taking care of the JSON-conversion of parameters and return values. It exports all functions with the `@SherpaFunction` annotation in classes that have the `@SherpaSection` annotation.
 */
@SherpaSection(title="Example")
public class Example {

	/**
	 * Sum returns the sum of two numbers.
	 */
	@SherpaFunction
	public static int sum(int a, int b) {
		return a + b;
	}

	/**
	 * Echo returns `s` unmodified.
	 */
	@SherpaFunction
	public static String echo(String s) {
		return s;
	}

	/**
	 * Raise exception, randomly choosing between SherpaUserException and SherpaServerException.
	 * SherpaServerExceptions are logged as implementation errors (that should probably be fixed).
	 */
	@SherpaFunction
	public static void error(String param1) throws SherpaException {
		randomError();
	}

	static void randomError() throws SherpaException {
		if (new Random().nextBoolean()) {
			throw new SherpaUserException("User error!");
		} else {
			throw new SherpaServerException("Server error!");
		}
	}
}
