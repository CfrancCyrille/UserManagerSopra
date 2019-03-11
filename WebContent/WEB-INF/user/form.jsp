
<form action="" method="post">
	<fieldset>
		<legend>Inscirption</legend>
		<p class="info">${actionMessage}</p>
		<p>Formulaire d'inscription, les champs (*) sont requis :</p>
		<p>
			<span class="error">${errors['email']}</span> <label for="email">Adresse
				email <span class="requis">*</span>
			</label> <input type="email" name="email" class="form-control" id="email"
				value="${form['email']}" required />
		</p>
		<p>
			<label for="password">Mot de passe <span class="requis">*</span>
			</label> <input type="password" name="pwd1" class="form-control"
				id="password" required value="${form['pwd1']}" /> <span
				class="error">${errors['pwd1']}</span>
		</p>
		<p>
			<label for="passwordRepeat">Confirmation du mot de passe <span
				class="requis">*</span>
			</label> <input type="password" name="pwd2" class="form-control"
				id="passwordRepeat" required value="${form['pwd2']}" />
		</p>
		<p>
			<label for="username">Nom d'utilisateur</label> <input type="text"
				name="name" class="form-control" id="username" value="${form['name']}" />
		</p>

		<button type="submit" class="btn btn-primary">Enregistrement</button>
	</fieldset>
</form>