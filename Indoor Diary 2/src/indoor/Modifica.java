package indoor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Modifica extends Ciclo {
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;

	private JTextField giorno;
	private JTextField data;
	private JTextField temperatura;
	private JTextField umidita;
	private JTextField acqua;
	private JTextField fertilizzante;
	private JTextField altezza;
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
	
	private JButton okButton;
	private JButton cancelButton;
	
	public Modifica(int ciclo,JScrollPane sp){
		setCiclo(ciclo);
		scrollPaneTabella=sp;
		init();
	}

	private void init() {
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		label8 = new JLabel();
		label9 = new JLabel();
		
		label1.setText("Inserisci il giorno e i campi da modificare:");
		label2.setText("Giorno: "); 
		label3.setText("Data: "); 
		label4.setText("Temperatura: "); 
		label5.setText("Umidit�: "); 
		label6.setText("Acqua: "); 
		label7.setText("Fertilizzanti: ");
		label8.setText("Altezza: "); 
		label9.setText("Altro: "); 
	
		
		//ciclo=new JTextField();
		giorno=new JTextField();
		data=new JTextField();
		temperatura=new JTextField();
		umidita=new JTextField();
		acqua=new JTextField();
		fertilizzante=new JTextField();
		altezza=new JTextField();
		altro=new JTextField();
		
		pannello1=new JPanel();
		pannello2=new JPanel();
		pannello3=new JPanel();
		pannello4=new JPanel();
		pannello5=new JPanel();
		pannello6=new JPanel();
		pannello7=new JPanel();
		pannello8=new JPanel();
		pannello9=new JPanel();
		pannello10=new JPanel();
		
		okButton=new JButton("OK");
		cancelButton=new JButton("ANNULLA");
		
		//ciclo.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		giorno.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		data.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		temperatura.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		umidita.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		acqua.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		fertilizzante.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		altezza.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		altro.setPreferredSize(FinestraLogin.DIM_TEXT_FIELD);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modifica Riga");
        setLocation(new java.awt.Point(340, 150));
        setSize(350,400);
        setResizable(true);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        pannello1.setLayout(new FlowLayout());
        pannello2.setLayout(new FlowLayout());
        pannello3.setLayout(new FlowLayout());
        pannello4.setLayout(new FlowLayout());
        pannello5.setLayout(new FlowLayout());
        pannello6.setLayout(new FlowLayout());
        pannello7.setLayout(new FlowLayout());
        pannello8.setLayout(new FlowLayout());
        pannello9.setLayout(new FlowLayout());
        pannello10.setLayout(new FlowLayout());
		
        pannello1.add(label1);
       // pannello1.add(ciclo);
        
        pannello2.add(label2);
        pannello2.add(giorno);
        
        pannello3.add(label3);
        pannello3.add(data);
        
        pannello4.add(label4);
        pannello4.add(temperatura);
        
        pannello5.add(label5);
        pannello5.add(umidita);
        
        pannello6.add(label6);
        pannello6.add(acqua);
        
        pannello7.add(label7);
        pannello7.add(fertilizzante);
        
        pannello8.add(label8);
        pannello8.add(altezza);
        
        pannello9.add(label9);
        pannello9.add(altro);
        
		pannello10.add(okButton);
		pannello10.add(cancelButton);
		
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
        
        getAccessibleContext().setAccessibleDescription("");

        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
                
            }
            private void okButtonActionPerformed(ActionEvent evt) {
            	String rigaDaModificare,s1,s2,s3,s4,s5,s6,s7,s8 = "";  	
        		int numeroRigaDaModificare;
        				
        		s1=giorno.getText();
        		if(s1.isEmpty())System.out.println("non hai inserito nessun giorno");
        		numeroRigaDaModificare=Integer.parseInt(s1);
        		s2=data.getText();
        		if(s2.isEmpty())s2= prendiValore(numeroRigaDaModificare,1);
        		s3=temperatura.getText();
        		if(s3.isEmpty())s3= prendiValore(numeroRigaDaModificare,2);
        		s4=umidita.getText();
        		if(s4.isEmpty())s4= prendiValore(numeroRigaDaModificare,3);
        		s5=acqua.getText();
        		if(s5.isEmpty())s5= prendiValore(numeroRigaDaModificare,4);
        		s6=fertilizzante.getText();
        		if(s6.isEmpty())s6= prendiValore(numeroRigaDaModificare,5);
        		s7=altezza.getText();
        		if(s7.isEmpty())s7= prendiValore(numeroRigaDaModificare,6);
        		s8=altro.getText();
        		if(s8.isEmpty())s8= prendiValore(numeroRigaDaModificare,7);
        		rigaDaModificare=s1+"$"+s2+"$"+s3+"$"+s4+"$"+s5+"$"+s6+"$"+s7+"$"+s8;
        	 
        		FileWriter f;
        	    BufferedWriter b;
        	    PrintWriter p;
        	    
        	    try {

        	    	BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream("src/Files/calendario"+getCiclo()+".txt") ) );
        			Vector v = new Vector(); // Conterr� tutte le righe del file
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
        	    
			}//fine okButtonActionP
           
            public String prendiValore(int riga,int colonna){
            	FileReader f;
        		BufferedReader b;
        		String rigaLetta ="";
        		String valore=null;
        		String[] campi=new String[9];
        		try {
        			f = new FileReader( "src/Files/calendario"+getCiclo()+".txt");
        			b= new BufferedReader(f);
        			rigaLetta = b.readLine();
        			for(int i=1;i<(contaRigheCalendario(getCiclo()))+1;i++){
        				campi=rigaLetta.split(Pattern.quote("$"));
        				if (i==riga){
        					valore=campi[colonna];
        				}
        				rigaLetta=b.readLine();
        			}
        			f.close();
        			b.close();
        		} catch (FileNotFoundException e) {
        			e.printStackTrace();
        			e.getMessage();
        		  }catch(IOException a){
        			a.getCause();
        			a.getMessage();
        		   }
            	
            	return valore;
            }
            
            
            
        });

        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
                
            }

			private void cancelButtonActionPerformed(ActionEvent evt) {
				dispose();
			}
        });
	}

}
