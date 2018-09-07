package get_ready.data_structs.arrays_strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilsTest {

    @Test
    public void mergeSortedTest() {
        int[] a = new int[]{1,3,5};
        int[] b = new int[]{2,4,6};
        int[] expected = new int[]{1,2,3,4,5,6};
        int[] c = ArrayUtils.mergeSorted(a,b);
        assertArrayEquals(c,expected);
    }
}