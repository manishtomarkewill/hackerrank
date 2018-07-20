package edu.njit.cs602.assignments;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordChecker {
	
	 String dictionaryFile;

    private class Dictionary {
        private final String dictionaryFile;
        private final Set<String> wordList = new HashSet<>();

        /**
         * Add word to dictionary
         * @param word
         */
        public void addWord(String word) {
            wordList.add(word);
        }

        /**
         * Is it a valid word ?
         * @param word
         * @return
         */
        public boolean isValid(String word) {
            return wordList.contains(word);
        }

        /**
         * Update the dictionary file
         */
        public void update() throws IOException {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(dictionaryFile));
                for (String word : wordList) {
                    writer.write(word);
                    writer.newLine();
                }
                writer.close();
            } catch(FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        /**
         * Construct dictionary from a dictionary file, one word per line
         * @param dictionaryFile
         * @throws FileNotFoundException
         * @throws IOException
         */
        public Dictionary(String dictionaryFile) throws FileNotFoundException, IOException {
            this.dictionaryFile = dictionaryFile;
            BufferedReader reader = new BufferedReader(new FileReader(dictionaryFile));
            String line = null;
            while ((line=reader.readLine()) != null) {
                addWord(line.trim());
            }
            reader.close();
        }
    }

    /**
     * Constructs WordChecker with a dictionary given in dictionary file
     * @param dictionaryFile
     */
    public WordChecker(String dictionaryFile) throws IOException {
    	this.dictionaryFile=dictionaryFile;
    }

    /**
     * Update dictionary file
     * @throws IOException 
     */
    public void updateDictionary() throws IOException {
    	
    	Dictionary dictionary = new WordChecker.Dictionary(dictionaryFile);
        Scanner scanner = new Scanner(System.in);
        String input, correct,word="YES";
        String[] arr;
        System.out.print("Enter the new word : ");
        input = scanner.next();
        arr=input.split(" ",100);
        if (dictionary.isValid(arr[0].trim()))
        {
            System.out.println("Word already exist in the dictionary");
        }
        else
        {
            dictionary.addWord(arr[0].trim());
            dictionary.update();
            System.out.println("One word added");
            
        }
    }

    /**
     * Check words in the file targetFile and output the word in outputFile
     * @param targetFile input file
     * @param outputFile output file
     * @throws IOException 
     */
    
    public void checkWords(String targetFile, String outputFile) throws IOException {
    	BufferedReader input = new BufferedReader(new FileReader(targetFile));
        BufferedWriter output = new BufferedWriter(new FileWriter(outputFile));
        Scanner scanner = new Scanner(System.in);
        Dictionary dictionary = new WordChecker.Dictionary(dictionaryFile);
        String arr[];
        String var;
        while((var=input.readLine())!=null){
        	arr=var.split(" ",100);
        	if(dictionary.isValid(arr[0].trim())){
        		output.write(arr[0].trim()+" ");
        		output.newLine();
        	}
        	else{
        		System.out.println("Word not found in dictionary : " +arr[0].trim() + " ");
        		System.out.println("Choose one of the following option");
        		System.out.println("1. Ignore Rule");
        		System.out.println("2. Valid Word");
        		System.out.println("3. Correct Word");
        		System.out.println("4. Ignore Word");
        		System.out.print("Enter choice : ");
        		switch (scanner.nextInt())
        		{
        			case 1: output.write(arr[0].trim()+" ");
        					output.newLine();
                        	System.out.println("Word added to the output file");
                        	break;
        			case 2: output.write(arr[0].trim()+" ");
        					output.newLine();
                			System.out.println("Word added to the output file");
                			dictionary.addWord(arr[0].trim() + " ");
                			dictionary.update();
                			System.out.println("Word added to the dictionary");
                			break;
        			case 3: String correctWord=scanner.next();
                			if(dictionary.isValid(correctWord)){
                				output.write(arr[0].trim()+" ");
                				output.newLine();
                				System.out.println("Word added to the output file");
                				dictionary.addWord(arr[0].trim() + " ");
                				dictionary.update();
                				System.out.println("Word added to the dictionary");
                			}else{
                				System.out.println("Again Invalid word");
                			}
                			break;
        			case 4:	System.out.println("Word is ignored");
                			break;
        			default:System.out.println("Invalid value");
                			break;
        		}
        	}
        }
        input.close();
        output.close();
    }


    public static void main(String [] args) throws Exception {
        String dictionaryFile = args[0];
        WordChecker checker = new WordChecker(dictionaryFile);
        String inputFile = args[1];
        String outputFile = args[2];
        checker.checkWords(inputFile, outputFile);
        checker.updateDictionary();
    }
}
