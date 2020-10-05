package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.Crud;

import java.util.TreeMap;

import model.Awards;
import model.Birthdaywishes;
import model.Conference;
import model.Cookingclasses;
import model.Employeedetails;
import model.Exhibition;
import model.Livebands;
import model.Photobooth;
import model.Reviews;
import model.Salarydetails;

public class Main 
{
	static ArrayList<Birthdaywishes> list=new ArrayList<Birthdaywishes>();
	static ArrayList<Reviews> reviews=new ArrayList<Reviews>();
	static HashMap<String,String> login=new HashMap<String ,String>();
	static List<Reviews> view = new ArrayList<Reviews>();
	
	public static void main(String args[]) throws NumberFormatException, IOException, ParseException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Crud obj=new Crud();
		int choice; int op; int option;
		String regexemail="^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+$";
		String regexpwd="^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,20}$";
	do {
		System.out.println("*****************************************");
		System.out.println("1.ADMIN PANEL");
		System.out.println("2.EMPLOYEE PANEL");
		System.out.println("*****************************************");
		System.out.println("Enter your choice");
		option=Integer.parseInt(br.readLine());
		switch(option)
		{
		case 1: 
		String username="admin";
		String pwd="admin";
		System.out.print("ENTER THE USERNAME:");
		String un=br.readLine();
		System.out.print("ENTER THE PASSWORD:");
		String pd=br.readLine();
		System.out.println();
		if(un.equals(username) && pd.equals(pwd))
		{
			System.out.println("///////////////////////////////////////////////////////////////////////////");
			System.out.printf("%50s","LOGIN SUCCESSFUL");
			System.out.println();
			System.out.println("////////////////////////////////////////////////////////////////////////////");
			admin();
		}
		else
		{
			System.out.println("/////////////////////////////////////////////////////////////////////////////");
			System.out.printf("%50s","CHECK YOUR USERNAME AND PASSWORD");
			System.out.println();
			System.out.println("/////////////////////////////////////////////////////////////////////////////");
		}
		break;
		case 2: 
			do{
			System.out.println("****************************************");
			System.out.println("1.NEW REGISTRATIONS");
		    System.out.println("2.LOGIN");
		    System.out.println("3.EXIT");
		    System.out.println("****************************************");
		    System.out.println("ENTER YOUR CHOICE");
		    op=Integer.parseInt(br.readLine());
		    switch(op)
		    {
		    case 1: 
		    	System.out.print("Enter the email id:");
		    	String email=br.readLine();
		    	Pattern p= Pattern.compile(regexemail);
				Matcher m=p.matcher(email);
		        System.out.print("Enter the password:");
		        String password=br.readLine();
		        Pattern p1=Pattern.compile(regexpwd);
				Matcher m1=p1.matcher(password);
				if(m.matches() && m1.matches())
				{
					login.put(email,password);
					System.out.println();
					System.out.println("///////////////////////////////////////////////////////////////////////////");
					System.out.printf("%50s","REGISTERED SUCCESSFULLY");
					System.out.println();
					System.out.println("///////////////////////////////////////////////////////////////////////////");
					 System.out.println();
				}
				else
				{
					System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
					System.out.printf("%30s","CHECK EMAIL-ID");
					System.out.println();
					System.out.printf("%30s","CHECK PASSWORD(must contains min 8 characters or max 20 characters and must include atleast one digits,specialchar,big letters,small letters,should not contain space)");
					System.out.println();
					System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
				    System.out.println();
				}
				break;
		    case 2: 
		    System.out.print("EMAIL-ID:");
		    String uemail=br.readLine();
		    System.out.print("PASSWORD:");
		    String upwd=br.readLine();
		    if(login.containsKey(uemail))
		    {
		    	String ue=login.get(uemail);
		    	if(ue.equals(upwd))
		    	{
		    		System.out.println();
		    		System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		    		System.out.printf("%50s","LOGIN SUCCESSFUL");
		    		System.out.println();
		    		System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		    		System.out.println();
		    		employee();
		    	}
		    	else
		    	{
		    		System.out.println();
			    	System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////");
		    		System.out.printf("%50s","CHECK YOUR PASSWORD");
		    		System.out.println();
		    		System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////");
		    		 System.out.println();
		    	}
		    }
		    else
		    {   System.out.println();
		    	System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////");
		    	System.out.printf("%50s","CHECK YOUR EMAIL ID");
		    	System.out.println();
		    	System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////");
		    	 System.out.println();
		    }
		       break;
		       default:System.out.println("wrong choice");
		 }
	 }while(op!=3);
	}
  }while(option !=3);
}

		
//************************************ADMIN PANEL**************************************//

private static void admin() throws NumberFormatException, IOException, ParseException 
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Crud obj=new Crud();
	int choice;
	do
	{
		System.out.println();
		System.out.println("*************************************");
		System.out.println("1.EMPLOYEE DETAILS");//1event
		System.out.println("2.EMPLOYEE WAGES");//2enter
		System.out.println("3.BIRTHDAY WISHES");
		System.out.println("4.REVIEWS OF EMPLOYEE'S");
		System.out.println("5.EXIT");
		System.out.println("*************************************");
	    System.out.println();
		System.out.println("ENTER YOUR CHOICE");
	    choice=Integer.parseInt(br.readLine());
	    int choice1,choice2,choice3;
		switch(choice)
		{
		case 1:
			
			do
			{
			   System.out.println();
			   System.out.println("*************************************");
			   System.out.println("1.NEW REGISTRATION");// ///CONFERENCE DTAILS 1.ADD 2.REMOVE 3DISPLAY
			   System.out.println("2.REMOVE THE REGISTRATION");//exhibi
			   System.out.println("3.UPDATE THE DETAILS");
		       System.out.println("4.VIEW THE DETAILS OF ALL EMPLOYEE'S");
		       System.out.println("5.SEARCH THE EMPLOYEE");
		      // System.out.println("6.SORTING BASED KEY VALUES");
		       System.out.println("6.EXIT");
		       System.out.println("*************************************");
		       System.out.println();
		       System.out.println("ENTER YOUR CHOICE");
		       choice1=Integer.parseInt(br.readLine());
		       employeedetails(choice1);
		     }while(choice1!=6);
			break;
			
		case 2:
			do
			{
			   System.out.println("*************************************");
			   System.out.println("1.ADD THE SALARY DETAILS");
			   System.out.println("2.REMOVE THE SALARY DETAILS");
		       System.out.println("3.VIEW THE SALARY DETAILS");
		       System.out.println("4.EXIT");
		       System.out.println("*************************************");
		       System.out.println();
		       System.out.println("ENTER YOUR CHOICE");
               choice2=Integer.parseInt(br.readLine());
               salary(choice2);
				
			}while(choice2!=4);
               break;
               
		case 3:
			System.out.println();
			System.out.println("*************************************");
			System.out.println("BIRTHDAY WISHES");
		    System.out.println("1.ADD THE WISHES");
		    //System.out.println("2.VIEW THE WISHES");
		    System.out.println("2.EXIT");
		    System.out.println("*************************************");
		    System.out.println();
		    System.out.println("ENTER YOUR CHOICE");
		    choice3=Integer.parseInt(br.readLine());
		    System.out.println();
		                       switch(choice3)
		                      {
		                      case 1:
		                    	  System.out.println("ENTER THE NAME:");
		                          String name=br.readLine();
		                          System.out.println("ENTER THE DATE:");
		                          String date=br.readLine();
		                          System.out.println("WISHES TO THE"+" "+name.toUpperCase()+":");
		                          String wishes=br.readLine();
		                          System.out.println("WISHES ADDED");
		                          Birthdaywishes obj1=new Birthdaywishes(wishes,name,date);
		                          list=obj.add(obj1);		
		                    	  Birthdaywishes n=new Birthdaywishes("Wishing you a great birthday and a memorable year.....","Mahesh","20-5-1999");
		                    	  list=obj.add(n);
		                    	  Birthdaywishes n1=new Birthdaywishes("Hoping your birthday brings you many happy reasons to celebrate!","Kavya","20-5-1995");
		                    	  list=obj.add(n1);
		                    	  Birthdaywishes n2=new Birthdaywishes("Wishing you the best on your birthday and everything good in the year ahead","Pavithra","20-5-1997");
		                    	  list=obj.add(n2);
		                    	  Birthdaywishes n3=new Birthdaywishes("Happy Birthday and all the best to you in the year to come","Ranjitha","20-5-1996");
		                    	  list=obj.add(n3);
		                    	  Birthdaywishes n4=new Birthdaywishes("Wishing you a relaxing birthday and happiness in the year to come.","Sagar","20-5-1999");
		                    	  list=obj.add(n4);
		                    	  Birthdaywishes n5=new Birthdaywishes("Wishing you a happy birthday, a wonderful year and success in all you do.","Veena","20-5-1998");
		                    	  list=obj.add(n5);
		                    	  Birthdaywishes n6=new Birthdaywishes("Happy Birthday and all the best to you in the year to come","Nayana","20-5-1999");
		                    	  list=obj.add(n6);
		                    	break;
		                      case 2:return;     
		                      }
		                      
		break;
        case 4:
        System.out.println();
        System.out.println("REVIEWS");
        System.out.println("------------------------------------------------------------------------------------------");
        //System.out.println("---------------------------------------------");
        Iterator<Reviews> itr=view.iterator();
        while(itr.hasNext())
        {
        	 Reviews objj=itr.next();
        	 System.out.println();
        	 System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
        	 System.out.println("EMPLOYEE NAME:"+" "+objj.getName());
        	 System.out.println("REVIEW"+" "+objj.getReview());
        	 System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
             System.out.println();
        }
        System.out.println("----------------------------------------------");
        System.out.println("----------------------------------------------");
               break;
		case 5:return;
		default:System.out.println("WRONG CHOICE");

		}
		
	}while(choice!=5);
}


//*********************************************ADMIN FUNCTION CALL-1***********************************************************//


