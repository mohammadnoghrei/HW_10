package Q1_HashMap;

import java.util.*;

public class Main2{

    static ArrayList<String> list = new ArrayList<> ();

    public static void main(String[] args) {

        Scanner scanner = new Scanner ( System.in );
        System.out.print ( "Enter a word: " );
        String input = scanner.nextLine ();

        HashMap<Character, Integer> charCount = new HashMap<> ();

        for (char c : input.toCharArray ()) {
            charCount.put ( c, charCount.getOrDefault ( c, 0 ) + 1 );
        }

        System.out.println ( charCount );
        generateAnagrams ( "", input.length (), charCount );


        extracted ( scanner, input );

    }

    private static void extracted(Scanner scanner, String input) {
        HashMap<String, String> hashMap = new HashMap<> ();

        for (String array: list )
        {
            hashMap.put (array, input );
        }

        System.out.println (hashMap);

        System.out.println ("enter string :");
        String name = scanner.next ();

        boolean isTrue = false;


        List<String> keyList = new ArrayList<>(hashMap.keySet());

        System.out.println (keyList);

        for (String array:keyList
        ) {
            if (array.equals ( name )){
                isTrue = true;
            }
        }
        System.out.printf ( "is %s",isTrue );
    }

    public static void generateAnagrams(String prefix, int remaining, HashMap<Character, Integer> charCount) {

        if (remaining == 0) {
            list.add ( prefix );
            System.out.println ( prefix );
        }

        for (char c : charCount.keySet ()) {
            int count = charCount.get ( c );
            if (count > 0) {
                charCount.put ( c, count - 1 );
                generateAnagrams ( prefix + c, remaining - 1, charCount );
                charCount.put ( c, count );
            }
        }
    }
}