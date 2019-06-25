package Naive_Bayes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class readData {

	public static ArrayList<Feature> readFile(File trainFile, boolean b) {
		// TODO Auto-generated method stub
		ArrayList<Feature> list = new ArrayList<Feature>();
        if (b){
            try {
                
                Scanner sc = new Scanner(trainFile);

                while (sc.hasNextLine()) {
                    ArrayList<Integer> currentLine = new ArrayList<Integer>();
                    for (int i = 0; i < 13; i++) {
                        currentLine.add(sc.nextInt());
                    }
                    sc.nextLine();
                    list.add(new Feature(currentLine));
                }
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                Scanner sc = new Scanner(trainFile);

                while(sc.hasNextLine()) {
                    ArrayList<Integer> currentLine = new ArrayList<Integer>();
                    for(int i=0; i < 12; i++) {
                        currentLine.add(sc.nextInt());
                    }
                    sc.nextLine();
                    list.add(new Feature(currentLine));
                }
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return list;
	}

	public static void outputFile(File testFile, ArrayList<Boolean> classified) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		  PrintWriter writer = new PrintWriter("sampleoutput.txt", "UTF-8");
	        Scanner sc = new Scanner(testFile);
	        int count = 0;
	        
	        while (sc.hasNextLine()) {
	            String line = sc.nextLine();
	                    if(classified.get(count)==true){
	                        line = line + ("     "+1);
	                    }
	                    else{
	                        line = line + ("     "+0);
	                    }

	            writer.println(line);
	            count++;
	        }

	        writer.close();
	        sc.close();
	}

}
