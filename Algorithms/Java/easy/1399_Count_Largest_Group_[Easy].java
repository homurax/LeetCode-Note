/**
 * 1399. Count Largest Group
 *
 * Given an integer n. Each number from 1 to n is grouped according to the sum of its digits.
 *
 * Return how many groups have the largest size.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 13
 * Output: 4
 * Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
 * [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with largest size.
 *
 * Example 2:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are 2 groups [1], [2] of size 1.
 *
 * Example 3:
 *
 * Input: n = 15
 * Output: 6
 * Example 4:
 *
 * Input: n = 24
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10^4
 */
public class CountLargestGroup {

    public int countLargestGroup(int n) {
        int max = 1;
        int[] count = new int[n + 1];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i / 10] + i % 10;
            count[sum[i]]++;
            if (count[sum[i]] > max) {
                max = count[sum[i]];
            }
        }
        int ans = 0;
        for (int num : count) {
            if (num == max) {
                ans++;
            }
        }
        return ans;
    }

}
