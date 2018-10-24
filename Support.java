import java.io.*;
import java.util.*;

public class Support extends Mainmenu//Class Containing Methods To Help Other Program Functions
{
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

	Mainmenu mm=new Mainmenu();

	public void sopln(String ch)//Method To Display Output with Println
	{
		System.out.println(ch);
	}

	public void sop(String s)//Method To Display Output with Print
	{
		System.out.print(s);
	}

	public void return_menu()throws IOException//Method To Return To Menu Or Exit
	{
		sopln("\n\tReturn to main menu? [ Y To Return To Main Menu  And E to Exit ]");

		char ch='n';
		try
		{
			do
			{
				sop("\t\tChoice = ");
				ch=(char)br.read();
				br.readLine();

				if(ch=='y' || ch=='Y')
					mm.menu();

				if(ch=='e' || ch=='E')
				{
					sopln("\n\tThank You Visiting...\n\n\tGood Bye :)\n");
					sop("\t");
					System.exit(0);
				}

			}while(true);
		}catch(NumberFormatException ne)
		{
			sopln("\n\tPlz enter one of the above choice and Retry..\n");
			do{
			return_menu();
			}while(true);
		}
	}

	public void RenameDelete()throws IOException//Method To Delete Original DAT File And Rename Temp File
	{
		File temp=new File("Temp.dat");
		File fm=new File("FlashMotors.dat");
		fm.delete();
		boolean success=temp.renameTo(fm);

		if(success)
			sopln("\n\tModification Successful\n");
		else
			sopln("\n\tModification Failed\n");
	}

	public boolean model_chk(String mod)throws IOException//Method To Check For The Record
	{
		boolean chk=false;
		String rec;
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
			for(int i=0 ; i<token.length ; i++)
			{
				if(token[0].equalsIgnoreCase(mod))
				{
					chk=true;
					break;
				}
			}

		}
		fr.close();

		return chk;

	}

	public boolean company_chk(String com)throws IOException//Method To Check For The Record
	{
		boolean chk=false;
		String rec;
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
			for(int i=0;i<token.length;i++)
			{
				if(token[1].equalsIgnoreCase(com))
				{
					chk=true;
					break;
				}
			}

		}
		fr.close();

		if(chk)
			sopln("\n\t"+com+" Found :)\n");

   		if(chk==false)
   		{
			sopln("\n\t"+com+" Not Found :(\n");
		}

		return chk;

	}

	public boolean colour_chk(String col)throws IOException//Method To Check For The Record
	{
		boolean chk=false;
		String rec;
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
			for(int i=0;i<token.length;i++)
			{
				if(token[2].equalsIgnoreCase(col))
				{
					chk=true;
					break;
				}
			}

		}
		fr.close();

		if(chk)
			sopln("\n\t"+col+" Found :)\n");

   		if(chk==false)
   		{
			sopln("\n\t"+col+" Not Found :(\n");
		}

		return chk;
	}

	public String mod_accept()throws IOException
	{
		String ch=br.readLine().trim();

		while(ch.equalsIgnoreCase("") || ch.equalsIgnoreCase(" ") || ch.equalsIgnoreCase("   ") || ch.equalsIgnoreCase("    ") || ch.equalsIgnoreCase("     ") || ch.equalsIgnoreCase("       "))
		{
			sopln("\n\tPlease Enter A Value And Retry :)");
			sop("\t\tModel = ");
			ch=br.readLine().trim();
		}

		return ch;
	}

	public String str_accept()throws IOException
	{
		int j=0;
		int i=0;
		String ch=br.readLine();

		while(i<ch.length())
		{
			char c=ch.charAt(i);
			if(Character.isDigit(c) || c==' ')
			{
				j=1;
				break;
			}
			else
				i++;
		}

		if(j==1 || ch.equalsIgnoreCase(""))
		{
			sopln("\n\tPlease Enter Only Letters And Retry :)");
			sop("\t\tEnter A Pure String = ");
			str_accept();
		}
		ch.trim();
		return ch;
	}

	public Double dbl_accept()throws IOException
	{
		double no=0;
		try
			{
			no=Double.parseDouble(br.readLine());
			}
		catch(NumberFormatException ne)
			{
				sopln("\n\tPlease Enter Only Real Number And Retry :)");
				sop("\t\tEnter A Real Number = ");
				dbl_accept();
			}

		return no;
	}

}