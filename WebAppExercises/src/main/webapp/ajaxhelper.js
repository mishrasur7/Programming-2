//this file contains functions that can be used in other programs 

//creating getDataFromServer function with two parameters 
function getDataFromServer(url, callbackFunction) {
	fetch(url)
		.then(response => {
			if (response.ok) {
				return response.json();
			} else {
				throw response.status;
			}
		})
		.then(data => callbackFunction(data))
		.catch(errorText => alert("getDataFromServer failed " + errorText));

}

//creating postDataToServer function with three parameters 
function postDataToServer(url, requestParameters, callbackFunction) {

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
		.then(status => callbackFunction(status))
		.catch(errorText => alert("postDataToServer failed: " + errorText));

}





