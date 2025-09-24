//       Brute Force 
// class Solution {
//     public int lastStoneWeight(int[] stones) {
//         List <Integer> arr = new ArrayList<>();
//         for(int ele : stones) {
//             arr.add(ele);
//         }
//         while(arr.size()>1){
//             Collections.sort(arr);
//             int y = arr.remove(arr.size()-1);
//             int x = arr.remove(arr.size()-1);
//             if(y!= x ) arr.add(y-x);
//         }
//         if(arr.size()==0) return 0;
//         else return arr.get(0);
//     }
// }
 

 class Solution{
    public int lastStoneWeight(int[] stones) {
        // MaxHeap
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : stones){
            pq.add(ele);
        }
        while(pq.size()>1){
            int y = pq.remove();
            int x = pq.remove();
            if(y!=x) pq.add(y-x);
        }
        if(pq.size()==0) return 0;
        else return pq.remove();
    }
 }

