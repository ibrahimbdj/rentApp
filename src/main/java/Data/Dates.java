package Data;

public class Dates {
	public String begin;
	public String end;
	
	
	public String getBegin() {
		return begin;
	}



	public void setBegin(String begin) {
		this.begin = begin;
	}



	public String getEnd() {
		return end;
	}


	public void setEnd(String end) {
		this.end = end;
	}


	@Override
    public String toString() {
        return "Dates{" +
                "begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