static HashMap<String, Salarydetails> map1=new HashMap<String,Salarydetails>();
  private static void salary(int choice2) throws IOException, ParseException {
		Salarydetails obj;
		Crud list=new Crud();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		switch(choice2)
		{
		case 1:
			if(operations.size()==0)
			{
				System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		        System.out.printf("%70s","NO EMPLOYEE'S RECORDS TO ADD THE PAYROLL");
		        System.out.println();
		        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			}
			else
			{
		System.out.println("Enter the Employee id");
		String id=br.readLine();
		System.out.println("Enter the name");
		String name=br.readLine();
		System.out.println("Enter the date(dd-MM-YYYY)");
		String date=br.readLine();
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    LocalDate localdate=LocalDate.parse(date,format);
	    int year=localdate.getYear();
		Month month=localdate.getMonth();
		System.out.println("Enter the total earnings");
		int total=Integer.parseInt(br.readLine());
		System.out.println("Enter the deduction amount");
		int deductions=Integer.parseInt(br.readLine());
		int net=total-deductions;
		obj=new Salarydetails(id, name, month , year , total, deductions, net);
		map1=list.put(id, obj);
		 System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
	        System.out.printf("%70s","SALARY DETAILS ADDED SUCCESSFULLY");
	        System.out.println();
	        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			}
		break;
		case 2:
			if(map1.size()==0)
			{
				System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		        System.out.printf("%50s","NO RECORDS TO REMOVE");
		        System.out.println();
		        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			}
			else
			{
		    System.out.println("Enter the employee id to remove");
		    int empid=Integer.parseInt(br.readLine());
		    map1=list.remove1(empid);
		    System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
	        System.out.printf("%70s","PAYROLL REMOVED");
	        System.out.println();
	        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			}
	        break;
		case 3:
			System.out.println("EMPLOYEE PAYROLL");
			System.out.println("--------------------------------------------------------------------------");
			System.out.printf("%6s %8s %8s %6S %11S %8S %8S","NAME","EMPID","MONTH","YEAR","TOTAL-EARNINGS","DEDUCTIONS","NET-AMOUNT");
			System.out.println();
			System.out.println("--------------------------------------------------------------------------");
			for(Entry<String, Salarydetails> pair:map1.entrySet())
			{
				Salarydetails value=pair.getValue();
				System.out.printf("%6S %8S %6s %8s %8s %11s %11s",value.getName(),value.getEmpid(),value.getMonth(),value.getYear(),value.getTotalearning(),value.getDeductions(),value.getNetamount());
			    System.out.println();
			}
			System.out.println("------------------------------------------------------------------");
			System.out.println();
			break;
		case 4:return;
		default:System.out.println("wrong choice");
			}
		}
  
