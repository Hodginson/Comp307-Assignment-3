package Naive_Bayes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Main {

	public static ArrayList<Feature> test, train;
	
	public static ArrayList<Boolean> classified = new ArrayList<Boolean>(); 
	
	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException {
		//File trainFile = new File("C:\\Users\\rawso\\Desktop\\spamLabelled.dat");
		//File testFile = new File("C:\\Users\\rawso\\Desktop\\spamUnlabelled.dat");
		
		File trainFile = new File(args[0]);
		File testFile = new File(args[1]);
		
		train =  readData.readFile(trainFile, true);
		test =  readData.readFile(testFile, false);
		
		Classifier classifier = new Classifier(train);
		int x = 1;
		
		for(Feature i : test) {
			System.out.println("Classifying email " +x+" (Vector F" + x +")...");
			boolean spam = classifier.classify(i);
			classified.add(spam);
			x++;
			System.out.println("--------------------------------------------------------");
		}
		readData.outputFile(testFile,classified);
	}
	
}
