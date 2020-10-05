package model;

public class Conference {
private String id1;
private String name1;
private String date1;
private String timings1;
public String getId1() {
	return id1;
}
public void setId1(String id1) {
	this.id1 = id1;
}
public String getName1() {
	return name1;
}
public void setName1(String name1) {
	this.name1 = name1;
}
public String getDate1() {
	return date1;
}
public void setDate1(String date1) {
	this.date1 = date1;
}
public String getTimings1() {
	return timings1;
}
public void setTimings1(String timings1) {
	this.timings1 = timings1;
}
public Conference(String id1, String name1, String date1, String timings1) {
	super();
	this.id1 = id1;
	this.name1 = name1;
	this.date1 = date1;
	this.timings1 = timings1;
}
@Override
public String toString() {
	return "Conference [id1=" + id1 + ", name1=" + name1 + ", date1=" + date1 + ", timings1=" + timings1 + "]";
}
}
