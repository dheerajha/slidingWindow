public class ConstantWin {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        int n = arr.length;

        if (n < k) {
            System.out.println("Window size is larger than array size");
            return;
        }

        // Calculate the sum of the first window
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;

        // Slide the window across the array
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k]; // Add new element, remove old one
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println("Maximum sum of subarray of size " + k + ": " + maxSum);
    }
}
