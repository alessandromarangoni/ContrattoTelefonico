package it.betacom.main;

import it.betacom.model.ContrattoFisso;
import it.betacom.model.ContrattoMobile;
import it.betacom.model.Telefonata;

public class Main {

	public static void main(String[] args) {
		
		//Istanzio il primo contratto Fisso
		ContrattoFisso contrattoFisso = new ContrattoFisso("Alessandro Marangoni", 1083814275L,"Padova");
		ContrattoMobile contrattoMobile = new ContrattoMobile("gino Paoli", 3883814275L);

		
		// genero telefonate per l istanza di contratto fisso
		for(int i = 0;  i < 10; i++ ) {
			 Telefonata telefonata = new Telefonata(contrattoFisso.getTipoContratto());
			    contrattoFisso.listaTelefonate.add(telefonata);
		}
		
		// genero telefonate per l istanza di contratto mobile
		for(int i = 0;  i < 10; i++ ) {
			 Telefonata telefonata = new Telefonata(contrattoMobile.getTipoContratto());
			    contrattoMobile.listaTelefonate.add(telefonata);
		}
		//stampo i resoconti in console
		contrattoFisso.StampaBolletta(contrattoFisso.getListaTelefonate());
		contrattoMobile.StampaBolletta(contrattoMobile.getListaTelefonate());
		
		//stampo i resoconti in un pdf nella cartella del progetto
		contrattoFisso.generaPdf(contrattoFisso.getListaTelefonate());
		contrattoMobile.generaPdf(contrattoMobile.getListaTelefonate());
		
		
	}

}
