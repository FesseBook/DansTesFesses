//Instance de xhr
function getXMLHttpRequest() {
	var xhr = null;
	xhr = new XMLHttpRequest(); 
	return xhr;
}



function afficherOnglet(obj){
	obj.className = "onglet-pas-default";
	autresOnglets = $(obj).siblings("a");
    for (var i = 0; i < autresOnglets.length; i++) {
		autresOnglets[i].className = "onglet-default";
    }	
}

function afficherPage(id){
	var page = document.getElementById(id);
	autresPages = $(page).siblings("div");
	page.style.display = "block";
    for (var i = 0; i < autresPages.length; i++) {
		autresPages[i].style.display = "none";
    }	
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

	$('.menu img').tooltip({placement:'left'});
	$('img').tooltip({placement:'right'});
	$('#liste-amis-complete').mouseleave(function(){
		document.getElementById('liste-amis-complete').style.display = "none";
	});
});
