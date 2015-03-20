package old_demo;
/*
 * 四种常见算法Java代码实现
 * */
public class SortDemo {
	
	public void selectSort(int[] array){
		//选择排序(每次寻找待序列最小值，然后放在左边序列末尾)
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
		//插入排序(遍历i次，每次都使i之前的数排好序，然后未排序的插到排好序当中)
		
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
		//冒泡(遍历i次，从后往前，想邻两两比较，假设按升序排列，前者大于后者，则两两交换)
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
		//快速排序(冒泡法的改进) 先实现部分有序，左边的数都小于右边的数，不断递归
		
		if(max>min){
			int mid = part(array,min,max);
			
			fastSort(array,min,mid-1);
		
	   
			fastSort(array,mid+1,max);
			
		}
	

	  
		
		
		
	}
	public int part(int[] array,int min,int max){
		//1.先保存其中一个数作为参考数
		//2.取i,j两变量，循环i，每次取得数和参考数比较，若小于参考数，则交换i对应的数和j对应的数，并且将j移动1位。
		//3.最后循环结束，将参考数和j对应的数作交换，并返回j
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
		//待排序数组
		int[] array = {2,5,1,6,3,8,7,4};
		System.out.println("排序前：");
		for(int value:array){
			System.out.print(value);
		}
		System.out.println();
		//直接排序
		//new SortDemo01().selectSort(array);
		//插入排序
		//new SortDemo01().insertSort(array);
		//冒泡排序
		//new SortDemo01().bubbleSort(array);

		//快速排序
		new SortDemo().fastSort(array,0,7);

		System.out.println("排序后：");
		for(int value:array){
			System.out.print(value);
		}
		
		
		
		
		
	}

}
