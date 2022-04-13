package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	

	private Set<String> setAnagrammi;
	private AnagrammaDAO anagrammaDAO= new AnagrammaDAO();
	
	
	
	public Set<String> anagrammi(String parola) {
		setAnagrammi= new HashSet<String>(); //ogni volta che premo il bottone pulisco la struttura dati
		anagramma_ricorsiva("", 0, parola);
		return setAnagrammi; 
	}

	private void anagramma_ricorsiva(String parziale, int L, String rimanenti) {
		if(rimanenti.length()==0) {
			setAnagrammi.add(parziale);
		}else{
			for(int pos=0; pos<rimanenti.length();pos++) {
				String nuova_parziale= parziale + rimanenti.charAt(pos);
				String nuova_rimanenti= rimanenti.substring(0,pos)+ rimanenti.substring(pos+1);
				anagramma_ricorsiva(nuova_parziale, L+1, nuova_rimanenti);
			}
		}
				
	}
	
//	public Set<String> anagrammiCorretti(Set<String> setAnagrammi){
//		Set<String> corretti= new HashSet<String>();
//		for(String s: setAnagrammi) {
//			if(anagrammaDAO.isCorrect(s))
//				corretti.add(s);
//		}
//		return corretti;
//	}
//	
//	public Set<String> anagrammiNonCorretti(Set<String> setAnagrammi){
//		Set<String> nonCorretti= new HashSet<String>();
//		for(String s: setAnagrammi) {
//			if(!anagrammaDAO.isCorrect(s))
//				nonCorretti.add(s);
//		}
//		return nonCorretti;
//	}
	
	public boolean isCorrect(String anagramma) {
		return anagrammaDAO.isCorrect(anagramma);
	}
	
	

}
