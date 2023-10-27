package it.betacom.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;


public class ContrattoTelefonico {
	public String tipoContratto;
	private long numeroTel;
	private String utente;
	public List<Telefonata> listaTelefonate;
	private int numeroTelefonate;
	private double bolletta;
	
	
	
	public ContrattoTelefonico(String utente, long numeroTel) {
		this.utente = utente;
		this.numeroTel = numeroTel;
		this.listaTelefonate = new ArrayList<>();
		this.numeroTelefonate = 0;
		}
	
	public void StampaBolletta(List<Telefonata> listaTelefonate) {
		
		// do valore al numero di telefonate pari alla lunghezza della lista di telefonate 
		this.setNumeroTelefonate(listaTelefonate.size());
		//prendo e setto l ora attuale
        LocalDate currentDate = LocalDate.now();
        
        
        for (Telefonata telefonata : listaTelefonate) {
        		this.bolletta += telefonata.getCostoTelefonata();
        	}
        
        //formatto e stampo i dati in console 
		System.out.println("*********************************");
		System.out.println("|| Bolletta del  " + currentDate + "  ||  Linea " + this.getTipoContratto());
		
		System.out.println("|| Utente:  " + this.getUtente() + "  ||  " + this.getNumeroTel() 
		+ "  ||  Numero telefonate:  "  + this.getNumeroTelefonate()
		+ "  ||  Costo Totale: " + this.getBolletta());
		
		for (int i = 0; i < listaTelefonate.size(); i++) {
	        Telefonata telefonata = listaTelefonate.get(i);
	        System.out.println("Telefonata #" + (i + 1)); 
	        System.out.println("Durata chiamata: " + telefonata.getDurataTelefonata());
	        System.out.println("Costo telefonata: € " + telefonata.getCostoTelefonata());
	        System.out.println("------------------------------");
	    }
		
		
		
	}
	
	public void generaPdf(List<Telefonata> listaTelefonate) {
		// do valore al numero di telefonate pari alla lunghezza della lista di telefonate 
		this.setNumeroTelefonate(listaTelefonate.size());
		//prendo e setto l ora attuale
        LocalDate currentDate = LocalDate.now();
        
        for (Telefonata telefonata : listaTelefonate) {
    		this.bolletta += telefonata.getCostoTelefonata();
    	}
        
        DecimalFormat df = new DecimalFormat(" #0.00");        
        
        Document bolletta = new Document();
        
        try {
        	PdfWriter.getInstance(bolletta, new FileOutputStream("Bolletta"+ this.getTipoContratto() + ".pdf"));
        	bolletta.open();
        	
        	Paragraph paragraph = new Paragraph();
        	
        	paragraph.add(new Chunk("*********************************"));
        	paragraph.add(Chunk.NEWLINE);
        	paragraph.add(new Chunk("|| Bolletta del  " + currentDate + "  ||  Linea " + this.getTipoContratto()));
        	paragraph.add(Chunk.NEWLINE);
        	paragraph.add("|| Utente:  " + this.getUtente() + "  ||  " + "Numero di riferimento: " +  this.getNumeroTel());
        	paragraph.add(Chunk.NEWLINE);
        	paragraph.add( "||  Numero telefonate:  "  + this.getNumeroTelefonate()
    		+ "  ||  Costo Totale: " + df.format(this.getBolletta()));
        	paragraph.add(Chunk.NEWLINE);

        	for (int i = 0; i < listaTelefonate.size(); i++) {
    	        Telefonata telefonata = listaTelefonate.get(i);
    	        paragraph.add(Chunk.NEWLINE);
    	        paragraph.add("Telefonata #" + (i + 1)); 
    	        paragraph.add(Chunk.NEWLINE);
    	        paragraph.add("Durata chiamata: " + telefonata.getDurataTelefonata());
    	        paragraph.add(Chunk.NEWLINE);
    	        paragraph.add("Costo telefonata: € " + df.format(telefonata.getCostoTelefonata()));
    	        paragraph.add(Chunk.NEWLINE);
    	        paragraph.add("------------------------------");
    	    }
        	bolletta.add(paragraph);
        	bolletta.close();
        	
        }catch(Exception e) {
        	System.out.println("errore");
        }
        
	}
	
	
	
	/**
	 * @return the numeroTel
	 */
	public long getNumeroTel() {
		return numeroTel;
	}
	/**
	 * @param numeroTel the numeroTel to set
	 */
	public void setNumeroTel(long numeroTel) {
		this.numeroTel = numeroTel;
	}
	/**
	 * @return the utente
	 */
	public String getUtente() {
		return utente;
	}
	/**
	 * @param utente the utente to set
	 */
	public void setUtente(String utente) {
		this.utente = utente;
	}


	/**
	 * @return the listaTelefonate
	 */
	public List<Telefonata> getListaTelefonate() {
		return listaTelefonate;
	}


	/**
	 * @param listaTelefonate the listaTelefonate to set
	 */
	public void setListaTelefonate(List<Telefonata> listaTelefonate) {
		this.listaTelefonate = listaTelefonate;
	}


	/**
	 * @return the bolletta
	 */
	public double getBolletta() {
		return bolletta;
	}


	/**
	 * @param bolletta the bolletta to set
	 */
	public void setBolletta(double bolletta) {
		this.bolletta = bolletta;
	}
	
	public String getTipoContratto() {
		return tipoContratto;
	}

	public void setTipoContratto(String tipoContratto) {
		this.tipoContratto = tipoContratto;
	}

	/**
	 * @return the numeroTelefonate
	 */
	public int getNumeroTelefonate() {
		return numeroTelefonate;
	}

	/**
	 * @param numeroTelefonate the numeroTelefonate to set
	 */
	public void setNumeroTelefonate(int numeroTelefonate) {
		this.numeroTelefonate = numeroTelefonate;
	}
}
