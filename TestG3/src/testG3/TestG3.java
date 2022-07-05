package testG3;

class Node
{
	private int data;//�ڵ�����
	private Node next = null;//ָ���һ���ڵ��ָ��
	public Node(int data)
	{
		this.data = data;
	}
	public int getData()
	{
		return data;
	}
	public void setData(int data)
	{
		this.data = data;
	}
	public Node getNext()
	{
		return next;
	}
	public void setNext(Node next)
	{
		this.next = next;
	}
}

class Singlelist
{
	private Node head;//ͷָ��
	public Singlelist(int data[])
	{
		for (int d : data)
		{
			Node node = new Node(d);
	        if (this.head == null)
	        {
	            this.head = node;
	        }
	        else
	        {
	            Node temp = head;
	            while(temp.getNext() != null)//�ҵ����һ���ڵ�
	                temp = temp.getNext();
	            temp.setNext(node);
	        } 
		}
	}
	Node getHead()
	{
		return this.head;
	}
	void setHead(Node node)
	{
		this.head = node;
	}
	void selectionsort()//ѡ������
	{
		if (this.head == null)
            return;
		Node curNode = this.head;
        int temp;//��¼��ǰ����ڵ����Сֵ
        while (curNode != null)
        {
            //��ǰ�ڵ����һ���ڵ�,��ΪҪ�ӵ�ǰ�ڵ�ĺ�һ�ڵ㿪ʼ ѭ��������С��temp�� Ȼ�����λ�ýڵ��val����
            /**
             * 	����ѭ���ӵ�ǰ�ڵ����һ���ڵ�ѭ����β�ڵ㣬
             * 	�ҵ�������ѭ����ֵ�Ƚ���С���Ǹ���Ȼ��������ѭ�����н���
             */
            Node nextNode = curNode.getNext();
            //�� next �ڵ㿪ʼѭ�������� �����ڵ�����С���Ǹ��ڵ�� data
            while (nextNode != null)
            {
                //ÿ��ѭ���� curNode �� data ��Ϊ������Сֵ���бȽ�
                if (curNode.getData() > nextNode.getData())
                {
                    temp = curNode.getData();
                    curNode.setData(nextNode.getData());
                    nextNode.setData(temp);
                }
                nextNode = nextNode.getNext();
            }
            curNode = curNode.getNext();
        }
	}
	public void bubblesort()//ð������
	{
		Node cur = head;
        Node tmp = null;
        while (cur != tmp)
        {
            while (cur.getNext() != tmp)
            {
                if (cur.getData() > cur.getNext().getData())
                {
                    int temp = cur.getData();
                    cur.setData(cur.getNext().getData());
                    cur.getNext().setData(temp);
                }
                cur = cur.getNext();
            }
            tmp = cur;
            cur = head;
        }
	}
	public void printList()//��ӡ������
	{
		Node n = this.head;
		if (n == null)
			return;
		String str = "[" + n.getData();
		for (n = this.head.getNext(); n != null; n = n.getNext())
			str = str + ", " + n.getData();
		str += "]";
		System.out.println(str);
	}
}

public class TestG3
{
	public static void main(String[] args)
	{
		int data[] = {23, 17, 72, 60, 25, 8, 68, 71, 52};
		Singlelist a = new Singlelist(data), b = new Singlelist(data);
		System.out.println("����ǰ��");
		System.out.print("a = ");
		a.printList();
		System.out.print("b = ");
		b.printList();
		System.out.println("\n�����");
		a.selectionsort();
		System.out.print("a = ");
		a.printList();
		b.bubblesort();
		System.out.print("b = ");
		b.printList();
		return;
	}
}