package model;

public class Birthdaywishes {
	private String wishes;
	private String date;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWishes() {
		return wishes;
	}
	public void setWishes(String Wishes) {
		this.wishes = Wishes;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Birthdaywishes(String  wishes, String name,String date) {
		super();
		this.wishes = wishes;
		this.name=name;
		this.date = date;
	}
	

}
