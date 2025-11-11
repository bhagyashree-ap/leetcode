class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();

        heap.add(0);

        while (!heap.isEmpty()) {
            int start = heap.poll();
            if (visited.contains(start)) continue;
            visited.add(start);

            for (int end = start + 1; end <= s.length(); end++) {
                if (wordSet.contains(s.substring(start, end))) {
                    if (end == s.length()) return true;
                    heap.add(end);
                }
            }
        }

        return false;
    }
}
