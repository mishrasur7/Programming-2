
function getDataFromServer(url, printStudents) {
	fetch(url)
		.then(response => {
			if (response.ok) {
				return response.json();
			} else {
				throw response.status;
			}
		})
		.then(studentList => printStudents(studentList))
		.catch(errorText => alert("getDataFromServer failed " + errorText));

}




