/**
 * 1046. Last Stone Weight
 *
 * We have a collection of rocks, each rock has a positive integer weight.
 *
 * Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *
 *
 * Example 1:
 *
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *
 *
 * Note:
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length);
        for (int stone : stones) {
            queue.add(-1 * stone);
        }

        while (queue.size() > 1) {
            int x = -1 * queue.poll();
            int y = -1 * queue.poll();
            if (x != y) {
                queue.add(-1 * Math.abs(x - y));
            }
        }

        return queue.isEmpty() ? 0 : -1 * queue.poll();
    }


    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones){
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            Integer weight1 = pq.poll();
            Integer weight2 = pq.poll();
            int diff = weight1 - weight2;
            if (diff > 0) {
                pq.offer(diff);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

}
