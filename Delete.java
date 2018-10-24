import java.io.*;
import java.util.*;

public class Delete extends Support//Class To Delete Record
{
	BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ));
	String rec;
	char chr;
	boolean chk;

	public void delete()throws IOException
	{
 		BufferedReader fr=null;

 		try
		{
			fr=new BufferedReader(new FileReader("FlashMotors.dat"));
		}
		catch(FileNotFoundException e)
		{
			sopln("\n\tFile Not Found :(\n");
		}

		PrintWriter pw=new PrintWriter(new FileWriter("Temp.dat"));

		sopln("\n\tEnter The Model Of The Bike That You Wish To Delete.");
		sop("\t\tBike To Be Deleted = ");
		String del=mod_accept();

		chk=model_chk(del);

		if( chk == true )
			sopln("\n\t"+del+" found :)");

		if( chk == false )
		{
			sopln("\n\t"+del+" not found :(");
			del_return();
		}

		sopln("\n\tAre You Sure? * Record Will Be Deleted * [ Y To Continue N To Return To Delete- Menu ]\n");
		sop("\t\tChoice = ");
		char del_ch=(char)br.read();
		br.readLine();

		int ss=0;

	 	if(del_ch=='y' || del_ch=='Y')
		{
			while((rec=fr.readLine()) != null)
			{
				String token[]=rec.split(" : ");
				if(token[0].equalsIgnoreCase(del))
				{
					ss=1;
					continue;//record is skipped and not printed
				}

				else
				{
					pw.println(rec);
				}
		}

   		 if(ss==1)
   		 	sopln("\n\tBike "+del+" Is Successfully Deleted");

   		 else if(ss==0)
   		 	sopln("\n\tBike "+del+" Is Not Deleted");
		}

		else if(del_ch=='n' || del_ch=='N')
			del_return();

		pw.close();
		fr.close();

		RenameDelete();

		del_return();
	}

	public void del_return()throws IOException//Method To Ask User To Re-run Same Method
	{
		Support st = new Support();

		sopln("\n\tDo You Wish To Delete Another Bike? D To Delete And N To Return to Sub-Menu");
		do
		{
			sop("\t\tEnter Choice = ");
			chr=(char)br.read();
			br.readLine();

			if(chr == 'd' || chr == 'D')
				delete();

			if(chr == 'n' || chr == 'N')
				st.return_menu();

		}while(true);
	}

}
