package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import funciones.Funciones;
import io.appium.java_client.AppiumDriver;

public class LoginPage {

	Funciones funciones;
	private WebElement telefono;
	private WebElement botonEntrarCrearCuenta;
	private WebElement botonEntrar;
	private WebElement numeroContrasenia;
	private WebElement botonListo;
	private WebElement reconocimientoFacial;
	private WebElement botonAhoraNo;
	private WebElement botonCerrar;
	private WebElement ingresarCodigo;
	private WebElement creaTuCuenta;
	private WebElement paseo;
	private WebElement ponTuClave;
	private WebElement pantallaEntera;
	private WebElement enlaceDispositivo;
	private WebElement quiereConocerLoNuevoNequi;
	private WebElement mensajeAquiRecargasTuCuenta; //*[contains(@text,'Aquí recargas tu cuenta') or contains(@content-desc,'Aquí recargas tu cuenta')]
	private WebElement mensajeMovimientoCuentaNequi; //*[contains(@text,'movimientos de tu cuenta Nequi') or contains(@content-desc,'movimientos de tu cuenta Nequi')]
	private WebElement mensajeServiciosOfreceNequi; //*[contains(@text,'servicios que te ofrece Nequi') or contains(@content-desc,'servicios que te ofrece Nequi')]
	private WebElement elementoHome;
	private WebElement mensajeClaveIncorrecta;
	private WebElement vuelveAintentarloClave;
	private WebElement accesoBloqueado;
	
	public LoginPage(AppiumDriver<WebElement> wait) {
		funciones = new Funciones(wait);

	}

	
	
	//-------- SETTERS--------
	public void setEnlaceDispositivo() {
		enlaceDispositivo = funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath("//*/android.widget.Button[@text='Acepta ' or @content-desc='Acepta ' or @text='Acepta' or @content-desc='Acepta']"),10);
	}
	
	public void setPantallaEntera() {
	    pantallaEntera = funciones.esperarHastaElementoVisible(By.id("android:id/content"));
	}
	
	public void setTelefono(Boolean flag) {
		if (flag == true) {
			telefono = null;
		}
		if (telefono == null)
			telefono = funciones.esperarHastaElementoVisible(By.className("android.widget.EditText"),20);

	}

	public void setReconocimientoFacial() {
		
		if (reconocimientoFacial == null)
			reconocimientoFacial = funciones.esperarHastaElementoVisibleNoMuestraError((By.xpath(
					"//*[contains(@text, 'Reconocimiento facial Tu cara es solo tuya y con ella evitas que alguien entre a tu cuenta. ')  or contains(@text, 'Reconocimiento facial') ]")),3);
	}

	public void setBotonAhoraNo() {
		if (botonAhoraNo == null)
			botonAhoraNo = funciones
					.esperarHastaElementoVisibleNoMuestraError((By.xpath("//*[contains(@text,'Ahora no') or @content-desc='Ahora no' ]")),3);

	}

	public void setEntrarSiCrearCuenta() {
		if (botonEntrarCrearCuenta == null)
			botonEntrarCrearCuenta = funciones
					.esperarHastaElementoVisible(By.xpath("//*[contains(@text,'Entra') and @clickable='true']"));
	}

	public void setEntrar() {
		if (botonEntrar == null)
			botonEntrar = funciones.esperarHastaElementoVisible(By.xpath("//*[@text='Entra ' or @content-desc='Entra ' or  @text='Entra' or @content-desc='Entra']"));
	}

	public void setBotonListo() {
		botonListo = funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath("//*[@text ='Enlace del dispositivo' or @content-desc='Enlace del dispositivo']/..//*[@text='Listo ' or @content-desc='Listo ' or @text='Listo' or @content-desc='Listo']"),8);
	}

	public void setCerrar() {
		if (botonCerrar == null)
			botonCerrar = funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath("//*[@text='' or @content-desc='']"),8);
	}

	public void setIngresarCodigo() {
		if (ingresarCodigo == null)
			ingresarCodigo = funciones.esperarHastaElementoVisibleNoMuestraError(
					By.xpath("//*/android.view.View[contains(@text,'Introduce el código') or @content-desc='Introduce el código']"),10);
	}


	
	public void setCreaTuCuenta() {
		if (creaTuCuenta == null)
			creaTuCuenta = funciones.esperarHastaElementoVisibleNoMuestraError(
					By.xpath("//*/android.widget.Button[contains(@text,'Crea tu cuenta') or @content-desc='Crea tu cuenta']"));
	}

	public void setPaseo() {
		if (paseo == null)
			paseo = funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath(
					"//*/android.widget.Button[@text='Salta ' or @content-desc='Salta ' or @text='Salta' or @content-desc='Salta']"),10);
	}

	public void setPonTuClave(Boolean flag) {
		if (flag == true) {
			ponTuClave = null;
		}
		if (ponTuClave == null)
			ponTuClave = funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath("//*[@text='Pon tu clave' or  @content-desc='Pon tu clave']"));
	}

	public void setQuieresConocerLoNuevoDeNequi() {
		
		if (quiereConocerLoNuevoNequi == null)
			quiereConocerLoNuevoNequi = funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath("//*[contains(@text,'¿Quieres conocer lo nuevo de') or contains(@content-desc,'¿Quieres conocer lo nuevo de')]/../*[@text='×' or @content-desc='×']"));
	}
	
	public void setMensajeAquiRecargasTuCuenta() {
		
		if (mensajeAquiRecargasTuCuenta == null)
			mensajeAquiRecargasTuCuenta = funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath("//*[contains(@text,'Aquí recargas tu cuenta') or contains(@content-desc,'Aquí recargas tu cuenta')]"));
	}
	
