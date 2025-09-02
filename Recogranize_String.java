class Solution {
    public String reorganizeString(String s) { 
     Map<Character,Integer> mp = new HashMap<>();   
     for(int i=0; i<s.length(); i++)
     { 
        char ch  = s.charAt(i);
        mp.put(ch, mp.getOrDefault(ch,0)+1);
     }
     PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> mp.get(b) -mp.get(a));    
     pq.addAll(mp.keySet());
     
     StringBuilder sb = new StringBuilder(); 
     while(pq.size() > 1)
     {
        char first  = pq.poll(); 
        char second = pq.poll();

        sb.append(first); 
        sb.append(second); 

        mp.put(first,mp.get(first)-1); 
        mp.put(second,mp.get(second)-1);  

        if(mp.get(first)  > 0 ) pq.add(first); 
        if(mp.get(second) > 0)  pq.add(second); 
     }
     
     if(!pq.isEmpty())
     {
       char ch = pq.poll(); 
       if(mp.get(ch) > 1) return ""; 
       sb.append(ch) ;
     }
     return sb.toString(); 
      
    }
}
