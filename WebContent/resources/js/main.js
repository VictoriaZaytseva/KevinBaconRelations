///send ajax request on click
/**
 * Format
 * Actor name - movie
 * 	actor - movie
 * 	actor(Bacon)
 */
function isEven(n) {
   return n % 2 == 0;
}
function beautify(data) {
	//formats data to a right string
	//[{"name":"a1","type":"a2"},{"name":"b1","type":"b2"}]
	var result = "<p>Degrees of separation "+data.length+"</p>";
	for (var i = 0; i < data.length; i++) {
		console.log(i)
		console.log(data[i])
		if(isEven(i))
			result = result+"<p>"+data[i].name;
		else
			result = result + " - " + data[i].name + "</p>";
	}
    return result+ "</p>";             // The function returns the product of p1 and p2
} 

$(document).ready(function() {
    $("#btn").click(function(){
    	var n =  $("#searchQuery").val();
    	console.log("new version");
    	$.ajax({
    		    'url' : '/kevin-bacon-relations-com-1.0-SNAPSHOT/path',
    		    'type' : 'GET',
    		    'data' : {
    		        'n' : n
    		      },
    		    'success' : function(data) {
    		    	var response = beautify(JSON.parse(data));
    		    	$( "#response" ).append(response);
    		    },
    		    'error': function(error){
    		    	console.log(error);
    		    }
    		  });
    }); 
});

