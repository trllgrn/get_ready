package get_ready.data_structs.arrays_strings;
import java.util.*;

public class ArraysAndStrings {
    //problem 1.1
    //Write a method to determine if a string is contains all unique characters
    //input: String
    //output: boolean
    //Example: test1 - "Google", test2 - "Amber", test3 - "Broken"
    public static boolean allCharsUnique(String input) {
        boolean allUnique = true;
        HashMap<Character,Integer> exists = new HashMap<Character,Integer>();

        for (int i = 0; i < input.length(); i++) {
            //Grab a character at this index
            //convert it to lower case
            Character token =  Character.toLowerCase(input.charAt(i));
            //check to see if this character is in the map
            if (exists.get(token) == null) {
                //this character is not in the map, let's add it
                exists.put(token,1);
            }
            else {
                //we've see this character before, we're done
                allUnique = false;
                break;
            }
        }
        return allUnique;
    }


    //problem 1.2
    //Write a method to determine if a string s1 is a permutation of another string
    //Example String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
    //input: String s1, String s2
    //output: boolean
    public static boolean isPermutation(String s1, String s2) {
        //sort each array
        char[] s1Sorted = s1.toCharArray();
        char[] s2Sorted = s2.toCharArray();
        Arrays.sort(s1Sorted);
        Arrays.sort(s2Sorted);
        return Arrays.equals(s1Sorted, s2Sorted);
    }


    //problem 1.3 URLify
    //Write a method that takes a string and inserts '%20' wherever there are spaces
    //Assume there is enough space at the end of the array to hold the new length
    //Input the character array and the true length
    //Example: String str = "Mr John Smith    ";
    public static void URLify(char[] sentence) {
        final char PERCENT = '%';
        final char TWO = '2';
        final char ZERO = '0';
        final char SPACE = ' ';

        //set up read and write pointers at the end of the string
        int read = sentence.length - 1;
        int write = sentence.length - 1;

        //iterate the read pointer to the first non-space index
        while (sentence[read] == SPACE) {
            read--;
        }

        while (write >= 0) {
            //check to see if we're at a space or not
            if (sentence[read] != SPACE) {
                //write the element at read index into the space at the write index
                sentence[write] = sentence[read];
                write--;
            }
            else {
                //we need to write the '%20'
                sentence[write] = ZERO;
                write--;
                sentence[write] = TWO;
                write--;
                sentence[write] = PERCENT;
                write--;
            }
            read--;
        }

    }



    //problem 1.4 Permutation Palindrome
    //Write a method to determine if a string is a permutation of a palindrome
    //Example: String[] strings = {"Rats live on no evil star",
    //							"A man, a plan, a canal, panama",
    //							"Lleve",
    //							"Tacotac",
    //							"asda"};
    public static boolean isPalindromePerm(String toCheck) {
        //Parse String into HashMap
        HashMap<Character, Integer> parsed = new HashMap<Character, Integer>();
        for (int i = 0; i < toCheck.length(); i++){
            if (Character.isLetter(toCheck.charAt(i))) {
                Character token = Character.toLowerCase(toCheck.charAt(i));
                Integer value = parsed.get(token);
                if (value == null) {
                    parsed.put(token,1);
                } else {
                    parsed.put(token, value.intValue() + 1);
                }
            }
        }

        //Now check the HashMap for more than one odd numbered key count
        int evenCount = 0;
        int oddCount = 0;
        for (Character key : parsed.keySet()) {
            if (parsed.get(key).intValue() % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        if (oddCount > 1) {
            return false;
        } else {
            return true;
        }
    }



    //problem 1.5 One Away
    //Write a method that tests to see if a string is one edit away from being another string
    //Example
//    String[][] tests = {{"a", "b", "true"},
//            {"", "d", "true"},
//            {"d", "de", "true"},
//            {"pale", "pse", "false"},
//            {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
//            {"acdsfdsfadsf", "acdsfdfadsf", "true"},
//            {"acdsfdsfadsf", "acdsfdsfads", "true"},
//            {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
//            {"adfdsfadsf", "acdfdsfdsf", "false"},
//            {"adfdsfadsf", "bdfdsfadsg", "false"},
//            {"adfdsfadsf", "affdsfads", "false"},
//            {"pale", "pkle", "true"},
//            {"pkle", "pable", "false"}};

    public static boolean oneEditAway(String a, String b) {
        boolean tooManyEdits = false;

        //if the difference in the lengths of these strings is more than one, we fail
        if (Math.abs(a.length() - b.length()) > 1) {
            tooManyEdits = true;
        }

        else {

            boolean diffFound = false;

            //set up indices
            int shortIndex = 0;
            int longIndex = 0;

            String longer = "";
            String shorter = "";

            //identify the long and short strings
            if (a.length() <= b.length()) {
                shorter = a;
                longer = b;
            } else if (a.length() > b.length()) {
                shorter = b;
                longer = a;
            }

            while (shortIndex < shorter.length() && longIndex < longer.length()) {
                //check to see if the elements at the current index are different
                if (shorter.charAt(shortIndex) != longer.charAt(longIndex)) {
                    //check to see if we've seen a difference already
                    if (diffFound) {
                        //this is the second difference, we're done
                        tooManyEdits = true;
                        break;
                    } else {
                        diffFound = true;
                        //don't increment the shorter index unless the lengths are the same
                        if (shorter.length() == longer.length()) {
                            shortIndex++;
                        }
                    }
                }
                else {
                    //items match
                    shortIndex++;
                }
                longIndex++;
            }
        }

        return !tooManyEdits;
    }



    //problem 1.6 String Compression
    //Write a method that takes in a string and computes a compressed version of it with just the character and the number of repeats
    //Example
    public static String compress(String input) {
        //Use a stringBuilder to build up the compressed string
        StringBuilder compressed = new StringBuilder();

        //check for quick escape
        if (input.length() <= 2) {
            return input;
        }
        else {
            Character prevToken = input.charAt(0);
            int tokenCount = 1;
            for (int i = 1; i < input.length(); i++) {
                Character currToken = input.charAt(i);
                if (currToken == prevToken) {
                    tokenCount++;
                }
                else {
                    //this is a new character
                    compressed.append(prevToken);
                    //add the letter
                    compressed.append(tokenCount);
                    //add the count for that letter
                    prevToken = currToken;
                    tokenCount = 1;
                    //reset the counter
                }
            }
            //append the final parsed character
            compressed.append(prevToken);
            compressed.append(tokenCount);
        }

        //return the longer of the two strings
        return compressed.length() < input.length() ? compressed.toString() : input;
    }



    //problem 1.7 Rotate Matrix
    //Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
    //Write a method to rotate the image by 90 degrees. Can you do this in place?



    //problem 1.8 Zero Matrix
    //Write an algorithm such that if an element in an MxN matrix is 0, tis entire row and column are set to 0.






    //problem 1.9 isRotation
    //Write a method that determines whether a string is a rotation of another string
    //Example
    //String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
}
