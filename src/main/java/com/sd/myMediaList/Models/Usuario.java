package com.sd.myMediaList.Models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "users")
public class Usuario extends RepresentationModel<Usuario> implements Serializable {

	@Id
	String username;

	String password;

	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Usuario usuario = (Usuario) o;
		return Objects.equals(username, usuario.username) && Objects.equals(password, usuario.password) && Objects.equals(email, usuario.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), username, password, email);
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
