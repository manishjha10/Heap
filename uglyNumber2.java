class Solution {
    public int nthUglyNumber(int n) {
    TreeSet<Long> s = new TreeSet<>(); 
    
    s.add(1L); 
    n--; 

    while(n-->0)
    {
        long x = s.first();   // 1 element give.
        s.remove(x); 

        s.add(x*2);
        s.add(x*3); 
        s.add(x*5);        
    }
    return s.first().intValue();   // O(nlogng)
    }
}

