
package Entity;

public class Service extends Patient {
    private String serviceName;
    private float cost;
    private String serviceType;

    public Service(String DoctorName, String patientId, String patientName, float age, float weight, String sex,
                   String serviceName, float cost, String serviceType) {
        super(DoctorName, patientId, patientName, age, weight, sex);
         this.serviceName = serviceName; 
         this.cost = cost; 
         this.serviceType = serviceType; 
    }

    public void setServiceName(String serviceName){
		 this.serviceName = serviceName; 
	}
    public String getServiceName() {
	 return serviceName; 
	}

    public void setCost(float cost){
	 this.cost = cost; 
	}
    public float getCost(){ 
	 return cost; 
	}
    public void setServiceType(String serviceType){
	 this.serviceType = serviceType; 
	}
    public String getServiceType(){ 
	 return serviceType; 
	}

    public String getServiceDetails() {
        return getDoctorName() + "~" + getPatientId() + "~" + getPatientName() + "~" + getAge() + "~" +
               getWeight() + "~" + getSex() + "~" + getServiceName() + "~" + getCost() + "~" + getServiceType();
    }

    @Override
    public void showService() {
        super.showService();
        System.out.println("ServiceName: " + serviceName);
        System.out.println("Cost: " + cost);
        System.out.println("ServiceType: " + serviceType);
    }
}
