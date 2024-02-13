
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker {

	/*
	 * Returns an ArrayList of words from a file.
	 */
	static ArrayList<String> read(String file) throws FileNotFoundException
	{
		ArrayList<String> list 	= new ArrayList<String>();
		Scanner reader			= new Scanner(System.in);

		reader = new Scanner(new FileReader(file));
		
		while(reader.hasNext()) // reads the file until end of file is reached
			list.add(reader.next()); //stores these words in an array

		reader.close();

		return list;
	}

	/*
	 * Sequential Search or Linear Search is a brute force technique which forces
	 * the program to loop through each index until the key value is found.
	 * Normally the technique would have an efficiency of O(n) if the program is looking
	 * for a single key. However, in this case the efficiency should be O(n^2) as we are
	 * comparing 2 different ArrayLists and the outer loop is dependent of the inner loop.
	 * Efficiency : O(n^2)
	 */
	static void seqSearch(ArrayList<String> test, ArrayList<String> words)
	{
		double startTime, elapsedTime;
		ArrayList <String> wordsNotFound = new ArrayList<String>();
		int count 				= 0;

		startTime = System.currentTimeMillis();
		
			// Implement seqSearch
		for (String word : test) {
            boolean found = false;
            for (String dictionaryWord : words) {
                if (word.equalsIgnoreCase(dictionaryWord)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                wordsNotFound.add(word);
                count++;
            }
        }

		elapsedTime = (System.currentTimeMillis() - startTime) * 1000;
		System.out.println("Sequential Search:\t" + count + " words not found. " + elapsedTime + " microseconds.");
		System.out.println("Words not found:\t" + wordsNotFound);
	}

	/*
	 *  Binary search is a method in which the 'middle' index of reference array
	 *  and the 'key' value is always compared. In each comparison, the middle
	 *  index adjusts depending if the key is < or > or = to the middle.
	 *  Looping through the test_data is (n) times, and comparing it using
	 *  binary search technique is (logn).Thus, program is supposed to run (n)(logn) times
	 *  Efficiency : O(nlogn)
	 */
	static void binSearch(ArrayList<String> test, ArrayList<String> words)
	{
		double startTime, elapsedTime;
		ArrayList <String> wordsNotFound	= new ArrayList<String>();
		int count 				= 0;

		startTime = System.currentTimeMillis();
		    
		    //Implement binary Search
		for (String word : test) {
            int low = 0;
            int high = words.size() - 1;
            boolean found = false;

            while (low <= high) {
                int mid = (low + high) / 2;
                int comparison = word.compareToIgnoreCase(words.get(mid));

                if (comparison == 0) {
                    found = true;
                    break;
                } else if (comparison < 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (!found) {
                wordsNotFound.add(word);
                count++;
            }
        }

		elapsedTime = (System.currentTimeMillis() - startTime) * 1000;
		System.out.println("Binary Search:\t\t" + count + " words not found. " + elapsedTime + " microseconds.");
		System.out.println("Words not found:\t" + wordsNotFound);
	}

	/*
	 * main method
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList <String> test		= read("/Users/user/eclipse-workspace/Lab3/src/lab3_testdata.txt");
		ArrayList <String> words	= read("/Users/user/eclipse-workspace/Lab3/src/lab3_wordlist.txt");

		seqSearch(test, words);
		System.out.println();
		binSearch(test,words);
	}

}
