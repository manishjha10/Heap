class MedianFinder {
    PriorityQueue<Integer> small; // max heap
    PriorityQueue<Integer> large;  // min heap  

    public MedianFinder() {
        small =  new PriorityQueue<>((a,b) -> b - a);  // max heap 
        large = new PriorityQueue<>();   // min heap 
    }
    
    public void addNum(int num){
        if(small.isEmpty() || num <= small.peek())
        {
            small.offer(num); 
        }else {
            large.offer(num); 
        }

        if(small.size() > large.size() + 1)
        {
            large.offer(small.poll()); 
        } else if (large.size() > small.size())
        {
            small.offer(large.poll()); 
        }
    }
    
    public double findMedian() {
        if(small.size() == large.size())
        {
            return (small.peek() + large.peek()) / 2.0; 
        }
        return small.peek();
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
