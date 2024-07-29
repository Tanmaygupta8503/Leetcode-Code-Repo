class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer ,Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i , map.getOrDefault(i , 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer , Integer> entry : map.entrySet()) {
            pq.add(entry);
            if(pq.size() > k) pq.poll();
        }
        int arr[] = new int[k];
        int ptr = 0;
        for(int i = 0 ; i < k ; i ++) {
            arr[i] = pq.poll().getKey();
        }
        return arr;
    }
}