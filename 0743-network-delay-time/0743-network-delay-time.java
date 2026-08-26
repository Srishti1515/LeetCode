class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new int[]{v, w});
        }
        int[] dist = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        q.offer(new int[]{0, k});
        while(!q.isEmpty()){
            int[] curr = q.poll();

            int distance = curr[0];
            int node = curr[1];
            if(distance > dist[node]){
                continue;
            }

            for(int[] next : adj.get(node)){
                int neighbour = next[0];
                int weight = next[1];
                int newDistance = distance + weight;
                if(newDistance < dist[neighbour]){
                    dist[neighbour] = newDistance;
                    q.offer(new int[]{newDistance, neighbour});
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}