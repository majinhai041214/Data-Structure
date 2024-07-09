public class 一元多项式 {
    /*多项式加法*/
    static LinkList<DATATYPE>addpoly(LinkList<DATATYPE>La,LinkList<DATATYPE>Lb){
        if(La==null||La.head.next==null){
            return Lb;
        }
        if(Lb==null||Lb.head.next==null){
            return La;
        }
        DATATYPE data1=new DATATYPE();
        //调用无参构造函数建立对象data1：系数为0，指数为0
        Node<DATATYPE>pa=new Node<DATATYPE>(data1);
        Node<DATATYPE>pb=new Node<>(data1);
        Node<DATATYPE>pc=new Node<>(data1);
        DATATYPE data2;
        Node<DATATYPE>pd;

        //建立Node<DATATYPE>pc
        LinkList<DATATYPE>Lc=new LinkList<DATATYPE>();
        pc=Lc.head;//pc指向Lc的头结点

        pa=La.head.next;//pa指向La的第一个结点
        pb=Lb.head.next;//pb指向Lb的第一个结点

        int a,b;
        float x;
        while(pa!=null&&pb!=null){
            a=pa.data.expn;//a为当前结点指数
            b=pb.data.expn;//b为当前结点指数
            if(a<b){
                data2=new DATATYPE(pa.data.coef,pa.data.expn);
                pd=new Node<DATATYPE>(data2);
                pc.next=pd;
                pc=pc.next;//和多项式往前走一步
                pa=pa.next;//pa往前走一步
            } else if (a==b) {
                x=pa.data.coef+pb.data.coef;//指数相等，系数相加
                pb=pb.next;//pb往前走一步
                if(x!=0){
                    data2=new DATATYPE(x,pa.data.expn);
                    pd=new Node<DATATYPE>(data2);
                    pc.next=pd;
                    pc=pc.next;//新建一个结点，并插入和链表中
                    pa=pa.next;//pa往前走一步
                }
            }else{
                data2=new DATATYPE(pb.data.coef,pb.data.expn);
                pd=new Node<DATATYPE>(data2);
                pc.next=pd;
                pc=pc.next;
                pb=pb.next;
            }
            if(pa!=null){
                pc.next=pa;//若La还没有处理完
            }
            if(pb!=null){
                pc.next=pb;//若LB还没有处理完
            }
        }
        return Lc;
    }


    /*输出多项式*/
    static String GetString(LinkList<DATATYPE>L){
        String a="";
        //判断链表是否为空
        if(L.head.next==null){
            a="多项式为空";
        }
        else{
            Node<DATATYPE>p=L.head.next;//p指向第一结点
            int i=1;
            while(p!=null){
                if(i==1){
                    a=a+p.data.coef+"X^"+p.data.expn;
                } else if (p.data.coef>0) {
                    a=a+"+"+p.data.coef+"X^"+p.data.expn;
                }else{
                    a=a+p.data.coef+"X^"+p.data.expn;
                }
                p=p.next;
                i++;
            }
        }
        return a;
    }
}
