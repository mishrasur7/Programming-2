function main() {
	getDataFromServer("/WebAppExercises/students", printStudents);
}

main();

function addStudent() {
location.replace("studentAdd.html"); 
}

function printStudents(studentList) {

	var studentTable = document.getElementById("studentListTable");
	
	for (var student of studentList) {
	
		//Inserting a new row in a table
		var newRow = studentTable.insertRow();

		var newCell1 = newRow.insertCell(0);
		var newCell2 = newRow.insertCell(1);
		var newCell3 = newRow.insertCell(2);
		var newCell4 = newRow.insertCell(3);
		var newCell5 = newRow.insertCell(4);
		var newCell6 = newRow.insertCell(5);
		var newCell7 = newRow.insertCell(6); 

		newCell1.innerHTML = student.id;
		newCell2.innerHTML = student.lastName;
		newCell3.innerHTML = student.firstName;
		newCell4.innerHTML = student.streetAddress;
		newCell5.innerHTML = student.postCode;
		newCell6.innerHTML = student.postOffice;
		newCell7.innerHTML = "Update " + "Delete"; 


	}
}

 