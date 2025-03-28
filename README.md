# Sliding Window - The Ultimate Guide

## 🔍 What is Sliding Window?
Sliding Window is an optimization technique used for solving problems involving arrays or lists by maintaining a window of elements and efficiently updating the result as the window moves.

## 🚀 Types of Sliding Window
1. **Fixed Size Sliding Window** (Window of constant size `k`)
2. **Variable Size Sliding Window** (Expands and contracts dynamically based on conditions)
3. **Two Pointer Technique** (Often used in conjunction with sliding window)

---

## 🛠️ Implementing Sliding Window
### 1️⃣ **Fixed Size Sliding Window**
Used when the window size is constant (`k`).
```cpp
vector<int> maxSlidingWindow(vector<int>& nums, int k) {
    deque<int> dq;
    vector<int> res;
    for(int i = 0; i < nums.size(); i++) {
        if(!dq.empty() && dq.front() == i - k) dq.pop_front();
        while(!dq.empty() && nums[dq.back()] < nums[i]) dq.pop_back();
        dq.push_back(i);
        if(i >= k - 1) res.push_back(nums[dq.front()]);
    }
    return res;
}
```
✅ Efficient for finding max/min in a window.

### 2️⃣ **Variable Size Sliding Window**
Used when the window size changes dynamically.
```cpp
int minSubArrayLen(int target, vector<int>& nums) {
    int left = 0, sum = 0, minLen = INT_MAX;
    for(int right = 0; right < nums.size(); right++) {
        sum += nums[right];
        while(sum >= target) {
            minLen = min(minLen, right - left + 1);
            sum -= nums[left++];
        }
    }
    return minLen == INT_MAX ? 0 : minLen;
}
```
✅ Useful for problems with dynamic constraints.

---

## 📌 Important Sliding Window Patterns & Problems

### 1️⃣ **Fixed Size Sliding Window**
- **Example:** [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
- **Example:** [First Negative Number in Every Window of Size K](https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/)

### 2️⃣ **Variable Size Sliding Window**
- **Example:** [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)
- **Example:** [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

### 3️⃣ **Sliding Window + Two Pointers**
- **Example:** [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)
- **Example:** [Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)

---

## 🎯 When to Use Sliding Window?
| Situation | Use |
|-----------|-----|
| Finding maximum/minimum in a window | Fixed Size Sliding Window |
| Dynamic subarrays meeting a condition | Variable Size Sliding Window |
| Optimizing a brute-force solution | Sliding Window + Two Pointers |

---

## 📚 More Practice Problems
1. [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)
2. [Permutation in String](https://leetcode.com/problems/permutation-in-string/)
3. [Longest Subarray of Ones After Deleting One Element](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/)

---

## 🔥 Conclusion
Sliding Window is a powerful technique for solving problems efficiently by reducing redundant calculations. Mastering its patterns will help in many competitive programming problems.

Happy Coding! 🚀

