package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HistogramAlphaBet {

    public static Integer totalChar = 0;
    public static int[] count = new int[26];
    public static Integer[] tempCount = new Integer[26];
    public static float[] prob = new float[26];
    public static char[] alphabets = new char[26];
    public static Map<String, Float> probMap;
    public static Map<String, Integer> countMap;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        for(int i=0;i<26;i++){
            alphabets[i] = (char)(i+97);
        }

        FileReader file = new FileReader("./Emma.txt");

        BufferedReader reader = new BufferedReader(file);
        int nextLetter;

        while ((nextLetter = reader.read()) != -1) {
            char current = (char) nextLetter;
            current = Character.toLowerCase(current);
            if (current >= 'a' && current <= 'z') {
                count[current - 97]++;
                totalChar++;
            }
        }

        //put alphabets in frequency order
        for(int i = 0; i < 26; i++){
            for(int j = i + 1; j < 26; j++){
                if(count[j] > count[i]){
                    int temp1 = count[i];
                    count[i] = count[j];
                    count[j] = temp1;
                    char temp2 = alphabets[i];
                    alphabets[i] = alphabets[j];
                    alphabets[j] = temp2;
                }
            }
        }

        for(int i = 0; i < 26; i++){
            tempCount[i] = count[i];
        }

        probMap = makeProbMap(count);
        countMap = makeMap(count);
        printMap(sortByComparator(countMap, false));

        Arrays.sort(tempCount);
        Arrays.sort(tempCount, Collections.reverseOrder());

        for(int i = 0; i < 26; i++){
            prob[i] = tempCount[i]*100/(float)totalChar;
        }

    }

    //make a map that is sorted by key
    private static Map makeMap(int[] count) {
        Map m = new HashMap<String, Integer>() {};
        int k = 0 ;
        for (int i = 0; i < 26; i++) {
            int max = -1;
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

    private static Map makeProbMap(int[] count) {
        Map m = new HashMap<String, Float>() {};
        for (int i = 0; i < 26; i++) {
            m.put(((char)(i+97))+"", count[i]*100/(float)totalChar);
        }
        return m;
    }

    //sort map by value
    private static Map<String, Integer> sortByComparator(Map<String, Integer> unSortMap, final boolean order){

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unSortMap.entrySet());

        // Sorting the list based on values
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                if (order) {
                    return o1.getValue().compareTo(o2.getValue());
                } else {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    //print map
    private static void printMap(Map<String, Integer> map){
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println("" + entry.getKey() + "     : "+ entry.getValue());
        }
    }
}
