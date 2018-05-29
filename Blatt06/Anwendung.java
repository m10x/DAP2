import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.lang.*;
import java.io.*; //readfile

public class Anwendung
{
	public static void main(String[] args)
	{
		try
		{
			if (args.length != 2) // Keine 2 Argumente übergeben?
				throw new Exception("Falsche Argumente übergeben!");
			if (args[0].equals("Interval"))
			{
				//Lese Intervalle aus Datei
				System.out.println("Bearbeite Datei '"+args[1]+"'.\n");
				ArrayList<Interval> liste = readFileInterval(args[1]);
				System.out.println("Es wurden "+liste.size()+" Zeilen mit folgendem Inhalt gelesen:");
				for (Interval I : liste) //Alle Intervalle ausgeben
				{
					System.out.print(I.toString());
				}
				System.out.println("\n");

				//Sortiere Intervalle nach Ende
				liste.sort(Comparator.comparing(Interval::getEnd));

				System.out.println("Sortiert:");
				for (Interval I : liste) //Alle Intervalle ausgeben
				{
					System.out.print(I.toString());
				}
				System.out.println("\n");

				//Berechne Intervallscheduling
				liste = intervalScheduling(liste);
				System.out.println("Berechnetes Intervallscheduling:");
				for (Interval I : liste) //Alle Intervalle ausgeben
				{
					System.out.print(I.toString());
				}
				System.out.println();
			}
			else if (args[0].equals("Lateness"))
			{
				//Lese Intervalle aus Datei
				System.out.println("Bearbeite Datei '"+args[1]+"'.\n");
				ArrayList<Job> liste = readFileJob(args[1]);
				System.out.println("Es wurden "+liste.size()+" Zeilen mit folgendem Inhalt gelesen:");
				for (Job I : liste) //Alle Intervalle ausgeben
				{
					System.out.print(I.toString());
				}
				System.out.println("\n");

				//Sortiere Intervalle nach Ende
				liste.sort(Comparator.comparing(Job::getDeadline));

				System.out.println("Sortiert:");
				for (Job I : liste) //Alle Intervalle ausgeben
				{
					System.out.print(I.toString());
				}
				System.out.println("\n");


				//Berechne Latenessscheduling
				int[] lateness = latenessScheduling(liste);
				int[] latenessohnemax = new int[lateness.length -1];
				for (int i = 0; i < latenessohnemax.length; i++)
				{
					latenessohnemax[i] = lateness[i];
				}
				System.out.println("Berechnetes Latenessscheduling:");
				System.out.println(Arrays.toString(latenessohnemax));
				System.out.println("\nBerechnete maximale Verspätung: "+lateness[lateness.length-1]);
				System.out.println();
			}
			else
				throw new Exception("Falsche Argumente übergeben!");
		}
		catch (Exception e) //Es ist eine Exception eingetroffen? Dann gebe den genauen Fehler aus und informiere den Benutzer über die korrekte Nutzung der Argumente!
		{
			System.out.println(e);
			System.out.println("Bitte benutze das Programm folgendermaßen:\njava Anwendung {Interval/Lateness} {Textdatei}\n");
			System.exit(0);
		}
	}

	public static ArrayList<Interval> intervalScheduling (ArrayList<Interval> intervals)
	{
		int n = intervals.size();
		ArrayList<Interval> A = new ArrayList<Interval>();
		A.add(intervals.get(0));
		int j = 0;
		for (int i = 1; i < n; i++)
		{
			if (intervals.get(i).getStart() >= intervals.get(j).getEnd())
			{
				A.add(intervals.get(i));
				j = i;
			}
		}
		return A;
	}

	public static int[] latenessScheduling(ArrayList<Job> jobs)
	{
		int n = jobs.size();
		int[] A = new int[jobs.size() + 1];
		int z = 0;
		int maxVerspaetung = 0;
		for (int i = 0; i < n; i++)
		{
			if (z + jobs.get(i).getDauer() - jobs.get(i).getDeadline() > maxVerspaetung)
				maxVerspaetung = z + jobs.get(i).getDauer() - jobs.get(i).getDeadline();
			A[i] = z;
			z = z + jobs.get(i).getDauer();
		}
		A[A.length-1] = maxVerspaetung;
		return A;
	}

  	public static ArrayList<Interval> readFileInterval(String datei)
	{
		try
		{
			ArrayList<Interval> A = new ArrayList<Interval>();

			// Datei öffnen
			FileInputStream fstream = new FileInputStream(datei);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;

			//Zeile für Zeile lesen und in ArrayList packen
			while ((strLine = br.readLine()) != null)   {
				List<String> zahlen = Arrays.asList(strLine.split(","));
				Interval I = new Interval(Integer.parseInt(zahlen.get(0)),Integer.parseInt(zahlen.get(1)));
				A.add(I);
			}

			//Close the input stream
			br.close();

			return A;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return null;
	}

	public static ArrayList<Job> readFileJob(String datei)
	{
		try
		{
			ArrayList<Job> A = new ArrayList<Job>();

			// Datei öffnen
			FileInputStream fstream = new FileInputStream(datei);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;

			//Zeile für Zeile lesen und in ArrayList packen
			while ((strLine = br.readLine()) != null)   {
				List<String> zahlen = Arrays.asList(strLine.split(","));
				Job I = new Job(Integer.parseInt(zahlen.get(0)),Integer.parseInt(zahlen.get(1)));
				A.add(I);
			}

			//Close the input stream
			br.close();

			return A;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return null;
	}

}
