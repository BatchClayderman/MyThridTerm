package testG3;

class Node
{
	private int data;//节点数据
	private Node next = null;//指向后一个节点的指针
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
	private Node head;//头指针
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
	            while(temp.getNext() != null)//找到最后一个节点
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
	void selectionsort()//选择排序
	{
		if (this.head == null)
            return;
		Node curNode = this.head;
        int temp;//记录当前链表节点的最小值
        while (curNode != null)
        {
            //当前节点的下一个节点,因为要从当前节点的后一节点开始 循环遍历出小于temp的 然后和首位置节点的val交换
            /**
             * 	内重循环从当前节点的下一个节点循环到尾节点，
             * 	找到和外重循环的值比较最小的那个，然后与外重循环进行交换
             */
            Node nextNode = curNode.getNext();
            //从 next 节点开始循环遍历出 后续节点中最小的那个节点的 data
            while (nextNode != null)
            {
                //每次循环以 curNode 的 data 作为链表最小值进行比较
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
	public void bubblesort()//冒泡排序
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
	public void printList()//打印单链表
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
		System.out.println("排序前：");
		System.out.print("a = ");
		a.printList();
		System.out.print("b = ");
		b.printList();
		System.out.println("\n排序后：");
		a.selectionsort();
		System.out.print("a = ");
		a.printList();
		b.bubblesort();
		System.out.print("b = ");
		b.printList();
		return;
	}
}