/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.bean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;

/**
 *
 * @author User
 */

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class ExitoErrorBean {
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		String url = mensaje.replace(" ", "%20");
		this.mensaje = url;
	}
	
	public String getMensajeParseado() {
		String mensaje = this.mensaje;
		mensaje = mensaje.replace("%20", " ");
		return mensaje;
	}
}
