package prog;

import java.util.*;	//����List�๤�߰�
public class Prog {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();  //����list1
		List<String> list2 = new ArrayList<String>();  //����list2
		String alphabet ="a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";  
		for(String t : alphabet.split(","))//��Ӣ�Ķ�����Ϊ�ָ�
		        list1.add(t);//��26����ĸ��ŵ�list1����  
		System.out.println(list1);//��ʾlist1
		int i = 0;//Ҫɾ����ǰԪ�ص�λ��
		while (!list1.isEmpty())
		{
			i = (i + 4) % list1.size(); 	
			list2.add(list1.get(i));
			list1.remove(i);//ɾ��Ԫ��
			System.out.println(list2);//��ʾÿ�μ�����ĸ��list2�ı仯
		}
		return;
	}
}