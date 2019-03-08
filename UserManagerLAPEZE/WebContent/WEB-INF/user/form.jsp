<fieldSet>
	<form action="register" method="POST">
		<p>Formulaire d'inscription, les champs (*) sont requis</p>
		<label>Adresse email<span class="requis">*</span></label>
		<input type="text" value="${form['email']}" name="email"><span class="error">${errors['email']}</span></br>
		<label>Mot de passe<span class="requis">*</span></label>
		<input type="text" value="${form['pwd1']}" name="pwd1"><span class="error">${errors['pwd1']}</span></br>
		<label>confirmation mot de passe<span class="requis">*</span></label>
		<input type="text" value="${form['pwd2']}" name="pwd2"><span class="error">${errors['pwd2']}</span></br>
		<label>Nom Utilisateur<span class="requis">*</span></label>
		<input type="text" value="${form['name']}" name="name"><span class="error">${errors['name']}</span></br>
		<button type="submit">Enregistrement</button>
	</form>
</fieldSet>