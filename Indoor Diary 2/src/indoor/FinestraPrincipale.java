package indoor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;



public abstract class FinestraPrincipale extends JFrame {
	
	protected JFrame framePrincipale;
	protected JPanel pannelloMenu;
	protected JPanel pannelloProvabottone,pannelloTabella,pannelloBottoni;
	
	protected JPanel pannelloBottoniSX;
	protected JPanel pannelloBottoniDX;
	
	protected JMenuBar menuBar;
	protected JMenu fileMenu;
	protected JMenu strumentiCicloMenu;
	protected JMenu strumentiCalendarioMenu;
	protected JMenu aiutoMenu;
	protected JMenuItem aggiungiCicloMenuItem;
	protected JMenuItem eliminaCicloMenuItem;
	protected JMenuItem modificaCicloMenuItem;
	protected JMenuItem visualizzaCicloMenuItem;
	protected JMenuItem aggiungiGiornoMenuItem;
	protected JMenuItem modificaGiornoMenuItem;
	protected JMenuItem eliminaGiornoMenuItem;
	
	protected JMenuItem nuovoUtenteMenuItem;
	protected JMenuItem cambiaPassMenuItem;
	protected JMenuItem eliminaUtenteMenuItem;
	protected JMenuItem esciMenuItem;
	protected JButton esciButton;
	
	protected JButton visualizzaCicloCorrenteButton,indietroButton;
	
	protected JTable tabellaCalendario;
	protected JTable tabellaCiclo;
	protected final Object COLONNE_TAB_CICLO[]=
		{"#","Seme","Genetica","Tipo","Tecnica","GrUmidi","GrFinali","GiorniTotali","Data Semina","Altro"};
	protected JScrollPane scrollPaneTabella;
	protected JLabel label;
	//protected String[] elencoCicli=new String[contaRigheCiclo()];
	protected JComboBox<String> apriCicloComboBox;
	protected JButton apriButton;
	protected final Object COLONNE_TAB_CALENDARIO[]=
		{"Giorno","Data","Temp","UR","Acqua","Fertilizzante","Altezza","Altro"};
	
	//protected JScrollPane scrollPaneTabellaCalendario;
	protected JButton aggiungiButton;
	protected JButton modificaButton;
	protected JButton eliminaButton;
	//protected int cicloCorrente=1;
	private int cicloCorrente;
	private int ciclo=33;
	protected JLabel intestazioneFinestra;
	protected JLabel utenteCorrenteFinestra;
	
	
	
	protected int getCicloCorrente(){
		cicloCorrente=contaRigheCiclo();
		return cicloCorrente;
	}
	
	protected void setCiclo(int numeroCiclo){
		this.ciclo=numeroCiclo;
		
	}
	
	protected int getCiclo(){
		return ciclo;
	}
	
	protected String setIntestazione() {
		// TODO Auto-generated method stub
		String  intestazione="Report Cicli:";
		
		
		
		return intestazione;
	}
	protected int contaRigheCalendario(int numeroCiclo) {
		FileReader f;
		BufferedReader b;
		int righeTot=0;
		String rigaLetta;
		try {
			f = new FileReader( "src/Files/calendario"+numeroCiclo+".txt");
			b= new BufferedReader(f);
			rigaLetta=b.readLine();
			while(rigaLetta != null){
				righeTot++;
				rigaLetta=b.readLine();
			}
		} catch (FileNotFoundException e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}
		return righeTot;
		
	}
	
	protected int contaRigheCiclo(){

		FileReader f;
		BufferedReader b;
		int righeTot=0;
		String rigaLetta;
		try {
			f = new FileReader( "src/Files/cicli.txt");
			b= new BufferedReader(f);
			rigaLetta=b.readLine();
			while(rigaLetta != null){
				righeTot++;
				rigaLetta=b.readLine();
			}
		} catch (FileNotFoundException e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
			e.getCause();
			e.getMessage();
			e.printStackTrace();
		}
		return righeTot;
	}
	
	protected void aggiornaTabellaCalendario(int numero) {
		
		
		FileReader f;
		BufferedReader b;
		String rigaLetta ="";
		String[] campi=new String[9];
		try {
			f = new FileReader( "src/Files/calendario"+numero+".txt");
			b= new BufferedReader(f);
			rigaLetta = b.readLine();
			for(int i=0;i<contaRigheCalendario(numero);i++){
				campi=rigaLetta.split(Pattern.quote("$"));
				tabellaCalendario.setValueAt(campi[0], i, 0);
				tabellaCalendario.setValueAt(campi[1], i, 1);
				tabellaCalendario.setValueAt(campi[2], i, 2);
				tabellaCalendario.setValueAt(campi[3], i, 3);
				tabellaCalendario.setValueAt(campi[4], i, 4);
				tabellaCalendario.setValueAt(campi[5], i, 5);
				tabellaCalendario.setValueAt(campi[6], i, 6);
				tabellaCalendario.setValueAt(campi[7], i, 7);
				rigaLetta=b.readLine();
			}
			f.close();
			b.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		  }catch(IOException a){
			a.getCause();
			a.getMessage();
		   }
	}
	
protected void aggiornaTabellaCiclo(){

		
		FileReader f;
		BufferedReader b;
		String rigaLetta ="";
		String[] campi=new String[10];
		try {
			f = new FileReader( "src/Files/cicli.txt");
			b= new BufferedReader(f);
			rigaLetta = b.readLine();
			for(int i=0;i<contaRigheCiclo();i++){
				campi=rigaLetta.split(Pattern.quote("$"));
				tabellaCiclo.setValueAt(campi[0], i, 0);
				tabellaCiclo.setValueAt(campi[1], i, 1);
				tabellaCiclo.setValueAt(campi[2], i, 2);
				tabellaCiclo.setValueAt(campi[3], i, 3);
				tabellaCiclo.setValueAt(campi[4], i, 4);
				tabellaCiclo.setValueAt(campi[5], i, 5);
				tabellaCiclo.setValueAt(campi[6], i, 6);
				tabellaCiclo.setValueAt(campi[7], i, 7);
				tabellaCiclo.setValueAt(campi[8], i, 8);
				tabellaCiclo.setValueAt(campi[9], i, 9);
				rigaLetta=b.readLine();
			}
			f.close();
			b.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		  }catch(IOException a){
			a.getCause();
			a.getMessage();
		   }
		
		
	}
	
//public JComboBox<String>	getComboBox(){
//	return apriCicloComboBox;
//}
protected void setComboBox(){

		apriCicloComboBox.removeAllItems();
		FileReader f;
		BufferedReader b;
		String rigaLetta ="";
		String[] campi=new String[10];
		try {
			f = new FileReader( "src/Files/cicli.txt");
			b= new BufferedReader(f);
			rigaLetta = b.readLine();
			for(int i=0;i<contaRigheCiclo();i++){
				System.out.println(contaRigheCiclo());
				campi=rigaLetta.split(Pattern.quote("$"));
				
				apriCicloComboBox.insertItemAt(campi[1], i);
				
				rigaLetta=b.readLine();
			}
			f.close();
			b.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		  }catch(IOException a){
			a.getCause();
			a.getMessage();
		   }
		
		
	}
}
