package com.example.seminarprojektws;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.apache.tools.ant.taskdefs.Get;

import uk.ac.shef.wit.simmetrics.similaritymetrics.BlockDistance;
import uk.ac.shef.wit.simmetrics.similaritymetrics.EuclideanDistance;
import uk.ac.shef.wit.simmetrics.similaritymetrics.JaccardSimilarity;
import uk.ac.shef.wit.simmetrics.similaritymetrics.SmithWaterman;
import uk.ac.shef.wit.simmetrics.similaritymetrics.Soundex;

public class SeminarController {

	private JFrame frame;
	private static CSVReader csvReader;
	private static Algorithm algorithm = new Algorithm();
	private static String[] EmployeeTypeArray = { "Internal", "Trainee", "External" };
	private static String[] LocationArray = { "M�nchen", "Frankfurt", "Berlin" };
	// private static SeminarprojektwsUI seminarprojektwsUI;
	// private static View view = new View();
	private static HashMap<Integer, csvItem> userList = csvReader.userListReader();
	// private static ArrayList<csvItem> userList = csvReader.userListReader();
	private static ArrayList<String> staedteList = csvReader.staedteReader();

	public static void main(String[] args) throws IOException {

		csvReader = new CSVReader();
		mainMethod();

		// seminarprojektwsUI = new SeminarprojektwsUI();

		SmithWaterman smithWaterman = new SmithWaterman();
		EuclideanDistance euclideanDistance = new EuclideanDistance();
		JaccardSimilarity jaccardSimilarity = new JaccardSimilarity();
		Soundex soundex = new Soundex();

		// Berechnet die Prozente wie im Dreisatz anhand der Länger der
		// Wörter, die aus falschen buchstaben bestehen--> dieses bsp.-->
		// ünchen =6 UC =2 d.h. 2 sind von 6 33,3 %
		// System.out.println(smithWaterman.getSimilarity("München", "MUC"));

		// Gibt entweder 1.0 oder 0.0 aus. 1.0 wird nur bei der 100%
		// übereinstimmung der Wörter(muss kompletter String gleich sein..in
		// ganzer länge) ausgegeben sonst immer 0.0
		// System.out.println(euclideanDistance.getSimilarity("Daniel",
		// "Daniel"));

		// gibt entweder 1 oder 0 zurück. Hierbei allerdings, wenn String 2 in
		// String 1 enthalten ist mit 1,0!!
		// System.out.println(euclideanDistance.getSimilarityTimingActual("München",
		// "MUC"));

		// Gibt 1,0 zurück, wenn Wörter zu 100% übereinstimmen also der
		// identische String sind..sonst 0
		// System.out.println(jaccardSimilarity.getSimilarity("München",
		// "München"));

	}

	public static void mainMethod() {

		for (int i = 1; i < userList.size(); i++) {
			int zeile = i + 1;
			algorithm.checkEmailRegEx(userList.get(i).getEMail());
			algorithm.checkNameswithEmail(userList.get(i).getGivenName(), userList.get(i).getLastName(),
					userList.get(i).getEMail(), zeile);
			//algorithm.werteListen�berpr�fer(EmployeeTypeArray, "Levenshtein", userList.get(i).getEmployeeType(), zeile);
			algorithm.checkNr("EuclideanDistance", userList.get(i).getGivenName(), userList.get(i).getLastName(), userList.get(i).getEmployeeNr(), zeile);
			// algorithm.werteListen�berpr�fer(LocationArray, "Soundex",
			
			// userList.get(i).getLocation(), zeile);
		}

	}

	

	public static float algorithmClicked(String name, String woord1, String word2) {

		switch (name) {

		case "Soundex":

			float soundexflaot = algorithm.algorithmSelected(name, woord1, word2);

			return soundexflaot;
		// ArrayList<Float> soundexpercent = algorithm.getAccuray(name,
		// userList, staedteList ).get(0);

		case "Levenshtein":
			// ArrayList<Float> levenshteinpercen = algorithm.getAccuray(name,
			// userList, staedteList).get(1);
			float levenshteinfloat = algorithm.algorithmSelected(name, woord1, word2);
			return levenshteinfloat;

		}
		return 0;
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