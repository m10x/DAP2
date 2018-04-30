import java.util.Arrays; //Für Arrays.fill

public class bubbleSort {
	
	public static void main(String[] args)
	{
		int[] feld = new int[20];
		fillArray(feld);

		System.out.println(Arrays.toString(feld));
		
		bubbleSort(feld);

		System.out.println(Arrays.toString(feld));
	}

	public static void bubbleSort(int[] feld)
	{
		int tmp;
		for (int i = 1; i < feld.length; i++)
		{
			for (int j = feld.length - 1; j >= i; j--)
			{
				if (feld[j-1] > feld[j])
				{
					tmp = feld[j-1];
					feld[j-1] = feld[j];
					feld[j] = tmp;
				}
			}
		}
	}

	public static void fillArray(int[] feld)
	{
		for (int i = 0; i < feld.length; i++) //Gehe das komplette Array durch
		{
			feld[i] = feld.length - i;
		}
	}
}
