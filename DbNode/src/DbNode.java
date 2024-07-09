public class DbNode<T> {
    DbNode<T> prev;//前驱引用域
    T data;//数据域
    DbNode<T> next;//后驱引用域

    /*三个参数的构造函数*/
    public DbNode(T val,DbNode<T>p1,DbNode<T>p2){
        this.data=val;
        prev=p1;
        next=p2;
    }
    //两个参数的构造函数
    public DbNode(DbNode<T>p1,DbNode<T>p2){
        prev=p1;
        next=p2;
    }
    //一个参数的构造函数
    public DbNode(T val){
        data=val;
        prev=null;
        next=null;
    }
    //无参构造函数
    public DbNode(){
        prev=null;
        next=null;
    }
}
