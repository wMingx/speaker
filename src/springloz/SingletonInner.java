package springloz;

public class SingletonInner {
	/** 
     * �ڲ���ʵ�ֵ���ģʽ 
     * �ӳټ��أ������ڴ濪�� 
     *  
     * 
     *  
     */  
    private static class SingletonHolder {  
        private static SingletonInner instance = new SingletonInner();  
    }  
  
    /** 
     * ˽�еĹ��캯�� 
     */  
    private SingletonInner() {  
  
    }  
  
    public static SingletonInner getInstance() {  
        return SingletonHolder.instance;  
    }  
    public PushMessage pushMessage=new PushMessage("0","0");
   
 
    public void method() {  
     //   System.out.println("SingletonInner");  
    }  
}
