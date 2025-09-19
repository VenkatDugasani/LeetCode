class RecentCounter {
    private Queue<Integer> resultQueue;

    public RecentCounter() {
        resultQueue = new LinkedList<>();
    }
    
    public int ping(int t) {
        resultQueue.offer(t);

        while(resultQueue.peek() < t - 3000){
            resultQueue.poll();
        }
        return resultQueue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */