public class Node<T> {
    T data;
    Node<T> next;

    /*构造函数*/
    public Node(T val,Node<T> p){
        data=val;
        next=p;
    }
    //一个参数的构造函数
    public Node(T val){
        data=val;
    }
    public Node(Node<T>p){
        next=p;
    }
    //无参构造
    public Node(){
        next=null;
    }
}