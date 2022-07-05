package testH3;

class BTNode
{
	private char data;//节点数据
	private BTNode left, right;//左右指针
	public BTNode()
	{
		this.data = '0';
		this.left = null;
		this.right = null;
	}
	public BTNode(char data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public char getData()
	{
		return data;
	}
	public void setData(char data)
	{
		this.data = data;
	}
	public BTNode getLeft()
	{
		return left;
	}
	public void setLeft(BTNode left)
	{
		this.left = left;
	}
	public BTNode getRight()
	{
		return right;
	}
	public void setRight(BTNode right)
	{
		this.right = right;
	}	
}

class BTree//二叉树
{
	private BTNode root;
	public BTNode getRoot()
	{
		return root;
	}
	public void setRoot(BTNode root)
	{
		this.root = root;
	}
	public BTNode buildBinaryTree(String pre, int startPre, int endPre, String in, int startIn, int endIn)
	{
        if (startPre > endPre || startIn > endIn)
            return null;
        BTNode node = new BTNode(pre.charAt(startPre));
        for (int i = startIn; i <= endIn; ++i)
            if (in.charAt(i) == pre.charAt(startPre))
            {
                node.setLeft(buildBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1));
                node.setRight(buildBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn));
                break;
            }
        return node;
    }
	BTree(String preOrder, String inOrderStr)
	{
		if (preOrder.length() <= 0 || inOrderStr.length() <= 0 || preOrder.length() != inOrderStr.length())
			this.root = null;
		else
			this.root = buildBinaryTree(preOrder, 0, preOrder.length() - 1, inOrderStr, 0, inOrderStr.length() - 1);
	}
	public void preOrderTraverse(BTNode node)
	{
        if (node != null)
        {
            System.out.print("->" + node.getData());
            preOrderTraverse(node.getLeft());
            preOrderTraverse(node.getRight());
        }
    }
	void preOrder()//先序遍历
	{
        System.out.print("root");
        preOrderTraverse(this.root);
        System.out.println("");
	}
	public void inOrderTraverse(BTNode node)
	{
        if (node != null)
        {
            inOrderTraverse(node.getLeft());
            System.out.print("->" + node.getData());
            inOrderTraverse(node.getRight());
        }
    }
	void inOrder()//中序遍历
	{
		System.out.print("root");
		inOrderTraverse(this.root);
        System.out.println("");
	}
	public void postOrderTraverse(BTNode node)
	{
        if (node != null)
        {
            postOrderTraverse(node.getLeft());
            postOrderTraverse(node.getRight());
            System.out.print("->" + node.getData());
        }
    }
	void postOrder()//后序遍历
	{
        System.out.print("root");
        postOrderTraverse(this.root);
        System.out.println("");
	}
}


public class TestH3
{
	public static void main(String[] args)
	{
		BTree tree = new BTree("ABCDEFG", "BDACFGE");
		System.out.print("先序遍历：");
		tree.preOrder();
		System.out.print("中序遍历：");
		tree.inOrder();
		System.out.print("后序遍历：");
		tree.postOrder();
		return;
	}
}