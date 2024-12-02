package gui.guifahrraeder;
   
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.FahrradModel;
import business.Fahrrädern;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class Fahrradview {
	  
    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblName 					= new Label("Name:");
    private Label lblFahrrad  		= new Label("Typ:");
    private Label lblRahmennummer  	 		= new Label("rahmennummer:");
    private Label lblMensch   			= new Label("k , d, h:");
    private Label lblgröße  		= new Label("größe :");
    
    
    
    private TextField txtName 	 			= new TextField();
    private TextField txtFarradtyp		= new TextField();
    private TextField txtrahmennu8mmer		= new TextField();
    private TextField txtmensch		= new TextField();
    private TextField txtgröße	= new TextField();
    
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    // speichert temporaer ein Objekt vom Typ Buergeramt
  
    private FahrradControl pcontrol;
    private FahrradModel pModel;
    
    public Fahrradview(FahrradControl pcontrol, Stage primaryStage, FahrradModel pModel){
    	
    	this.pcontrol = pcontrol;
    	this.pModel = pModel;
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Fahrrädern");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
    }
    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblName.setLayoutX(20);
    	lblName.setLayoutY(90);
    	lblFahrrad.setLayoutX(20);
    	lblFahrrad.setLayoutY(130);
    	lblRahmennummer.setLayoutX(20);
    	lblRahmennummer.setLayoutY(170);
    	lblMensch.setLayoutX(20);
    	lblMensch.setLayoutY(210);
    	lblgröße.setLayoutX(20);
    	lblgröße.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblName, lblFahrrad, lblRahmennummer,
       		lblMensch, lblgröße);
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtFarradtyp.setLayoutX(170);
    	txtFarradtyp.setLayoutY(130);
    	txtFarradtyp.setPrefWidth(200);
    	txtrahmennu8mmer.setLayoutX(170);
    	txtrahmennu8mmer.setLayoutY(170);
    	txtrahmennu8mmer.setPrefWidth(200);
    	txtmensch.setLayoutX(170);
    	txtmensch.setLayoutY(210);
    	txtmensch.setPrefWidth(200);
    	txtgröße.setLayoutX(170);
    	txtgröße.setLayoutY(250);
    	txtgröße.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, txtFarradtyp, txtrahmennu8mmer,
     		txtmensch, txtgröße);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    nehmedfarrhadauf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	    		zeigeFarradan();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	    		pcontrol.leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		    	pcontrol.leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				pcontrol.schreibeFarradtInCsvDatei();
			}	
	    });
    }
 
    private void nehmedfarrhadauf(){
    	try{
    		pModel.setFarradgeschäft(new Fahrrädern(
    			txtName.getText(), 
   	           	txtFarradtyp.getText(),
   	            Integer.parseInt(txtrahmennu8mmer.getText()),
    		    txtmensch.getText(),
    		    txtgröße.getText().split(";")));
    		zeigeInformationsfensterAn("Das Farrädern wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		exc.printStackTrace();
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
  
   
    public void zeigeFarradan(){
    	   if (pModel != null) {
    	         
    		   
               Fahrrädern fahradräder = pModel.getFarradgeschäft();
               
               
               String[] fahradr = pModel.getFahrArray();
               if(fahradr == null) {
            	   
            	   txtAnzeige.setText(
               			pModel.getFarradgeschäft().gibFahrradZurueck(' '));
               }
        
               StringBuilder textAnzeigeInhalt = new StringBuilder();

            
               if (fahradräder != null) {
                   textAnzeigeInhalt.append(fahradräder.gibFahrradZurueck(' ')).append("\n");
               } else {
                   textAnzeigeInhalt.append(" ");
               }

             
               if (fahradr != null && fahradr.length > 0) {
               	
                   for (String line : fahradr) {
                       textAnzeigeInhalt.append(line).append("\n");
                   }
               } else {
                   textAnzeigeInhalt.append(" ");
               }

           
               txtAnzeige.setText(textAnzeigeInhalt.toString());
           } else {
               zeigeInformationsfensterAn("Bisher wurde kein  aufgenommen!");
           }
    	   
    	   
  
    }    
		  


    public void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }

}
