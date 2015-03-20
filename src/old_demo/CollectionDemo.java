package old_demo;


import java.util.Collection;


import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;


/*
 * 1136
 * 
 * 
 * 1��ͼ 
 * 1����
 * 3������
 * 6���ӿ�
 * 
 * ʵ��comparable��comparator�����ӿڶ����ԱȽϴ�С��
 * �������ڣ�ǰ��Ĭ���ǵ���compareTo�����Ƚ�
 * �����ǲ���ģʽ���������ͼ�String���Դ��ⲿ�����µıȽϲ��ԣ�Ȩ�޸��󣬵���compare������
 * 
 * 
 * */
public class CollectionDemo {
	
	
	/*
	 * ʲôʱ���õ�hashCode
	 * ������Ϊ��ֵ�Եļ�ֵʱ��������ȡ���������ID������Ч��̫�ͣ��������ֱ���ö����������������Ч�ʡ�
	 * */
	public static void main(String[] args) {
		//test01();
		
		
		test02();
		
		
		//test03();
		
		//test04();
		
		//test05();
		
		
	}

	public static void test05() {
		Map m1 = new HashMap();
		Map m2 = new TreeMap();
		m1.put("one", 1);
		int  ii = (Integer)m1.put("one", 1);
		System.out.println(ii);
		m1.put("two", 2);
		m1.put("three", 3);
		m2.put("a", 4);
		m2.put("b", 5);
		System.out.println(m1.containsKey("one"));
		System.out.println(m1.containsKey("four"));
		System.out.println(m1.containsValue(3));
		System.out.println(m1.containsValue(4));
		
		int i = (Integer)m1.get("one");
		System.out.println(i);
		
		Map m3 = new TreeMap(m2);
		m3.putAll(m1);
		System.out.println(m3);
	}

	public static void test04() {
		List l1 = new LinkedList();
		l1.add(0,new Name("xiaopeng","lian"));
		l1.add(1,new Name("kuncai","xu"));
		l1.add(2,new Name("yan","lee"));
		l1.add(3,new Name("zengyu","chen"));
		l1.add(4,new Name("dapeng","lian"));
		System.out.println("����ǰ");
		 System.out.println(l1);
		Collections.sort(l1);
		System.out.println("�����");
	    System.out.println(l1);
	    Collections.reverse(l1);
	    System.out.println(l1);
	    Collections.shuffle(l1);
	    System.out.println(l1);
	}

	public static void test03() {
		List l1 = new LinkedList();
		for (int i = 0; i < 9; i++) {
			l1.add("a"+i);
		}
		Collections.shuffle(l1);
		Collections.reverse(l1);
		Collections.sort(l1);
		System.out.println(Collections.binarySearch(l1, "a4"));
		List l2 = new LinkedList();
		//���밴˳�����
		l2.add(0,"a0");
		l2.add(1, "a2");
		l2.add(2,"a1");
		l2.add(1, "a2");
		String str = (String) l2.set(0, "a3");
		System.out.println(str);
		
		System.out.println(l2);
	}

	public static void test02() {
		Set s1 = new HashSet();
		Set s2 = new HashSet();
		
		s1.add("a");s1.add("b");s1.add("c");
		s2.add("a");s2.add("b");s2.add("d");
		Set sn = new HashSet(s1);
		//������Ϊ���췽���������ڲ�ֻ�Ǹ�ֵ��������
		s1.removeAll( new HashSet());
		System.out.println("delete:"+sn);
		sn.retainAll(s2);
		System.out.println(sn);
		Set sm = new HashSet(s1);
		sm.addAll(s2);
		System.out.println(sm);
	}

	public static void test01() {
		Collection  c = new HashSet();
		c.add("hello");
		c.add(new Name("f1","l1"));
		c.add(new Name("f1","l1"));
		c.add(new Integer(100));
		c.remove("hello");
		System.out.println(c);
		c.remove(100);
		
		System.out.println(c.remove(new Name("f1","l1")));
		System.out.println(c);
	}

}

class Name implements Comparable<Name>{
	
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return 1;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	@Override
	public int compareTo(Name o) {
		// TODO Auto-generated method stub
		int num = lastName.compareTo(o.getLastName());
		
		return num!=0?num:firstName.compareTo(o.getFirstName());
	}
	
}