//************************************************ADMIN FUNCTION CALL-2*********************************************************//
  
        static HashMap<String, Employeedetails> operations=new HashMap<String,Employeedetails>();
		private static void employeedetails(int choice1) throws IOException 
		{
			Employeedetails obj;//CONFERENCE OBJ
			Crud list=new Crud(); int ch;
           BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           switch(choice1)
			{
			case 1:
			System.out.print("Enter the name:");
			String name1=br.readLine();
			System.out.print("Enter the qualification:");
			String qualification=br.readLine();
			System.out.print("Enter the id:");
			String id1=br.readLine();
			System.out.print("Enter the birthdate:");
			String date=br.readLine();
			System.out.print("Enter the Nationality:");
			String nation=br.readLine();
			System.out.print("Enter hte bloodgroup:");
			String bloodgroup=br.readLine();
			System.out.print("Enter the address:");
			String address=br.readLine();
			System.out.print("Enter the adharnumber:");
			String adharnumber=br.readLine();
			obj=new Employeedetails(name1, qualification, id1,date,nation,bloodgroup,address,adharnumber); //OBJ=NEW CONFER(------)
	        operations=(HashMap<String, Employeedetails>) list.put(id1,obj);
	        System.out.println();
	        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
	        System.out.printf("%70s","DETAILS ADDED SUCCESSFULLY");
	        System.out.println();
	        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			break;
			case 2:
				//System.out.println("size of employee"+operations.size());
				if(operations.size()<=0)
				{
				  System.out.println("NO RECORDS TO DELETE");
				}
				else
				{
				System.out.println("Enter the employee id to remove");
				String empid=br.readLine();
				operations=list.remove(empid);
				    System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			        System.out.printf("%70s","EMPLOYEE RECORD REMOVED SUCCESSFULLY");
			        System.out.println();
			        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			     }
			break;
			   case 3:
				  if(operations.size()==0)
				  {
					  System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
				        System.out.printf("%70s","NO EMPLOYEE RECORDS TO UPDATE");
				        System.out.println();
				        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
				  }
				  else
				  {
			    System.out.println();
			    System.out.println("*************************************");
				System.out.println("SELECT THE COLUMN WHICH YOU WANT TO UPDATE");
				System.out.println("1.ADDRESS");
				System.out.println("2.NAME");
				System.out.println("3.BIRTHDATE");
				System.out.println("*************************************");
			    System.out.println();
				System.out.println("ENTER THE CHOICE");
			     ch=Integer.parseInt(br.readLine());
				switch(ch)
				{
				case 1: System.out.println("Enter the new address");
				        String addr=br.readLine();
				        System.out.println("ENTER THE EMPLOYEE ID FOR MODIFICATION");
						String id02=br.readLine();
				        operations.get(id02).setPermanentaddress(addr);
				        break;
				case 2: System.out.println("Enter the name");
				        String name=br.readLine();
				        System.out.println("ENTER THE EMPLOYEE ID FOR MODIFICATION");
						String id01=br.readLine();
				        operations.get(id01).setName(name);
				        break;
				case 3: return;
				default:System.out.println("wrong choice");
				}
				 }
				   
			case 4:
				if(operations.size()<=0)
				{
					System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			        System.out.printf("%70s","NO RECORDS TO DELETE");
			        System.out.println();
			        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
				}
				else
				{
				System.out.println("EMPLOYEE DETAILS");
				System.out.println("----------------------------------------------------------------------------------------------------------");
				System.out.printf("%1s %11s %18s %15S %11S %13S %11S %12S","ID","NAME","QUALIFICATION","NATIONALITY","ADDRESS","BIRTHDATE","BLOODGROUP","ADHARNUMBER");
				System.out.println();
				System.out.println("----------------------------------------------------------------------------------------------------------");
				for(Entry<String, Employeedetails> pair:operations.entrySet())//FOR(I=0;i<n;i++)1to10 n=10
				{
					//System.out.println(pair.getKey());
					Employeedetails value=pair.getValue();
					System.out.printf("%1s %12s %11s %19S %14S %13S %7S %13S",value.getId(),value.getName(),value.getQualification(),value.getNationality(),value.getPermanentaddress(),value.getBirthdate(),value.getBloodgroup(),value.getAdharnumber());
					System.out.println();
				}
				System.out.println("-----------------------------------------------------------------------------------------------------------");
				}
				break;
			case 5: 
			if(operations.size()==0)
			{
				System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		        System.out.printf("%70s","NO RECORDS TO SEARCH");
		        System.out.println();
		        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			}
			else
			{
				System.out.println("ENTER THE EMPLOYEE ID TO SEARCH");
				String id=br.readLine();
				if(operations.containsKey(id))
				{
					Employeedetails value=operations.get(id);
					//System.out.println(object.getName());
					System.out.println("------------------------------------------------------------------------------------------------");
					System.out.printf("%1s %11s %18s %15S %11S %13S %11S %12S","ID","NAME","QUALIFICATION","NATIONALITY","ADDRESS","BIRTHDATE","BLOODGROUP","ADHARNUMBER");
					System.out.println();
					System.out.println("------------------------------------------------------------------------------------------------");
					System.out.printf("%1s %12s %11s %19S %14S %13S %7S %13S",value.getId(),value.getName(),value.getQualification(),value.getNationality(),value.getPermanentaddress(),value.getBirthdate(),value.getBloodgroup(),value.getAdharnumber());
					System.out.println("------------------------------------------------------------------------------------------------");
				}
				else
				{
					System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			        System.out.printf("%70s","CHECK EMPLOYEE ID");
			        System.out.println();
			        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
				}
			}
			break;
			//case 6:
				/*Map<String,Employeedetails> map = new TreeMap<String,Employeedetails>(operations); 
			       
				System.out.println("------------------------------------------------------------------------------------------------");
				System.out.printf("%1s %11s %18s %15S %11S %13S %11S %12S","ID","NAME","QUALIFICATION","NATIONALITY","ADDRESS","BIRTHDATE","BLOODGROUP","ADHARNUMBER");
				System.out.println();
				System.out.println("------------------------------------------------------------------------------------------------");
				for(Entry<String, Employeedetails> pair:map.entrySet())//FOR(I=0;i<n;i++)1to10 n=10
				{
					//System.out.println(pair.getKey());
					Employeedetails value=pair.getValue();
					System.out.printf("%1s %7s %10s %19S %15S %15S %7S %15S",value.getId(),value.getName(),value.getQualification(),value.getNationality(),value.getPermanentaddress(),value.getBirthdate(),value.getBloodgroup(),value.getAdharnumber());
					System.out.println();
				}
				System.out.println("------------------------------------------------------------------------------------------------");
			*/
		    case 6:return;
				
		   }
		}
		
	
//*******************************EMPLOYEE PANEL*****************************************************//

		private static void employee() throws NumberFormatException, IOException
{
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 int choice; int c1; int c2;  int choice1,choice2;
	 do
	   {
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
		     do 
		     {
		       System.out.println();
			   System.out.println("****************************************");
			   System.out.println("1.CONFERENCE");
			   System.out.println("2.EXHIBITION");
			   System.out.println("3.AWARDS");
			   System.out.println("4.BIRTHDAY WISHES");
			   System.out.println("5.EXIT");
		       System.out.println("****************************************");
		       System.out.println("ENTER YOUR CHOICE");
			   choice1 = Integer.parseInt(br.readLine());
		    switch(choice1)//1
			   {
			   case 1:conference();break;
			   case 2:exhibition();break;
               case 3:awards();break;
               case 4:birthdaywishes();break;
			   //case 4:return;
			   }   
		     }while(choice1!=5);
		       break;
            case 2:
			   do {
			   System.out.println("****************************************");
			   System.out.println("1.PHOTO BOOTH");
			   System.out.println("2.COOKING CLASSES");
			   System.out.println("3.LIVE BANDS");
			   System.out.println("4.EXIT");
		       System.out.println("****************************************");
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
			   //Crud list = new Crud();
			   Reviews ab;
			   System.out.println("ENTER EMPLOYEE NAME");
			   String employee_name = br.readLine();
			   System.out.println("ENTER EMPLOYEE REVIEWS");
			   String employee_reviews = br.readLine();
			   ab = new Reviews(employee_name,employee_reviews);
			   view.add(ab);
			   System.out.println("REVIEW ADDED SUCCESFULLY");
			   Reviews r1=new Reviews("Mahesh","Overall it is nice experience,great learning skills");
			   view.add(r1);
			   Reviews r2=new Reviews("Ranjitha","Nice working culture,great platform for freshers");
			   view.add(r2);
			   Reviews r3=new Reviews("Sagar","Stress full work");
			   view.add(r3);
			   Reviews r4=new Reviews("veena","good,nice experience,nice environment");
			   view.add(r4);
			   Reviews r5=new Reviews("Nayana","sometimes i feel stressful ,but all other work experience is good");
			   view.add(r5);
			   //view = list.add(ab);
			   break;
			   case 4 :return;
			  }
	   }while(choice!=4);
			   
	}

//********************************BIRTHDAY WISHES******************************************************//
private static void birthdaywishes()
{
System.out.println("WISHES");
System.out.println("---------------------------------------------");
System.out.println("---------------------------------------------");
Iterator<Birthdaywishes> itr=list.iterator();
while(itr.hasNext())
{
	 Birthdaywishes obj=itr.next();
	 System.out.println();
	 System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
	 System.out.println(obj.getName());
	 System.out.println(obj.getDate());
	 System.out.println(obj.getWishes());
	 System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
     System.out.println();
}
System.out.println("----------------------------------------------");
System.out.println("----------------------------------------------");
}
/*for(Birthdaywishes ob: list)
{
	 System.out.println("/////////////////////////////////////////");
	 System.out.println(ob.getName());
	 System.out.println(ob.getDate());
	 System.out.println(ob.getWishes());
	 System.out.println("/////////////////////////////////////////");
}
System.out.println("----------------------------------------------");
}*/

//************************CONFERENCE FUNCTION CALL****************************************//
static HashMap<String,Conference> map = new HashMap<String,Conference>();		   
private static void conference()throws IOException {
Conference obj;
Crud list = new Crud(); int c1;
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
do {
System.out.println();
System.out.println("*************************************");
System.out.println("1.ADD CONFERENCE DETAILS");
System.out.println("2.REMOVE CONFERENCE DETAILS");
System.out.println("3.DISPLAY CONFERENCE DETAILS");
System.out.println("4.EXIT");
System.out.println("*************************************");
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
	System.out.println("//////////////////////////////////////////////////////////////////////////////////");
	System.out.printf("%35s","ENTERED SUCCESSFULLY!!!");
	System.out.println();
	System.out.println("//////////////////////////////////////////////////////////////////////////////////");
break;
case 2:
	System.out.println("ENTER THE ID TO REMOVE");
	String meetid1 =br.readLine();
	map = list.remove1(meetid1);
	System.out.println("//////////////////////////////////////////////////////////////////////////////////");
	System.out.printf("%35s","MEETING ID"+meetid1+"  "+"REMOVED");
	System.out.println();
	System.out.println("//////////////////////////////////////////////////////////////////////////////////");
	break;
case 3:
System.out.println("DISPLAYING INFO");
System.out.println("**********************************************");
System.out.printf("%1s %9s %12s %15s","ID","NAME","DATE","TIMINGS");
System.out.println();
System.out.println("**********************************************");
for(Entry<String,Conference> pair: map.entrySet())
{
  Conference value = pair.getValue();	
  System.out.printf("%1s %11s %12s %15s",value.getId1(),value.getName1(),value.getDate1(),value.getTimings1());
  System.out.println();
}
System.out.println("**********************************************");
break;
case 4:return;
}
}while(c1!=4); //4==4;//true 4!=4//fail  1!=4==true  2!=4 3!4 4
}

//*******************************EXHIBITION FUNCTION CALL*******************************************//

