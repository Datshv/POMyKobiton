package manejoCapabilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CapabilitiesDinamico {

	public CapabilitiesDinamico() {

	}

	private String consultarCapabilities(String capabilitiesBuscado) {
		String line = null; 
		StringBuilder resultado = new StringBuilder();
		try {

			Process proc = Runtime.getRuntime().exec("adb shell getprop " + capabilitiesBuscado);
			InputStream inputStream = proc.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1);

			while ((line = bufferedReader.readLine()) != null) {
				resultado.append(line);
			}
			inputStream.close();
			bufferedReader.close();
			proc.waitFor();
			proc.destroy();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(resultado.toString());
		return resultado.toString();
	}

	
	/**
	 * Permite obtener la version de android
	 * @return
	 */
	public String getVersionAndroid() {
		return consultarCapabilities("ro.build.version.release");
	}
	
	/**
	 * Permite obtener el ID unico del dispositivo
	 * @return
	 */
	public String getIdUnicoDispositivo() {
		return consultarCapabilities("ro.serialno");
	}
	 
	/**
	 * Permite obtener el nombre del dispostivo
	 * @return
	 */
	public String getNombreDispositivo() {
		String resultado = consultarCapabilities("persist.sys.device_name");
		if(resultado==null || resultado.isEmpty()) {
			resultado = "my dispositivo";
		}
		return resultado;
	}
	
	/**
	 * Permite conocer si es Android o IOS
	 * @return
	 */
	public String getPlataformName() {
		return consultarCapabilities("net.bt.name");
	}

}
