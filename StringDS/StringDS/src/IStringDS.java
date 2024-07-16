public interface IStringDS {
    public int GetLenth();//求串的长度
    public boolean Compare(StringDS s);//比较串是否相等
    public void ClearString();//清空串
    public String SubString(int index,int len);//求子串
    public StringDS Concat(StringDS s);//串连接
    public StringDS Insert(int index,StringDS s);//串插入
    public StringDS Delete(int index,int len);//串删除
    public int Index(StringDS s);//串定位

}