public void setMensajeMovimientoCuentaNequi() {
		
		if (mensajeMovimientoCuentaNequi == null)
			mensajeMovimientoCuentaNequi = funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath("//*[contains(@text,'movimientos de tu cuenta Nequi') or contains(@content-desc,'movimientos de tu cuenta Nequi')]"));
	}


public void setMensajeServiciosOfreceNequi() {
	
	if (mensajeServiciosOfreceNequi == null)
		mensajeServiciosOfreceNequi = funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath("//*[contains(@text,'servicios que te ofrece Nequi') or contains(@content-desc,'servicios que te ofrece Nequi')]"));
}

public void setElementoHome() {
	
	if (elementoHome == null)
		elementoHome = funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath("//*[@text='Disponible' or @content-desc='Disponible']"));
}




public void setMensajeClaveIncorrecta() {
	
	if (mensajeClaveIncorrecta == null)
		mensajeClaveIncorrecta = funciones.esperarHastaElementoVisible(By.xpath("//*[contains(@text,'Ups! Esa no es tu clave') or contains(@content-desc,'Ups! Esa no es tu clave')]"));
}


public void setVuelveAintentarloClave() {
	
	if (vuelveAintentarloClave == null)
		vuelveAintentarloClave = funciones.esperarHastaElementoVisible(By.xpath("//*[contains(@text,'Vuelve a intentarlo') or contains(@content-desc,'Vuelve a intentarlo')]"));
}




