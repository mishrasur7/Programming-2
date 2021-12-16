//defining a function deleteStudent
function deleteStudent() {
	var url = "/WebAppExercises/deleteStudent";
	var inputId = document.forms["formDelete"];
	var requestParameters = "id=" + inputId["id"].value;

	postDataToServer(url, requestParameters, processStatus); 
}


//defining a function processStatus that can be used as a reference to 
//postDataToServer function..this function will be used in other programs 
function processStatus(status) {
	if (status.errorCode >= 1) {
		alert("Student data deleted!");
	} else if (status.errorCode === 0) {
		alert("Student data not deleted. Unknown student id!");
	} else {
		alert("The database is temporarily unavailable. Please try again later.")
	}
}