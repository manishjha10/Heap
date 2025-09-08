class Project implements comparable<Project>{
  int profit; 
  int capital;
  Project (int profit , int capital)
  {
    this.profit = profit; 
    this.capital = capital; 
  }
  public int compareTo(Project that)
  {
    return this.capital - that.capital;  // inc order of capital;
  }
}

class Solution{
  public int findMaxcapital( int k, int w  , int[] profit, int[] capital)
  {
    PriorityQueue<Project> minPq =  new PriorityQueue<>(); 
   int n  = capital.length; 
   //  insert project in minpq

      for(int i=0; i<n; i++)
      {
        minPq .offer(new Project(profit[i] , int capital[i]);
      }
    PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder()); 

      while(k > 0)
      { 

        while(!minPq.isEmpty() && minPq.peek().capital <= k)
          {
            maxPq.offer(minPq.poll().profit); 
          }
        if(maxPw.isEmpty() ) break ; 

        w += maxPq.poll(); 
        k -- ;
      }
    return w;
  }
}

        

  
