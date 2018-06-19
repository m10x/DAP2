public class Main {
    public static void main(String[] args){
		int[] array = {13,17,5,3,-10,100,40,-5,4,12,11};
        SearchTree baum = new SearchTree(array);
		baum.traversiere();
    }
}
