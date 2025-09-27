//                  Brute force method  TC -> O(n^2logn)
// class MedianFinder {
//     List<Integer> arr = new ArrayList<>();
//     public MedianFinder() {
        
//     }
    
//     public void addNum(int num) {
//        arr.add(num); 
//     }
    
//     public double findMedian() {
//         Collections.sort(arr);
//         int n = arr.size();
//         if(n%2!=0) return arr.get(n/2);
//         else return (arr.get(n/2) + arr.get(n/2-1))/2.0;
        
//     }
// }


class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();


    public MedianFinder() {

    }

     public void addNum(int num) {
        if(maxHeap.size()==0) maxHeap.add(num);
        else {
            if(num<maxHeap.peek()) maxHeap.add(num);
            else minHeap.add(num);
        }

        // Balance the heaps
        if(maxHeap.size()==minHeap.size()+2){
            int top = maxHeap.remove();
            minHeap.add(top);
        }
        if(minHeap.size() == maxHeap.size()+2){
            int top = minHeap.remove();
            maxHeap.add(top);
        }
     }

     public double findMedian() {
        if(maxHeap.size()== minHeap.size())
          return (maxHeap.peek() + minHeap.peek())/ 2.0;
        else if(maxHeap.size()> minHeap.size())
          return maxHeap.peek();
        else return minHeap.peek();    
     }
}