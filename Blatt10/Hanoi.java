public class Hanoi
{
	public static void main(String[] args)
	{
		try
		{
			if (args.length != 1) // Kein Argument übergeben?
			{
				System.out.println("Bitte benutze das Programm folgendermaßen:\njava Hanoi {Anzahl Scheiben}\n");
				System.exit(0);
			}

			int n = Integer.parseInt(args[0]);

			move(n, 'A', 'B', 'C');
		}

		catch (Exception e) //Es ist eine Exception eingetroffen?
		{
			System.out.println(e);
			System.out.println("Bitte benutze das Programm folgendermaßen:\njava Hanoi {Anzahl Scheiben}\n");
			System.exit(0);
		}
	}

	private static void move(int quantity, char start, char help, char target)
	{
		if (quantity != 1)
		{
			move(quantity-1, start, target, help); //verschiebe von a nach b, b und c tauschen Rollen
			move(1, start, help, target); //verschiebe von a nach c
			move(quantity-1, help, start, target); //verschiebe von b nach c, a und c tauschen Rollen
		}
		else
		 	System.out.println("Verschiebe oberste Scheibe von " + start + " nach " + target);
	}
}
