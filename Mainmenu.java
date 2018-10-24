import java.io.*;

public class Mainmenu//Class To View Main Menu And Run Program
{
	BufferedReader br = new BufferedReader ( new InputStreamReader ( System.in ));

	public static void main(String Vipul[])throws IOException// The Only Main Method In The Program
	{
		Mainmenu mm = new Mainmenu();
		mm.menu();
	}

	public void menu()throws IOException//Method To View MainMenu
	{
		Support st = new Support();
		Add add = new Add();
		Delete del = new Delete();
		Modify mod = new Modify();
		Search sch = new Search();
		View vew = new View();
		int n = 0;

		try
		{
			do
			{
				st.sopln("\n\t _______________________________________________________________ \n");
				st.sopln("\t|	*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x* \t|");
				st.sopln("\t|	x   						x \t|");
				st.sopln("\t|	*	     Welcome to Flash Motors  	 	* \t|");
				st.sopln("\t|	x                          	       	        x \t|");
				st.sopln("\t|	*  	 Your Options are:  	  *	   	* \t|");
				st.sopln("\t|	x 	  1 ] Add Bikes		 *	 	x \t|");
				st.sopln("\t|	* 	  2.] View Bike		****		* \t|");
				st.sopln("\t|	x 	  3.] Search Bikes	  *		x \t|");
				st.sopln("\t|	* 	  4.] Modify Bikes	 ****		* \t|");
				st.sopln("\t|	x 	  5.] Delete Bikes	   *		x \t|");
				st.sopln("\t|	* 	  6.] Exit		  *		* \t|");
				st.sopln("\t|	x   						x \t|");
				st.sopln("\t|	*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x* \t|");
				st.sopln("\t|_______________________________________________________________| \n");
				st.sop("\t\tChoice = ");
				n=Integer.parseInt(br.readLine());
				st.sopln("\n");

				if(n<1 || n>6)
					st.sopln("\n\tPlz enter one of the above choice and Retry..");

			}while(n<1 || n>6);
		}catch(NumberFormatException ne)
		{
			st.sop("\t");
			st.sopln("Please Enter An Integer And Try Again");
			menu();
		}

		switch(n)
		{
			case 1:{st.sopln("\n\t\t\t* You Have Chose To Add Bikes *\n");
					add.add();
					break;}

			case 2:{st.sopln("\n\t\t\t* You Have Chose To View Bikes *\n");
					vew.view();
					break;}

			case 3:{st.sopln("\n\t\t\t* You Have Chose To Search Bikes *\n");
					sch.search();
					break;}

			case 4:{st.sopln("\n\t\t\t* You Have Chose To Modify Bikes *\n");
					mod.modify();
					break;}

			case 5:{st.sopln("\n\t\t\t* You Have Chose To Delete Bikes *\n");
					del.delete();
					break;}

			case 6:{st.sopln("\n\t\t\tThank You Visiting...\n\n\tGood Bye :)\n");
					st.sop("\t");
					System.exit(0);}
		}

	}
}