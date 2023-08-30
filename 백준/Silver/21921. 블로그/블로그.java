import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int[] people = new int[N];
    int left = 0, right = X, max = 0, max_count = 0;
    int current_add = 0;

    for (int i = 0; i < N; i++) {
      people[i] = sc.nextInt();
    }

    for (int i = 0; i < X; i++) {
      current_add += people[i];
    }

    max = current_add;
    max_count = 1;

    while (right < N) {
      current_add -= people[left];
      current_add += people[right];

      if (max == current_add) {
        max_count++;
      } else if (max < current_add) {
        max = current_add;
        max_count = 1;
      }

      left++;
      right++;
    }

   if (max == 0) {
     System.out.println("SAD");
   } else {
     System.out.println(max);
     System.out.println(max_count);
   }
   
  }
}