class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for(int i = 0; i <= k; i++){
            int[] temp = dist.clone();
            for(int j = 0; j < flights.length; j++){
                int from = flights[j][0];
                int to = flights[j][1];
                int price = flights[j][2];
                if(dist[from] != Integer.MAX_VALUE){
                    int newPrice = dist[from] + price;
                    if (newPrice < temp[to]) {
                        temp[to] = newPrice;
                    }
                }
            }
            dist = temp;
        }
        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        }

        return dist[dst];
    }
}