//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SeqList list=new SeqList<Integer>(5);
        int i=8;
        list.Append(i);
        String str="nihao";
        list.Append(str);
        char c='c';
        double d=3.145;
        list.Insert(d,1);
        list.Append(c);
        System.out.println(list);
        SeqList seq=new SeqList(2);
        int m=9;
        seq.Append(m);
        list.Append(seq);
        System.out.println(list);
        list.Delete(5);
        System.out.println(list);
        list.Reverse();
        System.out.println(list);

    }
}