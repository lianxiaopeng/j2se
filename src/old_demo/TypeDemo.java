package old_demo;

public class TypeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    new TypeDemo().testConvert1();
	
	char c = 'a';//char���ı���
	byte b = 'b';
	System.out.println(c);
	System.out.println(b);
		
	}
	
	void testConvert1(){
		int i=1,j=12;
	    float f1=(float)0.1;  //0.1f  ǰ���ǰ�λת��λ  ���߾�����λ
	    float f2=123;
	    long l1 = 12345678,l2=8888888888L;
	    double d1 = 2e20,d2=124;
	    byte b1 = 1,b2 = 2,b3 = 127;
	    j = j+10;
	    i = i/10;
	    float d3 = (float) ((double)1/10);
	    System.out.println(d3);
	    i = (int)(i*0.1);
	    char c1='a',c2=125;
	    byte b = (byte)(b1-b2);
	    char c = (char)(c1+c2-1);
	    float f3 = f1+f2;
	    float f4 = (float)(f1+f2*0.1);
	    double d = d1*i+j;
	    float f = (float)(d1*5+d2);
	}
	void testConvert(){
		
		//����С��ת����������Ͳ������
		 int i1 = 123; 
	        int i2 = 456;
	        double d1 = (i1+i2)*1.2;//ϵͳ��ת��Ϊdouble������
	        float f1 = (float)((i1+i2)*1.2);//��Ҫ��ǿ��ת����
	        byte b1 = 'a'; 
	        byte b2 = 89;
	        byte b3 = (byte)(b1+b2);//ϵͳ��ת��Ϊint�����㣬��
	                                //Ҫǿ��ת����
	      
	        System.out.println(b3);
	        double d2 = 1e200;
	        float f2 = (float)d2;//��������
	        System.out.println(f2);

	        float f3 = 1.23f;//�����f
	        long l1 = 123;
	        long l2 = 30000000000l;//�����l
	        float f = l1+l2+f3;//ϵͳ��ת��Ϊfloat�ͼ���
	        long l = (long)f;//ǿ��ת������ȥС�����֣������������룩
	}

}
