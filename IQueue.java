interface IQueue<T>{
    int Count();//求队列的长度
    boolean IsEmpty();//判断队列是否为空
    void Clear();//清空操作
    void In(T item);//入队列操作
    T out();//出队列操作
    T GetFront();//取表头操作
}
