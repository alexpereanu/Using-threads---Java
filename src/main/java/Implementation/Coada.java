package Implementation;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextArea;

public class Coada extends Thread {

	private int nrCoada;
	private int timpProcesareClient;
	private Vector coadaClienti;
	private JTextArea afisareGUI;

	public Coada(int nr, JTextArea alex) {
		this.nrCoada = nr;
		coadaClienti = new Vector();
		this.timpProcesareClient = 0;
		this.afisareGUI = alex;
	}

	public int getTimpProcesareClient() {
		return timpProcesareClient;
	}

	public void setTimpProcesareClient(int timpProcesareClient) {
		this.timpProcesareClient = timpProcesareClient;
	}

	public int getNrCoada() {
		return nrCoada;
	}

	public void setNrCoada(int nrCoada) {
		this.nrCoada = nrCoada;
	}

	public Vector getCoadaClienti() {
		return coadaClienti;
	}

	public void setCoadaClienti(Vector coadaClienti) {
		this.coadaClienti = coadaClienti;
	}

	public synchronized void addClient(Client c) throws InterruptedException {
		coadaClienti.addElement(c);
		this.timpProcesareClient += c.getServiceTime();
		// setTimpProcesareClient(getTimpProcesareClient() + c.getServiceTime());
		notifyAll();
	}

	public boolean verifyCoada() {
		if (coadaClienti.isEmpty() == true)
			return true;
		return false;
	}

	public int timpService() {
		Client c = (Client) coadaClienti.elementAt(0);
		int timp = c.getServiceTime();
		return timp;

	}

	public synchronized void removeClient() throws InterruptedException {
		while (coadaClienti.size() == 0) {
			wait();
		}

		String s = "\nCoada " + (this.nrCoada + 1) + ":\n";
		Client c = (Client) coadaClienti.elementAt(0);
		for (int i = 0; i < coadaClienti.size(); i++)
			s += coadaClienti.elementAt(i) + ", ";
		System.out.println("\n");
		coadaClienti.removeElementAt(0);
		s += "\nClientul " + c.getNrClient() + " a fost extras din coada";
		this.timpProcesareClient -= c.getServiceTime();
		// s = "\nClientul " + Long.toString(c.getNrClient()) + " a fost servit de casa
		// " + (getNrCoada() + 1);
		afisareGUI.append(s);
		notifyAll();
	}

	public void run() {
		try {
			sleep(100);
			while (true) {
				if (coadaClienti.size() != 0) {
					int timp = 0;
					Client c = (Client) coadaClienti.elementAt(0);
					timp = c.getServiceTime();
					sleep(timp * 1000);
					removeClient();
				}

			}
		} catch (InterruptedException e) {
			System.out.println("Intrerupere");
			System.out.println(e.toString());
		}
	}

}