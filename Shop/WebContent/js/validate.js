var email_regex = /^(\w+(\.\w+)*@\w+\.\w{2,4})$/, birthday_regex = /^(\d{2}\/\d{2}\/\d{4})$/;
function validateEmail(e) {
	e = e.target.value;
	var error = "";
	if (e.length == 0) {
		error = "This field is required.";
	} else if (e.length > 32) {
		error = "This field cannot exceed the length of 32.";
	}
	else if (!email_regex.test(e)) {
		error = "Invalid email.";
	}
	$("#email_error").html(error);
	//isAllValid();
}

function validatePassword(e) {
	e = e.target.value;
	var error = "";
	if (e.length == 0) {
		error = "This field is required.";
	} else if (e.length > 24) {
		error = "This field cannot exceed the length of 24.";
	}
	$("#password_error").html(error);
	//isAllValid();
}
function validateBirthday(e) {
	e = e.target.value;
	var error = "";
	if (e.length == 0) {
		error = "This field is required.";
	} else if (!birthday_regex.test(e)) {
		error = "Invalid date format, Expected MM/dd/yyyy.";
	} else {
		var date = new Date(e), d = date.getDate(), m = date.getMonth() + 1, y = date
				.getFullYear();
		if (d < 10) {
			d = '0' + d;
		}
		if (m < 10) {
			m = '0' + m;
		}
		d = m + "/" + d + "/" + y;
		if (d != e || (date > new Date())) {
			error = "Invalid date.";
		}
	}
	$("#birthday_error").html(error);
	//isAllValid();
}