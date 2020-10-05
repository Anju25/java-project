package model;

public class Awards 
{
	private int index3;
	private String name3;
	private String date3;
	private String timings3;
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public String getDate3() {
		return date3;
	}
	public void setDate3(String date3) {
		this.date3 = date3;
	}
	public String getTimings3() {
		return timings3;
	}
	public void setTimings3(String timings3) {
		this.timings3 = timings3;
	}
	
	public int getIndex3() {
		return index3;
	}
	public void setIndex3(int index3) {
		this.index3 = index3;
	}
	
	public Awards(int index32, String name32, String date32, String timings32) {
		this.index3 = index32;
		this.name3 = name32;
		this.date3 = date32;
		this.timings3 = timings32;
		
	}
	@Override
	public String toString() {
		return "Awards [name3=" + name3 + ", date3=" + date3 + ", timings3=" + timings3 + ", index3=" + index3 +"]";
	}
}

