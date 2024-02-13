/**
 * 
 */
package A01182685.bcit.ca;

/**
 * @author user
 *
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Lab6 {

    static void q1(String file) throws FileNotFoundException {
        Scanner reader = new Scanner(new FileReader(file));
        Map<String, Integer> wordCount = new TreeMap<>();

        while (reader.hasNext()) {
            String word = reader.next().toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        reader.close();
    }

    static boolean q2(String file) throws FileNotFoundException {
        Scanner reader = new Scanner(new FileReader(file));
        Set<String> words = new HashSet<>();

        while (reader.hasNext()) {
            String word = reader.next();
            if (words.contains(word)) {
                reader.close();
                return false;
            }
            words.add(word);
        }

        reader.close();
        return true;
    }

    static void q3(String file) throws FileNotFoundException
	{
		Scanner reader = new Scanner(new FileReader(file));
		
		//create your other variables (sets, etc)

		int keyWordsCount = reader.nextInt();
		int excuseCount = reader.nextInt();

		// skip first line with numbers
		reader.nextLine();

		//read keywords
		for(int i = 0; i < keyWordsCount; i++)
		{
			//read keywords e.g. datatype.add(reader.nextLine())
		}		
		
		//evaluate excuses
		for(int i = 0; i < excuseCount; i++)
		{
			String excuse = reader.nextLine();
			String excuseWords[] = excuse.split(" ");
		
			//Implement
		}

		//Print max excuses
		
		reader.close();

	}

    public static void main(String[] args) throws FileNotFoundException {
    	System.out.println("Task1:");
        q1("/Users/user/eclipse-workspace/Lab6/src/love.txt");
        System.out.println("Task2:");
        System.out.println(q2("/Users/user/eclipse-workspace/Lab6/src/q2input.txt"));
        System.out.println("Task3:");
    }
}

