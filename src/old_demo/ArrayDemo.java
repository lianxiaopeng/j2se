package old_demo;

import java.util.Arrays;

public class ArrayDemo {
	/*
	 * ���鿽��
	 * */
	public static void copyBlockArray(){
		//�����������ڴ��еĳɿ���ڣ������鿽�����ݽϴ�ʱ�����Բ���System���arraycopy����
		Integer[] src = {1,2,3,4,5,6,7,8,9,0};
		Integer[] dest = new Integer[20];
		System.arraycopy(src, 0, dest, 0, 5);
		System.out.println(Arrays.toString(dest));

	}
	public static Double[][]parseDouble(String str){
			
			
			Double[][] dArray =null;
			
			String[] str1 = str.split(";");
			
			dArray = new Double[str1.length][];
			for (int i = 0; i < str1.length; i++) {
				String[] str2 = str1[i].split(",");
				dArray[i] = new Double[str2.length];
				for(int j=0;j<str2.length;j++){
					dArray[i][j] = Double.valueOf(str2[j]);
				}
					
				
				
			}
			return dArray;
			
			
			
			
			
		}

	public static void main(String[] args) {
		copyBlockArray();
		
		 //������1,2;3,4;5,6;7,8;��,��double���ͷ����ڶ�ά������
		  
		  String str = "1,2;3,4;5,6;7,8;";
		  Double[][] dArray = parseDouble(str);
		  
		  for(int i=0;i<dArray.length;i++){
			  for(int j=0;j<dArray[i].length;j++){
				  
				  System.out.println(dArray[i][j]);
			  }
		  }
	}
}
