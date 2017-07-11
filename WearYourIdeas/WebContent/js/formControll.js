/**
 * 
 */
var specialChars = "<>@!#$%^&*()_+[]{}?:;|'\"\\,./~`-="
function validateForm(string, name) {
	for (i = 0; i < specialChars.length; i++) {
		if (string.indexOf(specialChars[i]) > -1) {
			x = document.getElementById("error");
			x.style.display = "block";
			x.innerHTML = "Ricontrolla i tuoi Dati";
			alert('Caratteri non validi');
		}
	}
	document.getElementsByName(name)[0].style.borderColor = "red";
}