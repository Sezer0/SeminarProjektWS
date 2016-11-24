package com.example.seminarprojektws;


import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SeminarController {

 private JFrame frame;
 private static CSVReader csvReader;
 private static Algorithm algorithm = new Algorithm();
 //private static View view = new View();
 
 private static ArrayList<csvItem> userList = csvReader.userListReader();
 private static ArrayList <String> staedteList = csvReader.staedteReader();


 
 public static void main(String[] args) throws IOException {
	 csvReader  = new CSVReader();
	
 }

 public static void algorithmClicked(String name){
	 
	switch (name){
	
	case "Soundex":
		
		ArrayList<Float> soundexpercent = algorithm.getAccuray(name, userList, staedteList ).get(0);
		
		break;
	case "Levenshtein":
		ArrayList<Float> levenshteinpercen = algorithm.getAccuray(name, userList, staedteList).get(1);
		System.out.println(levenshteinpercen);
		
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