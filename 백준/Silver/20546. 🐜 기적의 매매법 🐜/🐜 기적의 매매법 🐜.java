import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

  static int money;
  static int[] chart = new int[14];
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    money = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < 14; i++) {
      chart[i] = Integer.parseInt(st.nextToken());
    }

    int bmp = BMP();
    int timing = TIMING();

    if (bmp > timing) {
      System.out.println("BNP");
    } else if (bmp < timing) {
      System.out.println("TIMING");
    } else {
      System.out.println("SAMESAME");
    }

  }

  static int BMP() {
    int totalBuyStockCount = 0;
    int bmpMoney = money;

    for (int i = 0; i < 14; i++) {
      int todayBuyStockCount = bmpMoney / chart[i];
      totalBuyStockCount += todayBuyStockCount;
      bmpMoney -= todayBuyStockCount * chart[i];
    }

    return totalBuyStockCount * chart[13] + bmpMoney;
  }

  static int TIMING() {
    int buyStockCount = 0;
    int timingMoney = money;
    int upCount = 0;
    int downCount = 0;

    for (int i = 1; i < 14; i++) {
      int yesterdayStockPrice = chart[i - 1];
      int todayStockPrice = chart[i];

      if (todayStockPrice > yesterdayStockPrice) {
        upCount++;
        downCount = 0;
      } else if (todayStockPrice < yesterdayStockPrice) {
        downCount++;
        upCount = 0;
      } else {
        downCount = 0;
        upCount = 0;
      }

      if (upCount >= 3) {
        timingMoney += todayStockPrice * buyStockCount;
        buyStockCount = 0;
      } else if (downCount >= 3) {
        int todayBuyStockCount = timingMoney / todayStockPrice;
        buyStockCount += todayBuyStockCount;
        timingMoney -= todayBuyStockCount * todayStockPrice;
      }
    }

    return buyStockCount * chart[13] + timingMoney;
  }

}