public class 평균구하기 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        double answer = 0;

        int tempAdd = 0;

        for (int i = 0; i < arr.length; i++) {
            tempAdd += arr[i];
        }

        answer = (double) tempAdd / arr.length;

    }
}
