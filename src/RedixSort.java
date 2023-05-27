import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedixSort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(387, 468, 134, 123, 68, 221, 769, 37, 7));
        radixSort(numbers);
        System.out.println(numbers);
    }

    public static void radixSort(List<Integer> numbers) {
        if (numbers == null || numbers.size() <= 1) {
            return;
        }

        int maxNumber = getMaxNumber(numbers);
        int maxLength = getNumDigits(maxNumber);

        for (int digitPlace = 1; digitPlace <= maxLength; digitPlace++) {
            List<Integer>[] buckets = new List[10];
            for (int i = 0; i < 10; i++) {
                buckets[i] = new ArrayList<>();
            }

            for (int number : numbers) {
                int digit = getDigit(number, digitPlace);
                buckets[digit].add(number);
            }

            numbers.clear();
            for (List<Integer> bucket : buckets) {
                numbers.addAll(bucket);
            }
        }
    }

    private static int getMaxNumber(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static int getNumDigits(int number) {
        if (number == 0) {
            return 1;
        }
        return (int) Math.log10(Math.abs(number)) + 1;
    }

    private static int getDigit(int number, int digitPlace) {
        return (number / (int) Math.pow(10, digitPlace - 1)) % 10;
    }

}
