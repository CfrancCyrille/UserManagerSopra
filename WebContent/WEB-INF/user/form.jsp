<form action="register" method="post" id="registration">
<fieldset form="registration">
<legend>Inscription</legend>
<label for="email" class="requis">EMAIL</label>
<input class="requis" name="email" id="email" value="${form['email']}">
<span class="error">${errors['email']}</span><br>

<label for="password" class="requis">mot de passe</label>
<input class="requis" name="password" id="password" value="${form['password']}"/>
<span class="error">${errors['password']}</span><br>

<label for="confirmPassword" class="requis">confirmer le mot de passe</label>
<input class="requis" name="confirmPassword" id="confirmPassword" value="${form['confirmPassword']}"/><br>

<label for="name">Nom d'utilisateur</label>
<input name="name" value="${form['name']}" id="name"/><br>
<button type="submit">register</button>
<p class="info">${actionMessage}</p>
</fieldset>
</form>
