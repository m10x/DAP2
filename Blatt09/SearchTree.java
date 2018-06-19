public class SearchTree
{
	BinaryTree baum = new BinaryTree();	

	public SearchTree (int[] array)
	{
		for (int i = 0; i < array.length; i++)
			baum.add(array[i]);
	}

	public void traversiere()
	{
		System.out.print("\nPreOrder: ");
		baum.preOrder();
		System.out.print("\nInOrder:  ");
		baum.inOrder();
		System.out.print("\nPostOrder:");
		baum.postOrder();
		System.out.println("\n");
	}
}
