package reality.Criterios;

import reality.Participante;

public class CriterioInstrumento extends Criterio {

	private String instrumento;
	
	public CriterioInstrumento(String instrumento){
		this.instrumento = instrumento;
	}
	
	public String getInstrumento() {
		return instrumento;
	}
	@Override
	public boolean cumple(Participante p1) {
		return p1.contieneInstrumento(instrumento);
	}

}
