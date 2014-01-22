<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.GlobalBean" %>
<%@ page import="model.Post" %>
<%@ page import="model.Comment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date"  %>
<%@ page import="java.text.DateFormat"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="PagePersoStyle.css"  />
<link href="dist/css/bootstrap.min.css"  rel="stylesheet" type="text/css"/>
<script src="jquery-2.0.3.min.js" type="text/javascript"></script> 
<script src="dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="script.js" type="text/javascript"></script>

<title>Insert title here</title>
</head>
<body>
		<%GlobalBean gb = (GlobalBean) request.getAttribute("globalBean"); %>
<header>
	<div id="milieu">
		<div id="menu-principal">
			<a rel="tooltip" title="Home" class="onglet-default" onclick="afficherOnglet(this); afficherPage('le-mur')">
				<h1>Home</h1>
			</a>
			<a rel="tooltip" title="Profil" class="onglet-default" onclick="afficherOnglet(this); afficherPage('le-profil')">
				<h1>Profil</h1>
			</a>
			<a rel="tooltip" title="Amis" class="onglet-pas-default" onclick="afficherOnglet(this); afficherPage('les-amis')">
				<h1>Amis</h1>
			</a>
			<a rel="Photo" title="Photos" class="onglet-default" onclick="afficherOnglet(this); afficherPage('les-photos')">
				<h1>Photos</h1>
			</a>							
		</div>
	</div>
</header>
    
<div id="principale">
	<div id="left">
		<div id="mur">
