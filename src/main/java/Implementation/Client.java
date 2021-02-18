package Implementation;

public class Client {
	
	private int nrClient;
	private int arrivingTime;
	private int serviceTime;
	
	public Client(int n1, int a1, int s1) {
		this.nrClient = n1;
		this.arrivingTime = a1;
		this.serviceTime = s1;
	}

	public int getNrClient() {
		return nrClient;
	}

	public void setNrClient(int nrClient) {
		this.nrClient = nrClient;
	}

	public int getArrivingTime() {
		return arrivingTime;
	}

	public void setArrivingTime(int arrivingTime) {
		this.arrivingTime = arrivingTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	
	public String toString()
    {
		String s="";
        s = Integer.toString(this.nrClient);
        return s;
    }
	

}
