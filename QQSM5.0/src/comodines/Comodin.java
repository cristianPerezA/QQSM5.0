package comodines;

import preguntas.Pregunta;

public abstract class Comodin {

	//Atributos de la clase padre Comod�n que despu�s heredar�n todos los comodines
	protected boolean usado;
	protected String nombreComodin;


	/**Constructor de la clase padre comod�n pas�ndole como parametro el boolean de si ha sdo usado o no
	 * @param usado
	 */
	public Comodin(boolean usado) {
		super();
		this.usado = usado;
	}


	public boolean isUsado() {
		return usado;
	}


	public void setUsado(boolean usado) {
		this.usado = usado;
	}


	public String getNombreComodin() {
		return nombreComodin;
	}


	public void setNombreComodin(String nombreComodin) {
		this.nombreComodin = nombreComodin;
	}


	/**M�todo que tendr�n que implementar cada uno de los comodines pero cada uno con su respectivo c�digo para que despu�s cada uno haga lo que necesite.
	 * @param pregunta
	 */
	public abstract void utilizarComodin( Pregunta pregunta);


}