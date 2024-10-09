package homework10;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        int[] array = new int[] {11, 144, 22, 3, 4, 5, 6, 7, 8, 9};

        ByCondition condition1 = number -> number % 2 == 0;
        ByCondition condition2 = number -> {
            char[] partOfNumber = String.valueOf(number).toCharArray();
            int result = 0;
            for (int i = 0; i < partOfNumber.length; i++) {
                result = result + Integer.parseInt(String.valueOf(partOfNumber[i]));
            }
            return result % 2 == 0;
        };

        System.out.println(Arrays.toString(Sequence.filter(array, condition1)));
        System.out.println(Arrays.toString(Sequence.filter(array, condition2)));

    }

}
