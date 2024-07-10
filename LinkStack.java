public class LinkStack <T>implements Istack<T>{
    public Node<T>top;//栈顶指示器(可以将top理解为head)
    public int num;//栈中结点的个数

    /*构造函数*/
    public LinkStack(){
        top=null;
        num=0;
    }

    @Override
    public int Count() {
        /*求链栈的长度*/
        return num;
    }
    public int GetLength(){
        /*求链栈的长度*/
        return num;
    }

    @Override
    public boolean IsEmpty() {
        return num==0;
    }

    /*清空操作*/
    @Override
    public void Clear() {
        top=null;
        num=0;
    }

    /*入栈操作*/
    @Override
    public void Push(T item) {
        //将top理解为head，每次插入就是将数据元素插入到链栈的第一个位置
        //这种理解是将top视为固定不变的，也可以将top视为可变的，即每次插入将top.next设为p,再让top=top.next，这种方法仅将top视为单独的一个结点，而与整个链栈无关
        Node<T> p=new Node<T>(item);
        if(top==null){
            top=p;
        }else{
            p.next=top;
            top.next=p;
        }
        num++;
    }

    /*出栈操作*/
    @Override
    public T Pop() {
        if(IsEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        Node<T>p=top;
        top=top.next;
        return p.data;
    }

    @Override
    public T GetTop() {
        if(IsEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }
}
