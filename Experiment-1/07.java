class Solution {
    
    public static int firstOccurrence(int[] arr, int k){
        int l=0, r=arr.length-1, ans=-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(arr[mid] == k){
                ans = mid;
                r = mid-1;
            }else if(arr[mid] < k){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return ans;
    }

    public static int lastOccurrence(int[] arr, int k){
        int l=0, r=arr.length-1, ans=-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(arr[mid]==k){
                ans = mid;
                l = mid+1;
            }else if(arr[mid] < k){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = firstOccurrence(nums, target);
        ans[1] = lastOccurrence(nums, target);

        return ans;
    }
}
