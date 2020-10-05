package model;

public class Reviews 
{
	private String name;
	private  String review;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Reviews(String name, String review) {
		super();
		this.name = name;
		this.review = review;
	}
	

}
