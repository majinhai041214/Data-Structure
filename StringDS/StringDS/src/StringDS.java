public class StringDS implements IStringDS{
    public char[]data;
    /*构造函数*/
    public StringDS(char[]arr){
        data=new char[arr.length];
        for(int i=0;i<arr.length;i++){
            data[i]=arr[i];
        }
    }
    /*构造函数*/
    public StringDS(int len){
        data=new char[len];
    }

    @Override
    public int GetLenth() {
        return data.length;
    }

    @Override
    public boolean Compare(StringDS s) {
        int len=((this.GetLenth()<=s.GetLenth()))?this.GetLenth():s.GetLenth();
        int i=0;
        for(i=0;i<len;i++){
            if(this.data[i]!=s.data[i]){
                break;
            }
            if(i==len&&this.GetLenth()==s.GetLenth()){
                return true;
            }else{return false;}
        }
        return false;
    }

    @Override
    public void ClearString() {
        data=null;
    }

    @Override
    public StringDS SubString(int index, int len) {
        if(index+len>this.GetLenth()){
            throw new RuntimeException("参数不合法");
        }
        char[]arr=new char[len];
        for(int i=0;i<len;i++){
            arr[i]=data[index+i];
        }
        return new StringDS(arr);
    }

    /*串连接*/
    @Override
    public StringDS Concat(StringDS s) {
        StringDS s1=new StringDS(this.GetLenth()+s.GetLenth());
        for(int i=0;i<this.GetLenth();i++){
            s1.data[i]=this.data[i];
        }
        for(int i=0;i<s.GetLenth();i++){
            s1.data[i+this.GetLenth()]=s.data[i];
        }
        return s1;
    }

    @Override
    public StringDS Insert(int index, StringDS s) {
        StringDS s1=new StringDS(this.GetLenth()+s.GetLenth());;
        for(int i=0;i<index;i++){
            s1.data[i]=this.data[i];
        }
        for(int i=0;i< s.GetLenth();i++){
            s1.data[i+index]=s.data[i];
        }
        for(int i=index;i<this.GetLenth();i++){
            s1.data[i+s.GetLenth()]=this.data[i];
        }
        return s1;
    }

    @Override
    public StringDS Delete(int index, int len) {
        if(index<0||index>this.GetLenth()-1||len<0||index+len>this.GetLenth(){
            throw new RuntimeException("参数不合法");
        }
        char []arr=new char[this.GetLenth()-len];
        for(int i=0;i<index;i++){
            arr[i]=this.data[i];
        }
        for(int i=index+len;i<this.GetLenth();i++){
            arr[i-len]=this.data[i];
        }
        return new StringDS(arr);
    }

    @Override
    public int Index(StringDS s) {
        if(this.GetLenth()<s.GetLenth()){
            return -1;
        }
        for(int i=0;i<this.GetLenth()-s.GetLenth();i++){
            StringDS s1=this.SubString(i,s.GetLenth());
            if(s1.Compare(s)){
                return i;
            }
        }
        return -1;
    }
}
