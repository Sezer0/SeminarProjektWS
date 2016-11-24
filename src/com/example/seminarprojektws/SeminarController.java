package com.example.seminarprojektws;


import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import uk.ac.shef.wit.simmetrics.similaritymetrics.BlockDistance;
import uk.ac.shef.wit.simmetrics.similaritymetrics.EuclideanDistance;
import uk.ac.shef.wit.simmetrics.similaritymetrics.JaccardSimilarity;
import uk.ac.shef.wit.simmetrics.similaritymetrics.SmithWaterman;

public class SeminarController {

 private JFrame frame;
 private static CSVReader csvReader;
 private static Algorithm algorithm = new Algorithm();
 private static SeminarprojektwsUI seminarprojektwsUI;
 //private static View view = new View();
 
 private static ArrayList<csvItem> userList = csvReader.userListReader();
 private static ArrayList <String> staedteList = csvReader.staedteReader();


 
 public static void main(String[] args) throws IOException {
	 csvReader  = new CSVReader();
	 seminarprojektwsUI = new SeminarprojektwsUI();
	 
	 SmithWaterman smithWaterman = new SmithWaterman();
	 EuclideanDistance euclideanDistance = new EuclideanDistance();
	 JaccardSimilarity jaccardSimilarity = new JaccardSimilarity();
	 
	 
	 // Berechnet die Prozente wie im Dreisatz anhand der Länger der Wörter, die aus falschen buchstaben bestehen--> dieses bsp.--> ünchen =6 UC =2 d.h. 2 sind von 6 33,3 %
	 //System.out.println(smithWaterman.getSimilarity("München", "MUC"));
	 
	 // Gibt entweder 1.0 oder 0.0 aus. 1.0 wird nur bei der 100% übereinstimmung der Wörter(muss kompletter String gleich sein..in ganzer länge) ausgegeben sonst immer 0.0
	// System.out.println(euclideanDistance.getSimilarity("Daniel", "Daniel"));
	 
	 // gibt entweder 1 oder 0 zurück. Hierbei allerdings, wenn String 2 in String 1 enthalten ist mit 1,0!!
	 //System.out.println(euclideanDistance.getSimilarityTimingActual("München", "MUC"));
	 
	 //Gibt 1,0 zurück, wenn Wörter zu 100% übereinstimmen also der identische String sind..sonst 0
	 //System.out.println(jaccardSimilarity.getSimilarity("München", "München"));
	 
	
	 
	 
	
 }

 public static void algorithmClicked(String name){
	 
	switch (name){
	
	case "Soundex":
		
		ArrayList<Float> soundexpercent = algorithm.getAccuray(name, userList, staedteList ).get(0);
		
		break;
	case "Levenshtein":
		ArrayList<Float> levenshteinpercen = algorithm.getAccuray(name, userList, staedteList).get(1);
	
		
	}
 }
 
 
 /**
  * Create the application.
  */
 public SeminarController() {
  initialize();
 }
 
 /**
  * Initialize the contents of the frame.
  */
 private void initialize() {
 
 }

}