static List<Exhibition> u1 = new ArrayList<Exhibition>();
private static void exhibition()throws NumberFormatException,IOException
{
	Crud list = new Crud(); int c2;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Exhibition obj1;
do {
	System.out.println();
       System.out.println("***************************************");
       System.out.println("1.ADD EXHIBITION DETAILS");
	   System.out.println("2.REMOVE EXHIBITION DETAILS");
	   System.out.println("3.DISPLAY EXHIBITION DETAILS ");
	   System.out.println("4.EXIT");
	   System.out.println("***************************************");
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
	System.out.println("/////////////////////////////////////////////////////////////////////");
	System.out.printf("%35s","ENTERED SUCCESSFULLY!!!");
	System.out.println();
	System.out.println("/////////////////////////////////////////////////////////////////////");
	break;
	case 2:
		System.out.println("ENTER THE INDEX TO REMOVE");
		int index21 = Integer.parseInt(br.readLine());
		u1 = list.remove11(index21);
		System.out.println("/////////////////////////////////////////////////////////////////");
		System.out.printf("%35s","MEETING ID"+index21+" "+"REMOVED");
		System.out.println();
		System.out.println("/////////////////////////////////////////////////////////////////");
		break;
    case 3:
		System.out.println("DISPLAYING INFO");
		System.out.println("**************************************************************");
		System.out.printf("%1s %12s %15s %18s","INDEX","NAME","DATE","TIMINGS");
		System.out.println();
		System.out.println("**************************************************************");
		for(Exhibition obj11 :u1)
		{
		  System.out.printf("%1s %18s %15s %18s",obj11.getIndex2(),obj11.getName2(),obj11.getDate2(),obj11.getTimings2());
		  System.out.println();
		}
		System.out.println("**************************************************************");
		break;
		case 4:return;
		  }
}while(c2!=4);
		}

//******************************AWARDS FUNCTION CALL****************************//
	
static List<Awards> u2 = new ArrayList<Awards>();
private static void awards()throws NumberFormatException,IOException 
{
	Crud list = new Crud(); int c3;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Awards obj2;
	do {
		System.out.println();
       System.out.println("********************************************");
	   System.out.println("1.ADD AWARDS DETAILS");
	   System.out.println("2.REMOVE AWARDS DETAILS ");
	   System.out.println("3.DISPLAY AWARDS DETAILS");
	   System.out.println("4.EXIT");
	   System.out.println("********************************************");
	   System.out.println("ENTER YOUR CHOICE");
	    c3 = Integer.parseInt(br.readLine());
	switch(c3) 
	{
	case 1:
	System.out.println("ENTER THE INDEX");
	int index3 = Integer.parseInt(br.readLine());
	System.out.println("ENTER THE AWARD NAME");
	String name3 = br.readLine();
	System.out.println("ENTER THE AWARD WINNER NAME");
	String date3 = br.readLine();
	System.out.println("ENTER THE EMPID");
	String timings3 = br.readLine();
	obj2 = new Awards(index3,name3,date3,timings3);
	u2 = list.adddetails1(obj2);
	System.out.println("////////////////////////////////////////////////////////////////////////////");
	System.out.printf("%35s","ENTERED SUCCESSFULLY!!!");
	System.out.println();
	System.out.println("////////////////////////////////////////////////////////////////////////////");
	break;
	case 2:
	System.out.println("ENTER THE INDEX TO REMOVE");
	int index31 = Integer.parseInt(br.readLine());
	u2 = list.remove2(index31);
	System.out.println("////////////////////////////////////////////////////////////////////////////");
	System.out.printf("%35s","MEETING ID"+index31+" "+"REMOVED");
	System.out.println();
	System.out.println("////////////////////////////////////////////////////////////////////////////");
	break;
	case 3:
		System.out.println("DISPLAYING INFO");
		System.out.println("***************************************************");
		System.out.printf("%1s %12s %13s","AWARAD-NAME","WINNER-NAME","EMPID");
		System.out.println();
		System.out.println("***************************************************");
		for(Awards obj12 :u2)
		{
		  System.out.printf("%1s %14s %15s",obj12.getName3(),obj12.getDate3(),obj12.getTimings3());
		  System.out.println();
		}
		System.out.println("***************************************************");
		break;
		case 4:return;
		}
	}while(c3!=4);
}
//*********************************PHOTO BOOTH***********************//
	
static List<Photobooth> u3 = new ArrayList<Photobooth>();	
private static void photo()throws NumberFormatException,IOException {
	Crud list = new Crud();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Photobooth obj3; int c4;
	do {
		System.out.println();
	   System.out.println("*************************************");
	   System.out.println("1.ADD PHOTO BOOTH DETAILS");
	   System.out.println("2.REMOVE PHOTO BOOTH DETAILS");
	   System.out.println("3.DISPLAY PHOTO BOOTH  DETAILS");
	   System.out.println("4.EXIT");
	   System.out.println("*************************************");
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
		System.out.println("/////////////////////////////////////////////////////////////////////");
		System.out.printf("%35s","ENTERED SUCCESSFULLY!!!");
		System.out.println();
		System.out.println("/////////////////////////////////////////////////////////////////////");
	    break;
    case 2:
		System.out.println("ENTER THE INDEX TO REMOVE");
		int ix11 = Integer.parseInt(br.readLine());
		u3 = list.remove3(ix11);
		System.out.println("////////////////////////////////////////////////////////////////////");
		System.out.printf("%35s","MEETING ID"+ix11+" "+"REMOVED");
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////////////////");
	    break;
		
	case 3:
		System.out.println("DISPLAYING INFO");
		System.out.println("*****************************************************");
		System.out.printf("%1s %12s %15s %18s","INDEX","DATE","TIMINGS","VENUE");
		System.out.println();
		System.out.println("*****************************************************");
		for(Photobooth obj13 :u3)
		{
		  System.out.printf("%1s %12s %15s %18s",obj13.getIx1(),obj13.getDt1(),obj13.getTime1(),obj13.getVenue1());
		  System.out.println();
		}
		System.out.println("*******************************************************");
		break;
		case 4:return;
			}
	}while(c4!=4);
		}
