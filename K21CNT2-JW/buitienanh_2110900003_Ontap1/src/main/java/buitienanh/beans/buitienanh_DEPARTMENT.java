package buitienanh.beans;

public class buitienanh_DEPARTMENT {

	private String DEPT_ID;
	private String DEPT_NAME;
	private String DEPT_NO;
	private String LOCATION;
	
	public buitienanh_DEPARTMENT() {
    	
    }
	
	public buitienanh_DEPARTMENT(String dEPT_ID, String dEPT_NAME, String dEPT_NO, String lOCATION) {
		super();
		DEPT_ID = dEPT_ID;
		DEPT_NAME = dEPT_NAME;
		DEPT_NO = dEPT_NO;
		LOCATION = lOCATION;
	}

	public String getDEPT_ID() {
		return DEPT_ID;
	}

	public void setDEPT_ID(String dEPT_ID) {
		DEPT_ID = dEPT_ID;
	}

	public String getDEPT_NAME() {
		return DEPT_NAME;
	}

	public void setDEPT_NAME(String dEPT_NAME) {
		DEPT_NAME = dEPT_NAME;
	}

	public String getDEPT_NO() {
		return DEPT_NO;
	}

	public void setDEPT_NO(String dEPT_NO) {
		DEPT_NO = dEPT_NO;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}
	
	
	
}
