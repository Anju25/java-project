package dao;


import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map;
import java.util.List;

import model.Awards;
import model.Birthdaywishes;
import model.Conference;
import model.Cookingclasses;
import model.Employeedetails;
import model.Exhibition;
import model.Livebands;
import model.Photobooth;
import model.Reviews;
//import model.Product;
import model.Salarydetails;


public class Crud {
	
	static HashMap<String,Salarydetails> map1=new HashMap<String,Salarydetails>();//salarydetails
	static HashMap<String,Employeedetails> operations=new HashMap<String,Employeedetails>();//empmloyeedetailss//
	static ArrayList<Birthdaywishes> list=new ArrayList<Birthdaywishes>();
	
	 static HashMap<String,Conference> map = new HashMap<String,Conference>();
	 static List<Exhibition> u1 = new ArrayList<Exhibition>();
	 static List<Awards> u2 = new ArrayList<Awards>();
	 static List<Photobooth> u3 = new ArrayList<Photobooth>();
	 static List<Cookingclasses> u4 = new ArrayList<Cookingclasses>();
	 static List<Livebands> u5= new ArrayList<Livebands>();
	/*public ArrayList<Employeedetails> adddetails(Employeedetails obj) {
		details.add(obj);
		return details;
		
	}*/
	
	public HashMap<String, Employeedetails> put(String id1, Employeedetails obj) 
	{
		operations.put(id1,obj);
		return operations;
	}

	public HashMap<String, Employeedetails> remove(String empid) {
		operations.remove(empid);
		return operations;
	}

	public HashMap<String, Salarydetails> put(String empid, Salarydetails obj) {
		if(operations.size()<=0)
		{
			System.out.println("YOUR EMPLOYEE DETAIL'S LIST IS ZERO");
		}
		else
		{
		map1.put(empid,obj);
		}
		return map1;
	}
	
	public HashMap<String, Salarydetails> remove1(int empid) {
		map1.remove(empid);
		return map1;
	}

	public ArrayList<Birthdaywishes> add(Birthdaywishes obj1) {
		list.add(obj1);
		return list;
	}
	
	
	//******************************************************************//
public HashMap<String, Conference> put(String id1, Conference obj) {
		map.put(id1,obj);
		return map;
	}

	public HashMap<String, Conference> remove1(String meetid1) {
		map.remove(meetid1);
		return map;
	}
public List<Exhibition> adddetails(Exhibition obj1) {
		u1.add(obj1);
		return u1;
}


public List<Awards> adddetails1(Awards obj2) {
	u2.add(obj2);
	return u2;
}



public List<Photobooth> adddetails2(Photobooth obj3) {
	u3.add(obj3);
	return u3;
}

public List<Cookingclasses> adddetails3(Cookingclasses obj4) {
	u4.add(obj4);
	return u4;
}

public List<Livebands> adddetails4(Livebands obj5) {
	u5.add(obj5);
	return u5;
}

public List<Exhibition> remove11(int index21) {
	u1.remove(index21);
	return u1;
}

public List<Awards> remove2(int index31) {
	u2.remove(index31);
	return u2;
}

public List<Photobooth> remove3(int ix11) {
	u3.remove(ix11);
	return u3;
}

public List<Cookingclasses> remove4(int ix21) {
	// TODO Auto-generated method stub
	u4.remove(ix21);
	return u4;
}

public List<Livebands> remove5(int ix31) {
	// TODO Auto-generated method stub
	u5.remove(ix31);
	return u5;
}
List<Reviews> view = new ArrayList<Reviews>();
public List<Reviews> add(Reviews ab) {
	view.add(ab);
	return view;
}


}
	/*public Map<Integer, Employeedetails> remove(int empid) {
		String returned_value = (String)operations.remove(empid); 
		/*for(Map.Entry<Integer, Employeedetails> pair:operations.entrySet())
		{
			int key=pair.getKey();
			Employeedetails values=pair.getValue();
			System.out.println(values.getId());
			if(key==empid)
			{
				operations.remove(key);
				operations.remove(values);
			}
			return operations;
		}*/
		//operations.remove(empid);
		//return operations;
		//return returned_value;
		
	//}
	
			

