package get_ready.data_structs.arrays_strings;

import get_ready.data_structs.arrays_strings.ArraysAndStrings;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ArraysAndStringsTest {

    @Test
    public void testAllCharsUnique() throws Exception {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        assertThat(ArraysAndStrings.allCharsUnique(words[0]), is(true));
        assertThat(ArraysAndStrings.allCharsUnique(words[1]), is (false));
        assertThat(ArraysAndStrings.allCharsUnique(words[2]), is (false));
        assertThat(ArraysAndStrings.allCharsUnique(words[3]), is (true));
        assertThat(ArraysAndStrings.allCharsUnique(words[4]), is (true));
    }

    @Test
    public void testIsPermutation() throws Exception {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        String test1a = "apple";
        String test1b = "papel";
        String test2a = "carrot";
        String test2b = "tarroc";
        String test3a = "hello";
        String test3b = "llloh";

        assertThat(ArraysAndStrings.isPermutation(test1a, test1b), is(true));
        assertThat(ArraysAndStrings.isPermutation(test2a, test2b), is(true));
        assertThat(ArraysAndStrings.isPermutation(test3a, test3b), is(false));
    }

    @Test
    public void testURLify() throws Exception {
        String testable = "Mr John Smith    ";
        String testableExpected = "Mr%20John%20Smith";
        char[] testableArray = testable.toCharArray();
        ArraysAndStrings.URLify(testableArray);
        String testableURL = new String(testableArray);
        assertThat(testableURL, is(testableExpected));
    }


    @Test
    public void testIsPalindromePerm() throws Exception {
        String test1 = "Rats live on no evil star";
        String test2 = "A man, a plan, a canal, panama";
        String test3 = "Lleve";
        String test4 = "A man, a plan, a canal, panama";
        String test5 = "Tacotac";
        String test6 = "asda";
        assertThat(ArraysAndStrings.isPalindromePerm(test1), is(true));
        assertThat(ArraysAndStrings.isPalindromePerm(test2), is(true));
        assertThat(ArraysAndStrings.isPalindromePerm(test3), is(true));
        assertThat(ArraysAndStrings.isPalindromePerm(test4), is(true));
        assertThat(ArraysAndStrings.isPalindromePerm(test5), is(true));
        assertThat(ArraysAndStrings.isPalindromePerm(test6), is(false));
    }


    @Test
    public void testOneAway() throws Exception {
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
        String test1a = "a";
        String test1b = "b";
        String test2a = "pale";
        String test2b = "pse";
        String test3a = "acdsfdsfadsf";
        String test3b = "acdsgdsfadsf";
        String test4a = "acdsfdsfadsf";
        String test4b = "acdsfdfadsf";
        String test5a = "";
        String test5b = "d";
        String test6a = "d";
        String test6b = "de";
        String test7a = "acdsfdsfadsf";
        String test7b = "acdsfdsfads";
        String test8a = "acdsfdsfadsf";
        String test8b = "cdsfdsfadsf";
        String test9a = "adfdsfadsf";
        String test9b = "acdfdsfdsf";
        String test10a = "adfdsfadsf";
        String test10b = "bdfdsfadsg";
        String test11a = "adfdsfadsf";
        String test11b = "affdsfads";
        String test12a = "pale";
        String test12b = "pkle";
        String test13a = "pkle";
        String test13b = "pable";


        assertThat(ArraysAndStrings.oneEditAway(test1a,test1b), is(true));
        assertThat(ArraysAndStrings.oneEditAway(test2a,test2b), is(false));
        assertThat(ArraysAndStrings.oneEditAway(test3a,test3b), is(true));
        assertThat(ArraysAndStrings.oneEditAway(test4a,test4b), is(true));
        assertThat(ArraysAndStrings.oneEditAway(test5a,test5b), is(true));
        assertThat(ArraysAndStrings.oneEditAway(test6a,test6b), is(true));
        assertThat(ArraysAndStrings.oneEditAway(test7a,test7b), is(true));
        assertThat(ArraysAndStrings.oneEditAway(test8a,test8b), is(true));
        assertThat(ArraysAndStrings.oneEditAway(test9a,test9b), is(false));
        assertThat(ArraysAndStrings.oneEditAway(test10a,test10b), is(false));
        assertThat(ArraysAndStrings.oneEditAway(test11a,test11b), is(false));
        assertThat(ArraysAndStrings.oneEditAway(test12a,test12b), is(true));
        assertThat(ArraysAndStrings.oneEditAway(test13a,test13b), is(false));
    }

    @Test
    public void testCompress() throws Exception {
        String test1 = "aa";
        assertThat(ArraysAndStrings.compress(test1), is("aa"));
        String test2 = "aabcccccaaa";
        String test2compressed = "a2b1c5a3";
        String test3 = "aaaaabbbbaaaabbddc";
        assertThat(ArraysAndStrings.compress(test2),is(test2compressed));
    }

}