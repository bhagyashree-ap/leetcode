class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        int[] state = new int[numCourses];
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs(i, graph, state, order)) return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) result[i] = order.get(numCourses - 1 - i);
        return result;
    }

    private boolean dfs(int course, List<List<Integer>> graph, int[] state, List<Integer> order) {
        if (state[course] == 1) return false;
        if (state[course] == 2) return true;

        state[course] = 1;

        for (int next : graph.get(course)) {
            if (!dfs(next, graph, state, order)) return false;
        }

        state[course] = 2;
        order.add(course);
        return true;
    }
}
