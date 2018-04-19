import java.util.Random;
import java.util.Arrays;

public class Sortierung
{
	public static void main(String[] args)
	{
		try
		{
			int laenge = Integer.parseInt(args[0]);
			assert laenge > 0 : laenge + " ist nicht groesser 0";
			int[] feld = new int[laenge];
			Random numberGenerator = new Random();

			long tStart, tEnd, msecs;

			for (int i = 0; i < feld.length; i++)
			{
				if (args.length == 2 && args[1].equals("auf"))
					feld[i] = 1 + i;
				else if (args.length == 2 && args[1].equals("ab"))
					feld[i] = feld.length - i;
				else if (args.length == 1 || ( args.length == 2 && args[1].equals("rand") ) )
					feld[i] = numberGenerator.nextInt();
				else
					throw new Exception("Falsche Argumente übergeben!");
			}
			if (feld.length <= 100)
			{
				System.out.println(Arrays.toString(feld));
			}

			tStart = System.currentTimeMillis();
			insertionSort(feld);
			tEnd = System.currentTimeMillis();
			msecs = tEnd - tStart;

			System.out.println("InsertionSort hat "+msecs+" Millisekunden benötigt.");			

			if (isSorted(feld))
				System.out.println("Feld sortiert!");
			else
				System.out.println("Feld NICHT sortiert!");
			if (feld.length <= 100)
			{
				System.out.println(Arrays.toString(feld));
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println("Bitte benutze das Programm folgendermaßen:\n java Sortierung {länge} {auf/ab/rand}\n wobei {länge} eine Zahl größer 0 seien muss.");
			System.exit(0);
		}

	}

	public static void mergeSort(int[] array) 
	{
		int[] tmpArray = new int[array.length];
		mergeSort(array, tmpArray, 0, array.length-1);
		assert isSorted(array);
	}

	public static void mergeSort(int[] array, int[] tmpArray, int left, int right) 
	{
		System.out.println("MergeSort wurde ausgeführt!!");
	}

	public static void insertionSort(int[] array)
	{
		int key;
		for (int j = 1; j < array.length; j++)
		{
			key = array[j];
			int i = j;
			while (i > 0 && array[i - 1] > key)
			{
				array[i] = array[i - 1];
				i = i - 1;
			}
			array[i] = key;
		}
	}

	public static boolean isSorted(int[] array)
	{
		int aktuell = array[0];
		for (int i = 1; i < array.length; i++)
		{
			if (aktuell > array[i])
			{
				return false;
			}
		}
		return true;
	}
}
