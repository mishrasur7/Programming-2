function main() {
	getDataFromServer("/WebAppExercises/students", printStudents);
}

main();

function addStudent() {
	location.replace("studentAdd.html") 
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
		newCell7.innerHTML = createUpdateDeleteLinks(student.id);
	}
}
//defining function to create update and delete links on the table
function createUpdateDeleteLinks(id) {
	return "<span class='link' onclick='updateStudent(" + id + ");'>Update</span>" +
		"&nbsp;&nbsp;" +
		"<span class='link' onclick='deleteStudent(" + id + ");'>Delete</span>";
}

function updateStudent() {
	alert(97);
}

function deleteStudent(id) {
	var confirmMessage = confirm("Delete student " + id + " ?");
	if(confirmMessage == true) {
 	var url = "/WebAppExercises/deleteStudent";
	var requestParameters = "id=" + id;

	postDataToServer(url, requestParameters, processStatus);
	document.location.reload();  
	} else {
	alert("Nothing deleted!")
	}	 
}

//defining a function processStatus that can be used as a reference to 
//postDataToServer function 
function processStatus(status) {
	if (status.errorCode >= 1) {
		alert("Student data deleted!");
	} else if (status.errorCode === 0) {
		alert("Student data not deleted. Unknown student id!");
	} else {
		alert("The database is temporarily unavailable. Please try again later.")
	}
}





