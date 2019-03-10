<fieldset>
	<legend> inscription </legend>
	<form method="POST" action="register">
		<p>
			Formulaire d'inscription, les champs (*) sont requis : <br> <label>Adresse
				mail<span class="requis">*</span>
			</label> <input type="text" required name="email" value="${form['email']}">
			<br> <span class="error">${error['email']}</span> <br> <label>mot
				de passe<span class="requis">*</span>
			</label> <input type="password" required name="pwd1" value="${form['pwd1']}">
			<br><span class="error">${error['pwd1']}</span> <br> <label>Confirmation
				du mot de passe<span class="requis">*</span>
			</label> <input type="password" required name="pwd2" value="${form['pwd2']}">
			<br> <label>Nom d'utilisateur</label> <input type="text"
				name="name" value="${form['name']}"> <br> <br>
		</p>
		<input class="sansLabel" type="submit" name="enregistrement"
			value="envoyer">
	</form>
	<p class="info">${actionMessage}</p>
</fieldset>
	