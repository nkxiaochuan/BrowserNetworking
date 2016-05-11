XHRHttpRquest = window.XHRHttpRquest || {}

XHRHttpRquest.xhrGet= function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/v1/xhr/hello');
	xhr.onload = function(){
		var responseText = xhr.responseText;
		alert(responseText);
		alert('same-origin ok');
	};
	xhr.send();
}
XHRHttpRquest.xhrCors=function (){
		var cors_xhr = new XMLHttpRequest();
		cors_xhr.withCredentials = true;
		cors_xhr.open('GET','http://localhost:8088/v1/xhr/hello');
		cors_xhr.onload=function(){
			var responseText = cors_xhr.responseText;
			alert(responseText);
			alert('cross-origin ok');
		};
		cors_xhr.onerror = function() {
			  alert('There was an error!');
			};
		cors_xhr.send();
	}
XHRHttpRquest.xhrDownload=function(){
		var xhr = new XMLHttpRequest();
		xhr.open('GET','/images/download.jpg');
		xhr.responseType='blob';
		xhr.onload=function(){
			
			if (this.status == 200){
				var img = document.createElement('img');
				img.src = window.URL.createObjectURL(this.response);
				
				img.onload = function(){
					window.URL.revokeObjectURL(this.src);
				}
				document.body.appendChild(img);
			}
		};
		xhr.send();
	}
XHRHttpRquest.xhrUpload=function(){
	//upload string 
	/*
	var xhr = new XMLHttpRequest();
	xhr.open('POST','/v1/xhr/upload');
	xhr.onload = function() {
		var responseText = xhr.responseText;
		alert(responseText);
	};
	xhr.send("text string");
	
	//upload form data
	var formData = new FormData();
	formData.append('id', 123456);
	formData.append('topic', 'performance');
	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/v1/xhr/upload');
	xhr.onload = function() {
		var responseText = xhr.responseText;
		alert(responseText);
	};
	xhr.send(formData); */
	
	//upload Array
	var xhr = new XMLHttpRequest();
	xhr.open('POST', '/v1/xhr/upload');
	xhr.onload = function() {
		var responseText = xhr.responseText;
		alert(responseText);
	};
	var uInt8Array = new Uint8Array([1, 2, 3]);
	xhr.send(uInt8Array.buffer);
	
	//split a large file into smaller chunks
	/* var blob = '';
	const BYTES_PER_CHUNK = 1024 * 1024;
	const SIZE = blob.size;
	var start = 0;
	var end = BYTES_PER_CHUNK;
	while(start < SIZE) {
		var xhr = new XMLHttpRequest();
		xhr.open('POST', '/v1/xhr/upload');
		xhr.onload = function() {
			var responseText = xhr.responseText;
			alert(responseText);
		};
		xhr.setRequestHeader('Content-Range', start+'-'+end+'/'+SIZE);
		xhr.send(blob.slice(start, end));
		start = end;
		end = start + BYTES_PER_CHUNK;
	} */
}
XHRHttpRquest.monitor=function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/High Performance Browser Networking.pdf');
	xhr.timeout = 5000;
	xhr.addEventListener('load', function() {var responseText = xhr.responseText;alert(responseText);});
	xhr.addEventListener('error', function() {alert("error")});
	var onProgressHandler = function(event) {
		if(event.lengthComputable) {
			var progress = (event.loaded / event.total) * 100;
			alert(progress);
		}
	}
	xhr.upload.addEventListener('progress', onProgressHandler);
	xhr.addEventListener('progress', onProgressHandler);
	xhr.send();
}

XHRHttpRquest.streamingData=function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/v1/xhr/stream');
	xhr.seenBytes = 0;
	xhr.onreadystatechange = function() {
		if(xhr.readyState > 2) {
			var newData = xhr.responseText.substr(xhr.seenBytes);
			// process newData
			xhr.seenBytes = xhr.responseText.length;
		}
	};
	xhr.send();
}

XHRHttpRquest.checkUpdates=function() {
	console.log("start");
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/v1/xhr/poll');
	xhr.onload = function() {
		console.log("end");
	};
	xhr.send();
}

XHRHttpRquest.checkUpdatesLong=function() {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/v1/xhr/poll');
	xhr.onload = function() {
		if (this.status == 200){
			console.log("get data back!");
			input.onload = function(){
			}
			document.body.appendChild(input);
		
			XHRHttpRquest.checkUpdatesLong();
		}
	};
	xhr.send();
}

