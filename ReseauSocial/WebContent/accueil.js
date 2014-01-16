function afficher_cacher(id)
{
    if(document.getElementById(id).style.visibility=="hidden") {
		if (id=='connexionMenu') {
			document.getElementById('inscriptionMenu').style.visibility="hidden";
			document.getElementById('carrousel').style.visibility="hidden";
			document.getElementById('controls').style.visibility="hidden";
			}
		if (id=='inscriptionMenu') {
			document.getElementById('connexionMenu').style.visibility="hidden";
			document.getElementById('carrousel').style.visibility="hidden";
			document.getElementById('controls').style.visibility="hidden";
			}
		if (id=='carrousel') {
			document.getElementById('inscriptionMenu').style.visibility="hidden";
			document.getElementById('connexionMenu').style.visibility="hidden";
		}
        document.getElementById(id).style.visibility="visible";
    }
    else
    {
        document.getElementById(id).style.visibility="hidden";
     }
    return true;
}