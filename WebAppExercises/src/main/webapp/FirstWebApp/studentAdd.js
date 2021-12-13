function addStudent() {
	var url = "http://localhost:8080/WebAppExercises/addStudent";
	var form = document.forms["formStudent"];
	var requestParameters =
		"id=" + form["id"].value +
		"&firstName=" + form["firstName"].value +
		"&lastName=" + form["lastName"].value +
		"&streetAddress=" + form["streetAddress"].value +
		"&postCode=" + form["postCode"].value +
		"&postOffice=" + form["postOffice"].value;

	var requestOptions = {
		method: "POST",
		headers: { "Content-Type": "application/x-www-form-urlencoded" },
		body: requestParameters
	};

	postDataToServer(url, requestParameters, processStatus); 

}

function processStatus(status) {
	if (status.errorCode === 0) {
		alert("Student data added!");
	} else if (status.errorCode === 1) {
		alert("Cannot add the student, the id is already in use!");
	} else {
		alert("The database is temporarily unavailable. Please try again later.")
	}
}

