class Bitset {
    private int[] bits;
    private int size, ones, isFlip;

    public Bitset(int size) {
        bits = new int[size];
        this.size = size;
        this.ones = 0;
        this.isFlip = 0;
    }

    public void fix(int idx) {
        if(bits[idx] == isFlip) {
            bits[idx] = isFlip == 0 ? 1 : 0;
            ones++;
        }
    }

    public void unfix(int idx) {
        if(bits[idx] != isFlip) {
            bits[idx] = isFlip; 
            ones--;
        }
    }

    public void flip() {
        if(isFlip == 1) isFlip = 0;
        else isFlip = 1;
        ones = size - ones;
    }

    public boolean all() {
        return ones == size;
    }

    public boolean one() {
        return ones > 0;
    }

    public int count() {
        return ones;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            sb.append(bits[i] == isFlip ? 0 : 1);
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */