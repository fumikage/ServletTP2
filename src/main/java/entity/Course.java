package entity;

public class Course {

	private String title;
	
	private double price;
	
	
	public Course(String title, double price) {
		this.title = title;
		this.price = price;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	@Override
	public String toString() {
		return this.title + " " + this.price;
	}
	
	
	
}
