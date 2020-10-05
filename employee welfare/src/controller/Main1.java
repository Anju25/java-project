package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import dao.Crud;

import java.util.regex.Matcher;

import model.Awards;
import model.Conference;
import model.Cookingclasses;
import model.Employeedetails;
import model.Exhibition;
import model.Livebands;
import model.Photobooth;
import model.Reviews;

public class Main1 
{
	static HashMap<String,String> login=new HashMap<String ,String>();
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int choice; int c1; int c2;  int choice1,choice2;
			do {
				   System.out.println("*****************************************");
				   System.out.println("1.CORPORATE EVENTS");
				   System.out.println("2.ENTERTAINMENT EVENTS");
				   System.out.println("3.EMPLOYEE REVIEWS");
				   System.out.println("4.EXIT");
				   System.out.println("*****************************************");
				   System.out.println("ENTER YOUR CHOICE");
				   choice =Integer.parseInt(br.readLine());
				   switch(choice)
				   {
				   case 1 :
					do {
				       System.out.println("****************************************");
					   System.out.println("1.CONFERENCE");
					   System.out.println("2.EXHIBITION");
					   System.out.println("3.AWARDS");
					   System.out.println("4.EXIT");
				       System.out.println("*******************************************");
				       System.out.println("ENTER YOUR CHOICE");
					   choice1 = Integer.parseInt(br.readLine());
					 
				       switch(choice1)
					   {
					   case 1:conference();break;
					   case 2:exhibition();break;
		               case 3:awards();break;
					  // case 4:return;
					   }   
					  }while(choice1!=4);
				       break;
		            case 2:
		            	do
		            	{
					   System.out.println("****************************************");
					   System.out.println("1.PHOTO BOOTH");
					   System.out.println("2.COOKING CLASSES");
					   System.out.println("3.LIVE BANDS");
					   System.out.println("4.EXIT");
				       System.out.println("*******************************************");
				       System.out.println("ENTER YOUR CHOICE");
					   choice2 = Integer.parseInt(br.readLine());
					   switch(choice2) 
					    {
					   case 1:photo();break;
					   case 2:cooking();break;
                       case 3:bands();break;
						}
		            	}while(choice2!=4);
		                  break;
					case 3:
					   Crud list = new Crud();
					   List<Reviews> view = new ArrayList<Reviews>();
					   Reviews ab;
					   System.out.println("ENTER EMPLOYEE NAME");
					   String employee_name = br.readLine();
					   System.out.println("ENTER EMPLOYEE REVIEWS");
					   String employee_reviews = br.readLine();
					   ab = new Reviews(employee_name,employee_reviews);
					   //view = list.add(ab);
					   break;
					   case 4 :return;
					  }
			}while(choice!=4);
					   
			}


		//*****************************CONFERENCE FUNCTION CALL***********************************//
		static HashMap<String,Conference> map = new HashMap<String,Conference>();		   
		private static void conference()throws IOException {
		Conference obj;
		Crud list = new Crud(); int c1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("*************************************");
		System.out.println("1.ADD CONFERENCE DETAILS");
		System.out.println("2.REMOVE CONFERENCE DETAILS");
		System.out.println("3.DISPLAY CONFERENCE DETAILS");
		System.out.println("4.EXIT");
		System.out.println("**************************************");
		System.out.println("ENTER YOUR CHOICE");
		c1 = Integer.parseInt(br.readLine());
		switch(c1) 
		{
		case 1:
		System.out.println("ENTER MEETING ID");
		String id1= br.readLine();
		System.out.println("ENTER THE HR NAME");
		String name1 = br.readLine();
		System.out.println("ENTER MEETING DATE");
		String date1 = br.readLine();
		System.out.println("ENTER MEETING TIMINGS");
		String timings1 = br.readLine();
		obj = new Conference(id1,name1,date1,timings1);
		map =list.put(id1,obj);
		System.out.println("/////////////////////////////////////////////////");
		System.out.printf("%35s","ENTERED SUCCESSFULLY!!!");
		System.out.println();
		System.out.println("/////////////////////////////////////////////////");
		break;

		case 2:
			
		System.out.println("ENTER THE ID TO REMOVE");
		String meetid1 =br.readLine();
		map = list.remove1(meetid1);
		System.out.println("/////////////////////////////////////////////////");
		System.out.printf("%35s",meetid1+""+"REMOVED");
		System.out.println();
		System.out.println("/////////////////////////////////////////////////");
		break;

		case 3:
			
		System.out.println("DISPLAYING INFO");
		System.out.println("**********************************************");
		System.out.printf("%1s %9s %12s %15s","ID","NAME","DATE","TIMINGS");
		System.out.println();
		System.out.println("************************************************");
		for(Entry<String,Conference> pair: map.entrySet())
		{
		  Conference value = pair.getValue();	
		  System.out.printf("%1s %9s %12s %15s",value.getId1(),value.getName1(),value.getDate1(),value.getTimings1());
		  System.out.println();
		}
		System.out.println("*******************************************************");
		break;
		case 4:return;
		}
	}

