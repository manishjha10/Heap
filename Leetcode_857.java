class Worker{
  double baseWage; 
  int quality; 
public Worker (double baseWage , int quality){
  this.baseWage = baseWage; 
  this.quality = quality; 
  }
}

class Solution {
  public double minCostToHireWorker(int[] quality , int[] wage , int k){

    ArrayList<Worker> list = new ArrayList<>(); 
    int n  = quality.length; 

    for(int i=0; i<n; i++){
      double baseWage = 1.0* wage[i] / quality[i] ;
      list.add(new worker(baseWage , quality[i])); 
    }
    Collections.sort(list , new Comparator<Worker>(){
      public int compare(Worker w1 , Worker w2){
        if(w1.baseWage <= w2.baseWage){
          return -1; 
        }else
        {
          return 1; 
        }
      }
    });
PriorityQueue<Worker> pq = PriorityQueue<>( new Comparator<Worker>() {
  if(w1.quality <= w2.quality){
    return 1; 
  }else 
  {
    return -1; 
  }
});
double ans =  Double.Max_VALUE ; 
int totalQuailty = 0; 

    for(int i=0; i<n; i++){
      pq.offer(list.get(i)); 
      totalQuality += list.get(i).quality; 

      if(pq.size() == k) 
      {
        double cost =  totalQuality * list.get(i).baseWage; 

        ans  =  Math.min(ans, cost); 
        totalQuality -= pq.poll().quality; 
      }
    }
    return ans; 
  }
}
