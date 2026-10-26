package Entity;

public abstract class Doctor{
	
	private String DoctorName;
	
	public Doctor(String DoctorName){
		this.DoctorName=DoctorName;
	}
	public void setDoctorName(String DoctorName){
		this.DoctorName=DoctorName;
	}
	public String getDoctorName(){
		return DoctorName;
	}
	public abstract void showService();
	
}