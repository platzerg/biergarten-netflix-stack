$(document).ready(function() {

	var refresh = function() {
		
		$("#content").empty();
		
		$.get("/guestbook/", function(data) {
			
			for(var i=0; i<data.length; i++) {
				
				var tr = $("<tr />");
				var td = $("<td />");
				
				td.append($("<div class='lead' />").text(data[i].title));
				td.append($("<div />").text(data[i].comment));
				td.append($("<div class='small text-muted' />").text(data[i].date + " von " + data[i].commenter));
				
				tr.append(td);
				$("#content").append(tr);
			}
		});
	};
	
	// Initiales Laden der Daten
	refresh();
	
	// Aktualisieren-Button binden
	$("#refresh").on("click", refresh);
	
})


