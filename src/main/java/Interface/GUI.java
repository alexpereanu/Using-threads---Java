package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Implementation.Coada;
import Implementation.Magazin;

public class GUI extends JFrame implements ActionListener{
	

	private Magazin m;
	
	private JPanel panel = new JPanel(); 
	private JButton start = new JButton("start");
	private JTextField minArriving = new JTextField(3);
	private JTextField maxArriving;
	private JTextField minServicing;
	private JTextField maxServicing;
	private JTextField noClients;
	private JTextField noCase;
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	
	private JTextArea afisare=new JTextArea(20,50);
	private JTextArea rezultat = new JTextArea();
	
	
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension size = new Dimension(800, 600);
		this.setSize(size);
		getContentPane().add(panel);
		setLayout(null);
		setVisible(true);
		
		start=new JButton("Start");
		add(start);
		start.setBounds(55,350,120,35);
		start.addActionListener(this);

		label1 = new JLabel("Min Arriving");
		add(label1);
		label1.setBounds(20, 50, 100, 70);
		label1.setFont(getFont());
		
		minArriving = new JTextField(20);
		minArriving.setBounds(85, 75, 20, 20);
		add(minArriving);
		
		label2 = new JLabel("Max Arriving");
		add(label2);
		label2.setBounds(20, 120, 200, 20);
		label2.setFont(getFont());
		
		maxArriving = new JTextField(20);
		maxArriving.setBounds(87, 120, 20, 20);
		add(maxArriving);
		
		label3 = new JLabel("Min Servicing");
		add(label3);
		label3.setBounds(14,165,250,20);
		label3.setFont(getFont());
		
		minServicing = new JTextField(20);
		minServicing.setBounds(90,165,20,20);
		add(minServicing);
		
		label4 = new JLabel("Max Servicing");
		add(label4);
		label4.setBounds(14,205,275,20);
		label4.setFont(getFont());
		
		maxServicing = new JTextField(20);
		maxServicing.setBounds(90,210,20,20);
		add(maxServicing);
		
		label5 = new JLabel("Nr Clienti");
		add(label5);
		label5.setBounds(180,120,200,20);
		label5.setFont(getFont());
		
		noClients = new JTextField(20);
		noClients.setBounds(240,120,20,20);
		add(noClients);
		
		label6 = new JLabel("Nr Case");
		add(label6);
		label6.setBounds(180,160,200,20);
		label6.setFont(getFont());

		noCase = new JTextField(20);
		noCase.setBounds(240,160,20,20);
		add(noCase);
		
		
		//luata de pe stackoverflow
		rezultat = new JTextArea("SUPERMARKET",20,100);
		rezultat.setLineWrap(true);
		rezultat.setWrapStyleWord(true);
		Border border = BorderFactory.createLineBorder(Color.red);
        rezultat.setBorder(border);
        rezultat.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(rezultat);
	    scrollPane.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    add(scrollPane);
	    scrollPane.setBounds(400,20,280,450);
	    
	    add(afisare);

		
	}
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		
		Object source = arg0.getSource();
		try {
		if(source == start) {
			String s1 = minArriving.getText();
			int n1 = Integer.parseInt(s1.toString());
			String s2 = maxArriving.getText();
			int n2 = Integer.parseInt(s2.toString());
			String s3 = minServicing.getText();
			int n3 = Integer.parseInt(s3.toString());
			String s4 = maxServicing.getText();
			int n4 = Integer.parseInt(s4.toString());
			String s5 = noClients.getText();
			int n5 = Integer.parseInt(s5.toString());
			String s6 = noCase.getText();
			int n6 = Integer.parseInt(s6.toString());
			
			int i;
	        int numarCase=n6;
	        Coada c[]=new Coada[numarCase];
	        for(i=0;i<numarCase;i++)
	        {
	            c[i]= new Coada(i,rezultat);
	            c[i].start();
	        }
	        m = new Magazin(n5,n6,c,n1,n2,n3,n4,rezultat);
	        m.start();
	        
		}
		}catch(Exception e) {
			System.out.println("Eroare la introducerea datelor ! ");
		}
		
	}

	
}