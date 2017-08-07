package nl.irias;

import nl.irias.sherpa.*;

/**
 * Functions for logging in users, and showing users present in the system.
 */
@SherpaSection(title="Authentication")
public class Authentication {
	final static String PRETEND_TOKEN = "pretend-this-is-random-looking-login-token";

	static void checkToken(String token) throws SherpaBadAuthException {
		if (!token.equals(PRETEND_TOKEN)) {
			throw new SherpaBadAuthException("Bad token.");
		}
	}

	/**
	 * Return authentication token for login credentials.
	 * Note: the correct username/password is testuser/testpassword.
	 */
	@SherpaFunction
	public static String login(String username, String password) throws SherpaUserException {
		if (username.equals("testuser") && password.equals("testpassword")) {
			return PRETEND_TOKEN;
		}
		throw new SherpaUserException("Invalid username/password combination.");
	}

	/**
	 * List users in the system.
	 */
	@SherpaFunction
	public static User[] listUsers(String token) throws SherpaBadAuthException {
		// You would typically get this data from a database. Use a try-with-resources to fetch a DB connection from a pool, and return the data from the query.
		checkToken(token);

		User u = new User();
		u.id = 1;
		u.name = "mjl";
		u.email = "m.lukkien@irias.nl";

		return new User[]{
			u
		};
	}
}