//************************COOKING CLASSES*******************************************//

static List<Cookingclasses> u4 = new ArrayList<Cookingclasses>();	
private static void cooking()throws NumberFormatException,IOException {
	Crud list = new Crud(); 
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Cookingclasses obj4; int c5;
	do {
		System.out.println();
	   System.out.println("***************************************");
	   System.out.println("1.ADD COOKING CLASSES DETAILS");
	   System.out.println("2.REMOVE COOKING CLASSES DETAILS");
	   System.out.println("3.DISPLAY COOKING CLASSES DETAILS ");
	   System.out.println("4.EXIT");
	   System.out.println("***************************************");
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
		System.out.println("/////////////////////////////////////////////////////////////////////");
		System.out.printf("%35s","ENTERED SUCCESSFULLY!!!");
		System.out.println();
		System.out.println("/////////////////////////////////////////////////////////////////////");
	    break;
	    
	case 2:
		
		System.out.println("ENTER THE INDEX TO REMOVE");
		int ix21 =Integer.parseInt(br.readLine());
		u4 = list.remove4(ix21);
		System.out.println("////////////////////////////////////////////////////////////////////");
		System.out.printf("%35s","MEETING ID"+ix21+" "+"REMOVED");
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////////////////");
		break;
	    
	    case 3:
	    	
		System.out.println("DISPLAYING INFO");
		System.out.println("**********************************************");
		System.out.printf("%1s %12s %15s %18s","INDEX","DATE","TIMINGS","VENUE");
		System.out.println();
		System.out.println("**********************************************");
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
	}while(c5!=4);
		}
	//*****************************LIVE BANDS****************************//
