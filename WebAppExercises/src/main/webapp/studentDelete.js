function deleteStudent() {
	var url = "/WebAppExercises/deleteStudent";
	var inputId = document.forms["formDelete"];
	var requestParameters = "id=" + inputId["id"].value;

	postDataToServer(url, requestParameters, processStatus); 
}

function processStatus(status) {
	if (status.errorCode >= 1) {
		alert("Student data deleted!");
	} else if (status.errorCode === 0) {
		alert("Student data not deleted. Unknown student id!");
	} else {
		alert("The database is temporarily unavailable. Please try again later.")
	}
}