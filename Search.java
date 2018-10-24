import java.io.*;
import java.util.*;

public class Search extends Support//Class To Search Records
{

	String model,company,colour,rec,srch;
	Double cost,disp;
	int n,rpt,opt,chk=0;
	char chr;
	boolean chk1;

	public void search()throws IOException//Method To Ask User The Search Options
	{
		sopln("\n\tWhat do you wish to Search Bikes by? \n\t1.Company\n\t2.Model\n\t3.Colour\n");
		try
		{
			do{
				sop("\t\tChoice = ");
				opt=Integer.parseInt(br.readLine());

			}while(opt<1 || opt>3);
		}catch(NumberFormatException ne)
		{
			sop("\t");
			sopln("\n\tPlease Enter An Integer And Try Again");
			search();
		}

   		Scanner sc=new Scanner(new FileReader("FlashMotors.dat"));

		if(opt == 1)
			Company_Search();

		else if(opt == 2)
			Model_Search();

		else if(opt == 3)
			Colour_Search();

		if(chk == 0)
		{
			sopln("\n\t"+srch+" Not Found :(");
		}

   		sc.close();
		return_menu();

	}

	public void Company_Search()throws IOException//Method To Search Bikes By Comapny
	{
		rpt=0;
		n=1;

 		BufferedReader fr=null;

 		try
		{
			fr=new BufferedReader(new FileReader("FlashMotors.dat"));
		}

		catch(FileNotFoundException e)
		{
			sopln("\n\t File Not Found :(");
		}

		sopln("\n\tEnter Bike Company that you wish to Search");
		sop("\t\tBike Company = ");
		srch=str_accept();

		chk1=company_chk(srch);

		if( chk1 == false )
			srch_return();

		while((rec=fr.readLine()) != null)
		{
			String token[]=rec.split(" : ");

			if(token[1].equalsIgnoreCase(srch))
			{
				chk=1;
				if(rpt==0)
				{
					sopln("\n\t|Bike Model\t|Bike Company\t|Colour\t\t|Cost(Rs.)\t|Displacement(cc)\t|Bike No.\n\n");
					rpt=1;
			}
			for(int i=0;i<token.length;i++)
			{
				if(i==0)
				sop("\t");
				if(token[i].length() > 7)
					sop(token[i]+"\t");

				else
					sop(token[i]+"\t\t");
			}

			sop("\t"+n);
			n++;
			sopln("\n");
			}
		}
		srch_return();
	}

	public void Model_Search()throws IOException//Method To Search Bikes By Model
	{
		rpt=0;
		n=1;

 		BufferedReader fr=null;

 		try
		{
			fr=new BufferedReader(new FileReader("FlashMotors.dat"));
		}

		catch(FileNotFoundException e)
		{
			sopln("\n\t File Not Found :(");
		}

	 	sopln("\n\tEnter Bike Model that you wish to Search");
	 	sop("\t\tBike Model = ");
	 	srch=mod_accept();

		chk1=model_chk(srch);

		if(chk1)
			sopln("\n\t"+srch+" Found :)\n");

		if( chk1 == false )
		{
			sopln("\n\t"+srch+" Not Found :(\n");
			srch_return();
		}

		while((rec=fr.readLine()) != null)
		{
			String token[]=rec.split(" : ");

			if(token[0].equalsIgnoreCase(srch))
			{
				chk=1;
				if(rpt==0)
				{
					sopln("\n\t|Bike Model\t|Bike Company\t|Colour\t\t|Cost(Rs.)\t|Displacement(cc)\t|Bike No.\n\n");
					rpt=1;
				}
				for(int i=0;i<token.length;i++)
				{
					if(i==0)
						sop("\t");
					if(token[i].length() > 7)
						sop(token[i]+"\t");

					else
						sop(token[i]+"\t\t");
				}
				sop("\t"+n);
				n++;
				sopln("\n");
			}
		}
		srch_return();
	}

	public void Colour_Search()throws IOException//Method To Search Bikes By Colour
	{
		rpt=0;
		n=1;

 		BufferedReader fr=null;

 		try
		{
			fr=new BufferedReader(new FileReader("FlashMotors.dat"));
		}

		catch(FileNotFoundException e)
		{
			sopln("\n\t File Not Found :(");
		}

		 sopln("\n\tEnter Bike Colour that you wish to Search");
		 sop("\t\tBike Colour = ");
		 srch=str_accept();

		chk1=colour_chk(srch);

		if( chk1 == false )
			srch_return();

		while((rec=fr.readLine()) != null)
		{
			String token[]=rec.split(" : ");

			if(token[2].equalsIgnoreCase(srch))
			{
				chk=1;
				if(rpt==0)
				{
					sopln("\n\t|Bike Model\t|Bike Company\t|Colour\t\t|Cost(Rs.)\t|Displacement(cc)\t|Bike No.\n\n");
					rpt=1;
				}
				for(int i=0;i<token.length;i++)
				{
					if(i==0)
						sop("\t");
					if(token[i].length() > 7)
						sop(token[i]+"\t");

					else
						sop(token[i]+"\t\t");
				}
				sop("\t"+n);
				n++;
				sopln("\n");
			}
		}
		srch_return();
	}

		public void srch_return()throws IOException//Method To Ask User To Re-run Same Method
		{
			Support st = new Support();

			sopln("\n\tDo You Wish To Search For Bike/s? S To Search And N To Return to Sub-Menu");
			do
			{
				sop("\t\tEnter Choice = ");
				chr=(char)br.read();
				br.readLine();

				if(chr == 's' || chr == 'S')
					search();

				if(chr == 'n' || chr == 'N')
					st.return_menu();
			}while(true);
		}

}
