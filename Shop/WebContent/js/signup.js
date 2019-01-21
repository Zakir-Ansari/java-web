//This java script will be called when the doc is loaded
var sign_up;
$(function() {
	$("#birthday").datepicker({ //This is to unable date options
		maxDate : "0d", // 0d means current date 
		showOtherMonths : true,
		selectOtherMonths : true,
		changeYear : true,
		changeMonth : true
	});
	$("#sign_up").button();
	$("[name = 'email']").focusout(validateEmail).keyup(validateEmail);
	$("[name = 'password']").focusout(validatePassword).keyup(validatePassword);
	$("[name = 'birthday']").focusout(validateBirthday).keyup(validateBirthday);
});

// Utility function to test the inputs are valid
// function isAllValid() {
// var valid = true;
// $("input[name]").each(function(i,e) { //index and element
// return valid = valid && (!!e.value); // why !!
// });
// $("[id$ = '_error']").each(function(i,e){
// return valid = valid && (!e.innerHTML);
// });
// sign_up.button({
// disabled : !valid //False disabled means unable i.e valid
// });
// }
