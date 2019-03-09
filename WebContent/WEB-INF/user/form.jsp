<form method="post" action="register">
	<legend>Inscription</legend>
	<p>Formulaire d'inscription, les champs (*) sont requis :</p>

	<div class="form-group">
		<label for="email">Adresse email <span class="requis">*</span></label>
		<input class="form-control" type="text" id="email" name="email" value="${form['email']}" size="20" maxlength="60" />
		<span class="requis">${errors['email']}</span>
	</div>

	<div class="form-group">
		<label for="pwd1">Mot de passe <span class="requis">*</span></label>
		<input class="form-control" type="password" id="pwd" name="pwd" value="" size="20" maxlength="20" />
		<span class="requis">${errors['pwd']}</span>
	</div>

	<div class="form-group">
		<label for="pwd2">Confirmation du mot de passe <span class="requis">*</span></label>
		<input class="form-control" type="password" id="pwd2" name="pwd2" value="" size="20" maxlength="20" />
		<span class="requis">${errors['pwd2']}</span>
	</div>

	<div class="form-group">
		<label for="name">Nom d'utilisateur</label>
		<input class="form-control" type="text" id="name" name="name" value="${ name }" size="20" maxlength="20" />
	</div>

		<input class="form-control" type="submit" value="Enregistrement" class="sansLabel" />
      	<small id="emailHelp" class="form-text info text-muted">${ actionMessage }</small>
</form>