interface IListDS<T> {
    int Count();//求长度操作
    void Clear();//清空操作
    boolean IsEmpty();//判断线性表是否为空操作
    void Append(T item);//附加操作
    void Insert(T item,int i);//插入操作
    T Delete(int i);//删除操作
    T GetElem(int i);//取表元操作
    int Locate(T item);//按值查找操作

}
