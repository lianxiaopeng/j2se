package old_demo;
/*
 * ���ֳ����㷨Java����ʵ��
 * */
public class SortDemo {
	
	public void selectSort(int[] array){
		//ѡ������(ÿ��Ѱ�Ҵ�������Сֵ��Ȼ������������ĩβ)
				/*for(int i=0;i<array.length;i++){
					for(int j=i;j<array.length;j++){
						if(array[j]<array[i]){
							int temp = array[j];
							array[j] = array[i];
							array[i] = temp;					
						}
					}
				}*/
		for(int i=0;i<array.length;i++){
			int min = i;
			for(int j=i;j<array.length;j++){
				if(array[j]<array[min]){
					
					min = j;
								
				}
			
			}
			
			if(min!=i){
				int temp = array[min];
				array[min] = array[i];
				array[i] = temp;	
			}
		}
	}
	public void insertSort(int[] array){
		//��������(����i�Σ�ÿ�ζ�ʹi֮ǰ�����ź���Ȼ��δ����Ĳ嵽�ź�����)
		
		for(int i=1;i<array.length;i++){
			for(int j=i;j>0;j--){
				if(array[j]<array[j-1]){
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;					
				}
				//else break;
			}
		}
		
	}
	public void bubbleSort(int[] array){
		//ð��(����i�Σ��Ӻ���ǰ�����������Ƚϣ����谴�������У�ǰ�ߴ��ں��ߣ�����������)
		for(int i=1;i<array.length;i++){
			for(int j=array.length-1;j>=i;j--){
				if(array[j-1]>array[j]){
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
		
		
	}
	public void fastSort(int[] array,int min,int max){
		//��������(ð�ݷ��ĸĽ�) ��ʵ�ֲ���������ߵ�����С���ұߵ��������ϵݹ�
		
		if(max>min){
			int mid = part(array,min,max);
			
			fastSort(array,min,mid-1);
		
	   
			fastSort(array,mid+1,max);
			
		}
	

	  
		
		
		
	}
	public int part(int[] array,int min,int max){
		//1.�ȱ�������һ������Ϊ�ο���
		//2.ȡi,j��������ѭ��i��ÿ��ȡ�����Ͳο����Ƚϣ���С�ڲο������򽻻�i��Ӧ������j��Ӧ���������ҽ�j�ƶ�1λ��
		//3.���ѭ�����������ο�����j��Ӧ������������������j
		int temp = array[max];
		int j=min;
		for(int i=min;i<max;i++){
			if(array[i]<temp){
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
				j++;
				
			}
		}
		int t = array[j];
		array[j] = temp;
		array[max] = t;
		
		return j;
	}
	
	public static void main(String[] args) {
		//����������
		int[] array = {2,5,1,6,3,8,7,4};
		System.out.println("����ǰ��");
		for(int value:array){
			System.out.print(value);
		}
		System.out.println();
		//ֱ������
		//new SortDemo01().selectSort(array);
		//��������
		//new SortDemo01().insertSort(array);
		//ð������
		//new SortDemo01().bubbleSort(array);

		//��������
		new SortDemo().fastSort(array,0,7);

		System.out.println("�����");
		for(int value:array){
			System.out.print(value);
		}
		
		
		
		
		
	}

}
