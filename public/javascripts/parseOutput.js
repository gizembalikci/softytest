function compileRequest(id){
    var xhr = new XMLHttpRequest();
    var url = "http://localhost:9000/coding/"+id.toString();
    var qid = id;
    var source = document.getElementById("source"+id.toString()).value;

    xhr.open("POST", url, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
            var output = json["result"]["stdout"];

            if(output == null) {
                output = json["result"]["compilemessage"];
                document.getElementById("output"+id.toString()).innerText = output;
            }

            else {
                var outputStr = "";
                output.forEach(function (element) {
                    outputStr += element;
                });
                document.getElementById("output"+id.toString()).innerText = outputStr;
            }
        }
    };
    xhr.send(source);
    document.getElementById("output"+id.toString()).innerText = "Compiling..."
}

// function compileRequest(){
//     var json = JSON.parse(document.getElementById("hiddenIframe").innerText);
//     var output = json["result"]["stdout"];
//     var outputStr = "";
//     outputStr.forEach(function (element) {
//         outputStr += element;
//     });
//     document.getElementById("output").innerText = outputStr;
// }