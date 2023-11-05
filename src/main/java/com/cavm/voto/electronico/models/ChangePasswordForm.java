package com.cavm.voto.electronico.models;

import jakarta.validation.constraints.NotBlank;

public class ChangePasswordForm {

	@NotBlank(message = "La contraseña actual es obligatoria")
	private String currentPassword;
	
	@NotBlank(message = "La nueva contraseña es oblogatoria")
	private String newPassword;
	
	@NotBlank(message = "Debe repetir la nueva contraseña")
	private String repeatNewPassword;

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepeatNewPassword() {
		return repeatNewPassword;
	}

	public void setRepeatNewPassword(String repeatNewPassword) {
		this.repeatNewPassword = repeatNewPassword;
	}
	
	
}
