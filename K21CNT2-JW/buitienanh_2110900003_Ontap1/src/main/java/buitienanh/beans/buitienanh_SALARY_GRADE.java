package buitienanh.beans;

public class buitienanh_SALARY_GRADE {

	private String GRADE;
	private String HIGH_SALARY;
	private String LOW_SALARY;
	
	public buitienanh_SALARY_GRADE() {
   	
    }

	public buitienanh_SALARY_GRADE(String gRADE, String hIGH_SALARY, String lOW_SALARY) {
		super();
		GRADE = gRADE;
		HIGH_SALARY = hIGH_SALARY;
		LOW_SALARY = lOW_SALARY;
	}

	public String getGRADE() {
		return GRADE;
	}

	public void setGRADE(String gRADE) {
		GRADE = gRADE;
	}

	public String getHIGH_SALARY() {
		return HIGH_SALARY;
	}

	public void setHIGH_SALARY(String hIGH_SALARY) {
		HIGH_SALARY = hIGH_SALARY;
	}

	public String getLOW_SALARY() {
		return LOW_SALARY;
	}

	public void setLOW_SALARY(String lOW_SALARY) {
		LOW_SALARY = lOW_SALARY;
	}

	
}
