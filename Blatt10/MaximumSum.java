import java.util.Random;
import java.util.Arrays;

class MaximumSum
{
    public static void main(String[] args)
    {
		try
		{
			if (args.length != 1) // Kein Argument übergeben?
			{
				System.out.println("Bitte benutze das Programm folgendermaßen:\njava MaximumSum {Laenge Array}\n");
				System.exit(0);
			}
			int n = Integer.parseInt(args[0]);
			int a[] = new int[n];

			Random r = new Random();
			int Low = -10;
			int High = 10;

			for (int i = 0; i < n; i++)
			{
				a[i] = r.nextInt(High-Low) + Low;
			}

			long tStart, tEnd, msecs;

			System.out.println(Arrays.toString(a));

			tStart = System.currentTimeMillis();
			int max = maximumSubarray(a, n);
			tEnd = System.currentTimeMillis();
			msecs = tEnd - tStart;

			System.out.println("\nDynamisch\nDie Laenge des maximalen Subarrays betraegt " + max + " und wurde in " + msecs + "ms berechnet!\n");

			tStart = System.currentTimeMillis();
			max = maximumSubarrayNaive(a, n);
			tEnd = System.currentTimeMillis();
			msecs = tEnd - tStart;

			System.out.println("Naiv\nDie Laenge des maximalen Subarrays betraegt " + max + " und wurde in " + msecs + "ms berechnet!\n");
		}
		catch (Exception e) //Es ist eine Exception eingetroffen?
		{
			System.out.println(e);
			System.out.println("Bitte benutze das Programm folgendermaßen:\njava MaximumSum {Laenge Array}\n");
			System.exit(0);
		}
    }

    static int maximumSubarray(int a[], int size)
    {
		int max = a[0]; //beinhaelt erstes Element zur Initialisierung
		int current = a[0]; //beinhaelt erstes Element zur Initialisierung
	 
		for (int i = 1; i < size; i++)
		{
			current = Math.max(a[i], current+a[i]); //current oder current+naechsteZahl groesser?
			max = Math.max(max, current); //current oder max groesser?
		}
		return max;
    }

	public static int maximumSubarrayNaive(int[] a, int size) {
		int sum, max;
		max = a[1];
		for (int i = 0; i < size; i++) {
			sum = 0;
			for (int j = i; j < size; j++) {
				sum += a[j];
				if (sum > max) {
					max = sum;
				}
			}
		}

		return max;
	}
}
