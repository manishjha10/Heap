class Solution {
    public static int minCost(int[] arr) {
        // min first  use min heap 
        if(arr.length  == 0) return 0; 
        PriorityQueue<Integer> pq = new  PriorityQueue<>((a,b) -> a-b); 
        
         int sum  = 0; 
         for(int el :  arr)
         {
            pq.offer(el); 
         }
         
         //  we pick 2  elements from the heap 
          while(pq.size() > 1){
             int first = pq.poll(); 
             int second  = pq.poll(); 
             
             int cost = first + second; 
             sum += cost; 
             
             // **** again push we need a single rope cost **  
             pq.offer(cost);
             
         } 
         return sum;
    }
}



