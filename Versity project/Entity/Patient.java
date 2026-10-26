
package Entity;

public class Patient extends Doctor {
    private String patientId;
    private String patientName;
    //private int age;
    private float age;
    private float weight;
    private String sex;

    public Patient(String DoctorName, String patientId, String patientName, float age, float weight, String sex) {
        super(DoctorName);
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.weight = weight;
        this.sex = sex;
    }

    public void setPatientId(String patientId){
      this.patientId = patientId; 
    }
    public String getPatientId(){
      return patientId; 
    }
    public void setPatientName(String patientName){
      this.patientName = patientName; 
    }
    public String getPatientName(){
     return patientName; 
    }

    public void setAge(float age){
      this.age = age; 
    }
    public float getAge(){ 
     return age; 
    }

    public void setWeight(float weight){
      this.weight = weight; 
    }
    public float getWeight(){
     return weight; 
    }
    public void setSex(String sex){ 
     this.sex = sex; 
    }
    public String getSex(){
     return sex; 
    }

    @Override
    public void showService() {
        System.out.println("Doctor Name: " + getDoctorName());
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Id: " + patientId);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight);
        System.out.println("Sex: " + sex);
    }
}
