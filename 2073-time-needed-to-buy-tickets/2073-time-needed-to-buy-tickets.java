class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            q.add(i);
        }
        int time=0;
        while(!q.isEmpty()){
            int i=q.remove();
            tickets[i]--;
            time++;
            if(tickets[i]>0){
                q.add(i);
            }
            if(tickets[k]==0){
                return time;
            }
        }
        return time;
    }
}