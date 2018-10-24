import java.io.*;
import java.util.*;

public class Add extends Support
{
	BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ));
	char chr;

	public void add()throws IOException//Method To Add New Bikes
	{
		int no=0;
		PrintWriter pw=new PrintWriter(new FileWriter("FlashMotors.dat",true));

		try
		{
			sopln("\n\tHow many Bikes do you wish to add ? ");
			sop("\t\tNo. Of Bikes  = ");
			no=Integer.parseInt(br.readLine());

		}catch(NumberFormatException ne)
		{
			sopln("\n\tPlease Enter Integers Only And Retry :)\n");
			add();
		}

		String model,company,colour;
		Double cost,disp;
		boolean chk1;
		try
		{
	  		for (int i=1 ; i<=no ; i++)
	    	{

	    	 sopln("\n\tEnter Bike Model");
	    	 sop("\t\tBike Model = ");
	    	 model = mod_accept();

			 chk1 = model_chk(model);

		 	 if(chk1)
			{
				sopln("\n\t"+model+" is already entered");
			 	break;
		 	 }

	    	 sopln("\n\tEnter Bike Company");
	    	 sop("\t\tBike Company = ");
	    	 company = str_accept();

	    	 sopln("\n\tEnter Bike Colour");
	    	 sop("\t\tBike Colour = ");
	    	 colour = str_accept();

	    	 sopln("\n\tEnter Bike Cost(Rs.)");
	    	 sop("\t\tBike Cost = ");
	    	 cost = dbl_accept();

	    	 sopln("\n\tEnter Bike Displacement(cc)");
	    	 sop("\t\tBike Displacement = ");
	    	 disp = dbl_accept();


	 	 	 pw.println (model +" : "+ company +" : "+ colour +" : "+ cost + " : " + disp);

	 	   sopln ("\n");
		}
		pw.close();

  		}catch(InputMismatchException e1)
  		{sopln("\n\tPlease Enter A Real Number And Retry :)");}

		add_return();
	}

	public void add_return()throws IOException//Method To Ask User To Re-run Same Method
	{
		Support st = new Support();

		sopln("\n\tDo You Wish To Add Bike/s ? A To Add And N To Return to Sub-Menu");
		do
		{
			sop("\t\tEnter Choice = ");
			chr=(char)br.read();
			br.readLine();

			if(chr == 'a' || chr == 'A')
				add();

			if(chr == 'n' || chr == 'N')
				st.return_menu();
		}while(true);
	}

}
