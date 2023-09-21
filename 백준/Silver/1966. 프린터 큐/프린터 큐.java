import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < T; i++) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      int answer = 0;
      String findPaper = "";
      String[] importance = new String[N];
      Queue<String> printList = new LinkedList<>();

      for (int n = 0; n < N; n++) {
        String tempPaper = sc.next();
        importance[n] = tempPaper;

        if (n == M) {
          tempPaper = "a" + tempPaper;
          findPaper = tempPaper;
        } else {
          tempPaper = "b" + tempPaper;
        }

        printList.add(tempPaper);
      }

      Arrays.sort(importance, Collections.reverseOrder());

      end: for (int j = 0; j < importance.length; j++) {
        for (int k = 0; k < printList.size(); k++) {
          String temp = printList.peek();
          if (importance[j].equals(temp.substring(1))) {
            if (temp.equals(findPaper)) {
              answer = j+1;
              break end;
            } else {
              printList.poll();
              break;
            }
          } else {
            printList.add(printList.peek());
            printList.poll();
          }
        }
      }
      sb.append(answer).append("\n");
    }
    System.out.println(sb);
  }
}