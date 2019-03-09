<fieldSet>
	<form action="login" method="POST">
		<p>Formulaire d'inscription, les champs (*) sont requis</p>
		<label>Adresse email<span class="requis">*</span></label>
		<input type="text" value="${form['email']}" name="email"><span class="error">${errors['email']}</span></br>
		<label>Mot de passe<span class="requis">*</span></label>
		<input type="text" value="${form['pwd']}" name="pwd"><span class="error">${errors['pwd']}</span></br>
		<button type="submit">Connexion</button>
	</form>
</fieldSet>