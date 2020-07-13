package algorithmTimeAndSpaceComplexity;

import algorithmFunctions.SortAlgorithmFunctions;
//import javax.swing.*;

public class TimeComplexity {

	public static void main(String [] args) {

		try {
			arrayTest("cyclesortalgorithm",1);
			SortAlgorithmFunctions.bubbleSortAlgorithm(arrayDispenser(50000));
			System.out.println("Bubble sort algorithm: " + timeToSeconds(SortAlgorithmFunctions.timeOfAlgorithm()) + " seconds");

			SortAlgorithmFunctions.selectionSortAlgorithm(arrayDispenser(50000));
			System.out.println("Selection sort algorithm: " + timeToSeconds(SortAlgorithmFunctions.timeOfAlgorithm()) + " seconds");

			SortAlgorithmFunctions.cocktailShakerSortAlgorithm(arrayDispenser(50000));
			System.out.println("Cocktail shaker sort algorithm: " + timeToSeconds(SortAlgorithmFunctions.timeOfAlgorithm()) + " seconds");

			SortAlgorithmFunctions.insertionSortAlgorithm(arrayDispenser(50000));
			System.out.println("Insertion sort algorithm: " + timeToSeconds(SortAlgorithmFunctions.timeOfAlgorithm()) + " seconds");
			
			SortAlgorithmFunctions.countingSortAlgorithm(arrayDispenser(50000));
			System.out.println("Counting sort algorithm: " + timeToSeconds(SortAlgorithmFunctions.timeOfAlgorithm()) + " seconds");
			
			SortAlgorithmFunctions.gnomeSortAlgorithm(arrayDispenser(50000));
			System.out.println("Gnome sort algorithm: " + timeToSeconds(SortAlgorithmFunctions.timeOfAlgorithm()) + " seconds");
			
			SortAlgorithmFunctions.optimizedGnomeSortAlgorithm(arrayDispenser(50000));
			System.out.println("Optimized gnome sort algorithm: " + timeToSeconds(SortAlgorithmFunctions.timeOfAlgorithm()) + " seconds");
			
			SortAlgorithmFunctions.oddEvenSortAlgorithm(arrayDispenser(50000));
			System.out.println("Odd-Even sort algorithm: " + timeToSeconds(SortAlgorithmFunctions.timeOfAlgorithm()) + " seconds");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void printArray(int [] array) {
		for(int i = 0; i < array.length; i++) {
			if(i < array.length - 1) System.out.print(array[i] + ", ");
			else System.out.print(array[i]);
		}
		System.out.println();
	}

	public static String timeToSeconds(long time) {
		String timeString = String.valueOf(time), timeToSeconds = "";

		if(timeString.length() <= 9) {
			int difference = 9 - timeString.length();
			timeToSeconds += "0.";
			for(int i = 0; i < difference; i++) {
				timeToSeconds += "0";
			}
		}

		for(int i = 0; i < timeString.length(); i++) {
			if(i != (timeString.length() - 9)) timeToSeconds += timeString.charAt(i);
			else if(timeString.length() > 9){
				timeToSeconds += ".";
				timeToSeconds += timeString.charAt(i);
			}else {
				timeToSeconds += timeString.charAt(i);
			}
		}

		return timeToSeconds;
	}

	public static int [] arrayDispenser(int index) {

		int [] newArray = new int [index];

		for(int i = 0; i < index; i++) {
			newArray[i] = (int) (Math.random()*10000) + 1; //Numeros aleatorios entre 1 y index
		}

		return newArray;
	}

	public static void arrayTest(String typeOfAlgorithm, int index) {
		int [] array = {2,4,1,5,3}, newArray;

		try {
			if(typeOfAlgorithm.equalsIgnoreCase("bubblesortalgorithm")) {
				printArray(array);
				newArray = SortAlgorithmFunctions.bubbleSortAlgorithm(array);
				printArray(newArray);
			}else if(typeOfAlgorithm.equalsIgnoreCase("cocktailshakersortalgorithm")) {
				printArray(array);
				newArray = SortAlgorithmFunctions.cocktailShakerSortAlgorithm(array);
				printArray(newArray);
			}else if(typeOfAlgorithm.equalsIgnoreCase("selectionsortalgorithm")) {
				printArray(array);
				newArray = SortAlgorithmFunctions.selectionSortAlgorithm(array);
				printArray(newArray);
			}else if(typeOfAlgorithm.equalsIgnoreCase("insertionsortalgorithm")) {
				printArray(array);
				newArray = SortAlgorithmFunctions.insertionSortAlgorithm(array);
				printArray(newArray);
			}else if(typeOfAlgorithm.equalsIgnoreCase("countingsortAlgorithm")) {
				printArray(array);
				newArray = SortAlgorithmFunctions.countingSortAlgorithm(array);
				printArray(newArray);
			}else if(typeOfAlgorithm.equalsIgnoreCase("gnomesortalgorithm")) {
				printArray(array);
				newArray = SortAlgorithmFunctions.gnomeSortAlgorithm(array);
				printArray(newArray);
			}else if(typeOfAlgorithm.equalsIgnoreCase("optimizedgnomesortalgorithm")) {
				printArray(array);
				newArray = SortAlgorithmFunctions.optimizedGnomeSortAlgorithm(array);
				printArray(newArray);
			}else if(typeOfAlgorithm.equalsIgnoreCase("oddevensortalgorithm")) {
				printArray(array);
				newArray = SortAlgorithmFunctions.oddEvenSortAlgorithm(array);
				printArray(newArray);
			}else if(typeOfAlgorithm.equalsIgnoreCase("cyclesortalgorithm")) {
				printArray(array);
				newArray = SortAlgorithmFunctions.cycleSortAlgorithm(array);
				printArray(newArray);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
