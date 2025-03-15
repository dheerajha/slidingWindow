public class VariableWin {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 7, 10 };
        int n = arr.length;
        int k = 14;
        int left = 0, right = 0;
        int maxLen = 0;
        int sum = 0;
        while (right < n) {
            sum += arr[right];
            while (sum > k) { // use if in that case if they only ask length as we maintain maxLen we
                              // calcuated previously but if they ask for array then use while only
                sum -= arr[left];
                left++;
            }
            if (sum <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        System.out.println(maxLen);
    }
}
/*
 * below is the most optimal approach for this type problem
 * public class VariableWin {
 * public static void main(String[] args) {
 * int[] arr = {2, 5, 1, 7, 10};
 * int n = arr.length;
 * int k = 14;
 * 
 * int left = 0, sum = 0, maxLen = 0;
 * 
 * // Sliding window loop
 * for (int right = 0; right < n; right++) {
 * sum += arr[right]; // Expand window by adding right element
 * 
 * // ❗ If they only ask for the length, we can use 'if' instead of 'while'
 * // This prevents shrinking too much since maxLen is updated continuously.
 * // Use 'while' ONLY if they want the actual valid subarray too.
 * while (sum > k) {
 * sum -= arr[left];
 * left++;
 * }
 * 
 * // Update max length if current window sum is valid
 * maxLen = Math.max(maxLen, right - left + 1);
 * }
 * 
 * System.out.println("Maximum subarray length with sum ≤ " + k + ": " +
 * maxLen);
 * }
 * }
 * 
 */