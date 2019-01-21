package jsp;

import java.text.SimpleDateFormat;

public class Validate {
	// Functions to validate the values by passing it to validate functions
	public static String validateEmail(String email) {
		String error = "";
		if (email.isEmpty()) {
			error = "This field is required.";
		} else if (email.length() > 32) {
			error = "This field cannot exceed the length of 32.";
		}
		// w=word, + = more then 1, * = optional {2,4} = 2-4 words
		else if (!email.matches("^(\\w+(\\.\\w+)*@\\w+\\.\\w{2,4})$")) {
			error = "Invalid email.";
		}
		return error;
	}

	public static String validatePassword(String password) {
		String error = "";
		if (password.isEmpty()) {
			error = "This field is required.";
		} else if (password.length() > 24) {
			error = "This field cannot exceed the length of 24.";
		}
		return error;
	}

	public static String validateBirthday(String birthday) {
		String error = "";
		if (birthday.isEmpty()) {
			error = "This field is required.";
		} else if (!birthday.matches("^(\\d{2}/\\d{2}/\\d{4})$")) {
			error = "Invalid date format, Expected MM/dd/yyyy.";
		} else {
			try {
				java.util.Date d = new SimpleDateFormat("MM/dd/yyyy").parse(birthday);
				if (d.after(new java.util.Date())) {
					error = "Invalid Date.";
				}
			} catch (Exception e) {
				error = "Invalid Date.";
			}

		}
		return error;
	}

}
