function getXMLHttpRequest() {
	var xhr = null;
	
	if (window.XMLHttpRequest || window.ActiveXObject) {
		if (window.ActiveXObject) {
			try {
				xhr = new ActiveXObject("Msxml2.XMLHTTP");
			} catch(e) {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
		} else {
			xhr = new XMLHttpRequest(); 
		}
	} else {
		alert("Votre navigateur ne supporte pas l'objet XMLHTTPRequest...");
		return null;
	}
	
	return xhr;
}

function afficherListeComplete(id){
	var element = document.getElementById(id);
	if(element.style.display == "block") {
		element.style.display = "none";
	} else {
		element.style.display = "block";
	}
}

function afficherCommentaires(obj){
	var commentaires = $(obj).parent().parent().parent().siblings(".bloc-commentaire");
    for (var i = 0; i < commentaires.length; i++) {
		if(commentaires[i].style.display == "block") {
			commentaires[i].style.display = "none";
		} else {
			commentaires[i].style.display = "block";
		}
    }
}

function nouveauCommentaire(obj){
	var commentaire = $(obj).parent().parent().parent().siblings(".bloc-nouveau-commentaire");
    for (var i = 0; i < commentaire.length; i++) {
		if(commentaire[i].style.display == "block") {
			commentaire[i].style.display = "none";
		} else {
			commentaire[i].style.display = "block";
		}
    }
}

$(function (){

	$('.bloc-post .menu img').tooltip({placement:'left'});
	$('img').tooltip({placement:'right'});
	$('#liste-amis-complete').mouseleave(function(){
		document.getElementById('liste-amis-complete').style.display = "none";
	});
});
