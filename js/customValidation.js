function alphabetsOnly(evt) {
	evt = (evt) ? evt : event;
	var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode
			: ((evt.which) ? evt.which : 0));
	if (charCode > 31 && (charCode < 65 || charCode > 90)
			&& (charCode < 97 || charCode > 122)) {
		// alert("Enter letters only.");
		document.getElementById('name_error').innerHTML = "Enter letters only.";
		return false;
	}
	document.getElementById('name_error').innerHTML = "";
	return true;
}

function readUrl(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#pic').attr('src', e.target.result)
		};

		reader.readAsDataURL(input.files[0]);
	}
}

