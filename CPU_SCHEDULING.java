// Heap  Solution .
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
       
        for(char ch: tasks)
            freq[ch - 'A']++;

        Queue<Integer> pq = new PriorityQueue(Collections.reverseOrder()); // max 

        for(int x: freq) {
            if(x > 0)
                pq.add(x);
        }

        int time = 0;

        while(!pq.isEmpty()) {
            List<Integer> temp = new ArrayList();

            for(int i=1; i<=n+1; i++) {
                if(!pq.isEmpty()) {
                    int f = pq.poll();
                    f--;
                    temp.add(f);
                }
            }

            for(int f: temp)
                if(f > 0)
                    pq.add(f);

            if(pq.isEmpty())
                time += temp.size();
            else
                time += (n+1);
        }

        return time;
    }
}

// Greedy solution . 
// class Solution {
//     public int leastInterval(char[] tasks, int n) {
//         int[] freq = new int[26];
//         for(char ch:tasks){
//             freq[ch-'A']++;
//         }
//         int maxfreq = 0;
//         for(int curfreq:freq){
//             maxfreq = Math.max(maxfreq,curfreq);
//         }

//         int maxcount = 0;
//         for(int count:freq){
//             if(count==maxfreq) maxcount++;
//         }

//         return Math.max(tasks.length,(maxfreq-1)*(n+1)+maxcount);
//     }
// }
