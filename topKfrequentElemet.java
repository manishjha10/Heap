class Solution {
    public ArrayList<Integer> topKFrequent(int[] arr, int k) {
       
        ArrayList<Integer> li = new ArrayList<>();
        Map<Integer,Integer> mp = new HashMap<>();
       
        for(int i : arr){
            mp.put(i,mp.getOrDefault(i,0)+1);
        } 
        
       
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {
           
           //  min heap on the basics of map value 
           if(mp.get(a).equals(mp.get(b))) return a - b ; //  if eqal smallest would be return 
           else return mp.get(a) - mp.get(b);   // min heap conditon 
       }); 

    
        for(int key : mp.keySet()){
            pq.add(key);
            if(pq.size() > k){
                pq.remove();
            }
        }
        
        
        while(pq.size()!=0){
            li.add(pq.remove());
        }
        
        
        Collections.reverse(li);
        return li;
    }
    
}
