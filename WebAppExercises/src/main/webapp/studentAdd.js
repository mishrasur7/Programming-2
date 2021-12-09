function addStudent() {
	var url = "http://localhost:8080/WebAppExercises/addStudent";
	var form = document.forms["formStudent"];
	var requestParameters =
		"id=" + form["txtId"].value +
		"&firstName=" + form["txtFirstName"].value +
		"&lastName=" + form["txtLastName"].value +
		"&streetAddress=" + form["txtStreetAddress"].value +
		"&postCode=" + form["txtPostCode"].value +
		"&postOffice=" + form["txtPostOffice"].value;

	var requestOptions = {
		method: "POST",
		headers: { "Content-Type": "application/x-www-form-urlencoded" },
		body: requestParameters
	};
	
	fetch(url, requestOptions)
		.then(response => response.json())
		.then(status => processStatus(status));

}

function processStatus(status) {
	if (status === 0) {
		alert("Student data added!");
	} else if (status === 1) {
		alert("Cannot add the student, the id is already in use!");
	} else {
		alert("The database is temporarily unavailable. Please try again later.")
	}
}

