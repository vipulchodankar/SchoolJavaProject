import java.io.*;

public class View extends Support//Class To View All Records
{
	char chr;

	public void view()throws IOException//Method To View All Records
	{
 		BufferedReader fr=null;

 		try
		{
			fr=new BufferedReader(new FileReader("FlashMotors.dat"));
		}

		catch(FileNotFoundException e)
		{
			sopln("\n\tFile Not Found :(");
		}

		String rec;

		sopln("\n\t|Bike Model\t|Bike Company\t|Bike Colour\t|Bike Cost(Rs.)\t|Bike Displacement(cc)\t|Bike No.\n\n");
		sop("\t");
		for(int k=0;k<16;k++)
			sop("------");
		sopln("");

		int n=1;

		while((rec=fr.readLine()) != null)
		{
			String token[]=rec.split(" : ");
			sop("\t");
			for(int i=0;i<token.length;i++)
			{
				if(token[i].length() > 7)
					sop(token[i]+"\t");

				else
					sop(token[i]+"\t\t");
			}
			sop("\t"+n+"");
			n++;
			sopln("");
			sop("\t");
			for(int k=0;k<16;k++)
				sop("------");
			try
			{
				Thread.sleep(400);
			}
			catch(InterruptedException ie)
			{}
			sopln("");

		}

		fr.close();
		view_return();;
 	}

 	public void view_return()throws IOException//Method To Ask User To Re-run Same Method
	{
		Support st = new Support();

		sopln("\n\tDo You Wish To View All Bikes ? V To View And N To Return to Sub-Menu");
		do
		{
			sop("\t\tEnter Choice = ");
			chr=(char)br.read();
			br.readLine();

			if(chr == 'v' || chr == 'V')
				view();

			if(chr == 'n' || chr == 'N')
				st.return_menu();

		}while(true);
	}

}