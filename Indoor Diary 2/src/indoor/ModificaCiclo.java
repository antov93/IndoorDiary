package indoor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificaCiclo extends JFrame{

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;

	private JTextField numeroCiclo;
	private JTextField seme;
	private JTextField genetica;
	private JTextField tipo;
	private JTextField tecnica;
	private JTextField grUmidi;
	private JTextField grFinali;
	private JTextField giorniTot;
	private JTextField dataSemina;
	private JTextField altro;
	
	private JPanel pannello1;
	private JPanel pannello2;
	private JPanel pannello3;
	private JPanel pannello4;
	private JPanel pannello5;
	private JPanel pannello6;
	private JPanel pannello7;
	private JPanel pannello8;
	private JPanel pannello9;
	private JPanel pannello10;
	private JPanel pannello11;
	private JPanel pannello1bis;
	
	private JButton okButton;
	private JButton cancelButton;
	
	public ModificaCiclo(){
		init();
	}
	
	private void init(){
		
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		label8 = new JLabel();
		label9 = new JLabel();
		label11 = new JLabel();
		label10 = new JLabel();
		
		label1.setText("Inserisci il numero del cilclo e i campi da modificare:");
		label2.setText("Ciclo: "); 
		label3.setText("Seme: "); 
		label4.setText("Genetica: "); 
		label5.setText("Tipo: "); 
		label6.setText("Tecnica: "); 
		label7.setText("gr Umidi: "); 
		label8.setText("gr Finali: ");
		label9.setText("Giorni Totali: "); 
		label10.setText("Data Semina: "); 
		label11.setText("Altro: ");
		
		numeroCiclo=new JTextField();
		seme=new JTextField();
		genetica=new JTextField();
		tipo=new JTextField();
		tecnica=new JTextField();
		grUmidi=new JTextField();
		grFinali=new JTextField();
		giorniTot=new JTextField();
		dataSemina=new JTextField();
		altro=new JTextField();
		
		pannello1=new JPanel();
		pannello1bis= new JPanel();
		pannello2=new JPanel();
		pannello3=new JPanel();
		pannello4=new JPanel();
		pannello5=new JPanel();
		pannello6=new JPanel();
		pannello7=new JPanel();
		pannello8=new JPanel();
		pannello9=new JPanel();
		pannello10=new JPanel();
		pannello11=new JPanel();
		
		okButton=new JButton("OK");
		cancelButton=new JButton("ANNULLA");
		
		numeroCiclo.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		seme.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		genetica.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		tipo.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		tecnica.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		grUmidi.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		grFinali.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		giorniTot.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		dataSemina.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		altro.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	    setTitle("Modifica Ciclo");
	    setLocation(new java.awt.Point(340, 150));
	    setSize(350,400);
	    setResizable(true);
	    getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	    
	    pannello1.setLayout(new FlowLayout());
	    pannello1bis.setLayout(new FlowLayout());
	    pannello2.setLayout(new FlowLayout());
	    pannello3.setLayout(new FlowLayout());
	    pannello4.setLayout(new FlowLayout());
	    pannello5.setLayout(new FlowLayout());
	    pannello6.setLayout(new FlowLayout());
	    pannello7.setLayout(new FlowLayout());
	    pannello8.setLayout(new FlowLayout());
	    pannello9.setLayout(new FlowLayout());
	    pannello10.setLayout(new FlowLayout());
	    pannello11.setLayout(new FlowLayout());
		
	    pannello1bis.add(label1);
	    pannello1.add(label2);
        pannello1.add(numeroCiclo);
        
        pannello2.add(label3);
        pannello2.add(seme);
        
        pannello3.add(label4);
        pannello3.add(genetica);
        
        pannello4.add(label5);
        pannello4.add(tipo);
        
        pannello5.add(label6);
        pannello5.add(tecnica);
        
        pannello6.add(label7);
        pannello6.add(grUmidi);
        
        pannello7.add(label8);
        pannello7.add(grFinali);
        
        pannello8.add(label9);
        pannello8.add(giorniTot);
        
        pannello9.add(label10);
        pannello9.add(dataSemina);
        
        pannello10.add(label11);
        pannello10.add(altro);
        
        pannello11.add(okButton);
		pannello11.add(cancelButton);
		
        add(pannello1bis);
        add(pannello1);
        add(pannello2);
        add(pannello3);
        add(pannello4);
        add(pannello5);
        add(pannello6);
        add(pannello7);
        add(pannello8);
        add(pannello9);
        add(pannello10);
        add(pannello11);
        	    
	    getAccessibleContext().setAccessibleDescription("");

	    okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
	    });

        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
	
	}
	
	private void cancelButtonActionPerformed(ActionEvent evt) {
		dispose();
	}
	
	private void okButtonActionPerformed(ActionEvent evt) {
	/*	String rigaDaModificare,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10 = "";  	
		int numeroRigaDaModificare;
				
		s1=numeroCiclo.getText();
		if(s1.isEmpty())System.out.println("non hai inserito nessun ciclo");
		numeroRigaDaModificare=Integer.parseInt(s1);
		s2=seme.getText();
		if(s2.isEmpty())s2= prendiValore(numeroRigaDaModificare,1);
		s3=genetica.getText();
		if(s3.isEmpty())s3= prendiValore(numeroRigaDaModificare,2);
		s4=tipo.getText();
		if(s4.isEmpty())s4= prendiValore(numeroRigaDaModificare,3);
		s5=tecnica.getText();
		if(s5.isEmpty())s5= prendiValore(numeroRigaDaModificare,4);
		s6=grUmidi.getText();
		if(s6.isEmpty())s6= prendiValore(numeroRigaDaModificare,5);
		s7=grFinali.getText();
		if(s7.isEmpty())s7= prendiValore(numeroRigaDaModificare,6);
		s8=giorniTot.getText();
		if(s8.isEmpty())s8= prendiValore(numeroRigaDaModificare,7);
		s9=dataSemina.getText();
		if(s9.isEmpty())s2= prendiValore(numeroRigaDaModificare,1);
		s10=altro.getText();
		if(s10.isEmpty())s2= prendiValore(numeroRigaDaModificare,1);
		
		
		rigaDaModificare=s1+"$"+s2+"$"+s3+"$"+s4+"$"+s5+"$"+s6+"$"+s7+"$"+s8;
	 
		FileWriter f;
	    BufferedWriter b;
	    PrintWriter p;
	    
	    try {

	    	BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream("src/Files/calendario"+getCiclo()+".txt") ) );
			Vector v = new Vector(); // Conterrà tutte le righe del file
			String linea = "";
			
			// Leggo tutto il file e lo memorizzo nel Vector
			while((linea = br.readLine()) != null) {
			v.add( linea );
			}
			br.close();
			
			// Ora riscrivo tutto, tranne la riga modificata
			PrintStream ps = new PrintStream( new FileOutputStream("src/Files/calendario"+getCiclo()+".txt") );
			for(int i=0; i<v.size(); i++) { 
				if(i!=(numeroRigaDaModificare-1)){
					ps.println((String) v.elementAt(i));
				}else{
					ps.println((String) rigaDaModificare);
				 }
			}
			ps.close();
	    } catch (IOException e) {
			}
	   
	    
	    
	    dispose();
	  
	    refreshCalendario();
	    
*/
	}
	
	
}
