// 참고 - https://moz1e.tistory.com/431

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int wordLength = 3;
    int frontWordLength = 0;
    int middleWordLength = 3;

    while (N > wordLength) {
      frontWordLength = wordLength;
      wordLength = wordLength * 2 + (middleWordLength + 1);
      middleWordLength++;
    }

    while (true) {
      if (frontWordLength < N && N <= frontWordLength+middleWordLength) {
        N -= frontWordLength;
        break;
      } else if (N <= frontWordLength) {
        wordLength = frontWordLength;
        middleWordLength--;
        frontWordLength = (wordLength - middleWordLength) / 2;
      } else {
        wordLength = frontWordLength;
        N -= (frontWordLength + middleWordLength);
        middleWordLength--;
        frontWordLength = (wordLength-middleWordLength) / 2;

      }
    }

    if (N == 1) {
      System.out.println('m');
    } else {
      System.out.println('o');
    }

  }

}