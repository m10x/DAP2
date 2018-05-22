public class Job
{
	private int dauer;
	private int deadline;

	public Job(int dauer, int deadline)
	{
		this.dauer = dauer;
		this.deadline = deadline;
	}

	public int getDauer()
	{
		return dauer;
	}

	public int getDeadline()
	{
		return deadline;
	}

	public String toString()
	{
		return "["+dauer+","+deadline+"]";
	}
}
