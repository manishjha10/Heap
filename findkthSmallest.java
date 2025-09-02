class Solution {
    public int kthSmallest(int[][] mat, int k) {
        // 
        List<Integer> l = new ArrayList<>(); 
        l.add(0); 

        for(int[] row : mat)
        {
            l = merge(l,row,k); 
        }
        return l.get(k-1);
    }
    public List<Integer> merge(List<Integer> prev , int[] row , int k)
    {
       PriorityQueue<Integer> pq = new PriorityQueue<>(); 

       for(int ele : prev)
       {
          for(int  val : row)
          {
              pq.add(ele + val);    // list + val[that is each row ]
          }
       }
       
       List<Integer> l = new ArrayList<>(); 
       for(int i=0; i<k && !pq.isEmpty(); i++)
       {
          l.add(pq.poll());
       }
       return l ;

    }
}
