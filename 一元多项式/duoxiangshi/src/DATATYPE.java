import java.util.Date;

public class DATATYPE {
    public float coef;//系数域
    public int expn;//指数域
    //两个参数的构造函数
    public DATATYPE(float val1,int val2){
        coef=val1;
        expn=val2;
    }
    //无参构造
    public DATATYPE(){
        coef=0;
        expn=0;
    }
}
