package tool;

public class Mutter {
	private String id;
	private String data;
	private String hour;

	public Mutter(String id, String data, String hour) {
		this.id = id;
		this.data = data;
		this.hour = hour;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

}
