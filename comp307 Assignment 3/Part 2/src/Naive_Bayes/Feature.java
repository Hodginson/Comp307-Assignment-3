package Naive_Bayes;

import java.util.ArrayList;

public class Feature {

	ArrayList<Integer> features = new ArrayList<Integer>();
	
	public int get(int i) {
		// TODO Auto-generated method stub
		return features.get(i);
	}
	
	public Feature(ArrayList<Integer> features) {
		this.features = features;
	}

}
