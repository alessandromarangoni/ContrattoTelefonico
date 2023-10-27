package it.betacom.model;

public class ContrattoFisso extends ContrattoTelefonico {
	
	private String citta;
	
	public ContrattoFisso(String utente, long numeroTel, String citta) {
		super(utente, numeroTel);
		this.citta = citta;
		this.setTipoContratto("fissa");
	}

	

	/**
	 * @return the citta
	 */
	public String getCitta() {
		return citta;
	}

	/**
	 * @param citta the citta to set
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	
	
}
