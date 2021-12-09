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

	fetch(url, requestOptions)
		.then(response => {
			if (response.ok) {
				return response.json();
			} else {
				throw "HTTP status code is " + response.status;
			}
		})
		.then(status => processStatus(status))
		.catch(errorText => alert("postDataToServer failed: " + errorText));

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

