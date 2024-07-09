public class LinkList<T>{
    public Node<T>head;
    //单链表的头引用，根据结点的头引用就可以沿地址连后移，从而确定线性表的所有数据元素
    public LinkList(){
        head=new Node<T>();
        //头结点的数据域等于T类型的默认值，引用域为空
    }

    /*求单链表长度*/
    public int Count(){
        Node<T>p=head;
        int len=0;
        while(p!=null){
            ++len;
            p=p.next;
        }
        return len-1;//不算头结点的数量
    }

    /*清空操作*/
    public void Clear(){
        head.next=null;
    }

    /*判断单链表是否为空*/
    public boolean IsEmpty(){
        return head.next==null;
    }

    /*附加操作*/
    /*在单链表的末端添加一个新的结点*/
    public void Append(T item){
        Node<T>p=new Node<>();
        p=head;
        Node<T>q=new Node<>(item);
        while(p.next!=null){
            p=p.next;
        }
        p.next=q;
    }

    /*插入操作*/
    public void Insert(int i,T item){
        Node<T>p=head;
        Node<T>q=new Node<>(item);
        for(int j=1;j<i;j++){
            p=p.next;
        }
        q.next=p.next;
        p.next=q;
    }

    /*删除操作*/
    public T Delete(int i){
        Node p=head;
        Node r=new Node();
        int j=1;
        while(j<=i){
            r=p;
            p=p.next;
            j++;
        }
        r.next=p.next;
        //这步操作完成后r指向第i-1个结点，p指向第i个结点
        return (T)p.data;
    }

    /*取表元操作*/
    public T getElem(int i){
        Node p=head;
        for(int j=0;j<i;j++){
            p=p.next;
        }
        return (T)p.data;
    }

    /*按值查找操作*/
    public int Locate(T item){
        int i=0;
        Node p=head;
        for(i=0;i<Count();i++){
            if(p.data==item){
                break;
            }else{
                p=p.next;
            }
        }
        if(i<=Count()){
            return i;
        }else{return -1;}
    }

    /*单链表的复杂操作*/
    /*单链表的倒置*/
//    public LinkList Reverce(){
//        LinkList<T>r=new LinkList<>();
//        Node q;
//        Node p=head.next;
//        int j=1;
//        for(j=1;j<=Count();j++){
//            q=new Node(p.data);
//            p=p.next;
//            r.Insert(1,(T)q.data);
//        }
//        return r;
//    }

    public void Reverce(){
        Node<T>p=head.next;
        Node<T>q=new Node<T>();
        head.next=null;
        while(p!=null){
            q=p;
            p=p.next;
            q.next=head.next;
            head.next=q;
        }
    }

//????????????????????????????????????
//    public void Reverce(){
//        Node p=head.next;
//        Node q;
//        int j=1;
//        for(j=1;j<Count();j++){
//            p.next.next=p;
//            p=p.next;
//        }
//        head.next=p;
//    }

    /*合并升序排列两链表*/
    public static LinkList<Integer>Merge(LinkList<Integer>Ha,LinkList<Integer>Hb){
        LinkList<Integer>Hc=new LinkList<Integer>();
        int i=0;
        int j=0;
        Node<Integer>p= Ha.head.next;
        Node<Integer>q=Hb.head.next;
        while(i<Ha.Count()&&j<Hb.Count()){
            if(p.data<q.data){
                Hc.Append(p.data);
                p=p.next;
                i++;
            } else if (p.data==q.data) {
                Hc.Append(p.data);
                p=p.next;
                q=q.next;
                i++;
                j++;
            }else{
                Hc.Append(q.data);
                q=q.next;
                j++;
            }
        }
        while(i<Ha.Count()||j<Hb.Count()){
            if(i<Ha.Count()){
                Hc.Append(p.data);
                p=p.next;
                i++;
            }
            if(j<Hb.Count()){
                Hc.Append(q.data);
                q=q.next;
                j++;
            }
        }
        return Hc;
    }

    /*toString方法*/
    public String toString(){
        String str="(";
        Node<T>p=head.next;
        if(p!=null){
            str+=p.data;
            p=p.next;
        }
        while(p!=null){
            str=str+","+p.data;
            p=p.next;
        }
        str=str+")";
        return str;
    }
}
