public class IMC{
	
	/**
	 * Calcula el Índice de Masa Corporal de una persona.
	 * @param peso el peso de la persona.
	 * @param altura la altura de la persona.
	 * @return el imc de la persona.
	 */
	public float calcularIMC(int peso, double altura){
		float alt = (float)altura;
		float imc = peso/(alt*alt);
		return imc;
	}
	
	/**
	 * Regresa el estado de salud de una persona dados sus
	 * imc y género.
	 * @param genero el genero (Hombre o Mujer) de la persona.
	 * @param imc el imc de la persona
	 * @return un String con el estado de salud de la persona.
	 */
	public String darResultado(String g, float imc){
		// Caso Género = Hombre
		if(g == "hombre"){
			if(imc <= 15){
				return "Muy Delgado, IMC: " + imc ;
			}
			if((imc > 15) && (imc <= 20)){
				return "Delgado, IMC: " + imc;
			}
			if((imc > 20) && (imc <= 25)){
				return "IMC Normal, IMC: "+ imc;
			}
			if((imc > 25) && (imc <= 30)){
				return "Gordura, IMC: "+ imc;
			}
			if(imc > 30){
				return "Obesidad, IMC: "+ imc;
			}
		}
		
		// Caso Género = Mujer
		if(g == "mujer"){
			if(imc <= 13){
				return "Muy Delgada, IMC: "+ imc;
			}
			if((imc > 13) && (imc <= 18)){
				return "Delgada, IMC: "+ imc;
			}
			if((imc > 18) && (imc <= 23)){
				return "IMC Normal: "+ imc;
			}
			if((imc > 23) && (imc <= 28)){
				return "Gordura, IMC: "+ imc;
			}
			if(imc > 28){
				return "Obesidad, IMC: "+ imc;
			}
		}
		return "";
	}
}
