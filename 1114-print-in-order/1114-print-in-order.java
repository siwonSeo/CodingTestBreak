class Foo {
    int flag=0;
    public Foo() {
        
        
    }

    synchronized public void first(Runnable printFirst) throws InterruptedException {
        while(flag!=0){
            wait();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag=1;
        notifyAll();
    }

    synchronized public void second(Runnable printSecond) throws InterruptedException {
        while(flag!=1){
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag=2;
        notifyAll();
    }

    synchronized public void third(Runnable printThird) throws InterruptedException {
        while(flag!=2){
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        flag=0;
        notifyAll();
    }
}