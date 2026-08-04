class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] merged = new int[m+n];

        int index=0, i=0, j=0;
        while(i<m && j<n){
            if(nums1[i] <= nums2[j]){
                merged[index++] = nums1[i++];
            }else{
                merged[index++] = nums2[j++];
            }
        }

        while(i < m){
            merged[index++] = nums1[i++];
        }

        while(j < n){
            merged[index++] = nums2[j++];
        }

        int size = merged.length;

        if(size % 2 != 0){
            int idx = size/2;
            return (double)merged[idx];
        }
        
        int idx = size/2;
        int next_idx = idx;
        double res = ((double)merged[idx-1] + (double)merged[idx])/2.0;
        return res;
    }
}
