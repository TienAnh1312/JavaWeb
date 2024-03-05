package buitienanh.beans;

public class buitienanh_TIMEKEEPER {

	private String Timekeeper_Id;
	private String Date_Time;
	private String In_Out;
	private String EMP_ID;
	
	
	public buitienanh_TIMEKEEPER() {

    }

	public buitienanh_TIMEKEEPER(String timekeeper_Id, String date_Time, String in_Out, String eMP_ID) {
		super();
		Timekeeper_Id = timekeeper_Id;
		Date_Time = date_Time;
		In_Out = in_Out;
		EMP_ID = eMP_ID;
	}

	public String getTimekeeper_Id() {
		return Timekeeper_Id;
	}

	public void setTimekeeper_Id(String timekeeper_Id) {
		Timekeeper_Id = timekeeper_Id;
	}

	public String getDate_Time() {
		return Date_Time;
	}

	public void setDate_Time(String date_Time) {
		Date_Time = date_Time;
	}

	public String getIn_Out() {
		return In_Out;
	}

	public void setIn_Out(String in_Out) {
		In_Out = in_Out;
	}

	public String getEMP_ID() {
		return EMP_ID;
	}

	public void setEMP_ID(String eMP_ID) {
		EMP_ID = eMP_ID;
	}

	
	
}
