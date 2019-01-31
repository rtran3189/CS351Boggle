/**
 * The Dictionary class is responsible for reading in and handling
 * the list of words.
 * @author Richard Tran
 */

import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;

public class Dictionary
{
    private TreeSet<String> wordList = new TreeSet<>();

    /**
     * The constructor, takes in a file and adds it to TreeSet.
     */
    public Dictionary()
    {
        InputStream input = getClass().getResourceAsStream("dictionary.txt");
        Scanner scanner = new Scanner(input).useDelimiter("\n");
        scanner.forEachRemaining(st -> wordList.add(st.trim()));

    }

    /**
     * Checks if a word is valid.
     * @param s A string to check if it exists in the dictionary.
     * @return True if yes, False if not.
     */
    public boolean isValid(String s)
    {
        return wordList.contains(s);
    }

    /**
     * Gets the TreeSet of words.
     * @return
     */
    public Collection<String> getWordList()
    {
        return wordList;
    }

    /**
     * Prints all the words in the dictionary.
     */
    public void printAllWords()
    {
        int count = 0;
        for (String s: wordList)
        {
            count++;
            System.out.println(s);
        }
        System.out.println("Printed " + count + " words.");
    }

}

