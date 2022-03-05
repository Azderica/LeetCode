class Logger {
    private Map<String, Integer> msgDict;

    public Logger() {
        msgDict = new HashMap<String, Integer>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!msgDict.containsKey(message)) {
            msgDict.put(message, timestamp);
            return true;
        }
        
        int oldTimestamp = msgDict.get(message).intValue();
        if(timestamp - oldTimestamp >= 10) {
            msgDict.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */