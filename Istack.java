/*用接口表示栈的抽象数据类型*/
interface Istack<T> {
    int Count();//求栈的长度
    boolean IsEmpty();//判断栈是否为空
    void Clear();//清空操作
    void Push(T item);//入栈操作
    T Pop();//出栈操作
    T GetTop();//取栈顶元素
}