//*********************************EXHIBITION FUNCTION CALL**************************************************//

		static List<Exhibition> u1 = new ArrayList<Exhibition>();
		private static void exhibition()throws NumberFormatException,IOException
		{
			Crud list = new Crud(); int c2;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Exhibition obj1;
           
		       System.out.println("***************************************");
		       System.out.println("1.ADD EXHIBITION DETAILS");
			   System.out.println("2.REMOVE EXHIBITION DETAILS");
			   System.out.println("3.DISPLAY EXHIBITION DETAILS ");
			   System.out.println("4.EXIT");
			   System.out.println("*****************************************");
			   System.out.println("ENTER YOUR CHOICE");
			   c2 = Integer.parseInt(br.readLine());
			switch(c2) 
			{
			case 1:
			System.out.println("ENTER THE INDEX");
			int index2 = Integer.parseInt(br.readLine());
			System.out.println("ENTER THE EXHIBITION NAME");
			String name2 = br.readLine();
			System.out.println("ENTER THE DATE");
			String date2 = br.readLine();
			System.out.println("ENTER THE TIMINGS");
			String timings2 = br.readLine();
			obj1 =new Exhibition (index2,name2,date2,timings2);
			u1 = list.adddetails(obj1);
			System.out.println("/////////////////////////////////////////////////");
			System.out.printf("%35s","ENTERED SUCCESSFULLY!!!");
			System.out.println();
			System.out.println("/////////////////////////////////////////////////");
			break;
			case 2:
				System.out.println("ENTER THE INDEX TO REMOVE");
				int index21 = Integer.parseInt(br.readLine());
				u1 = list.remove11(index21);
				//System.out.println(index21 + "REMOVED");
				System.out.println("/////////////////////////////////////////////////");
				System.out.printf("%35s",index21+""+"REMOVED");
				System.out.println();
				System.out.println("/////////////////////////////////////////////////");
				break;
			case 3:
				System.out.println("DISPLAYING INFO");
				System.out.println("**********************************************");
				System.out.printf("%1s %12s %15s %18s","INDEX","NAME","DATE","TIMINGS");
				System.out.println();
				System.out.println("************************************************");
				for(Exhibition obj11 :u1)
				{
				  System.out.printf("%1s %12s %15s %18s",obj11.getIndex2(),obj11.getName2(),obj11.getDate2(),obj11.getTimings2());
				  System.out.println();
				}
				System.out.println("*******************************************************");
				break;
			case 4:return;
				}
           }
//********************************AWARDS FUNCTION CALL************************************************//		

		static List<Awards> u2 = new ArrayList<Awards>();
		private static void awards()throws NumberFormatException,IOException {
			Crud list = new Crud(); int c3;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Awards obj2;
			
			 System.out.println("********************************************");
			   System.out.println("1.ADD AWARDS DETAILS");
			   System.out.println("2.REMOVE AWARDS DETAILS ");
			   System.out.println("3.DISPLAY AWARDS DETAILS");
			   System.out.println("4.EXIT");
			   System.out.println("*********************************************");
			   System.out.println("ENTER YOUR CHOICE");
			    c3 = Integer.parseInt(br.readLine());
			switch(c3) {
			case 1:
			System.out.println("ENTER THE INDEX");
			int index3 = Integer.parseInt(br.readLine());
			System.out.println("ENTER THE AWARD NAME");
			String name3 = br.readLine();
			System.out.println("ENTER THE DATE");
			String date3 = br.readLine();
			System.out.println("ENTER THE TIMINGS");
			String timings3 = br.readLine();
			obj2 = new Awards(index3,name3,date3,timings3);
			u2 = list.adddetails1(obj2);
			System.out.println("/////////////////////////////////////////////////");
			System.out.printf("%35s","ENTERED SUCCESSFULLY!!!");
			System.out.println();
			System.out.println("/////////////////////////////////////////////////");
			break;
		    case 2:
			System.out.println("ENTER THE INDEX TO REMOVE");
			int index31 = Integer.parseInt(br.readLine());
			u2 = list.remove2(index31);
			//System.out.println(index31 + "REMOVED");
			System.out.println("/////////////////////////////////////////////////");
			System.out.printf("%35s",index31 + "REMOVED");
			System.out.println();
			System.out.println("/////////////////////////////////////////////////");
			break;
			case 3:
				System.out.println("DISPLAYING INFO");
				System.out.println("**********************************************");
				System.out.printf("%1s %12s %15s %18s","INDEX","NAME","DATE","TIMINGS");
				System.out.println();
				System.out.println("************************************************");
				for(Awards obj12 :u2)
				{
				  System.out.printf("%1s %12s %15s %18s",obj12.getIndex3(),obj12.getName3(),obj12.getDate3(),obj12.getTimings3());
				  System.out.println();
				}
				System.out.println("*******************************************************");
				break;
				case 4:return;
				}
			}
		
