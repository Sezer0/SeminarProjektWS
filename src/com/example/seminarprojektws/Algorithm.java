package com.example.seminarprojektws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import uk.ac.shef.wit.simmetrics.similaritymetrics.BlockDistance;
import uk.ac.shef.wit.simmetrics.similaritymetrics.EuclideanDistance;
import uk.ac.shef.wit.simmetrics.similaritymetrics.Levenshtein;
import uk.ac.shef.wit.simmetrics.similaritymetrics.SmithWaterman;
import uk.ac.shef.wit.simmetrics.similaritymetrics.Soundex;

public class Algorithm {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	static final ArrayList<Float> emailFehlerRate = new ArrayList<>();

	/*
	 * public HashMap<String, ArrayList<Float>> getAccuray(String name,
	 * HashMap<Integer, csvItem> csvHashMap, ArrayList <String>
	 * staedteArrayList){ ArrayList<ArrayList<Float>> algorithmsArray = new
	 * ArrayList<ArrayList<Float>>(); HashMap<String, ArrayList<Float>>
	 * algorithmsHashmap = new HashMap<>();
	 * 
	 * Soundex soundex = new Soundex (); Levenshtein levenshtein = new
	 * Levenshtein(); BlockDistance blockDistance = new BlockDistance();
	 * 
	 * 
	 * ArrayList<Float> soundexarray = new ArrayList<Float>(); ArrayList<Float>
	 * levenshteinarray = new ArrayList<Float>(); for (int i=0;
	 * i<csvHashMap.size();i++){ for (int y=0; y< staedteArrayList.size();y++){
	 * 
	 * switch(name){
	 * 
	 * case "Soundex": float soundexFloatLocation;
	 * 
	 * soundexFloatLocation =
	 * soundex.getSimilarity(csvHashMap.get(i).getLocation(),
	 * staedteArrayList.get(y)); // soundexFloatEmployeeType =
	 * soundex.getSimilarity(csvHashMap.get(i).getEmployeeType(), string2)
	 * //hier gehï¿½rt eine if abfrage hin, die die
	 * soundexarray.add(soundexFloatLocation);
	 * 
	 * break;
	 * 
	 * case "Levenshtein": float levenshteinFloatLocation;
	 * levenshteinFloatLocation =
	 * levenshtein.getSimilarity(csvHashMap.get(i).getLocation(),
	 * staedteArrayList.get(y)); levenshteinarray.add(levenshteinFloatLocation);
	 * 
	 * 
	 * 
	 * break;
	 * 
	 * 
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * } algorithmsArray.add(soundexarray); algorithmsHashmap.put("Soundex",
	 * soundexarray ); algorithmsArray.add(levenshteinarray);
	 * 
	 * 
	 * return algorithmsHashmap ;
	 * 
	 * 
	 * 
	 * }
	 */

	public static float checkNr(String algorithname, String Firstname, String Lastname, String wort, int zeile) {
		String artificialNR = Firstname.substring(0, 1).toLowerCase() + Lastname;

		if (algorithmSelected(algorithname, artificialNR, wort) <1) {
			System.out.println(algorithmSelected(algorithname, artificialNR, wort));

			if (algorithmSelected(algorithname, artificialNR, wort.substring(0, wort.length() - 1)) < 1) {

				System.out.println(zeile + wort + "   "+ algorithmSelected(algorithname, artificialNR, wort));
			}

		}

		return algorithmSelected(algorithname, artificialNR, wort);
	}

	public static float[] werteListenÜberprüfer(String[] werteliste, String algorithmname, String wort, int zeile) {
		float wertelistenArray[] = new float[werteliste.length];
		boolean bool = true;
		for (int i = 0; i < werteliste.length; i++) {
			if (algorithmSelected(algorithmname, werteliste[i], wort) < 1) {
				wertelistenArray[i] = algorithmSelected(algorithmname, werteliste[i], wort);
				bool = false;

			}

		}
		if (bool == true) {
			System.out.println(zeile + wort);
		}
		return wertelistenArray;
	}

	public static void checkEmailRegEx(String email) {

		// gibt true oder false zurück
		// System.out.println(algorithm.validateMail(email));
		if (validateMail(email) == false) {
			// System.out.println(i); gibt falsche emaiaddressen aus index
		}
	}

	public static float checkNameswithEmail(String First, String Last, String email, int zeile) {
		// twyla.jesse@DemoCompany.com
		String artificialEmail = First.toLowerCase() + "." + Last.toLowerCase() + "@DemoCompany.com";
		return algorithmSelected("Levenshtein", artificialEmail, email);

	}

	public static float algorithmSelected(String algorithmNAme, String Wort1, String Wort2) {

		switch (algorithmNAme) {
		case "Soundex":
			Soundex soundex = new Soundex();
			soundex.getSimilarity(Wort1, Wort2);
			return soundex.getSimilarity(Wort1, Wort2);
		case "Levenshtein":
			Levenshtein levenshtein = new Levenshtein();
			levenshtein.getSimilarity(Wort1, Wort2);
			return levenshtein.getSimilarity(Wort1, Wort2);
		case "SmithWaterman":
			SmithWaterman smithWaterman = new SmithWaterman();
			return smithWaterman.getSimilarity(Wort1, Wort2);
			
		case "EuclideanDistance":
			EuclideanDistance euclideanDistance = new EuclideanDistance();
			return euclideanDistance.getSimilarity(Wort1, Wort2);

		}

		return 1337;

	}

	public static boolean validateMail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public String getDescription(String name) {

		return "";
	}
}