<%DateFormat shortDf = DateFormat.getDateInstance(DateFormat.SHORT); %>					
<%ArrayList<Post> myPost = (ArrayList<Post>) gb.get_postContainer();
if (myPost!=null) {
	for(int i=0; i< myPost.size();i++){%>
			<div>
				<div class="bloc-post">
					<div class="posteur"><a href="#"><img rel="tooltip" class="avatar" src="Images/wall/Avatar.jpg" title= <%= myPost.get(i).get_author() %> /></a> <%= shortDf.format(myPost.get(i).get_date()) %></div>
					<p class="post">
					<%= myPost.get(i).get_body() %>
					</p>
					<div class="menu">
						<a target="_self" class="raccourci"><img rel="tooltip" src="Images/wall/Commentaires.png" onclick="afficherCommentaires(this)" title="Afficher les Commentaires" height="16" width="16"/></a>
						<a target="_self" class="raccourci"><img rel="tooltip" src="Images/wall/Ecrire.png" onclick="nouveauCommentaire(this)" title="Ajouter un commentaire" height="16" width="16"/></a>
					</div>
				</div>	
				
				<%ArrayList<Comment> myComments = (ArrayList<Comment>) myPost.get(i).get_comments();
				if (myComments!=null) {
				for(int j=0; j< myComments.size();j++){%>
				
				<div class="bloc-commentaire">
					<div><a href="#"><img rel="tooltip" src="Images/wall/Avatar.jpg" title= <%= myComments.get(j).get_author() %> /></a> <%= shortDf.format(myComments.get(j).get_date()) %> </div>
					<p class="commentaire">
					<%= myComments.get(j).get_body() %>
					</p>
				</div>
				 <% } %>
				<% } %>
				<div class="bloc-nouveau-commentaire">
					<div><a href="#"><img rel="tooltip" src="Images/wall/Avatar.jpg" title="Paf"/></a> <%  Date d = new Date(); %> <%= shortDf.format(d) %> > </div>
					<FORM>
					<TEXTAREA name="nom">Valeur par défaut</TEXTAREA>
					</FORM>	
					<button class="btn btn-primary" type="submit">Publier</button>	
				</div>				
			</div>	
<%	} %>
<% } %>								
						<div class="clear"></div>																					
		</div>
		<div id="le-profil">
			<div>
				<div class="bloc-post">
					<div class="posteur"><a href="#"><img rel="tooltip" class="avatar" src="Images/wall/Avatar.jpg" title="Plop"/></a>16 Jan. 2014</div>
					<p class="post">
					Plop
					</p>
					<div class="menu">
						<a target="_self" class="raccourci"><img rel="tooltip" src="Images/wall/Commentaires.png" onclick="afficherCommentaires(this)" title="Afficher les Commentaires" height="16" width="16"/></a>
						<a target="_self" class="raccourci"><img rel="tooltip" src="Images/wall/Ecrire.png" onclick="nouveauCommentaire(this)" title="Ajouter un commentaire" height="16" width="16"/></a>
					</div>
				</div>
				<div class="bloc-nouveau-commentaire">
					<div><a href="#"><img rel="tooltip" src="Images/wall/Avatar.jpg" title="Paf"/></a>18 Jan. 2014</div>
					<FORM>
					<TEXTAREA name="nom">Valeur par défaut</TEXTAREA>
					</FORM>	
					<button class="btn btn-warning" type="submit">Publier</button>	
				</div>						
			</div>
			<div class="clear"></div>	
		</div>
		<div id="les-amis">	
			<div id="nouvelles-invitations"> 
				<h2>Nouvelles invitations</h2>	
				<div>
					<div class="invitation"><img src="Images/wall/Avatar.jpg"/><p>Pouet</p>
						<div class="menu">
							<a target="_self" class="raccourci"><img rel="tooltip" src="Images/wall/Refuse.png" title="Refuser l'invitation" height="16" width="16"/></a>
							<a target="_self" class="raccourci"><img rel="tooltip" src="Images/wall/Accept.png" title="Accepter l'invitation" height="16" width="16"/></a>
						</div>			
					</div>
					<div class="invitation"><img src="Images/wall/Avatar.jpg"/><p>Prout</p>
						<div class="menu">
							<a target="_self" class="raccourci"><img rel="tooltip" src="Images/wall/Refuse.png" title="Refuser l'invitation" height="16" width="16"/></a>
							<a target="_self" class="raccourci"><img rel="tooltip" src="Images/wall/Accept.png" title="Accepter l'invitation" height="16" width="16"/></a>
						</div>			
					</div>	
					<div class="invitation"><img src="Images/wall/Avatar.jpg"/><p>Plouf</p>
						<div class="menu">
							<a target="_self" class="raccourci"><img rel="tooltip" src="Images/wall/Refuse.png" title="Refuser l'invitation" height="16" width="16"/></a>
							<a target="_self" class="raccourci"><img rel="tooltip" src="Images/wall/Accept.png" title="Accepter l'invitation" height="16" width="16"/></a>
						</div>			
					</div>						
				</div>		
			</div>
			<div id="recherche-personne">
				<h2>Recherche</h2>
				<div>
					<input type="text"> <button class="btn btn-warning" type="submit">Rechercher</button>
				</div>
				<a href="#" class="amis"><img src="Images/wall/Avatar.jpg"/><p>Pouet</p></a>
				<a href="#" class="amis"><img src="Images/wall/Avatar.jpg"/><p>Prout</p></a>		
				<a href="#" class="amis"><img src="Images/wall/Avatar.jpg"/><p>Plouf</p></a>		
				<a href="#" class="amis"><img src="Images/wall/Avatar.jpg"/><p>Ping</p></a>		
				<a href="#" class="amis"><img src="Images/wall/Avatar.jpg"/><p>Pong</p></a>		
				<a href="#" class="amis"><img src="Images/wall/Avatar.jpg"/><p>Poum</p></a>		
				<a href="#" class="amis"><img src="Images/wall/Avatar.jpg"/><p>Plouc</p></a>		
				<a href="#" class="amis"><img src="Images/wall/Avatar.jpg"/><p>Paf</p></a>
				<a href="#" class="amis"><img src="Images/wall/Avatar.jpg"/><p>Pppppppppppppppppppppppppppppppppp</p></a>	
				<div class="autres"><img src="Images/wall/Avatar.jpg"/><p>Autres1</p>
					<div class="menu">
						<a target="_self" class="raccourci"><img rel="tooltip" src="Plus.png" title="Ajouter à ma liste d'amis" height="16" width="16"/></a>
					</div>			
				</div>
			</div>
		</div>
		<div id="les-photos">
		</div>
	</div>
	<div class="clear"></div>	
	
	<div id="right">
		<div id="profil">
			<div id="utilisateur">
				<a href="#" target="_self"><img src="Images/wall/Avatar.jpg" title="Photo de profil" id="avatar" height="80" width="80"/></a>
				<p> <%= gb.get_surname() %> <br/> <%= gb.get_name() %> </p>	
				<div id="raccourci-profil">
					<a href="#" target="_self" class="raccourci"><img rel="tooltip" src="Images/wall/Deconnexion.png" title="Déconnexion" height="16" width="16"/></a>	
				</div>	
			</div>
			<div id="amis">
				<h2>Amis</h2>
				
				<div id="liste-amis">	
					<a href="#"><img rel="tooltip" src="Images/wall/Avatar.jpg" title="Pouet" class="amiconnecte"/></a>
					<a href="#"><img rel="tooltip" src="Images/wall/Avatar.jpg" title="Prout" class="amiconnecte"/></a>		
					<a href="#"><img rel="tooltip" src="Images/wall/Avatar.jpg" title="Plouf" class="aminonconnecte"/></a>		
					<a href="#"><img rel="tooltip" src="Images/wall/Avatar.jpg" title="Ping" class="aminonconnecte"/></a>		
					<a href="#"><img rel="tooltip" src="Images/wall/Avatar.jpg" title="Pong" class="aminonconnecte"/></a>		
					<a href="#"><img rel="tooltip" src="Images/wall/Avatar.jpg" title="Poum" class="aminonconnecte"/></a>		
					<a href="#"><img rel="tooltip" src="Images/wall/Avatar.jpg" title="Plouc" class="aminonconnecte"/></a>		
					<a href="#"><img rel="tooltip" src="Images/wall/Avatar.jpg" title="Paf" class="aminonconnecte"/></a>		
					<div id="menu-amis">
						<a target="_self" class="raccourci"><img rel="tooltip" src="Images/wall/ListeComplete.png" onclick="script:afficherListeComplete('liste-amis-complete')" title="Liste complète" height="16" width="16"/></a>
						<a href="#" target="_self" class="raccourci"><img rel="tooltip" src="Images/wall/Amis.png" title="Gestion" height="16" width="16"/></a>
						<a href="#" target="_self" class="raccourci"><img rel="tooltip" src="Images/wall/Recherche.png" title="Recherche" height="16" width="16"/></a>																	
					</div>	
				</div>
				<!--<div id="liste-amis-complete" >-->
				<form method="get" action="Servlet1" id="liste-amis-complete">
					<a href="#"><img src="Images/wall/Avatar.jpg" class="amiconnecte"/><p>Pouet</p></a>
					<a href="#"><img src="Images/wall/Avatar.jpg" class="amiconnecte"/><p>Prout</p></a>		
					<a href="#"><img src="Images/wall/Avatar.jpg" class="aminonconnecte"/><p>Plouf</p></a>		
					<a href="#"><img src="Images/wall/Avatar.jpg" class="aminonconnecte"/><p>Ping</p></a>		
					<a href="#"><img src="Images/wall/Avatar.jpg" class="aminonconnecte"/><p>Pong</p></a>		
					<a href="#"><img src="Images/wall/Avatar.jpg" class="aminonconnecte"/><p>Poum</p></a>		
					<a href="#"><img src="Images/wall/Avatar.jpg" class="aminonconnecte"/><p>Plouc</p></a>		
					<a href="#"><img src="Images/wall/Avatar.jpg" class="aminonconnecte"/><p>Paf</p></a>
					<a href="#"><img src="Images/wall/Avatar.jpg" class="aminonconnecte"/><p>Pppppppppppppppppppppppppppppppppp</p></a>						
				<!--</div>-->
				</form>
			</div>
			<form method="post" action="Servlet1" class= "newPost">
			<div id="posts-rapides">
				<h2>New Post</h2>
				<FORM>
					<TEXTAREA name="nom" id="nouveau-post">Valeur par défaut</TEXTAREA>
				</FORM>
					
				<div id="publier">				
					<button class="btn btn-warning" type="submit" name="operation" value="publication">Publier</button>	
				</div>						
			</div>
			</form>
			<div id="home">
				<a href="#" target="_self"><img rel="tooltip" src="Images/wall/Home.png" title="Home" id="image-home" height="64" width="64"/></a>					
			</div>						
		</div>
		<div class="clear"></div>	
	</div>	
	<div class="clear"></div>		
</div>
	
<footer>
</footer>
</body>
</html>