//*******************************PHOTO BOOTH**************************************************//		
		
		static List<Photobooth> u3 = new ArrayList<Photobooth>();	
		private static void photo()throws NumberFormatException,IOException {
			Crud list = new Crud();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Photobooth obj3; int c4;
			System.out.println("*************************************");
			   System.out.println("1.ADD PHOTO BOOTH DETAILS");
			   System.out.println("2.REMOVE PHOTO BOOTH DETAILS");
			   System.out.println("3.DISPLAY PHOTO BOOTH  DETAILS");
			   System.out.println("4.EXIT");
			   System.out.println("**************************************");
			   System.out.println("ENTER YOUR CHOICE");
			   c4 = Integer.parseInt(br.readLine());
			switch(c4)
			{
			
			case 1:
				System.out.println("ENTER THE INDEX");
				int ix1 = Integer.parseInt(br.readLine());
				System.out.println("ENTER THE DATE");
				String dt1 = br.readLine();
				System.out.println("ENTER THE TIME");
				String time1 = br.readLine();
				System.out.println("ENTER THE VENUE");
				String venue1 = br.readLine();
				obj3 = new Photobooth(ix1,dt1,time1,venue1);
				u3 = list.adddetails2(obj3);
				System.out.println("/////////////////////////////////////////////////");
				System.out.printf("%35s","ENTERED SUCCESSFULLY!!!");
				System.out.println();
				System.out.println("/////////////////////////////////////////////////");
			    break;
			
			case 2:
				System.out.println("ENTER THE INDEX TO REMOVE");
				int ix11 = Integer.parseInt(br.readLine());
				u3 = list.remove3(ix11);
				//System.out.println(ix11 + "REMOVED");
				
				System.out.println("/////////////////////////////////////////////////");
				System.out.printf("%35s",ix11 + "REMOVED");
				System.out.println();
				System.out.println("/////////////////////////////////////////////////");
			    break;
				
			case 3:
				System.out.println("DISPLAYING INFO");
				System.out.println("**********************************************");
				System.out.printf("%1s %12s %15s %18s","INDEX","DATE","TIMINGS","VENUE");
				System.out.println();
				System.out.println("************************************************");
				for(Photobooth obj13 :u3)
				{
				  System.out.printf("%1s %12s %15s %18s",obj13.getIx1(),obj13.getDt1(),obj13.getTime1(),obj13.getVenue1());
				  System.out.println();
				}
				System.out.println("*******************************************************");
				break;
				case 4:return;
					
				}
				}
		
