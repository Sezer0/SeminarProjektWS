package com.example.seminarprojektws;

import java.util.ArrayList;

import uk.ac.shef.wit.simmetrics.similaritymetrics.BlockDistance;
import uk.ac.shef.wit.simmetrics.similaritymetrics.Levenshtein;
import uk.ac.shef.wit.simmetrics.similaritymetrics.Soundex;

public class Algorithm {
	
 public ArrayList<ArrayList<Float>> getAccuray(String name, ArrayList <csvItem> csvArrayList, ArrayList <String> staedteArrayList){
	 ArrayList<ArrayList<Float>> algorithmsArray = new ArrayList<ArrayList<Float>>();
	 Soundex soundex = new Soundex ();
	 Levenshtein levenshtein = new Levenshtein();
	 BlockDistance blockDistance = new BlockDistance();
	 
	 String v =blockDistance.getLongDescriptionString();
	 
	 System.out.println("FICKEN");
	
	 
	 ArrayList<Float> soundexarray = new ArrayList<Float>();
	 ArrayList<Float> levenshteinarray = new ArrayList<Float>();
	 for (int i=0; i<csvArrayList.size();i++){
		 	for (int y=0; y< staedteArrayList.size();y++){
		
		 			switch(name){
	 
		 				case "Soundex":
		 					float soundexFloatLocation;
		
						 soundexFloatLocation = soundex.getSimilarity(csvArrayList.get(i).getLocation(), staedteArrayList.get(y));
						 // soundexFloatEmployeeType = soundex.getSimilarity(csvArrayList.get(i).getEmployeeType(), string2)
						 //hier geh�rt eine if abfrage hin, die die 
						 soundexarray.add(soundexFloatLocation);
					
						break;
		
						 case "Levenshtein":
							 float levenshteinFloatLocation;
							 levenshteinFloatLocation = levenshtein.getSimilarity(csvArrayList.get(i).getLocation(), staedteArrayList.get(y));
							levenshteinarray.add(levenshteinFloatLocation);
							
							 
							 
							break;
						
	 
	
		 			}
	
	 } 
		 
		 
		 
		 
		 
	 }
	 algorithmsArray.add(soundexarray);
	 algorithmsArray.add(levenshteinarray);
	 
	return  algorithmsArray;
	 
	 
	
	}
	
 public String getDescription (String name){
	 
	return "";  
 }
}
