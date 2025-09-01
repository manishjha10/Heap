class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String , Integer> mp = new HashMap<>(); 
        for(String ele : words)
        {
            mp.put(ele , mp.getOrDefault(ele, 0)+1);
        }
       
PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
    (a, b) -> {
        if (!a.getValue().equals(b.getValue())) {
            return a.getValue() - b.getValue(); 
            // smaller freq first → so when size > k, we pop min
        } else {
            return b.getKey().compareTo(a.getKey()); 
            // reverse lex order for tie → so correct one stays
        }
    }
);

        for(Map.Entry<String, Integer> e : mp.entrySet())
        {
            pq.offer(e); 
            if(pq.size() > k)
            {
                pq.poll();
            }
        } 
       
       List<String> l = new ArrayList<>(); 
       while(!pq.isEmpty())
        {
          String ele = pq.poll().getKey() ; 
          l.add(ele);
        }
        Collections.reverse(l); 
       return l; 
    }
}
