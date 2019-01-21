package jsp;

public class Template {
	// with SHOWN and LINK, we can create new option with its linked jsp file
	public static final String[] SHOWN = new String[] { "Home", "About" };
	public static final String[] LINK = new String[] { "index.jsp", "about.jsp" };

	public static String getNavigationBar() {
		String s = "";
		/*
		 * Running a loop for SHOWN.length time, to display options and their links in
		 * Navigation Bar
		 */
		for (int i = 0; i < SHOWN.length; i++) {
			s += "<li><a href=\"" + LINK[i] + "\">" + SHOWN[i] + "</a></li>  ";
		}
		return s; // <a href="index.jsp">Shop</a> <a href="about.jsp">About</a>
	}

	public static String getAccountLinks(Object user_id) {
		// if person is not logged in, user_id will be null
		if (user_id == null) {
			return "<a href=\"#\">Log In</a> / <a href=\"#\">Sign Up</a>";
		} else {
			return "<a href=\"#\">Account</a> / <a href=\"#\">Log In</a>";
		}

	}

	public static String getFooter() {
		return "&copy; 2019 Shop.com";
	}

	// Will pass below user id as parameter in session.getAttribute()
	public static final String USER_ID = "user_id";
}