static List<Livebands> u5= new ArrayList<Livebands>();
private static void bands()throws NumberFormatException,IOException 
{
	Crud list = new Crud();
	Livebands obj5; int c6;
	BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
	
	   System.out.println();
	   System.out.println("********************************************");
	   System.out.println("1.ADD LIVE BANDS DETAILS");
	   System.out.println("2.REMOVE LIVE BANDS DETAILS ");
	   System.out.println("3.DISPLAY LIVE BANDS DETAILS");
	   System.out.println("EXIT");
	   System.out.println("********************************************");
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
		System.out.println("/////////////////////////////////////////////////////////////////////");
		System.out.printf("%35s","ENTERED SUCCESSFULLY!!!");
		System.out.println();
		System.out.println("/////////////////////////////////////////////////////////////////////");
	    break;
	    
	case 2:
		System.out.println("ENTER THE INDEX TO REMOVE");
		int ix31 = Integer.parseInt(br.readLine());
		u5 = list.remove5(ix31);
		System.out.println("////////////////////////////////////////////////////////////////////");
		System.out.printf("%35s","MEETING ID"+ix31+" "+"REMOVED");
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////////////////");
		break;
	    
	    
	    
		
	case 3:
		System.out.println("DISPLAYING INFO");
		System.out.println("************************************************");
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

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*String pattern="dd-mm-yyyy";
		DateTimeFormatter format=DateTimeFormatter.ofPattern(pattern);
		LocalDate birthdate;
		String emp="EMP"; int inc=101;
	    String id;
	    Employeedetails obj1;
		
		
		System.out.println("------------------------");
		System.out.println("ADMIN PANEL");
		System.out.println();
		System.out.println("------------------------");
		//int choice=1;
		System.out.println("ENTER YOUR CHOICE");
		System.out.println("1.NEW REGISTRATION");
		System.out.println("2.VIEW THE EMPLOYEE DETAILS");
		System.out.println("3.UPDATE THE DETAILS");
		System.out.println("4.DELETE THE EMPLOYEE DETAILS");
		//System.out.println("5.VIEW THE WORK EXPERIENCE");
		//System.out.println("5.EXIT");
		int choice = Integer.parseInt(br.readLine());
		switch(choice)
		{
		case 1:
		System.out.println("ENTER THE EMPLOYEE DETAILS");
		System.out.print("Enter the name:");
		String name1=br.readLine();
		System.out.println("Enter the qualification");
		String qualification=br.readLine();
		System.out.println("Enter the age");
		int age1=Integer.parseInt(br.readLine());
		System.out.println("Enter the birthdate(DD-MM-YYYY)");
		String date=br.readLine();
		//birthdate=LocalDate.parse(date,format);
		System.out.println("Enter the bloodgroup");
		String bloodgroup=br.readLine();
		System.out.println("Enter the nationality");
		String nationality=br.readLine();
		System.out.println("Entre the address");
		String permanentaddress=br.readLine();
		System.out.println("Enter the adhar number");
		String adharnumber=br.readLine();
		System.out.println("Enter the passport number");
		String passportnumber=br.readLine();
		id=emp+inc++;
		obj1=new Employeedetails(name1, id, age1, date, nationality, bloodgroup, qualification, permanentaddress, passportnumber, adharnumber);
		details.add(obj1);
		operations.put(id, obj1);
		break;
		
		case 2: System.out.println("EMPLOYEE DETAILS");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.printf("%6s %6s %6s %6s %6s %6s","EMPLOYEE-ID","NAME","AGE","BIRTHDATE","NATIONALITY","BLOODGROUP");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------");
		details.forEach((element)->System.out.println(element));
		
		/*for(Employeedetails obj:details)
		{
			System.out.format("%6s %6s %6s %6 %6s %6s",obj.getId(),obj.getName(),obj.getAge(),obj.getBirthdate(),obj.getNationality(),obj.getBirthdate());
		   System.out.println();
		}
		System.out.println("--------------------------------------");*/
		/*break;
		
		case 4:System.out.println("ENTER THE ID OF EMPLOYEE TO REMOVE");
		String id1=br.readLine();
		operations.remove(id1);
		break;*/
		
	//}


	
/*	do
{
	System.out.println();
	System.out.println("*************************************");
	System.out.println("1.EMPLOYEE DETAILS");//1event
	System.out.println("2.EMPLOYEE WAGES");//2enter
	System.out.println("3.BIRTHDAY WISHES");
	System.out.println("4.REVIEWS OF EMPLOYEE'S");
	System.out.println("5.EXIT");
	System.out.println("*************************************");
    System.out.println();
	System.out.println("ENTER YOUR CHOICE");
    choice=Integer.parseInt(br.readLine());
    int choice1,choice2,choice3;
	switch(choice)
	{
	case 1:
		
		do
		{
		   System.out.println();
		   System.out.println("*************************************");
		   System.out.println("1.NEW REGISTRATION");// ///CONFERENCE DTAILS 1.ADD 2.REMOVE 3DISPLAY
		   System.out.println("2.REMOVE THE REGISTRATION");//exhibi
		   System.out.println("3.UPDATE THE DETAILS");
	       System.out.println("4.VIEW THE DETAILS OF ALL EMPLOYEE'S");
	       System.out.println("5.SEARCH THE EMPLOYEE");
	       System.out.println("6.SORTING BASED KEY VALUES");
	       System.out.println("7.EXIT");
	       System.out.println("*************************************");
	       System.out.println();
	       System.out.println("ENTER YOUR CHOICE");
	       choice1=Integer.parseInt(br.readLine());
	       employeedetails(choice1);
	     }while(choice1!=7);
		break;
		
	case 2:
		do
		{
		   System.out.println("*************************************");
		   System.out.println("1.ADD THE SALARY DETAILS");
		   System.out.println("2.REMOVE THE SALARY DETAILS");
	       System.out.println("3.VIEW THE SALARY DETAILS");
	       System.out.println("4.EXIT");
	       System.out.println("*************************************");
	       System.out.println();
	       System.out.println("ENTER YOUR CHOICE");
           choice2=Integer.parseInt(br.readLine());
           salary(choice2);
			
		}while(choice2!=4);
           break;
           
	case 3:
		System.out.println();
		System.out.println("*************************************");
		System.out.println("BIRTHDAY WISHES");
	    System.out.println("1.ADD THE WISHES");
	    System.out.println("2.VIEW THE WISHES");
	    System.out.println("3.EXIT");
	    System.out.println("*************************************");
	    System.out.println();
	    System.out.println("ENTER YOUR CHOICE");
	    choice3=Integer.parseInt(br.readLine());
	    System.out.println();
	                       switch(choice3)
	                      {
	                      case 1:System.out.println("Enter the Name");
	                             String name=br.readLine();
	                             System.out.println("Enter the date");
	                             String date=br.readLine();
	                             System.out.println("Wishes to the"+" "+name);
	                             String wishes=br.readLine();
	                             Birthdaywishes obj1=new Birthdaywishes(wishes,name,date);
	                             list=obj.add(obj1);		
	                             System.out.println("WISHES ADDED");
	                             break;
	                      case 2:System.out.println("WISHES");
	                             System.out.println("------------------------------");
	                             for(Birthdaywishes ob: list)
	                             {
	                            	 System.out.println(ob.getName());
	                            	 System.out.println(ob.getDate());
	                            	 System.out.println(ob.getWishes());
	                             }
	                             System.out.println("-------------------------------");
	                             break;
	                      case 3:return;     
	                      }
	                      
	break;
    case 4:System.out.println("REVIEWS");
         // review.add()
          // Reviews obj3;
           break;
	case 5: return;
	//default:System.out.println("WRONG CHOICE");

	}
	
}while(choice!=5);

}*/
