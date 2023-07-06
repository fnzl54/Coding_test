import java.util.*;

public class q11 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    HashMap<Integer, Set<Integer>> map1 = new HashMap<Integer, Set<Integer>>();
    int num = sc.nextInt();
    int[][] table = new int[num][5];
    int max = 0;
    int answer = 0;

    for (int i = 0; i < num; i++) {
      map1.put(i, new HashSet<>());
    }


    for (int i = 0; i < num; i++) {
      for (int j = 0; j < 5; j++) {
        table[i][j] = sc.nextInt();
      }
    }

    for (int i = 0; i < num; i++) {
      for (int j = i+1; j < num; j++) {
        for (int n = 0; n < 5; n++) {
          if (table[i][n] == table[j][n]) {
            map1.get(i).add(j);
            map1.get(j).add(i);
          }
        }
      }
    }


    for (int i = 0; i < num; i++) {
      if ( max < map1.get(i).size() ) {
        max = map1.get(i).size();
        answer = i+1;
      }
    }

    if (max == 0) {
      answer = 1;
    }

    System.out.print(answer);
  }
}