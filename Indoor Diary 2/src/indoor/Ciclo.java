package indoor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Ciclo extends FinestraPrincipale{
	
	protected String utente="";
	private int numeroCiclo=1;
	
	public Ciclo(){}
	
	public Ciclo(String utente){
		this.utente=utente;
		
		//finestra principale
		framePrincipale=new JFrame("INDOOR DIARY");
		framePrincipale.getContentPane().setLayout(new BorderLayout());
		
		pannelloMenu= new JPanel();
		pannelloMenu.setLayout(new FlowLayout(FlowLayout.LEFT)); 
		
		pannelloTabella= new JPanel();   
		pannelloTabella.setLayout(new BorderLayout()); 
		
		pannelloBottoni=new JPanel();
		pannelloBottoni.setLayout(new GridLayout(1,2));
		
		pannelloBottoniSX=new JPanel();
		pannelloBottoniDX=new JPanel();
		pannelloBottoniSX.setLayout(new FlowLayout(FlowLayout.LEFT));
		pannelloBottoniDX.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		visualizzaCicloCorrenteButton=new JButton("Apri ciclo in corso");
		indietroButton=new JButton("INDIETRO");
		esciButton=new JButton("ESCI");
		
		menuBar=new JMenuBar();
		
		fileMenu=new JMenu();
		fileMenu.setText("File");
		
		nuovoUtenteMenuItem=new JMenuItem ();
		nuovoUtenteMenuItem.setText("Nuovo utente..."); 
		cambiaPassMenuItem=new JMenuItem ();
		cambiaPassMenuItem.setText("Cambia password..."); 
		eliminaUtenteMenuItem=new JMenuItem ();
		eliminaUtenteMenuItem.setText("Elimina utente...");
		esciMenuItem=new JMenuItem ();
		esciMenuItem.setText("Esci");
		
		strumentiCicloMenu=new JMenu();
		strumentiCicloMenu.setText("Ciclo");
		aggiungiCicloMenuItem=new JMenuItem ();
	    eliminaCicloMenuItem=new JMenuItem() ;
	    modificaCicloMenuItem=new JMenuItem ();
	    visualizzaCicloMenuItem=new JMenuItem();
	    aggiungiCicloMenuItem.setText("Nuovo ciclo...");
	    eliminaCicloMenuItem.setText("Elimina ultimo ciclo");
	    modificaCicloMenuItem.setText("Modifica ciclo...");
	    visualizzaCicloMenuItem.setText("Visualizza tutti i cicli");;
	    
		strumentiCalendarioMenu= new JMenu();
		strumentiCalendarioMenu.setText("Calendario");
		aggiungiGiornoMenuItem=new JMenuItem();
		modificaGiornoMenuItem=new JMenuItem();
		eliminaGiornoMenuItem=new JMenuItem();
		aggiungiGiornoMenuItem.setText("Nuovo giorno...");
		modificaGiornoMenuItem.setText("Modifica un giorno del calendario");;
		eliminaGiornoMenuItem.setText("Elimina ultimo giorno del calendario");;
		
		aiutoMenu=new JMenu();
		aiutoMenu.setText("Help");
		
		menuBar.add(fileMenu);
			fileMenu.add(nuovoUtenteMenuItem);
			fileMenu.add(cambiaPassMenuItem);
			fileMenu.add(eliminaUtenteMenuItem);
			fileMenu.add(esciMenuItem);
			
	    menuBar.add(strumentiCicloMenu);
	    	strumentiCicloMenu.add(aggiungiCicloMenuItem);
	    	strumentiCicloMenu.add(modificaCicloMenuItem);
	    	strumentiCicloMenu.add(eliminaCicloMenuItem);
	    	strumentiCicloMenu.add(visualizzaCicloMenuItem);
	    	visualizzaCicloMenuItem.setEnabled(false);
	    
	    menuBar.add(strumentiCalendarioMenu);
	    	strumentiCalendarioMenu.add(aggiungiGiornoMenuItem);
	    	strumentiCalendarioMenu.add(modificaGiornoMenuItem);
	    	strumentiCalendarioMenu.add(eliminaGiornoMenuItem);
	    	aggiungiGiornoMenuItem.setEnabled(false);
	    	modificaGiornoMenuItem.setEnabled(false);
	    	eliminaGiornoMenuItem.setEnabled(false);
	    
	    menuBar.add(aiutoMenu);
	   
	    pannelloMenu.add(menuBar);
	    
	    pannelloBottoni.add(pannelloBottoniSX);
		pannelloBottoni.add(pannelloBottoniDX);
		pannelloBottoniDX.add(visualizzaCicloCorrenteButton);
		pannelloBottoniDX.add(indietroButton);
		pannelloBottoniDX.add(esciButton);
		
	    framePrincipale.getContentPane().add(pannelloMenu,BorderLayout.NORTH);
	    framePrincipale.getContentPane().add(pannelloBottoni,BorderLayout.SOUTH);
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		framePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipale.setLocation(new Point(275,100));
		framePrincipale.setSize(800, 550);
		framePrincipale.setResizable(true);
		framePrincipale.setVisible(true);
	
		//parte della tabella ciclo
		intestazioneFinestra= new JLabel();
		intestazioneFinestra.setText(setIntestazione());
		utenteCorrenteFinestra=new JLabel();
		utenteCorrenteFinestra.setText("Utente: "+utente+"");
		
		tabellaCiclo = new JTable(new Object[contaRigheCiclo()][10],COLONNE_TAB_CICLO);
		tabellaCiclo.setEnabled(false);
		tabellaCiclo.setVisible(true);
	
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
		
		scrollPaneTabella = new JScrollPane();
		scrollPaneTabella.setViewportView(tabellaCiclo);
		
		label=new JLabel("Apri ciclo:");
		apriCicloComboBox=new JComboBox<>();//elencoCicli
		apriButton=new JButton("Apri");
		setComboBox();
		pannelloBottoniSX.add(label);
		pannelloBottoniSX.add(apriCicloComboBox);
		pannelloBottoniSX.add(apriButton);
			
		indietroButton.setEnabled(false);
		aggiornaTabellaCiclo();
		
		//calendario
		aggiungiButton=new JButton("Aggiungi");
		modificaButton=new JButton("Modifica");
		eliminaButton=new JButton("Elimina");

		pannelloTabella.add(intestazioneFinestra,BorderLayout.NORTH);
		pannelloTabella.add(utenteCorrenteFinestra,BorderLayout.SOUTH);
		pannelloTabella.add(scrollPaneTabella,BorderLayout.CENTER);
		framePrincipale.getContentPane().add(pannelloTabella,BorderLayout.CENTER);

		//LISTENER
		modificaCicloMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				modificaCicloMenuItemActionPerformed(event);
				
			}
		});
		
		nuovoUtenteMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				nuovoUtenteMenuItemActionPerformed(event);
				
			}

			
		});
		
		esciMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				esciButtonActionPerformed(event);
				
			}
		});
		
		aggiungiCicloMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				aggiungiCicloButtonActionPerformed(event);
				
			}

			
		});
		
		aggiungiGiornoMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				aggiungiButtonActionPerformed(event);
				
			}
		});
		
		modificaGiornoMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				modificaButtonActionPerformed(event);
				
			}
		});
		
		eliminaGiornoMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				eliminaButtonActionPerformed(event);
				
			}
		});

		visualizzaCicloMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				visualizzaCicloMenuItemActionPerformed(event);
				
			}
		});

		apriButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				apriButtonActionPerformed(event);
				
			}
		});

		esciButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				esciButtonActionPerformed(event);
				
			}


			
		});

		visualizzaCicloCorrenteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
					visualizzaCicloCorrenteButtonActionPerformed(event);
				
			}

			
		});
	
		aggiungiButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
					aggiungiButtonActionPerformed(event);
				
			}
	});
		
		eliminaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
					
						eliminaButtonActionPerformed(event);
					
				
			}
	});
		
		modificaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
					modificaButtonActionPerformed(event);
			}
		});
	
		indietroButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent event) {
					
						indietroButtonActionPerformed(event);
					
				}
		});
		
		eliminaCicloMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
					eliminaCicloMenuItemActionPerformed(event);
			}
		});
		
	
	}
	
	private void modificaCicloMenuItemActionPerformed(ActionEvent event) {
		ModificaCiclo m=new ModificaCiclo();
		m.setVisible(true);
		
	}
	
	private void nuovoUtenteMenuItemActionPerformed(ActionEvent event) {
		
		
	}
	
	private void eliminaCicloMenuItemActionPerformed(ActionEvent event)  {
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream("src/Files/cicli.txt") ) );
			Vector v = new Vector(); // Conterrà tutte le righe del file
			String linea = "";
			
			// Leggo tutto il file e lo memorizzo nel Vector
			while((linea = br.readLine()) != null) {
			v.add( linea );
			}
			br.close();
			
			// Ora riscrivo tutto, tranne l'ultima riga
			PrintStream ps = new PrintStream( new FileOutputStream("src/Files/cicli.txt") );
			for(int i=0; i<v.size()-1; i++) { // Il -1 indica di tralasciare l'ultima riga
			ps.println((String) v.elementAt(i));
			}
			ps.close();
			}catch(IOException e){
				e.getMessage();
			}
		///////////////////////////////////////////////////////////////////
		//parte di aggiornamento dopo l eliminazione
		//////////////////////////////////////
		
		  setCiclo(getCicloCorrente());
		tabellaCiclo = new JTable(new Object[contaRigheCiclo()][10],COLONNE_TAB_CICLO);
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
		//intestazioneFinestra= new JLabel();
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
		  
		//elimino il file calendarioX.txt del ciclo eliminato 
		
		 File file=new File("src/Files/calendario"+(getCicloCorrente()+1)+".txt");
		    file.delete();
		
					
	}
	
	protected void visualizzaCicloMenuItemActionPerformed(ActionEvent event) {
		setCiclo(getCicloCorrente());
		tabellaCiclo = new JTable(new Object[contaRigheCiclo()][10],COLONNE_TAB_CICLO);
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
		//intestazioneFinestra= new JLabel();
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
	
	private void aggiungiCicloButtonActionPerformed(ActionEvent event) {
		InserisciCiclo i=new InserisciCiclo(2,tabellaCiclo,utente,intestazioneFinestra,
				scrollPaneTabella,pannelloBottoniSX,aggiungiButton,eliminaButton,
				modificaButton,label,apriCicloComboBox,apriButton,
				indietroButton,visualizzaCicloCorrenteButton,visualizzaCicloMenuItem,
				aggiungiGiornoMenuItem,modificaGiornoMenuItem,eliminaGiornoMenuItem);
		i.setVisible(true);
		i.pack();

		///////////////////////////////////////////////////////////////////
	//parte di aggiornamento dopo l aggiunta
	//////////////////////////////////////
	/*
	setCiclo(getCicloCorrente());
	tabellaCiclo = new JTable(new Object[contaRigheCiclo()][10],COLONNE_TAB_CICLO);
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
	//intestazioneFinestra= new JLabel();
	intestazioneFinestra.setText(setIntestazione());
	
	utenteCorrenteFinestra=new JLabel();
	utenteCorrenteFinestra.setText("Utente: "+utente+"");
	
	scrollPaneTabella.setViewportView(tabellaCiclo);
	
	pannelloBottoniSX.remove(aggiungiButton);
	pannelloBottoniSX.remove(eliminaButton);
	pannelloBottoniSX.remove(modificaButton);
	pannelloBottoniSX.remove(refresh);
	
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
	*/
		//devo trovare il modo di aggiornare la tabella
	}
	
	
	private void indietroButtonActionPerformed(ActionEvent event) {
		setCiclo(getCicloCorrente());
		tabellaCiclo = new JTable(new Object[contaRigheCiclo()][10],COLONNE_TAB_CICLO);
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
		//intestazioneFinestra= new JLabel();
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
	
	
	private void eliminaButtonActionPerformed(ActionEvent event)  {

		
		try{
		BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream("src/Files/calendario"+getCiclo()+".txt") ) );
		Vector v = new Vector(); // Conterrà tutte le righe del file
		String linea = "";
		
		// Leggo tutto il file e lo memorizzo nel Vector
		while((linea = br.readLine()) != null) {
		v.add( linea );
		}
		br.close();
		
		// Ora riscrivo tutto, tranne l'ultima riga
		PrintStream ps = new PrintStream( new FileOutputStream("src/Files/calendario"+getCiclo()+".txt") );
		for(int i=0; i<v.size()-1; i++) { // Il -1 indica di tralasciare l'ultima riga
		ps.println((String) v.elementAt(i));
		}
		ps.close();
		}catch(IOException e){
			e.getMessage();
		}
			refreshCalendario();	
			int x =scrollPaneTabella.getVerticalScrollBar().getMaximum();
			scrollPaneTabella.getVerticalScrollBar().setValue(x);
	}
	
	
	protected void refreshCalendario() {
		tabellaCalendario = new JTable(new Object[contaRigheCalendario(getCiclo())][8],COLONNE_TAB_CALENDARIO);
		tabellaCalendario.setEnabled(false);
		tabellaCalendario.getColumn("Giorno").setPreferredWidth(70);
		tabellaCalendario.getColumn("Data").setPreferredWidth(250);
		tabellaCalendario.getColumn("Temp").setPreferredWidth(100);
		tabellaCalendario.getColumn("UR").setPreferredWidth(100);
		tabellaCalendario.getColumn("Acqua").setPreferredWidth(200);
		tabellaCalendario.getColumn("Fertilizzante").setPreferredWidth(300);
		tabellaCalendario.getColumn("Altezza").setPreferredWidth(125);
		tabellaCalendario.getColumn("Altro").setPreferredWidth(350);
		scrollPaneTabella.setViewportView(tabellaCalendario);
		int x =scrollPaneTabella.getVerticalScrollBar().getMaximum();
		scrollPaneTabella.getVerticalScrollBar().setValue(x);
		aggiornaTabellaCalendario(getCiclo());		
	}
	
	private void esciButtonActionPerformed(ActionEvent event) {
		framePrincipale.dispose();
		
	}
	
	private void apriButtonActionPerformed(ActionEvent event) {
		apriCicloComboBox.getSelectedIndex();
		tabellaCalendario = new JTable(new Object[contaRigheCalendario(apriCicloComboBox.getSelectedIndex()+1)][8],COLONNE_TAB_CALENDARIO);
		tabellaCalendario.setEnabled(false);
		tabellaCalendario.getColumn("Giorno").setPreferredWidth(70);
		tabellaCalendario.getColumn("Data").setPreferredWidth(250);
		tabellaCalendario.getColumn("Temp").setPreferredWidth(100);
		tabellaCalendario.getColumn("UR").setPreferredWidth(100);
		tabellaCalendario.getColumn("Acqua").setPreferredWidth(200);
		tabellaCalendario.getColumn("Fertilizzante").setPreferredWidth(300);
		tabellaCalendario.getColumn("Altezza").setPreferredWidth(125);
		tabellaCalendario.getColumn("Altro").setPreferredWidth(350);
		
		scrollPaneTabella.setViewportView(tabellaCalendario);
		intestazioneFinestra.setText("CALENDARIO "+(apriCicloComboBox.getSelectedItem()).toString().toUpperCase());
		
		indietroButton.setEnabled(true);
		visualizzaCicloCorrenteButton.setEnabled(false);
		visualizzaCicloMenuItem.setEnabled(true);
		
		aggiungiGiornoMenuItem.setEnabled(true);
		modificaGiornoMenuItem.setEnabled(true);
		eliminaGiornoMenuItem.setEnabled(true);
		
		setCiclo(apriCicloComboBox.getSelectedIndex()+1);
		pannelloBottoniSX.remove(label);
		pannelloBottoniSX.remove(apriCicloComboBox);
		pannelloBottoniSX.remove(apriButton);
		
		pannelloBottoniSX.add(aggiungiButton);
		pannelloBottoniSX.add(modificaButton);
		pannelloBottoniSX.add(eliminaButton);
		
		int x =scrollPaneTabella.getVerticalScrollBar().getMaximum();
		scrollPaneTabella.getVerticalScrollBar().setValue(x);
		
		pannelloBottoni.updateUI();
		aggiornaTabellaCalendario(apriCicloComboBox.getSelectedIndex()+1);
		
	}
	
	
	private void aggiungiButtonActionPerformed(ActionEvent event) {
		Inserisci x=new Inserisci(getCiclo(),scrollPaneTabella,apriCicloComboBox);
		x.setVisible(true);
		
		
	}
	

	private void modificaButtonActionPerformed(ActionEvent event) {
		Modifica m=new Modifica(getCiclo(),scrollPaneTabella);
		m.setVisible(true);
	}
	

	private void visualizzaCicloCorrenteButtonActionPerformed(ActionEvent event) {
		setCiclo(getCicloCorrente());
		setComboBox();
		tabellaCalendario = new JTable(new Object[contaRigheCalendario(getCicloCorrente())][8],COLONNE_TAB_CALENDARIO);
		tabellaCalendario.setEnabled(false);
		
		tabellaCalendario.getColumn("Giorno").setPreferredWidth(70);
		tabellaCalendario.getColumn("Data").setPreferredWidth(250);
		tabellaCalendario.getColumn("Temp").setPreferredWidth(100);
		tabellaCalendario.getColumn("UR").setPreferredWidth(100);
		tabellaCalendario.getColumn("Acqua").setPreferredWidth(200);
		tabellaCalendario.getColumn("Fertilizzante").setPreferredWidth(300);
		tabellaCalendario.getColumn("Altezza").setPreferredWidth(125);
		tabellaCalendario.getColumn("Altro").setPreferredWidth(350);
		
		scrollPaneTabella.setViewportView(tabellaCalendario);
		intestazioneFinestra.setText("CALENDARIO "+(apriCicloComboBox.getItemAt(getCicloCorrente()-1)).toUpperCase());
		
		indietroButton.setEnabled(true);
		visualizzaCicloCorrenteButton.setEnabled(false);
		visualizzaCicloMenuItem.setEnabled(true);
		
		aggiungiGiornoMenuItem.setEnabled(true);
		modificaGiornoMenuItem.setEnabled(true);
		eliminaGiornoMenuItem.setEnabled(true);
		
		pannelloBottoniSX.remove(label);
		pannelloBottoniSX.remove(apriCicloComboBox);
		pannelloBottoniSX.remove(apriButton);
		
		pannelloBottoniSX.add(aggiungiButton);
		pannelloBottoniSX.add(modificaButton);
		pannelloBottoniSX.add(eliminaButton);
		pannelloBottoni.updateUI();
		
		aggiornaTabellaCalendario(getCicloCorrente());
		int x =scrollPaneTabella.getVerticalScrollBar().getMaximum();
		scrollPaneTabella.getVerticalScrollBar().setValue(x);
	}
	
	
	
	
}
