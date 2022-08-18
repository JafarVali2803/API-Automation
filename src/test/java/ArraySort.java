import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySort {
    public static void main(String[] args) {
     //   [2, 4, 3, 5, 1] -> [5, 1, 4, 2, 3]
        int[] arr = new int[]{2,4,3,5,1};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)); // [1,2,3,4,5]
        for (int i = 0;i< arr.length;i++){

        }

    }
}
