import java.util.PriorityQueue;

public class Task2 {
    public static int[] Task2(int[] numbers, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b - a);

        for (int i = 0; i < k; i++) {
            maxHeap.offer(numbers[i]);
        }

        for (int i = k; i < numbers.length; i++) {
            int num = numbers[i];

            if (num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }

        int[] leastFour = new int[k];
        for (int i = 0; i < k; i++) {
        	leastFour[i] = maxHeap.poll();
        }

        return leastFour;
    }

    public static void main(String[] args) {
        int[] dumpArray = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        int[] testOutput = Task2(dumpArray, k);
         
        for (int i : testOutput) {
            System.out.print(i + " ");
        }
    }
}
