package Data;

public class Car {
	public String plateNumber;
	public String brand;
	public int price;
	public boolean free;
	
	public Car() {
		plateNumber = "A278ER";
		brand = "ferrari";
		price = 1500;
		free = true;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}
}
