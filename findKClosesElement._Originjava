class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Priority
    PriorityQueue<int[]> pq = new PriorityQueue<>(
    (a, b) -> b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]); // bigger distance → higher priority


for (int i = 0; i < arr.length; i++) {
    int dis = Math.abs(arr[i] - x);
    pq.add(new int[]{dis, arr[i]});
    
    if (pq.size() > k) {
        pq.poll();
    }
} 

List<Integer> l = new ArrayList<>();
while (!pq.isEmpty()) {
    l.add(pq.poll()[1]);
}

// final answer should be sorted
Collections.sort(l);
return l;

    }
}
