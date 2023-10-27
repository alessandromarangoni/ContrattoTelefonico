package it.betacom.model;


public class ContrattoMobile extends ContrattoTelefonico {

	

	
	public ContrattoMobile(String utente, long numeroTel) {
		super(utente, numeroTel);
		this.setTipoContratto("mobile");
	}
	
}