public void setAccesoBloqueado() {
	
	if (accesoBloqueado == null)
		accesoBloqueado = funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath("//*[@text='Acceso bloqueado' or @content-desc='Acceso bloqueado']"));
}



	// GETTERS
	public WebElement getReconocimientoFacial() {
		setReconocimientoFacial();
		return reconocimientoFacial;
	}

	public WebElement getBotonAhoraNo() {
		setBotonAhoraNo();
		return botonAhoraNo;
	}

	public WebElement getBotonListo() {
		setBotonListo();
		return botonListo;
	}

	public WebElement getCerrar() {
		setCerrar();
		return botonCerrar;
	}

	public WebElement getIngresarCodigo() {
		setIngresarCodigo();
		return ingresarCodigo;
	}

	public WebElement getCreaTuCuenta() {
		setCreaTuCuenta();
		return creaTuCuenta;
	}

	public WebElement getPonTuClave() {
		setPonTuClave(false);
		return ponTuClave;
	}

	public WebElement getPaseo() {
		setPaseo();
		return paseo;
	}
	
	public WebElement getEnlaceDispositivo() {
		setEnlaceDispositivo();
		return enlaceDispositivo;
	}

	public WebElement getQuieresConocerLoNuevoDeNequi() {
		setQuieresConocerLoNuevoDeNequi();
		return quiereConocerLoNuevoNequi;
	}
	
	public WebElement getMensajeAquiRecargasTuCuenta() {
		setMensajeAquiRecargasTuCuenta();
		return mensajeAquiRecargasTuCuenta;
	}
	
	public WebElement getMensajeMovimientoCuentaNequi() {
		setMensajeMovimientoCuentaNequi();
		return mensajeMovimientoCuentaNequi;
	}
	
	public WebElement getMensajeServiciosOfreceNequi() {
		setMensajeServiciosOfreceNequi();
		return mensajeServiciosOfreceNequi;
	}
	
	public WebElement getElementoHome() {
		setElementoHome();
		return elementoHome;
	}
	
	public WebElement getMensajeClaveIncorrecta() {
		setMensajeClaveIncorrecta();
		return mensajeClaveIncorrecta;
	}
	
	public WebElement getVuleveAintentarClave() {
		setVuelveAintentarloClave();
		return vuelveAintentarloClave;
	}
	
	public WebElement getAccesoBloqueado() {
		setAccesoBloqueado();
		return accesoBloqueado;
	}
	
	//----- ACCIONES-------

	public void tapEnTelefono() {
		setTelefono(false);
		telefono.click();
	}

	public void llenarTelefono(String celular) {
		setTelefono(false);
		telefono.clear();
		setTelefono(true);
		telefono.sendKeys(celular);
	}

	public void tapEnReconocimientoFacial() {
		funciones.esperaGlobal(10);
		setReconocimientoFacial();
		reconocimientoFacial.click();
	}

	public void tapBotonAhoraNo() {
		setBotonAhoraNo();
		botonAhoraNo.click();
	}

	public int llenarPassword(String contrasenia) {
		int contadorDeVueltas=0;
		Boolean otroIntento= true;
		do {
			contadorDeVueltas = contadorDeVueltas +1;
			for (char numeroDeContra : contrasenia.toCharArray()) {
				numeroContrasenia = funciones.esperarHastaElementoVisible(By.xpath("//*[(@text='"+numeroDeContra+"' or @content-desc='"+numeroDeContra+"') and @clickable='true']"),10);
				numeroContrasenia.click();
			}
			//
		if(getBotonListo()==null) {
		try {
			funciones.esperaGlobal(10);
			if(funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath("*//android.view.View[2]/android.view.View[@text='*']"), 5)==null
					||funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath("*//android.view.View[3]/android.view.View[@text='*']"), 5)==null
					||funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath("*//android.view.View[4]/android.view.View[@text='*']"), 5)==null 
				    ||funciones.esperarHastaElementoVisibleNoMuestraError(By.xpath("*//android.view.View[5]/android.view.View[@text='*']"), 5)==null) 
				{
					funciones.esperarHastaElementoVisible(By.xpath("//*[@text='t']"),5).click();
					funciones.esperarHastaElementoVisible(By.xpath("//*[@text='t']"),5).click();
					funciones.esperarHastaElementoVisible(By.xpath("//*[@text='t']"),5).click();
					funciones.esperarHastaElementoVisible(By.xpath("//*[@text='t']"),5).click();
					otroIntento = false;
				}
		} catch (TimeoutException e) {
			
			System.out.println("Ingreso correctamente la clave");
			break;
		}
		}
		if(contadorDeVueltas==4) {
			break;
		}
		
		}while(otroIntento != true);
		return contadorDeVueltas;
	}

	public void tapEntrarSiCrearCuenta() {
		setEntrarSiCrearCuenta();
		botonEntrarCrearCuenta.click();
	}

	public void tapEntrar() {
		setEntrar();
		botonEntrar.click();
	}

	public void tapEnListo() {
		setBotonListo();
		botonListo.click();
	}

	public void clickCerrar() {
		setCerrar();
		botonCerrar.click();
	}

	public void clickPaseoSkip() {
		paseo.click();
	}
	
	public void tapPantallaEntera() {
		setPantallaEntera();
		pantallaEntera.click();
	}

	public void tapEnlaceDispositivo() {
		setEnlaceDispositivo();
		enlaceDispositivo.click();
	}
	
	public void tapQuieresConocerLoNuevoNequi() {
		setQuieresConocerLoNuevoDeNequi();
		quiereConocerLoNuevoNequi.click();
	}
	
	public void tapMensajeAquiRecargasTuCuenta() {
		setMensajeAquiRecargasTuCuenta();
		mensajeAquiRecargasTuCuenta.click();
	}
	
	public void tapMensajeMovimientoCuentaNequi() {
		setMensajeMovimientoCuentaNequi();
		mensajeMovimientoCuentaNequi.click();
	}
	
	
	public void tapMensajeServiciosOfreceNequi() {
		setMensajeServiciosOfreceNequi();
		mensajeServiciosOfreceNequi.click();
	}
	
	
	
	
	public void llenarPasswordNVeces(String contrasenia, int intentos) {
		for (int i = 1; i <= intentos; i++) {
		
			for (char numeroDeContra : contrasenia.toCharArray()) {
				numeroContrasenia = funciones.esperarHastaElementoVisible(By.xpath("//*[(@text='"+numeroDeContra+"' or @content-desc='"+numeroDeContra+"') and @clickable='true']"),10);
				numeroContrasenia.click();
			}
			
		}
		
		
	}
	
	public void tapVuelveAintentarloClave() {
		setVuelveAintentarloClave();
		vuelveAintentarloClave.click();
	}
	
}

