var api_key = "hackerrank|2457518-2104|9d116831bff01e4b23474b30324b288025403da9";

// Create the XHR object.
function createCORSRequest(method, url) {
    var xhr = new XMLHttpRequest();
    if ("withCredentials" in xhr) {
        // XHR for Chrome/Firefox/Opera/Safari.
        xhr.open(method, url, true);
    } else if (typeof XDomainRequest != "undefined") {
        // XDomainRequest for IE.
        xhr = new XDomainRequest();
        xhr.open(method, url);
    } else {
        // CORS not supported.
        xhr = null;
    }
    return xhr;
}

// Helper method to parse the title tag from the response.
function getTitle(text) {
    return text.match('<title>(.*)?</title>')[1];
}

// Make the actual CORS request.
function makeCorsRequest() {
    // This is a sample server that supports CORS.
    var url = 'https://hackerrank-hackerrank.p.mashape.com/https://api.hackerrank.com/checker/submission.json';

    var xhr = createCORSRequest('POST', url);
    if (!xhr) {
        alert('CORS not supported');
        return;
    }

    // Response handlers.
    xhr.onload = function() {
        var text = xhr.responseText;
        var title = getTitle(text);
        alert('Response from CORS request to ' + url + ': ' + title);
    };

    xhr.onerror = function() {
        alert('Woops, there was an error making the request.');
    };

    var source = document.getElementById("source").value;
    var lang = document.getElementById("lang").value;
    var testcases = [document.getElementById("testcases").value];

    var data = JSON.stringify({"source": source, "lang": lang, "testcases": testcases, "api_key": api_key});
    xhr.send(data);
}


function postSourceCode(){


    var xhr = new XMLHttpRequest();
    var url = "http://api.hackerrank.com/checker/submission.json";

    xhr.withCredentials = true;
    xhr.open("POST", url, true);
    xhr.onreadystatechange = function () {

        if(xhr.readyState == 4) alert("It worked!");

    };
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    var data = JSON.stringify({"source": source, "lang": lang, "testcases": testcases, "api_key": api_key});
    xhr.send(data);

}
