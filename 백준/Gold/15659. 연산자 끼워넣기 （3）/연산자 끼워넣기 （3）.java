// stack -> Deque (마지막에 +, - 만 남았을 경우 - 는 엎뒤 순서에 따라 달라진다)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static int[] numList, operator = new int[4];
  static char[] operatorSequence;
  static int max = Integer.MIN_VALUE;
  static int min = Integer.MAX_VALUE;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());

    numList = new int[N];
    operatorSequence = new char[N-1];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i <  N; i++) {
      numList[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      operator[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0);

    sb.append(max + "\n" + min);
    System.out.println(sb);

  }

  public static void dfs(int depth) {
    if(depth == N-1) {
      calculate();
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (operator[i] != 0) {

        // 랜덤으로 선정한 연산자 순서를 정해주는 역할
        if (i == 0) operatorSequence[depth] = '+';
        if (i == 1) operatorSequence[depth] = '-';
        if (i == 2) operatorSequence[depth] = '*';
        if (i == 3) operatorSequence[depth] = '/';

        // i번째 연산자를 넣어주어서 연산자 숫자를 줄여주는 역할
        operator[i]--;
        dfs(depth + 1);
        operator[i]++;
      }
    }

  }

  public static void calculate() {
    Deque<Integer> numberStack = new LinkedList<>();
    Deque<Character> operatorStack = new LinkedList<>();
    numberStack.add(numList[0]);

    for (int i = 0; i < operatorSequence.length; i++) {
      char operator = operatorSequence[i];

      switch (operator) {
        case '+': case '-':
          operatorStack.addLast(operator);
          numberStack.addLast(numList[i+1]);
          break;
        case '*':
          numberStack.addLast(numberStack.pollLast() * numList[i+1]);
          break;
        case '/':
          numberStack.addLast(numberStack.pollLast() / numList[i+1]);
          break;
      }
    }

    int result = numberStack.poll();

    while (!operatorStack.isEmpty()) {
      char operator = operatorStack.poll();

      int num = numberStack.poll(); // 여기 부분

      if (operator == '+') result += num;
      if (operator == '-') result -= num;
    }

    max = Math.max(max, result);
    min = Math.min(min, result);
  }
}