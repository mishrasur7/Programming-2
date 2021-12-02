function main() {
	fetch("http://localhost:8080/WebAppExercises/students")
		.then(response => response.json())
		.then(studentList => printStudents(studentList));

}

function printStudents(studentList) {

	/* This loop was used to display lastname into browser console	
	for (var student of studentList) {
			console.log(student.lastName);
		}
	*/
	var outPutText = "ID " + " Last name " + " First name " + " Street " +
		" Postcode " + " Post office <br/>";
	for (var student of studentList) {
		outPutText += student.id + " " + student.lastName + " " + student.firstName +
			" " + student.streetAddress + " " + student.postCode + " " +
			student.postOffice + "<br/>";
	}

	document.getElementById("table1").innerHTML = outPutText;
}
main(); 