package indoor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class InserisciCiclo extends Ciclo{
	
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
	
	public InserisciCiclo(int s,JTable tabella,String user,
			JLabel intestazione,JScrollPane sp,JPanel pannello,
			JButton a,JButton e,JButton m,JLabel l,
			JComboBox<String> cb,JButton apri,JButton indietro,
			JButton visuCC,JMenuItem visCiMenu,JMenuItem aggGioItem,JMenuItem modiGiorItem,JMenuItem elimGiornIte){
	
			tabellaCiclo=tabella;
			utente=user;
			intestazioneFinestra=intestazione;
			scrollPaneTabella=sp;
			pannelloBottoniSX=pannello;
			aggiungiButton=a;
			eliminaButton=e;
			modificaButton=m;
			//refresh=r;
			label=l;
			apriCicloComboBox=cb;
			apriButton=apri;
			indietroButton=indietro;
			visualizzaCicloCorrenteButton=visuCC;
			visualizzaCicloMenuItem=visCiMenu;
			aggiungiGiornoMenuItem=aggGioItem;
			modificaGiornoMenuItem=modiGiorItem;
			eliminaGiornoMenuItem=elimGiornIte;
			
			
			label1 = new JLabel();
			label2 = new JLabel();
			label3 = new JLabel();
			label4 = new JLabel();
			label5 = new JLabel();
			label6 = new JLabel();
			label7 = new JLabel();
			label8 = new JLabel();
			label9 = new JLabel();
			label10 = new JLabel();
			
			label1.setText("Ciclo numero "+(contaRigheCiclo()+1)+".");
			label2.setText("Seme: "); 
			label3.setText("Genetica: "); 
			label4.setText("Tipo: "); 
			label5.setText("Tecnica: "); 
			label6.setText("gr Umidi: "); 
			label7.setText("gr Finali: ");
			label8.setText("Giorni Totali: "); 
			label9.setText("Data Semina: "); 
			label10.setText("Altro: ");
			
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
			pannello1bis= new JPanel ();
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
			
			okButton=new JButton("Aggiungi");
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
	        setTitle("Nuovo Ciclo");
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
			
	        pannello1.add(label1);
	        pannello1bis.add(numeroCiclo);
	        
	        pannello2.add(label2);
	        pannello2.add(seme);
	        
	        pannello3.add(label3);
	        pannello3.add(genetica);
	        
	        pannello4.add(label4);
	        pannello4.add(tipo);
	        
	        pannello5.add(label5);
	        pannello5.add(tecnica);
	        
	        pannello6.add(label6);
	        pannello6.add(grUmidi);
	        
	        pannello7.add(label7);
	        pannello7.add(grFinali);
	        
	        pannello8.add(label8);
	        pannello8.add(giorniTot);
	        
	        pannello9.add(label9);
	        pannello9.add(dataSemina);
	        
	        pannello10.add(label10);
	        pannello10.add(altro);
	        
	        pannello11.add(okButton);
			pannello11.add(cancelButton);
			
	        add(pannello1);
	        add(pannello1bis);
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
	        
	        int numero=(contaRigheCiclo()+1);
			String testo= Integer.toString (numero);
			numeroCiclo.setText(testo);
			numeroCiclo.setEditable(false);
	        numeroCiclo.setVisible(false);
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

				private void cancelButtonActionPerformed(ActionEvent evt) {
					dispose();
					
				}
	        });
	        
	
	}
	
	
	
	private void okButtonActionPerformed(ActionEvent evt) {
		String rigaDaAggiungere,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10 = "";  	
		
		s1=numeroCiclo.getText();
		if(s1.isEmpty())s1="  ";
		s2=seme.getText();
		if(s2.isEmpty())s2="  ";
		s3=genetica.getText();
		if(s3.isEmpty())s3="  ";
		s4=tipo.getText();
		if(s4.isEmpty())s4="  ";
		s5=tecnica.getText();
		if(s5.isEmpty())s5="  ";
		s6=grUmidi.getText();
		if(s6.isEmpty())s6="  ";
		s7=grFinali.getText();
		if(s7.isEmpty())s7="  ";
		s8=giorniTot.getText();
		if(s8.isEmpty())s8="  ";
		s9=dataSemina.getText();
		if(s9.isEmpty())s9="  ";
		s10=altro.getText();
		if(s10.isEmpty())s10="  ";
		
		rigaDaAggiungere=s1+"$"+s2+"$"+s3+"$"+s4+"$"+s5+"$"+s6+"$"+s7+"$"+s8+"$"+s9+"$"+s10;
	    FileWriter f;
	    BufferedWriter b;
	    PrintWriter p;
	    
	    try {
	    	FileOutputStream out=new FileOutputStream( "src/Files/cicli.txt",true);
	    	OutputStreamWriter writer =new OutputStreamWriter (out);
	    	BufferedWriter outFile=new BufferedWriter (writer);
	    	outFile.append(rigaDaAggiungere);
	    	outFile.newLine();
	    	outFile.close();
	    	
	    } catch (IOException e) {
	    	e.getMessage();
	    	e.printStackTrace();
		 }
	    File file=new File("src/Files/calendario"+(getCicloCorrente())+".txt");
	    try {
			file.createNewFile();
		} catch (IOException e) {
e.getMessage();
e.printStackTrace();
		}
	    
	   
	    dispose();
	    setCiclo(getCicloCorrente());
	    tabellaCiclo= new JTable(new Object[contaRigheCiclo()][10],COLONNE_TAB_CICLO);
		tabellaCiclo.getColumn("#").setPreferredWidth(25);
		tabellaCiclo.getColumn("Seme").setPreferredWidth(350);
		tabellaCiclo.getColumn("Genetica").setPreferredWidth(350);
		tabellaCiclo.getColumn("Tipo").setPreferredWidth(400);
		tabellaCiclo.getColumn("Tecnica").setPreferredWidth(400);
		tabellaCiclo.getColumn("GrUmidi").setPreferredWidth(100);
		tabellaCiclo.getColumn("GrFinali").setPreferredWidth(100);
		tabellaCiclo.getColumn("GiorniTotali").setPreferredWidth(100);
		tabellaCiclo.getColumn("Data Semina").setPreferredWidth(200);
		tabellaCiclo.getColumn("Altro").setPreferredWidth(500);
		tabellaCiclo.setVisible(true);
		tabellaCiclo.setEnabled(false);
		
		
		
		intestazioneFinestra.setText(setIntestazione());
		
		utenteCorrenteFinestra=new JLabel();
		utenteCorrenteFinestra.setText("Utente: "+utente+"");
		
		scrollPaneTabella.setViewportView(tabellaCiclo);
		
		pannelloBottoniSX.remove(aggiungiButton);
		pannelloBottoniSX.remove(eliminaButton);
		pannelloBottoniSX.remove(modificaButton);
		//pannelloBottoniSX.remove(refresh);
		
		pannelloBottoniSX.add(label);
		pannelloBottoniSX.add(apriCicloComboBox);
		pannelloBottoniSX.add(apriButton);
		pannelloBottoniSX.updateUI();
		
		
		indietroButton.setEnabled(false);
		
		visualizzaCicloCorrenteButton.setEnabled(true);
		visualizzaCicloMenuItem.setEnabled(false);
		
		aggiungiGiornoMenuItem.setEnabled(false);
		modificaGiornoMenuItem.setEnabled(false);
		eliminaGiornoMenuItem.setEnabled(false);
		
		aggiornaTabellaCiclo();	
	    
}
	}