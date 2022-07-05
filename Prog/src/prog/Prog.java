package prog;

import java.util.*;	//引入List类工具包
public class Prog {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();  //建立list1
		List<String> list2 = new ArrayList<String>();  //建立list2
		String alphabet ="a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";  
		for(String t : alphabet.split(","))//以英文逗号作为分割
		        list1.add(t);//将26个字母存放到list1里面  
		System.out.println(list1);//显示list1
		int i = 0;//要删除当前元素的位置
		while (!list1.isEmpty())
		{
			i = (i + 4) % list1.size(); 	
			list2.add(list1.get(i));
			list1.remove(i);//删除元素
			System.out.println(list2);//显示每次加入字母后list2的变化
		}
		return;
	}
}