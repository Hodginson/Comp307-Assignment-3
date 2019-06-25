package Naive_Bayes;

import java.util.ArrayList;

public class Classifier {

	ArrayList<Feature> feature;
	final int totalFeatures = 200;
	
	
	public Classifier(ArrayList<Feature> train) {
		// TODO Auto-generated constructor stub
		this.feature = train;
	}

	public boolean classify(Feature i) {
		// TODO Auto-generated method stub
		double trueProb = 1.0;
		double falseProb = 1.0;
		
		ArrayList<Feature> True = new ArrayList<Feature>();
		ArrayList<Feature> False = new ArrayList<Feature>();
		
		for(Feature trainFeature : feature) {
			if(trainFeature.get(12)==1 ) {
				True.add(trainFeature);
			} else {
				False.add(trainFeature);
			}
		}
		
		trueProb = (double) True.size() / totalFeatures;
		falseProb = 1-trueProb;

		
		ArrayList<Double> trueProbs = calculate(True);
		ArrayList<Double> falseProbs = calculate(False);
		ArrayList<Double> allProbs = calculate(feature);
		
		double denominator =1.0;
		
		for(int x=0; x < i.features.size(); x++) {
			if(i.get(x)==1) {
				trueProb = trueProb* trueProbs.get(x);
				falseProb = falseProb* falseProbs.get(x);
				denominator = denominator * allProbs.get(x);
			} else {
				trueProb = trueProb* (1-trueProbs.get(x));
				falseProb = falseProb* (1-falseProbs.get(x));
				denominator = denominator * (1-allProbs.get(x));
			}
		}
		
        System.out.println("Probability of being spam: " + trueProb);
        System.out.println("Probability of not being spam: " + falseProb);
		if(trueProb > falseProb) {
			System.out.println("Class: Spam");
		}else {
			System.out.println("Class: Non-Spam");
		}
		

		return trueProb > falseProb;
	}

	private ArrayList<Double> calculate(ArrayList<Feature> feature2) {
		// TODO Auto-generated method stub
		ArrayList<Double> temp = new ArrayList<Double>();
		int[] featureCount = new int[12];
		
		for(Feature i : feature2) {
			for(int j = 0; j<12;j++) {
				featureCount[j] += i.get(j);
			}
		}
		
		for(int i =0; i < featureCount.length; i++) {
			double x = (double)featureCount[i] / (double)feature2.size();
			temp.add(x);
		}
		return temp;
	}
}
