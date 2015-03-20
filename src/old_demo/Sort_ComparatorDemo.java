package old_demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.naming.ldap.SortControl;
import javax.swing.text.html.MinimalHTMLWriter;
/*
 * 实现comparator接口排序
 * 
 * */

public class Sort_ComparatorDemo implements Comparable{

	public Sort_ComparatorDemo() {
		// TODO Auto-generated constructor stub

		
	}
	public void Test3(){
		
		
		
	}
	public static void sort(String[] array,Comparator comparator){
		
		for(int i = 0 ;i<array.length;i++){
			int min = i;
			for(int j = i ;j<array.length;j++){
				if(comparator.compare(array[min], array[j])<0){
					min = j;
				}
				
			}
			if(min!=i){
				
				String temp = array[min];
				array[min] = array[i];
				array[i] = temp;
				
				
			}
		}
	}
	public static void selectSort(String[] array,Comparator<String> comparator){
		
		//选择排序
		//每次选取待排序中最小值（最大值），放在已排好序末尾
		for (int i = 0; i < array.length; i++) {
			int min = i;
			for (int j = i ;j<array.length;j++){
				if(comparator.compare(array[j], array[min])<0){
					min = j;
				}
				
			}
			if(min!=i){
				String tmp = array[min];
				array[min] = array[i];
				array[i] = tmp;
			}
		}
		
	}
	
	public static void insertSort(String[] array,Comparator<String> comparator){
		//插入排序 :将待排序列中插到已排好序当中
		for (int i = 1; i < array.length; i++) {
			for(int j = i;j>0;j--){
				if(comparator.compare(array[j], array[j-1])<0){
					String tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
				}else {
					break;
				}
			}
		}
		
	}
	
	public static void bubbleSort(String[] array , Comparator<String> comparator){
		//冒泡排序 ：序列中两两比较，后者小于前者交换，放在已排好序末尾
		for (int i = 0; i < array.length; i++) {
			for(int j = array.length - 1;j>i;j--){
				if(comparator.compare(array[j], array[j-1])<0){
					String tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
				}
			}
		}
		
	}
	public static void fastSort(String[] array , Comparator<String> comparator){
		
		//快速排序 : 
	
		part(array,0,array.length-1,comparator);
		
	}
	public static void part(String[] array , int min , int max, Comparator<String> comparator){
		
		int j = min ;
		String  index  = array [max];
		
		for (int i = min; i < max; i++) {
			if(comparator.compare(array[i], index)<0){
				String tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
				j++;
			}
			
		}
		String tmp = array [max];
		array[max] = array[j];		
		array[j] = tmp;

		int mid = j;
		
		if(min<mid-1)
		part(array,min,mid-1,comparator);
			
			
        if(mid+1<max)
		part(array,mid+1,max,comparator);
		
		
		
		
	}
	
	public static void main(String[] args) {
		//System.out.println("1111");

		
		String[] array = new String[]{"1","b","B","0","S","a","2","3","c","h","9"};
		
		
		
		/*fastSort(array, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});*/
		//实现Comparator修改String类的比较方式，由于String是final类型，不能用
		//comparable在这里是没法用的，除非是我们自定义类。
		Arrays.sort(array, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		
		System.out.println(Arrays.toString(array));
		
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
