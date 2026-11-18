class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];

            adj.get(prerequisite).add(course);
        }
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int completed = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            completed++;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        return completed == numCourses;
    }
}