//********************************COOKING CLASSES********************************************//		
		
		static List<Cookingclasses> u4 = new ArrayList<Cookingclasses>();	
		private static void cooking()throws NumberFormatException,IOException {
			Crud list = new Crud();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Cookingclasses obj4; int c5;
			  System.out.println("***************************************");
			   System.out.println("1.ADD COOKING CLASSES DETAILS");
			   System.out.println("2.REMOVE COOKING CLASSES DETAILS");
			   System.out.println("3.DISPLAY COOKING CLASSES DETAILS ");
			   System.out.println("4.EXIT");
			   System.out.println("*****************************************");
			   System.out.println("ENTER YOUR CHOICE");
			   c5 = Integer.parseInt(br.readLine());
			switch(c5)
			{
			
			case 1:
				System.out.println("ENTER THE INDEX");
				int ix2 = Integer.parseInt(br.readLine());
				System.out.println("ENTER THE DATE");
				String dt2 = br.readLine();
				System.out.println("ENTER THE TIME");
				String time2 = br.readLine();
				System.out.println("ENTER THE VENUE");
				String venue2 = br.readLine();
				obj4 = new Cookingclasses(ix2,dt2,time2,venue2);
				u4 = list.adddetails3(obj4);
				System.out.println("/////////////////////////////////////////////////");
				System.out.printf("%35s","ENTERED SUCCESSFULLY!!!");
				System.out.println();
				System.out.println("/////////////////////////////////////////////////");
			    break;
			    
			case 2:
				
				System.out.println("ENTER THE INDEX TO REMOVE");
				int ix21 =Integer.parseInt(br.readLine());
				u4 = list.remove4(ix21);
				//System.out.println(ix21 + "REMOVED");
				System.out.println("/////////////////////////////////////////////////");
				System.out.printf("%35s",ix21 + "REMOVED");
				System.out.println();
				System.out.println("/////////////////////////////////////////////////");
				
				
				break;
			    
			    case 3:
			    	
				System.out.println("DISPLAYING INFO");
				System.out.println("**********************************************");
				System.out.printf("%1s %12s %15s %18s","INDEX","DATE","TIMINGS","VENUE");
				System.out.println();
				System.out.println("************************************************");
				for(Cookingclasses obj14 :u4)
				{
				  System.out.printf("%1s %12s %15s %18s",obj14.getIx2(),obj14.getDt2(),obj14.getTime2(),obj14.getVenue2());
				  System.out.println();
				}
				System.out.println("*******************************************************");
				break;
				
				case 4:
					
					return;
					
				}
				}
		
//************************************LIVE BANDS**************************************************//
		
		static List<Livebands> u5= new ArrayList<Livebands>();
		private static void bands()throws NumberFormatException,IOException 
		{
			Crud list = new Crud();
			Livebands obj5; int c6;
			BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
			 System.out.println("********************************************");
			   System.out.println("1.ADD LIVE BANDS DETAILS");
			   System.out.println("2.REMOVE LIVE BANDS DETAILS ");
			   System.out.println("3.DISPLAY LIVE BANDS DETAILS");
			   System.out.println("EXIT");
			   System.out.println("*********************************************");
			   System.out.println("ENTER YOUR CHOICE");
			   c6 = Integer.parseInt(br.readLine());
			switch(c6)
			{
			case 1:
				System.out.println("ENTER THE INDEX");
				int ix3 = Integer.parseInt(br.readLine());
				System.out.println("ENTER THE DATE");
				String dt3 = br.readLine();
				System.out.println("ENTER THE TIME");
				String time3 = br.readLine();
				System.out.println("ENTER THE VENUE");
				String venue3 = br.readLine();
				obj5 = new Livebands(ix3,dt3,time3,venue3);
				u5 = list.adddetails4(obj5);
				System.out.println("/////////////////////////////////////////////////");
				System.out.printf("%35s","ENTERED SUCCESSFULLY!!!");
				System.out.println();
				System.out.println("/////////////////////////////////////////////////");
			    break;
			    case 2:
				System.out.println("ENTER THE INDEX TO REMOVE");
				int ix31 = Integer.parseInt(br.readLine());
				u5 = list.remove5(ix31);
				System.out.println("/////////////////////////////////////////////////");
				System.out.printf("%35s",ix31+"REMOVED");
				System.out.println();
				System.out.println("/////////////////////////////////////////////////");
				//System.out.println(ix31+"REMOVED");
				break;
			    case 3:
				System.out.println("DISPLAYING INFO");
				System.out.println("**********************************************");
				System.out.printf("%1s %12s %15s %18s","INDEX","DATE","TIMINGS","VENUE");
				System.out.println();
				System.out.println("************************************************");
				for(Livebands obj15 :u5)
				{
				  System.out.printf("%1s %12s %15s %18s",obj15.getIx3(),obj15.getDt3(),obj15.getTime3(),obj15.getVenue3());
				  System.out.println();
				}
				System.out.println("*******************************************************");
				break;
				case 4:
				return;
					
			}
		}
}




/*Enter the user name and pwd
user="";
pwd="";
if(login.contains(id))
{
String pwd=login.getvalue(id);
   if(enteredpwd===pwd)
   {
   sys("you have login succhessful");
   }
 }
 else
 {
 sys("wrong email and pwd");
 }





























*/
 