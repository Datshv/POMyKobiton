package flujos;

import java.util.ResourceBundle;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import pages.LoginPage;

public class LoginStep {
	
	LoginPage paginaLogeo;
	ResourceBundle rb = ResourceBundle.getBundle("funciones/configuracion");

	public LoginStep(AppiumDriver<WebElement> driver)  {
		 paginaLogeo = new LoginPage(driver);
	}
	

	public void correrLogin(){
		
		try {
			
		if (paginaLogeo.getPaseo() != null) {
			paginaLogeo.clickPaseoSkip();
		}
	
	
		if (paginaLogeo.getCreaTuCuenta() != null) {
			paginaLogeo.tapEntrarSiCrearCuenta();
		}

		paginaLogeo.tapEnTelefono();
		paginaLogeo.llenarTelefono(rb.getString("telefonoDeCuenta"));
		paginaLogeo.tapEntrar();
		paginaLogeo.llenarPassword(rb.getString("password"));
		
		if(paginaLogeo.getElementoHome()==null) {
		
		if(paginaLogeo.getEnlaceDispositivo() != null) {
			paginaLogeo.tapEnlaceDispositivo();
		}

		if (paginaLogeo.getBotonListo() != null) {
			paginaLogeo.tapEnListo();

		}
		if (paginaLogeo.getIngresarCodigo() != null) {
			paginaLogeo.llenarPassword("1234");
		}

		if (paginaLogeo.getReconocimientoFacial() != null) {
			paginaLogeo.tapEnReconocimientoFacial();
		}

		if (paginaLogeo.getBotonAhoraNo() != null) {
			paginaLogeo.tapBotonAhoraNo();
		}
		
		if(paginaLogeo.getMensajeAquiRecargasTuCuenta()!= null) {
			paginaLogeo.tapMensajeAquiRecargasTuCuenta();
		}
		
		if(paginaLogeo.getMensajeMovimientoCuentaNequi()!= null) {
			paginaLogeo.tapMensajeMovimientoCuentaNequi();
		}
		
		if(paginaLogeo.getMensajeServiciosOfreceNequi()!= null) {
			paginaLogeo.tapMensajeServiciosOfreceNequi();
		}
		if(paginaLogeo.getQuieresConocerLoNuevoDeNequi()!= null) {
			paginaLogeo.tapQuieresConocerLoNuevoNequi();
		}
		if (paginaLogeo.getCerrar() != null) {
			paginaLogeo.clickCerrar();
		}
		}
		rb=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void correrLogin(String numeroTelefonico, String password) {
		try {
			
			if (paginaLogeo.getPaseo() != null) {
				paginaLogeo.clickPaseoSkip();
			}
		
		
			if (paginaLogeo.getCreaTuCuenta() != null) {
				paginaLogeo.tapEntrarSiCrearCuenta();
			}

			paginaLogeo.tapEnTelefono();
			paginaLogeo.llenarTelefono(numeroTelefonico);
			paginaLogeo.tapEntrar();
			paginaLogeo.llenarPassword(password);
			
			if(paginaLogeo.getElementoHome()==null) {
				
			
			if(paginaLogeo.getEnlaceDispositivo() != null) {
				paginaLogeo.tapEnlaceDispositivo();
			}
	
			if (paginaLogeo.getBotonListo() != null) {
				paginaLogeo.tapEnListo();
	
			}
			if (paginaLogeo.getIngresarCodigo() != null) {
				paginaLogeo.llenarPassword(password);
			}
	
			if (paginaLogeo.getReconocimientoFacial() != null) {
				paginaLogeo.tapEnReconocimientoFacial();
			}
	
			if (paginaLogeo.getBotonAhoraNo() != null) {
				paginaLogeo.tapBotonAhoraNo();
			}
			
			if(paginaLogeo.getMensajeAquiRecargasTuCuenta()!= null) {
				paginaLogeo.tapMensajeAquiRecargasTuCuenta();
			}
			
			if(paginaLogeo.getMensajeMovimientoCuentaNequi()!= null) {
				paginaLogeo.tapMensajeMovimientoCuentaNequi();
			}
			
			if(paginaLogeo.getMensajeServiciosOfreceNequi()!= null) {
				paginaLogeo.tapMensajeServiciosOfreceNequi();
			}
			if(paginaLogeo.getQuieresConocerLoNuevoDeNequi()!= null) {
				paginaLogeo.tapQuieresConocerLoNuevoNequi();
			}
			if (paginaLogeo.getCerrar() != null) {
				paginaLogeo.clickCerrar();
			}
			}
			rb=null;
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	
	public LoginPage paginaLoginConElementos() {
		return paginaLogeo;
	}
	

}
