class MyCircularQueue {
    int[] data;
    int capacity;
    int start;
    int rear;
    int size;
    public MyCircularQueue(int k) {
        this.data = new int[k+1];
        this.capacity = k+1;        
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        
        rear = (rear + 1) % (capacity);
        data[rear] = value;        
        
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }

        start = (start + 1) % (capacity); 
        data[start] = -1;
        
        return true;        
    }
    
    public int Front() {
        if(!isEmpty()) return data[(start + 1) % (capacity)];
        return -1;
    }
    
    public int Rear() {
        if(!isEmpty()) return data[rear];
        return -1;
    }
    
    public boolean isEmpty() {
        return start == rear;
    }
    
    public boolean isFull() {
        return (rear+1) % (capacity)  == start;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */