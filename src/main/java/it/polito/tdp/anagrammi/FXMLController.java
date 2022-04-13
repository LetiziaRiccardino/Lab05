package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private Button btnReset;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private TextField txtInput;
    
    private Model model;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {

    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    	
    	String parola= txtInput.getText();
    	
    	if(parola.length()<2) {
    		txtAnagrammiCorretti.setText("Parola inserita troppo corta. Inserire almeno 3 lettere");
    		txtAnagrammiErrati.setText("Parola inserita troppo corta. Inserire almeno 3 lettere");
    		return;
    	}
    	
    	Set<String> anagrammi= this.model.anagrammi(parola);
    	
    	for(String s: anagrammi) {
    		if(model.isCorrect(s))
    			txtAnagrammiCorretti.appendText(s+"\n");
    		else
    			txtAnagrammiErrati.appendText(s+"\n");
    	}
    	
    	
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtInput.clear();
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();

    }

    @FXML
    void initialize() {
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		
	}

}
