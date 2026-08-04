class Solution {
    private boolean canFinish(int mid, int[] piles, int h){
        int time = 0;
        for(int i=0; i<piles.length; i++){
            if(time > h){
                return false;
            }
            double val = (double)piles[i]/mid;
            time += (int)Math.ceil(val);
        }

        return time <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxElem = 0;
        for(int i=0; i<n; i++){
            if(piles[i] > maxElem){
                maxElem = piles[i];
            }
        }

        int l=1, r=maxElem, result=0;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(canFinish(mid, piles, h)){
                result = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return result;
    }
}
