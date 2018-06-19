public class BinaryTree 
{
    Node root;
 
    private Node addRecursive(Node current, int value) {
		if (current == null) {
		    return new Node(value);
		}
	 
		if (value < current.value)
		{
		    current.left = addRecursive(current.left, value);
		} 
		else if (value > current.value) 
		{
		    current.right = addRecursive(current.right, value);
		} 
		else 
		{
		    // value already exists
		    return current;
		}
	 
		return current;
	}

	public void add(int value) 
	{
    	root = addRecursive(root, value);
	}

	public void inOrder() 
	{
		inOrderRecursive(root);
	}

	public void inOrderRecursive(Node node) 
	{
		if (node != null) {
		    inOrderRecursive(node.left);
		    System.out.print(" " + node.value);
		    inOrderRecursive(node.right);
		}
	}

	public void preOrder() 
	{
		preOrderRecursive(root);
	}

	public void preOrderRecursive(Node node) 
	{
		if (node != null) {
		    System.out.print(" " + node.value);
		    preOrderRecursive(node.left);
		    preOrderRecursive(node.right);
		}
	}

	public void postOrder() 
	{
		postOrderRecursive(root);
	}

	public void postOrderRecursive(Node node) {
		if (node != null) {
		    postOrderRecursive(node.left);
		    postOrderRecursive(node.right);
		    System.out.print(" " + node.value);
		}
	}
}


