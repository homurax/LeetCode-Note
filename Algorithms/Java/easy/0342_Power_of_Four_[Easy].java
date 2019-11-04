/**
 * 342. Power of Four
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 5
 * Output: false
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {


    /**
     * 2的幂次方只有高位为1
     * 4的幂次方奇数位为1
     */
    public boolean isPowerOfFour(int num) {
        return num > 0
                && ((num & (num - 1)) == 0
                && ((num & 0x55555555) == num));
    }
}
