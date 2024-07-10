import java.util.Stack;

public class CSeqQueue<T> implements IQueue<T>{
    public T[] data;//数组，用于存储队列中的数据元素
    public int maxsize;
    public int front;//队头，front的变化范围是0~maxsize-1
    public int rear;//队尾，rear的变化范围是0~maxsize-1


    /*构造函数*/
    public CSeqQueue(int size){
        data=(T[])new Object[size];
        maxsize=size;
        front=rear=0;
    }
    @Override
    public int Count() {
        return (rear-front+maxsize)%maxsize;
    }

    @Override
    public boolean IsEmpty() {
        return front==rear;
    }

    /*判断队列已满*/
    /*注意：循环队列判断队列已满的条件是当所占用的空间比总空间少1个时，我们认为该队列已满*/
    public boolean IsFull(){
        return (rear+1)%maxsize==front;
    }
    @Override
    public void Clear() {
        front=rear;
    }

    /*入队操作，在队列未满的情况下，在rear处插入元素，然后使rear+1*/
    /*特别的，如果rear已经是数组的最后一个位置（但是数组的头部因为删除操作还有空位），则插入元素后，rear由maxsize-1变为0*/
    @Override
    public void In(T item) {
        if(IsFull()){
            throw new RuntimeException("Queue is full");
        }
        data[rear]=item;
        if(rear==maxsize-1){
            rear=0;
        }else{rear++;}
    }

    /*出队操作*/
    /*在队列不空的情况下，使队头指示器front加1*/
    /*特别的，如果front已经是数组的最后一个位置，则元素出队后，rear由maxsize-1变为0*/
    @Override
    public T out() {
        T tmp;
        if(IsEmpty()){
            throw new RuntimeException("队列为空");
        }
        tmp=data[front];
        if(front==maxsize-1){
            front=0;
        }else{front++;}
        return tmp;
    }

    @Override
    public T GetFront() {
        if(IsEmpty()){System.out.println("队列为空");}
        return data[front];
    }
}
