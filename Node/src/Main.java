//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        LinkList<Integer>list=new LinkList<Integer>();
//        Integer intValue1 = Integer.valueOf(10);
//        list.Append(intValue1);
//        Integer intValue2 = Integer.valueOf(20);
//        list.Append(intValue2);
//        Integer intValue3 = Integer.valueOf(30);
//        list.Insert(2,intValue3);
//        System.out.println(list);
//        System.out.println(list.Count());
//        //System.out.println(list.Delete(2));
//        System.out.println(list);
//        System.out.println(list.getElem(2));
//        System.out.println(list.Locate(20));
//        list.Reverce();
//        System.out.println(list);

        LinkList<Integer>Ha=new LinkList<Integer>();
        LinkList<Integer>Hb=new LinkList<Integer>();
        Integer a=Integer.valueOf(10);
        Integer b=Integer.valueOf(20);
        Integer c=Integer.valueOf(30);
        Integer d=Integer.valueOf(30);
        Integer e=Integer.valueOf(50);


        Ha.Append(a);
        Ha.Append(c);
        Hb.Append(b);
        Hb.Append(d);
        Hb.Append(e);


        LinkList<Integer>Hc=new LinkList<Integer>();
        Hc=LinkList.Merge(Ha,Hb);
        System.out.println(Hc);
    }
}