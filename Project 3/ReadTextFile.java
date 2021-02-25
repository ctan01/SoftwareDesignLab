package sample;

import java.io.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadTextFile {
    private Scanner input;
    int[] characterCount = new int[26];
    char[] characterArr = new char[26];
    int totalCharacter = 0;

    /*for(int i=97; i<=122; i++){
        characterArr[i - 97] = (char) i;
    }*/

    public void main (String [] args){
        openFile();
        readFile();
        closeFile();
    }

    public void openFile() {
        try {
            input = new Scanner(new File("./Emma.txt") );
        }
        catch ( Exception e) {
            System.out.println( "Error opening file." );
        }
    }

    // read record from file
    public void readFile() {
        while ( input.hasNext() ) {
            String word = input.next();

            for(int i=0;i<word.length();i++){

                char alphabet = word.charAt(i);

                if(alphabet >= 'a' && alphabet <= 'z'){

                    characterCount[alphabet-97]++;
                    totalCharacter++;
                }
                if(alphabet >= 'A' && alphabet <= 'Z'){

                    characterCount[alphabet-65]++;
                    totalCharacter++;
                }
            }
        }
    }

    public void closeFile()
    {
        input.close(); // close file
    }


}



    /*private Scanner input;

    public void main (String [] args){
        openFile();
        readFile();
        closeFile();
    }

    public void openFile()
    {
        try
        {
            input = new Scanner(new File("Emma.txt") );
        }
        catch ( Exception e)
        {
            System.out.println( "Error opening file." );
        }
    }

    // read record from file
    public void readFile() {
            while ( input.hasNext() )
            {

            }
    }

    public void closeFile()
    {
            input.close(); // close file
    }*/


    /* public static void main(String[] args) throws FileNotFoundException, IOException {

        FileReader fr = new FileReader("C://download//Emma.txt");

        BufferedReader br = new BufferedReader(fr);
        int nextLetter;
        int[] count = new int[26];
        int total = 0;
        int other = 0;

        System.out.println("Letter            Frequency");
        while ((nextLetter = br.read()) != -1) {
            char current = (char) nextLetter;
            current = Character.toLowerCase(current);
            if (current >= 'a' && current <= 'z') {
                count[current - 'a']++;
                total++;
            } else {
                other++;
            }
        }
        Map ans = sorting(count);
        printMap(ans);
    }

    private static Map sorting(int[] count) {
        Map m = new LinkedHashMap<String, Integer>() {};
        int k = 0 ;
        for (int i = 0; i < 26; i++) {
            int max =-1;
            for (int j = 0; j < 26; j++) {
                if(max < count[j]){
                    max = count[j];
                    k = j;
                }
            }
            count[k] = -1;
            if(max!=0)
                m.put(((char)(k+97))+"", max);
            max=0;
        }
        return m;
    }

    public static void printMap(Map<String, Integer> map)
    {
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println("" + entry.getKey() + "     : "+ entry.getValue());
        }
    }*/