package model;

public class Exhibition {
	private int index2;
	private String name2;
	private String date2;
	private String timings2;
	public Exhibition(int index22, String name22, String date22, String timings22) {
		this.index2 = index22;
		this.name2 = name22;
		this.date2 = date22;
		this.timings2 = timings22;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public String getTimings2() {
		return timings2;
	}
	public void setTimings2(String timings2) {
		this.timings2 = timings2;
	}
	
	public int getIndex2() {
		return index2;
	}
	public void setIndex2(int index2) {
		this.index2 = index2;
	}
	
	@Override
	public String toString() {
		return "Exhibition [name2=" + name2 + ", date2=" + date2 + ", timings2=" + timings2 + ",index2=" + index2 +"]";
	}
}
