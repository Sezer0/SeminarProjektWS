package com.example.seminarprojektws;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public  class CSVReader {
	
	private static ArrayList<csvItem> csvArrayList = new ArrayList<csvItem>();
	private static HashMap<Integer, csvItem> csvHashMap = new HashMap<>();
	private static ArrayList<String> csvStaedteList = new ArrayList<String>();
	
    public static void main(String[] args) {

    //	userListReader();
 
    	userListReader();
    	staedteReader();
    }   

    public static ArrayList<String> staedteReader()  {
		String staedteFile = "/Users/Florian/Desktop//staedte.csv";
		BufferedReader bufferedReader = null;
		String lineStaedte = ";";
		String cvsStaedteSplitBy = ";";
		
		
		try {
			bufferedReader = new BufferedReader(new FileReader(staedteFile));
			 try {
				while ((lineStaedte = bufferedReader.readLine()) != null) {
					 
					 String [] staedte = lineStaedte.split(cvsStaedteSplitBy);
					 csvStaedteList.add(staedte[0]);
					 
				 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return csvStaedteList;
		
	}
public static HashMap<Integer, csvItem> userListReader(){///////////////////////////////////////////////////////////////////////////
    	
    	String csvFile = "/Users/Florian/Desktop/HR.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        int z  = 0;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] csvArray = line.split(cvsSplitBy);

                //System.out.println("csvArray [code= " + csvArray[4] + " , name=" + csvArray[5] + "]");
                /*System.out.println("Spalte DN: "+ csvArray[0] + "\n "
                		+ "Spalte EmployeeNr: " + csvArray[1] + "\n"
                				+ "Spalte GivenName: " +csvArray[2] + "\n"
                						+ "Spalte LastName: " +csvArray[3] + "\n "
                								+ "Spalte Location: " +csvArray[4] + "\n "
                										+ "Spalte EmployeeType: " + csvArray[5] + "\n "
                												+ "Spalte: Function: " + csvArray[6] + "\n "
                														+ "Spalte Valid_Until: " +  csvArray[7] + "\n "
                																+ "Spalte EMail: " + csvArray[8]);*/
                
       csvItem newCsvItem = new csvItem (csvArray[0], csvArray[1], csvArray[2], csvArray[3], csvArray[4], csvArray[5], csvArray[6], csvArray[7], csvArray[8]);
       csvArrayList.add(newCsvItem); 
       csvHashMap.put(z,newCsvItem);
       
       z++;
                
            }

            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       
        return csvHashMap;
    }
    
/*	public static ArrayList<csvItem> userListReader(){///////////////////////////////////////////////////////////////////////////
    	
    	String csvFile = "/Users/Florian/Desktop/HR.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] csvArray = line.split(cvsSplitBy);

                //System.out.println("csvArray [code= " + csvArray[4] + " , name=" + csvArray[5] + "]");
                /*System.out.println("Spalte DN: "+ csvArray[0] + "\n "
                		+ "Spalte EmployeeNr: " + csvArray[1] + "\n"
                				+ "Spalte GivenName: " +csvArray[2] + "\n"
                						+ "Spalte LastName: " +csvArray[3] + "\n "
                								+ "Spalte Location: " +csvArray[4] + "\n "
                										+ "Spalte EmployeeType: " + csvArray[5] + "\n "
                												+ "Spalte: Function: " + csvArray[6] + "\n "
                														+ "Spalte Valid_Until: " +  csvArray[7] + "\n "
                																+ "Spalte EMail: " + csvArray[8]);*/
                /*
       csvItem newCsvItem = new csvItem (csvArray[0], csvArray[1], csvArray[2], csvArray[3], csvArray[4], csvArray[5], csvArray[6], csvArray[7], csvArray[8]);
       csvArrayList.add(newCsvItem); 
     
                
            }

            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return csvArrayList;
    }
    	
    
    */ /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList <csvItem> getArrayList(){
    	
    	return csvArrayList;
    	
    	
    }
    
}
