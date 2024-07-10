public class SeqStack<T> implements Istack<T>{
    public T[] data;//数组，用于存储顺序栈中的数据元素
    public int maxsize;//顺序栈的容量
    public int top;//指示顺序栈的栈顶，值是栈顶元素在数组中的下标

    /*创建顺序栈类的构造函数*/
    public SeqStack(int size){
        data=(T[]) new Object[size];//类型为T，长度为size的数组存放栈中元素
        maxsize=size;//栈的容量等于数组的长度
        top=-1;//空栈top的值为-1
    }

    @Override
    public int Count() {
        return top+1;
    }

    @Override
    public boolean IsEmpty() {
        return top==-1;
    }

    public  boolean IsFull(){
        if(top==maxsize-1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void Clear() {
        top=-1;
    }

    @Override
    public void Push(T item) {
        if(top==maxsize-1){
            System.out.println("Stack is full");
            return;
        }
        data[++top]=item;
    }

    @Override
    public T Pop() {
        T tmp;
        if(IsEmpty()){
            throw new RuntimeException("栈为空，无法删除");
        }
        tmp=data[top];
        top--;
        return tmp;
    }

    @Override
    public T GetTop() {
        T tmp;
        if(IsEmpty()){
            throw new RuntimeException("栈为空，无法删除");
        }
        tmp=data[top];
        return tmp;
    }
}
