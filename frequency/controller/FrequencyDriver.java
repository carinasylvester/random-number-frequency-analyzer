package edu.westga.cs6311.frequency.controller;

import edu.westga.cs6311.frequency.model.NumberGenerator;
import edu.westga.cs6311.frequency.view.FrequencyTUI;

/**
 * This class creates a NumberGenerator and FrequencyTUI object and calls run
 * method on FrequencyTUI object.
 * 
 * @author Carina Sylvester
 * @version 11/20/2020
 *
 */
public class FrequencyDriver {

	/**
	 * Entry point of the application
	 * 
	 * @param args not used
	 * 
	 * @precondition None
	 */
	public static void main(String[] args) {
		NumberGenerator numberGeneratorObject = new NumberGenerator();
		FrequencyTUI frequencyTUIObject = new FrequencyTUI(numberGeneratorObject);
		frequencyTUIObject.run();
	}
}
