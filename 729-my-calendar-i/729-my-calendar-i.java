class MyCalendar {
    TreeMap<Integer,Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer lowerVal = calendar.lowerKey(end);
        if(lowerVal == null || calendar.get(lowerVal) <= start){
            calendar.put(start,end);
            return true;
        }
        
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */