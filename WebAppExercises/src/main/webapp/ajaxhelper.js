//creating getDataFromServer function with two parameters 
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

//creating postDataToServer function with three parameters 
function postDataToServer(url, requestParameters, processStatus) {

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





