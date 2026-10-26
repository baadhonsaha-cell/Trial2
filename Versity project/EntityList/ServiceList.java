package EntityList;

import Entity.Service;

public class ServiceList{
	
	int size;
	private Service[] s;
	
	public ServiceList(int x){
		s=new Service[x];
		this.size=x;
	}
    public int getSize(){
		return size;
	}

	public void insert(Service service){
		boolean idtaken=false;
		for(int i=0;i<s.length;i++){
			if(s[i]!=null){
				if(s[i].getPatientId().equals((service.getPatientId()))){
					idtaken=true;
					break;
				}
			}
		}
		if(!idtaken){
			for(int i=0;i<s.length;i++){
				if(s[i]==null){
					s[i]=service;
					System.out.println("Inserted successfully");
					break;
				}
			}
		}
		else{
			System.out.println(service.getPatientId()+" already taken");
		}
	}

	public Service get(int x){  
		return s[x];
	}

	public void delete(String id){
		boolean flag=false;
		for(int i=0;i<s.length;i++){
			if(s[i]!=null){
				if(s[i].getPatientId().equals(id)){
					System.out.println("deleted successfully");
					s[i]=null;
					flag=true;
					break;
				}
			}
		}
		if(!flag){
			System.out.println("Id not matched");
		}
	}
	public Service update(String id){
		Service service =null;
		for(int i=0;i<s.length;i++){
			if(s[i]!=null){
				if(s[i].getPatientId().equals(id)){
					service=s[i];
					break;
				}
			}
		}
		return service;
	}
	public void showAll(){
		for(int i=0;i<s.length;i++){
			if(s[i]!=null){
				System.out.println("---------------------------");
				s[i].showService();;
				System.out.println("---------------------------");
			}
		}
	}
}
