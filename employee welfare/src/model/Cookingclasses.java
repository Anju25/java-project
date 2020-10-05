package model;

public class Cookingclasses {
	private int ix2;
	private String dt2;
	private String time2;
	private String venue2;
	public String getDt2() {
		return dt2;
	}
	public void setDt2(String dt2) {
		this.dt2 = dt2;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public String getVenue2() {
		return venue2;
	}
	public void setVenue2(String venue2) {
		this.venue2 = venue2;
	}
	
	public int getIx2() {
		return ix2;
	}
	public void setIx2(int ix2) {
		this.ix2 = ix2;
	}

	public Cookingclasses(int ix22, String dt22, String time22, String venue22) {
		this.ix2 = ix22;
		this.dt2 = dt22;
		this.time2 = time22;
		this.venue2 = venue22;
	}
	@Override
	public String toString() {
		return "Cookingclasses [dt2=" + dt2 + ", time2=" + time2 + ", venue2=" + venue2 + ", ix2=" + ix2 +"]";
	}
	}
