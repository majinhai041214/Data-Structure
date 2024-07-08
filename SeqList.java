public class SeqList<T> implements IListDS{
    /*顺序表类的实现*/
    /*i的取值范围是【1，n】*/
    /*当线性表不为空的时候，last的取值范围是【0，n-1】*/
    public T []data;//数组，用于存储数据元素
    public int maxsize;//容量
    public int last;//指示最后一个元素在数组中的位置（当last的值为-1时，表示线性表为空表）

    public SeqList(int size){
        if(size>0){
            data=(T[])new Object[size];//建立一个长度为size，类型为T的数组
            this.maxsize=size;//顺序表的容量maxsize=size
            last=-1;//最后一个元素位置last为-1，表示顺序表为空表
        }else{
            throw new RuntimeException("初始化容量必须大于0");
        }
    }

    @Override
    public int Count() {
        return last+1;
    }

    @Override
    public void Clear() {
        last=-1;
    }

    @Override
    public boolean IsEmpty() {
        return last==-1;
    }

    @Override
    public void Append(Object item) {
        if(last==maxsize-1){
            throw new RuntimeException("线性表已满，无法附加");
        }else{
            data[++last]=(T)item;
        }
    }

    @Override
    public void Insert(Object item,int i) {
        //判断表是否已满
        if(IsEmpty()){
            throw new RuntimeException("表已满，无法插入");
        }
        //判断插入位置是否正确
        if(i<1||i>last+2){
            throw new RuntimeException("位置不正确，无法插入");
        }
        //元素移动
        for(int j=last;j>=i-1;j--){
            data[j+1]=data[j];
        }
        //将新的数据元素插入到第i个位置
        data[i-1]=(T)item;
        //修改表长
        last++;
    }

    @Override
    public Object Delete(int i) {
        T tmp;
        //判断表是否为空
        if(IsEmpty()){
            throw new RuntimeException("线性表为空，无法删除");
        }
        //判断删除的位置是否正确
        if(i<1||i>last+1){
            throw new RuntimeException("无效下标"+i);
        }
        //tmp的值等于第i个数据元素
        tmp=data[i-1];
        //元素移动
        for(int j=last;j>i-1;j--){
            data[j-1]=data[j];
        }
        last--;
        return tmp;
    }

    @Override
    public Object GetElem(int i) {
        //判断表是否为空以及位置是否正确
        if(IsEmpty()){
            throw new RuntimeException("线性表为空，无法获取元素");
        }
        //判断位置是否正确
        if(i<0||i>last+1){
            throw new RuntimeException("无效的下标"+i);
        }
        return data[i-1];
    }

    /*按值查找*/
    /*若查找成功，返回线性表中首次出现该数据元素的序号，若表中没有与给定值匹配的数据元素，则返回-1*/
    @Override
    public int Locate(Object item) {

        //表为空
        if(IsEmpty()){
            return -1;
        }
        int i=0;
        for(i=0;i<last;i++){
            if(data[i]==(T)item){
                break;
            }
        }
        if(i>last){
            return -1;
        }else{return i+1;}
    }

    /*顺序表的复杂操作*/
    /*顺序表的倒置*/
    public void Reverse(){
        T tmp;
        for(int i=0;i<last/2;i++){
            tmp=data[i];
            data[i]=data[last-i];
            data[last-i]=tmp;
        }
    }
    /*合并升序排列*/
    public static SeqList<Long>Merge(SeqList<Long>La,SeqList<Long>Lb){
        SeqList<Long>Lc=new SeqList<>(La.Count()+Lb.Count());
        int i=0;
        int j=0;
        while(i<La.Count()&&j<Lb.Count()){
            if(La.data[i]<Lb.data[j]){
                Lc.Append(La.data[i++]);
            }
            if(La.data[i]==Lb.data[j]){
                Lc.Append(La.data[i]);
                j++;
            }
            else{
                Lc.Append(Lb.data[j++]);
            }
        }
        while(La.Count()>i){
            Lc.Append(La.data[i++]);
        }
        while(Lb.Count()>j){
            Lc.Append(Lb.data[j++]);
        }
        return Lc;
    }

    public String toString(){
        String str="(";
        if(Count()>0){
            str=str+data[0];
            for(int i=1;i<=last;i++){
                str=str+","+data[i];
            }
        }
        str=str+")";
        return str;
    }
}
