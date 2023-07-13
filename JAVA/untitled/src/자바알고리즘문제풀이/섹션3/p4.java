package 자바알고리즘문제풀이.섹션3;

import java.util.*;

public class p4 {
    public static void main(String[] args) {

        int[] prices =  {10,7,8,5,8,7,6,2,9};
        int k =  3;
        int answer = -1;

        for (int i = 0; i < prices.length - k; i++) {
            int[] temp = Arrays.copyOfRange(prices, i+1, prices.length);
            Arrays.sort(temp);
            if (prices[i] > temp[temp.length - 1]) {
                continue;
            } else {
                int tempNum = - prices[i]*k;
                for (int j = 1; j <= k; j++) {
                    tempNum += temp[temp.length - j];
                }
                if (answer < tempNum) {
                    answer = tempNum;
                }
            }
        }

        System.out.println(answer);
    }
}
