package Java.Q13_07_Lambda_Expressions;

import Java.Q13_08_Lambda_Random.QuestionB;
import Java.Q13_08_Lambda_Random.QuestionC;

import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
 		ArrayList<Country> countries = new ArrayList<Country>();
 		countries.add(new Country("United States", "North America", 5));
 		countries.add(new Country("Canada", "North America", 10));
 		countries.add(new Country("India", "Asia", 30));
 		
 		String continent = "North America";
 		int popA = QuestionA.getPopulation(countries, continent);
 		int popB = Java.Q13_07_Lambda_Expressions.QuestionB.getPopulation(countries, continent);
 		int popC = Java.Q13_07_Lambda_Expressions.QuestionC.getPopulation(countries, continent);
 		
 		if (popA == popB && popB == popC) {
 			System.out.println("Population: " + popA);
 		} else {
 			System.out.println("Mismatch: " + popA + ", " + popB + ", " + popC);
 		}
	}

}
