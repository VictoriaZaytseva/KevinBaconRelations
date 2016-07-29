//consts for errors
const notFound = "<p class= \"response-line\">I did not find any relation to KB for your request:(</p>";
const serverError = "<p class= \"response-line\">Internal Server Error</p>";	
const invalidName =  "<p class= \"response-line\">Please enter a valid actor name, with correct case(app is currently case sensitive)</p>";	
//checking if actor or movie depending on a position
function isEven(n) {
   return n % 2 == 0;
}
//format json to the right string
function beautify(data) {
	if(data.length > 0){
	var result = "<p class= \"response-line\">Degrees of separation "+(data.length-2)+"</p>";
	for (var i = data.length-1; i >=0 ; i--) {
		console.log(i)
		console.log(data[i])
		if(isEven(i))
			result = result+"<p class= \"response-line\">"+data[i].name;
		else
			result = result + " - " + data[i].name + "</p>";
	}
    return result+ "</p>";             // The function returns the product of p1 and p2
	}else{
		return notFound;
	}
} 
//updateDom with the new response
function updateDom(response){
	$( ".response-line" ).empty();
	$( "#response" ).append(response);
}
//validate input
function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}
// put everything uppercase
function process(name){
	var arr = name.trim().split(" ");
	var result = "";
	for (var i = 0; i < arr.length ; i++) {
		result = result+" "+ capitalizeFirstLetter(arr[i]);
	}
	return result.trim();
}

//onClick function to send the data
$(document).ready(function() {
    $("#btn").click(function(){
    	var n =  process($("#searchQuery").val());
    	$.ajax({
    		    'url' : '/path',
    		    'type' : 'GET',
    		    'data' : {
    		        'n' : n
    		      },
    		    'success' : function(data) {
    		    	updateDom(beautify(data));
    		    },
    		    'error': function(error){
    		    	console.log(error);
    		    }
    		  }); 
    }); 
});

