/**
 * 1317. Convert Integer to the Sum of Two No-Zero Integers
 *
 * Given an integer n. No-Zero integer is a positive integer which doesn't contain any 0 in its decimal representation.
 *
 * Return a list of two integers [A, B] where:
 *
 * A and B are No-Zero integers.
 * A + B = n
 * It's guarateed that there is at least one valid solution. If there are many valid solutions you can return any of them.
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: [1,1]
 * Explanation: A = 1, B = 1. A + B = n and both A and B don't contain any 0 in their decimal representation.
 *
 * Example 2:
 *
 * Input: n = 11
 * Output: [2,9]
 *
 * Example 3:
 *
 * Input: n = 10000
 * Output: [1,9999]
 *
 * Example 4:
 *
 * Input: n = 69
 * Output: [1,68]
 *
 * Example 5:
 *
 * Input: n = 1010
 * Output: [11,999]
 *
 *
 * Constraints:
 *
 * 2 <= n <= 10^4
 */
public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for (int i = 1; i < n; i++) {
            if (withoutZero(i) && withoutZero(n - i)) {
                ans[0] = i;
                ans[1] = n - i;
                break;
            }
        }
        return ans;
    }

    private boolean withoutZero(int n) {
        while (n > 0) {
            if ((n % 10) == 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

}
