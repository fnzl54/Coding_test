package 자바알고리즘문제풀이.섹션2;

import java.util.*;

public class q8 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    Integer[] numList = new Integer[num];
    Integer[] numListA = new Integer[num];
    int answer = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i = 0; i < num; i++) {
      int temp = sc.nextInt();
      numList[i] = temp;
      numListA[i] = temp;
    }
    Arrays.sort(numList, Collections.reverseOrder());

    int rank = 1;
    int nowNum = numList[0];
    map.put(nowNum, rank);

    for (int i = 1; i < num; i++) {
      if (nowNum == numList[i]) {
        rank++;
      } else {
        rank++;
        map.put(numList[i], rank);
        nowNum = numList[i];
      }
    }

    for (int i : numListA) {
      System.out.print(map.get(i) + " ");
    }
  }

}