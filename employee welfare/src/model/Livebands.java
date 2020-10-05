package model;

public class Livebands {
	private int ix3;
	private String dt3;
	private String time3;
	private String venue3;
	public Livebands(int ix32, String dt32, String time32, String venue32) {
	this.ix3 = ix32;
	this.dt3 = dt32;
	this.time3 = time32;
	this.venue3 = venue32;
	}
	public String getDt3() {
		return dt3;
	}
	public void setDt3(String dt3) {
		this.dt3 = dt3;
	}
	public String getTime3() {
		return time3;
	}
	public void setTime3(String time3) {
		this.time3 = time3;
	}
	public String getVenue3() {
		return venue3;
	}
	public void setVenue3(String venue3) {
		this.venue3 = venue3;
	}
	
	public int getIx3() {
		return ix3;
	}
	public void setIx3(int ix3) {
		this.ix3 = ix3;
	}
	
	@Override
	public String toString() {
		return "Livebands [dt3=" + dt3 + ", time3=" + time3 + ", venue3=" + venue3 + ", ix3=" + ix3 +"]";
	}
}
