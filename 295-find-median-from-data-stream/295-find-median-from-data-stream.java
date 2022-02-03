class MedianFinder {

    PriorityQueue<Integer> lo, hi;
    
    public MedianFinder() {
        lo = new PriorityQueue<>(Collections.reverseOrder());
        hi = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.poll());
        if(lo.size() < hi.size()) {
            lo.add(hi.poll());
        }
    }
    
    public double findMedian() {
        if(lo.size() > hi.size())
            return lo.peek();
        else
            return ((double) lo.peek() + hi.peek()) * 0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */