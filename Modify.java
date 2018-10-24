import java.io.*;
import java.util.*;
public class Modify extends Support//Class To Modifu MEthods
{
	BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ));
	String mod,rec;
	int mod_ch;
	char chr;
	boolean chk1;

	public void modify()throws IOException//Method To Ask For Model Of The Record To Be Modified
	{
		sopln("\n\tEnter the model of the bike that you wish to modify.");
		sop("\t\tBike To Be Modified = ");
		mod=mod_accept();

		chk1=model_chk(mod);

		if( chk1 == true )
			sopln("\n\t"+mod+" found :)");

		if( chk1 == false )
		{
			sopln("\n\t"+mod+" not found :(");
			mod_return();
		}

		mod_menu();

	}

	public void mod_menu()throws IOException//Method To Display Modify Menu
	{
		try
		{
			do
			{
				sopln("\n\tWhat Do You Wish To Modify?");
				sopln("\n\t1.Bike Model");
				sopln("\t2.Bike Company");
				sopln("\t3.Bike Colour");
				sopln("\t4.Bike Cost");
				sopln("\t5.Bike Displacement(cc)\n");
				sop("\t\tChoice = ");
				mod_ch=Integer.parseInt(br.readLine());
			}
			while(mod_ch < 1 || mod_ch > 5);
		}
		catch(NumberFormatException ne)
		{
			sopln("\nPlease Enter One Of These Integers Only :)");
			mod_menu();
		}

		if(mod_ch == 1)
			mod_model();

		else if(mod_ch == 2)
			mod_company();

		else if(mod_ch == 3)
			mod_colour();

		else if(mod_ch == 4)
			mod_cost();

		else if(mod_ch == 5)
			mod_displacement();

		mod_return();

	}

	public void mod_model()throws IOException//Method To Modify Records's Model
	{
 		BufferedReader fr=null;

		PrintWriter pw=new PrintWriter(new FileWriter("Temp.dat"));

 		try
		{
			fr=new BufferedReader(new FileReader("FlashMotors.dat"));
		}
		catch(FileNotFoundException e)
		{
			sopln("\n\tFile Not Found :(\n");
		}

		while((rec=fr.readLine()) != null)
		{
			String token[]=rec.split(" : ");
				if(token[0].equalsIgnoreCase(mod))
				{
					sopln("\n\t\tPresent Bike Model : "+token[0]);
					sop("\n\t\tNew Bike Model = ");
					String model=br.readLine().trim();
					pw.println(model+" : "+token[1]+" : "+token[2]+" : "+token[3]+" : "+token[4]);
				}

				else
				{
					pw.println(rec);
				}
		}

		fr.close();
		pw.close();
		RenameDelete();
		mod_return();

		}

	public void mod_company()throws IOException//Method To Modify Records's Company
	{
		PrintWriter pw=new PrintWriter(new FileWriter("Temp.dat"));

 		BufferedReader fr=null;

 		try
		{
			fr=new BufferedReader(new FileReader("FlashMotors.dat"));
		}
		catch(FileNotFoundException e)
		{
			sopln("\n\tFile Not Found :(\n");
		}

		while((rec=fr.readLine()) != null)
		{
			String token[]=rec.split(" : ");
				if(token[0].equalsIgnoreCase(mod))
				{
					sopln("\n\t\tPresent Bike Company : "+token[1]);
					sop("\n\t\tNew Bike Company = ");
					String company=str_accept();
					pw.println(token[0]+" : "+company+" : "+token[2]+" : "+token[3]+" : "+token[4]);
				}

				else
				{
					pw.println(rec);
				}
		}
		fr.close();
		pw.close();
		RenameDelete();
		mod_return();

		}

	public void mod_colour()throws IOException//Method To Modify Records's Colour
	{
		PrintWriter pw=new PrintWriter(new FileWriter("Temp.dat"));

 		BufferedReader fr=null;

 		try
		{
			fr=new BufferedReader(new FileReader("FlashMotors.dat"));
		}
		catch(FileNotFoundException e)
		{
			sopln("\n\tFile Not Found :(\n");
		}

		while((rec=fr.readLine()) != null)
		{
			String token[]=rec.split(" : ");
				if(token[0].equalsIgnoreCase(mod))
				{
					try
					{
						sopln("\n\t\tPresent Bike Colour : "+token[2]);
						sop("\n\t\tNew Bike Colour = ");
						String colour=str_accept();
						pw.println(token[0]+" : "+token[1]+" : "+colour+" : "+token[3]+" : "+token[4]);
					}
					catch(NumberFormatException ne)
					{
						sopln("\nPlease Enter A Real Number Only And Retry :)");
						sop("\n\t\tNew Bike Colour = ");
						String colour=br.readLine().trim();
						pw.println(token[0]+" : "+token[1]+" : "+colour+" : "+token[3]+" : "+token[4]);
					}

				}

				else
				{
					pw.println(rec);
				}

			}
			fr.close();
			pw.close();
			RenameDelete();
			mod_return();

		}

	public void mod_cost()throws IOException//Method To Modify Records's Cost
	{
		PrintWriter pw=new PrintWriter(new FileWriter("Temp.dat"));

 		BufferedReader fr=null;

 		try
		{
			fr=new BufferedReader(new FileReader("FlashMotors.dat"));
		}
		catch(FileNotFoundException e)
		{
			sopln("\n\tFile Not Found :(\n");
		}

		while((rec=fr.readLine()) != null)
		{
			String token[]=rec.split(" : ");
				if(token[0].equalsIgnoreCase(mod))
				{
					try
					{
						sopln("\n\t\tPresent Bike Cost : "+token[3]);
						sop("\n\t\tNew Bike Cost = ");
						Double cost=dbl_accept();
						pw.println(token[0]+" : "+token[1]+" : "+token[2]+" : "+cost+" : "+token[4]);
					}
					catch(NumberFormatException ne)
					{
						sopln("\nPlease Enter A Real Number Only And Retry :)");
						sop("\n\t\tNew Bike Cost = ");
						Double cost=Double.parseDouble(br.readLine());
						pw.println(token[0]+" : "+token[1]+" : "+token[2]+" : "+cost+" : "+token[4]);
					}
				}

				else
				{
					pw.println(rec);
				}
			}
			fr.close();
			pw.close();
			RenameDelete();
			mod_return();

		}
	public void mod_displacement()throws IOException//Method To Modify Records's Displacement
	{
		PrintWriter pw=new PrintWriter(new FileWriter("Temp.dat"));

 		BufferedReader fr=null;

 		try
		{
			fr=new BufferedReader(new FileReader("FlashMotors.dat"));
		}
		catch(FileNotFoundException e)
		{
			sopln("\n\tFile Not Found :(\n");
		}

		while((rec=fr.readLine()) != null)
		{
			String token[]=rec.split(" : ");
				if(token[0].equalsIgnoreCase(mod))
				{
					sopln("\n\t\tPresent Bike Displacement(cc) : "+token[4]);
					sop("\n\t\tNew Displacement(cc) = ");
					Double displacement=dbl_accept();
					pw.println(token[0]+" : "+token[1]+" : "+token[2]+" : "+token[3]+" : "+displacement);
				}

				else
				{
					pw.println(rec);
				}
			}
			fr.close();
			pw.close();
			RenameDelete();
			mod_return();

		}

		public void mod_return()throws IOException//Method To Ask User To Re-run Same Method
		{
			Support st = new Support();

			sopln("\n\tDo You Wish To Modify Another Bike? M To Modify And N To Return to Sub-Menu");
			do
			{
				sop("\t\tEnter Choice = ");
				chr=(char)br.read();
				br.readLine();

				if(chr == 'm' || chr == 'M')
					modify();

				if(chr == 'n' || chr == 'N')
					st.return_menu();

			}while(true);
		}
}