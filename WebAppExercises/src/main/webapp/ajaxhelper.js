var url = "/WebAppExercises/students"; 
 async function getDataFromServer(url, printStudents) {
	return url; 
	.then(studentList => printStudents(studentList)); 
}