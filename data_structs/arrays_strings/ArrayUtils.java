package data_structs.arrays_strings;

public class ArrayUtils {
    public static int[] mergeSorted(int[] list1, int[] list2) {
        int[] merged = new int[list1.length + list2.length];

        int list1Index = 0;
        int list2Index = 0;
        int mergedIndex = 0;
        while (list1Index < list1.length && list2Index < list2.length) {
            if (list1[list1Index] <= list2[list2Index]) {
                merged[mergedIndex] = list1[list1Index];
                list1Index++;
            } else if (list2[list2Index] < list1[list1Index]) {
                merged[mergedIndex] = list2[list2Index];
                list2Index++;
            }
            mergedIndex++;
        }

        //At this point one of the lists is exhausted
        if (list1Index == list1.length) {
            //copy over the rest of the array
            while(list2Index < list2.length) {
                merged[mergedIndex] = list2[list2Index];
                mergedIndex++;
                list2Index++;
            }
        } else if (list2Index == list2.length) {
            //copy over the rest of array 1
            while(list1Index < list1.length) {
                merged[mergedIndex] = list1[list1Index];
                mergedIndex++;
                list1Index++;
            }
        }


        return merged;
    }
}
