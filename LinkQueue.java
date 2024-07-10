public class LinkQueue<T> implements IQueue<T>{
    public Node<T>front;//队头指示器
    public Node<T>rear;//队尾指示器

    /*构造函数,构造了一个只用头结点的空队列*/
    public LinkQueue(){
        front=rear=new Node<T>();//头结点数据域等于T类型的默认值，引用域为空
    }

    @Override
    public int Count() {
        Node<T>p=front;
        int len=0;
        while(p!=null){
            ++len;
            p=p.next;
        }
        return len-1;
    }

    @Override
    public boolean IsEmpty() {
        return front==rear;
    }

    @Override
    public void Clear() {
        front.next=null;
        rear=front;
    }

    @Override
    public void In(T item) {
        Node<T>p=new Node<>(item);
        rear.next=p;
        rear=p;
    }

    /*队列只能是第一个元素出，最后一个元素入*/
    @Override
    public T out() {
        if(IsEmpty()){
            throw new RuntimeException("队列为空，无法删除");
        }
        Node<T>p=front.next;
        front.next=p.next;
        return p.data;
    }

    @Override
    public T GetFront() {
        if(IsEmpty()){
            throw new RuntimeException("队列为空，无法获取");
        }
        return front.next.data;
    }
}
