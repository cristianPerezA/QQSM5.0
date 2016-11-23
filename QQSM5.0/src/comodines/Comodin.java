package comodines;

import preguntas.Pregunta;

public abstract class Comodin {

	//Atributos de la clase padre Comodín que después heredarán todos los comodines
	protected boolean usado;
	protected String nombreComodin;


	/**Constructor de la clase padre comodín pasándole como parametro el boolean de si ha sdo usado o no
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


	/**Método que tendrán que implementar cada uno de los comodines pero cada uno con su respectivo código para que después cada uno haga lo que necesite.
	 * @param pregunta
	 */
	public abstract void utilizarComodin( Pregunta pregunta);


}