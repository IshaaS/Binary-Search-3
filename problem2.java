// Time Complexity : O(log(n)+k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//we start with first and last element and decrease the window from either side
//until window is equal to k. we decrease the window by moving left to right or right to left
//based on the absolute difference(greater).

//2 pointers
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         int left = 0;
//         int right = arr.length-1;
//         while(right-left>=k){
//             int dif1 = arr[left]-x;
//             if(dif1<0) dif1=dif1*-1;
//             int dif2=arr[right]-x;
//             if(dif2<0) dif2=dif2*-1;
//             if(dif1<=dif2) right= right-1;
//             else left = left+1;
//         }
//         List<Integer> result = new ArrayList<>();
//         for(int i=left;i<=right;i++){
//             result.add(arr[i]);
//         }
//         return result;
//     }
// }

// Your code here along with comments explaining your approach
// we use max heap, we add every element one by one, but keep the top k elements in the
//heap with least absolute difference.

//O(nlog(k)) time
//heap and hashmap
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         HashMap<Integer, Integer> maping = new HashMap<>();
//         PriorityQueue<int []> pq= new PriorityQueue<>((a,b)->{
//             if(a[1]==b[1]) return b[0]-a[0];
//             else return b[1]-a[1];
//         });
//         for(int i=0;i<arr.length;i++){
//             int dis = Math.abs(arr[i]-x);
//             pq.add(new int[]{i,dis});
//             if(pq.size()>k){
//                 pq.poll();
//             }
//         }
//         List<Integer> result=new ArrayList<>();
//         while(!pq.isEmpty()){
//             result.add(arr[pq.poll()[0]]);
//         }
//         Collections.sort(result);
//         return result;
//     }
// }

//finding a window of size k inside arr such that that window is closest to x
//binary search for low, the best starting index of that k‑window.
//We’re comparing two “edge distances”:
// Left distance: x - arr[mid] (how far x is from the start of this window)
// Right distance: arr[mid + k] - x (how far x is from the element just beyond this window)
// If the right distance is smaller, it means you should shift the window to the right (low = mid + 1), otherwise shift to the left (or keep).
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low =0;
        int high = arr.length-k;
        while(low<high){
            int mid = low+(high-low)/2;
            int distS = x-arr[mid];
            int distE = arr[mid+k]-x;
            if(distE<distS) low = mid+1;
            else high = mid;
        }
        List<Integer> result = new ArrayList<>();
        for(int i=low; i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}