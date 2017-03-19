
$(document).ready(function() {
	
	$(".successarea").hide();
	
	$("#send").on("click", function() {
	
		var data = {
			title:$("#title").val(),
			comment:$("#comment").val(),
			commenter:$("#commenter").val()
		};
		
		$.ajax({
		
			url:"/guestbook/",
			method:"PUT",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function(data) {
				$(".successarea").show();
				$("form").hide();
			},
			error:function(data) {
				alert("Etwas hat nicht geklappt!");
			}
		});
	});
	
	
	
})
