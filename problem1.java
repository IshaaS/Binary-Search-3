// Time Complexity : O(long(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//reducing the n by half always. makes the solution binary (log(n))
//for odd we are multiply result with x, and for every iteraion we are multiplying x with x.

// class Solution {
//     public double myPow(double x, int n) {
//         //base
//         if(n==0) return 1;
//         //recursion
//         double mul=x;
//         if(n<0){
//             mul=1/x;
//         }
//         double half= myPow(x,n/2);
//         if(n%2==0) return half*half;
//         else return half*half*mul;
//     }
// }

class Solution {
    public double myPow(double x, int n) {
        if(n<0) {
            x=1/x;
            n=n*-1;
        }
        double result=1.0;
        while(n!=0){
            if(n%2!=0)result=result*x;
            x= x*x;
            n=n/2;
        }
        return result;
    }
}