package funciones;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Funciones {

	WebDriverWait miEspera;
	AppiumDriver<WebElement> driverSinEspera;


	/**
	 * Constructor que recibe el WebDriver 
	 * @param Recibe el AppiumDriver<WebElement> para crear las esperas.
	 */
	public Funciones(AppiumDriver<WebElement> miEspera) {
		this.driverSinEspera = miEspera;
	}


	/**
	 * Busca un elemento en la pantalla con una espera default de 10 segundos
	 * 
	 * @param By. con el xpath o la forma de buscar el elemento
	 * @return El elemento Encontrado
	 * @Autor Mateo Castanio Vasquez
	 */
	private MobileElement logicaInternaDeEsperarElemento(By elemento, int segundosDeReintento) {
		MobileElement elementoDummy = null;
		
			
			this.miEspera = new WebDriverWait(driverSinEspera, segundosDeReintento);
			
			
			elementoDummy =  (MobileElement) miEspera.ignoring(StaleElementReferenceException.class).
						until(ExpectedConditions.elementToBeClickable(elemento));
			 StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		     StackTraceElement element = stackTrace[4];
		     System.out.println("buscando :"+element.getMethodName()+" de la clase "+element.getFileName());
			
		return elementoDummy;
	}
	

	/**
	 * Busca un elemento en la pantalla con una espera default de 10 segundos no muestra error
	 * 
	 * @param By. con el xpath o la forma de buscar el elemento
	 * @return El elemento Encontrado
	 * @Autor Mateo Castanio Vasquez
	 */
	private MobileElement logicaInternaDeEsperarElementoNoMuestraError(By elemento, int segundosDeReintento) {
		MobileElement elementoDummy = null;
		try {
			
			this.miEspera = new WebDriverWait(driverSinEspera, segundosDeReintento);
			
			
			elementoDummy =  (MobileElement) miEspera.ignoring(StaleElementReferenceException.class).
						until(ExpectedConditions.elementToBeClickable(elemento));
		
			
		} catch (TimeoutException e ) {
			 StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		     StackTraceElement element = stackTrace[3];
		     System.out.println("NO SE ENCONTRO UN ELEMENTO EN LA CLASE: "+ element.getClassName()+" EN EL METODO :"+element.getMethodName() + " USANDO EL XPATH: "+elemento);		    
		}

		return elementoDummy;
	}
	
	
	/**
	 * Busca un elemento en la pantalla Y espera maximo 10 segundos o muestra error
	 * 
	 * @param By. con el xpath o la forma de buscar el elemento
	 * @return El elemento Encontrado
	 * @Autor Mateo Castanio Vasquez
	 */
	public MobileElement esperarHastaElementoVisible(By elemento) {
		return logicaInternaDeEsperarElemento(elemento, 10 );
	}
	
	/**
	 * Busca un elemento en la pantalla el cual se le indica durante cuanto tiempo reintente encontrarlo
	 * @param elemento: Elemento a buscar por By xpath, id, etc.
	 * @param segundos : tiempo en segundo que reintentara la busqueda del elemento
	 * @return
	 * Autor Mateo Castanio Vasquez
	 */
	public MobileElement esperarHastaElementoVisible(By elemento, int segundosDeReintento) {
		return logicaInternaDeEsperarElemento(elemento, segundosDeReintento);
	}
	
	
	
	
	/**
	 * Busca un elemento en la pantalla Y espera maximo 10 segundos 
	 * NOTA: NO MUESTRA ERROR SI NO ENCUENTRA EL ELEMENTO
	 * @param By. con el xpath o la forma de buscar el elemento
	 * @return El elemento Encontrado
	 * @Autor Mateo Castanio Vasquez
	 */
	public MobileElement esperarHastaElementoVisibleNoMuestraError(By elemento) {
		return logicaInternaDeEsperarElementoNoMuestraError(elemento, 10);
	}
	
	
	/**
	 * Busca un elemento en la pantalla Y espera el tiempo indicado en segundos 
	 * NOTA: NO MUESTRA ERROR SI NO ENCUENTRA EL ELEMENTO.
	 * @param elemento a buscar por By xpath, id, etc.
	 * @param segundos a esperar a que aparezca el elemento
	 * @return
	 * Autor Mateo Castanio Vasquez
	 */
	public MobileElement esperarHastaElementoVisibleNoMuestraError(By elemento, int segundosDeReintento) {
		return logicaInternaDeEsperarElementoNoMuestraError(elemento, segundosDeReintento);
	}
	
	
	
	/**
	 * Realiza el tap en la pantalla completa y no realiza el tap en ningun elemento 
	 * 
	 * Autor Mateo Castanio Vasquez
	 */
	public void realizarTapEnPantallNoElemento() {
		miEspera.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/content"))).click();
	}
	


	/**
	 * Permite la busqueda de varios elementos en la ventana
	 * @param xpath o By con metodo de busqueda
	 * @return Lista de WebElements que se encontraron con el xpath o By de busqueda
	 * 
	 * @Autor Mateo Castanio Vasquez
	 */
	public List<WebElement> leerVariosElementos(By xpath) {
		return driverSinEspera.findElements(xpath);
	}
	
	
	
	/**
	 * Permite la busqueda de varios elementos en la ventana con un tiempo de espera en milisegundos antes de iniciar la busqueda
	 * @param xpath o By con metodo de busqueda
	 * @param segundos: tiempo de espera antes de iniciar la busqueda de la lista de elementos
	 * @return Lista de WebElements que se encontraron con el xpath o By de busqueda
	 * 
	 * @Autor Mateo Castanio Vasquez
	 */
	public List<WebElement> leerVariosElementos(By xpath,int segundos) {
		esperaGlobal(segundos);
		return driverSinEspera.findElements(xpath);
	}

	
 /**
  * Permite realizar el swipe o el scroll
  * 
  * @param xInicial posicion x del punto inicial
  * @param yInicial posicion y del punto inicial
  * @param xFinal  posicion x del punto final
  * @param yFinal poisicion y del punto final
  * @param segundos  tiempo que se tarda en realizar el swipe
  * 
  * @Autor Mateo Castanio Vasquez
  */
	@SuppressWarnings("rawtypes")
	public void  swipeOscroll(int xInicial, int yInicial, int xFinal, int yFinal, int segundos) {
			esperaGlobal(5); 
			TouchAction touch = new TouchAction((PerformsTouchActions) driverSinEspera);
			touch.press(PointOption.point(xInicial, yInicial))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(segundos)))
			.moveTo(PointOption.point(xFinal, yFinal)).release().perform();
			touch = null;
	}
	
	/**
	 * Permite obtener el xpath con el cual se busco un elemento, despues de que el elemento fue encontrado
	 * @param elemento
	 * @return
	 * Autor Mateo Castanio Vasquez
	 */
	public String getXpath(WebElement elemento) {
		
		    String str = elemento.toString();
		    String[] listString = null;
		    if(str.contains("xpath"))
		      listString = str.split("xpath:");
		    else if(str.contains("id"))
		      listString = str.split("id:");
		    String last = listString[1].trim();
		    return last.substring(0, last.length() - 1);
		
	}
	
	/**
	 * Permite recibir el valor del cuatro por mil
	 * @param valorAsacar4porMil
	 * @return
	 * Autor Mateo Castanio Vasquez
	 */
	public double cuatroPorMil(double valorAsacar4porMil) {
		return Math.ceil((valorAsacar4porMil/1000)*4);
	}
	
	/**
	 * Permite recibir el valor del cuatro por mil
	 * @param valorAsacar4porMil
	 * @return
	 * Autor Mateo Castanio Vasquez
	 */
	public int cuatroPorMil(int valorAsacar4porMil) {
		return (int) Math.ceil((valorAsacar4porMil/1000)*4);
	}
	
	/**
	 * Permite recibir el valor del cuatro por mil
	 * @param valorAsacar4porMil
	 * @return
	 * Autor Mateo Castanio Vasquez
	 */
	public double cuatroPorMil(String valorAsacar4porMil) {
		return  Math.ceil((Double.parseDouble(valorAsacar4porMil.trim())/1000)*4);
	}
	
	
	
	/**
	 * Permite realizar esperas de tiempo durante segundos , remplazo para Thread.sleep
	 * @param tiempoSegundos = el tiempo en segundos a esperar
	 * Autor Mateo Castanio Vasquez
	 */
	public void esperaGlobal(int tiempoSegundos) {
		try {
			 StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
			 StackTraceElement element = stackTrace[2];
		     System.out.println("Espera antes de: " + element.getMethodName());
			Thread.sleep(tiempoSegundos*1000);
		} catch (InterruptedException e) {
			System.out.println("Fallo el tiempo de espera");
			 StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		        StackTraceElement element = stackTrace[2];
		        System.out.println("En el metodo: " + element.getMethodName());
		        System.out.println("En la clase:  " + element.getClassName());
			e.getStackTrace();
			e.printStackTrace();
		}
	}

	
}