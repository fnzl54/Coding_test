package level_1;

import java.util.*;

public class 제일작은수제거하기 {
    public static void main(String[] args) {

        // int[] arr = {4,3,2,1};
        int[] arr = {10};

        //logic

        int[] sort_arr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sort_arr);

        List<Integer> arr_list = new ArrayList<>();

        for (int i : arr) {
            if (i == sort_arr[0]) {
                continue;
            }
            arr_list.add(i);
        }

        if (arr.length == 1) {
            arr_list.add(-1);
        }


        Object[] answer = arr_list.toArray();
        //output
        System.out.println(Arrays.toString(answer));
    }
}