class Solution {

    private boolean isPossible(int[] weights, int days, int capacity) {
        int requiredDays = 1;
        int load = 0;

        for (int weight : weights) {
            if (load + weight > capacity) {
                requiredDays++;
                load = weight;
            } else {
                load += weight;
            }
        }

        return requiredDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;

        for (int weight : weights) {
            l = Math.max(l, weight);
            r += weight;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isPossible(weights, days, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
