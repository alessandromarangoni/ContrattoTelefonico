package it.betacom.model;

public class Telefonata{

	private double durataTelefonata;
	private double costoTelefonata;
	
	private static final double COSTO_AL_SECONDO = 0.01;
	
	//costruttore
	public Telefonata(String contratto) {
		
		// Creo in automatico una chiamata di durata random
		this.durataTelefonata = (int) (Math.random() * 300);
		
		
		//verifico il tipo di contratto e in seguito setto le prezzistiche in base alla durata e al tipo di contratto
		if (contratto.equalsIgnoreCase("fissa")) {
			
			this.costoTelefonata = (this.durataTelefonata * Telefonata.COSTO_AL_SECONDO);
		}
		else if (contratto.equalsIgnoreCase("mobile")) {
			this.costoTelefonata = (this.durataTelefonata * Telefonata.COSTO_AL_SECONDO)+ 1.5;
		}
	}

	/**
	 * @return the durataTelefonata
	 */
	public double getDurataTelefonata() {
		return durataTelefonata;
	}

	/**
	 * @param durataTelefonata the durataTelefonata to set
	 */
	public void setDurataTelefonata(double durataTelefonata) {
		this.durataTelefonata = durataTelefonata;
	}

	/**
	 * @return the costoTelefonata
	 */
	public double getCostoTelefonata() {
		return costoTelefonata;
	}

	/**
	 * @param costoTelefonata the costoTelefonata to set
	 */
	public void setCostoTelefonata(double costoTelefonata) {
		this.costoTelefonata = costoTelefonata;
	}
	
}
