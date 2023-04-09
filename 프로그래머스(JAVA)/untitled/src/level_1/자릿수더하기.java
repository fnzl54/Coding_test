package level_1;

public class 자릿수더하기 {
    public static void main(String[] args) {
        int n = 123;

        int tempAdd = 0;

        String s = Integer.toString(n); //int n을 String으로 변환

        for (int i = 0; i < s.length(); i++){
            tempAdd +=  Character.getNumericValue(s.charAt(i));

        }

        System.out.println(tempAdd);

    }
}
