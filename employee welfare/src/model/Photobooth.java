package model;

public class Photobooth {
	private int ix1;
	private String dt1;
	private String time1;
	private String venue1;
	public String getDt1() {
		return dt1;
	}
	public void setDt1(String dt1) {
		this.dt1 = dt1;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getVenue1() {
		return venue1;
	}
	public void setVenue1(String venue1) {
		this.venue1 = venue1;
	}
	
	public int getIx1() {
		return ix1;
	}
	public void setIx1(int ix1) {
		this.ix1 = ix1;
	}
	public Photobooth(int ix1,String dt1, String time1, String venue1) {
		super();
		this.ix1 = ix1;
		this.dt1 = dt1;
		this.time1 = time1;
		this.venue1 = venue1;
		
	}
	@Override
	public String toString() {
		return "Photobooth [dt1=" + dt1 + ", time1=" + time1 + ", venue1=" + venue1 + ", ix1=" + ix1 + "]";
	}
}
