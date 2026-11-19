class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, visited, i, n);
            }
        }

        return count;
    }

    static void dfs(int[][] isConnected, boolean[] visited,
                    int city, int n) {
        visited[city] = true;
        for (int j = 0; j < n; j++) {
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j, n);
            }
        }
    }
}