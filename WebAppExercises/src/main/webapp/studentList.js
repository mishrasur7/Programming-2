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

	var studentTable = document.getElementById("studentListTable");
	for (var student of studentList) {
		var newRow = studentTable.insertRow();

		var newCell1 = newRow.insertCell(0);
		var newCell2 = newRow.insertCell(1);
		var newCell3 = newRow.insertCell(2);
		var newCell4 = newRow.insertCell(3);
		var newCell5 = newRow.insertCell(4);
		var newCell6 = newRow.insertCell(5);

		newCell1.innerHTML = student.id;
		newCell2.innerHTML = student.lastName;
		newCell3.innerHTML = student.firstName;
		newCell4.innerHTML = student.streetAddress;
		newCell5.innerHTML = student.postCode;
		newCell6.innerHTML = student.postOffice;


	}

	document.getElementById("table1").innerHTML = outPutText;
}
main(); 