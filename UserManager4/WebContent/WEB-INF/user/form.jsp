<form method="post" action="register">
	<fieldset>
		<legend>Inscription</legend>
		<p>Formulaire d'inscription, les champs (*) sont requis :</p>

		<label for="email">Adresse email <span class="requis">*</span></label>
		<input type="text" id="email" name="email" value="${form['email']}"
			size="20" maxlength="60" /> <span class="requis">${errors['email']}</span>
		<br /> <label for="pwd1">Mot de passe <span class="requis">*</span></label>
		<input type="password" id="pwd1" name="pwd1" value="${form['pwd1']}"
			size="20" maxlength="20" /> <span class="requis">${errors['pwd1']}</span>
		<br /> <label for="pwd2">Confirmation du mot de passe <span
			class="requis">*</span></label> <input type="password" id="pwd2" name="pwd2"
			value="${form['pwd1']}" size="20" maxlength="20" /> <span
			class="requis">${errors['pwd1']}</span> <br /> <label for="name">Nom
			d'utilisateur</label> <input type="text" id="name" name="name"
			value="${form['name']}" size="20" maxlength="20" /> <span
			class="requis">${errors['name']}</span> <br /> <input type="submit"
			value="Enregistrement" class="sansLabel" /> <br />
		<p class="info">${actionMessage}</p>
	</fieldset>
</form>