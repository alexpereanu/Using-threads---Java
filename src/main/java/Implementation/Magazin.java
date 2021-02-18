package Implementation;

import java.util.Random;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Magazin extends Thread {

	private int numarClienti;
	private int numarCase;
	private Coada coziMagazin[];
	private int minArrivingTime;
	private int maxArrivingTime;
	private int minServiceTime;
	private int maxServiceTime;
	private JTextArea afisareGUI;
	public static int timpSimulare = 0;

	public Magazin(int n1, int n2, Coada coziMagazin[], int m1, int m2, int m3, int m4, JTextArea afisareGUI) {
		this.numarClienti = n1;
		this.numarCase = n2;
		this.coziMagazin = new Coada[n2];
		for (int i = 0; i < numarCase; i++) {
			this.coziMagazin[i] = coziMagazin[i];
		}
		this.minArrivingTime = m1;
		this.maxArrivingTime = m2;
		this.minServiceTime = m3;
		this.maxServiceTime = m4;
		this.afisareGUI = afisareGUI;
	}

	public int selectareCoadaClient() throws InterruptedException {
		int index = 0;
		int min = coziMagazin[0].getTimpProcesareClient();
		for (int i = 0; i < numarCase; i++) {
			int lungime = coziMagazin[i].getTimpProcesareClient();
			if (lungime < min) {
				min = lungime;
				index = i;
			}
		}

		return index;
	}

	public void run() {
		try {
			String s = "";
			double avgArr=0;
			double avgSrv = 0;
			
			int i = 1;
			while (i <= numarClienti) {
				Random ran = new Random();
				Client c = new Client(i, minArrivingTime + ran.nextInt(maxArrivingTime - minArrivingTime),
						minServiceTime + ran.nextInt(maxServiceTime - minServiceTime));
				int selectareCasaAleasa = selectareCoadaClient();
				//System.out.println(selectareCasaAleasa);
				//System.out.println("Clientul " + i + " add la casa " + Integer.toString(selectareCasaAleasa + 1));
				coziMagazin[selectareCasaAleasa].addClient(c);
				avgArr += c.getArrivingTime();
				avgSrv += c.getServiceTime();
				s = "\nClientul " + i + " add la casa " + Integer.toString(selectareCasaAleasa + 1) + " cu tServire= " + c.getServiceTime();
				afisareGUI.append(s);
				sleep( 1000);
				i++;
			}
			s="\nAverrage arriving = ";
			System.out.println("Average arriving = "+ avgArr / (numarClienti-1));
			s += avgArr / (numarClienti - 1) ;
			afisareGUI.append(s);
			s="\nAverrage servicing = ";
			System.out.println("Average servicing = "+ avgSrv / (numarClienti-1));
			s += avgSrv / (numarClienti - 1);
			afisareGUI.append(s);
			
		} catch (InterruptedException e) {
			System.out.println(e.toString());
		}
	}
	
}