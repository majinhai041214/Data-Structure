import java.io.IOException;
import java.util.Scanner;

public class 进制转换 {
    /*八进制转十进制*/
    public static void OtoD() throws IOException{
        System.out.println("请输入八进制数，按Enter键结束");
        char c;
        int n=0;
        int dec=0,i=0;
        SeqStack<Integer>s=new SeqStack<Integer>(15);
        while((c=(char)System.in.read())!='\n'){
            s.Push(c-'0');
        }
        while(!s.IsEmpty()){
            n=s.Pop();
            dec=dec+n*(int)Math.pow(8,i);
            i++;
        }
        System.out.println("转换的十进制数是："+dec);
    }

    /*八进制转换为十进制*/
    public static void DtoO(){
        int n;
        System.out.println("请输入要转换的十进制数：");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        SeqStack<Integer>s=new SeqStack<>(15);
        while(n>0){
            s.Push(n%8);
            n=n/8;
        }
        System.out.println("转换的八进制数是：");
        while(!s.IsEmpty()){
            n=n*10+s.Pop();
        }
        System.out.println(n);
        sc.close();
    }
}
