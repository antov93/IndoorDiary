package indoor;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FinestraLogin {
	
	static private JTextField userText;
	static private JPasswordField pwText;
	static private JFrame frameLogin=new JFrame("Login");
	
	public static final Dimension DIM_TEXT_FIELD=new Dimension(100,25);
	
	public FinestraLogin(){
		creaFinestraLogin();
	}
	
	public void creaFinestraLogin(){
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.setLocation(new Point(500,200));
		frameLogin.setSize(300, 250);
		frameLogin.setResizable(true);
		
		JPanel pannello=new JPanel();  
		pannello.setLayout(new BoxLayout(pannello,BoxLayout.Y_AXIS)); 
		
		JPanel panel1=new JPanel();//pannello per campo user
		
		JLabel label1=new JLabel("User: ");
		userText= new JTextField();
		userText.setPreferredSize(DIM_TEXT_FIELD);
		userText.setText("antov");
		
		JPanel panel2=new JPanel();//pannello per campo pass
		
		JLabel label2=new JLabel("Password: ");
		pwText= new JPasswordField();
		pwText.setPreferredSize(DIM_TEXT_FIELD);
		pwText.setText("verde");
		
		JPanel panel3=new JPanel(); //pannello per bottoni
		
		JButton bottoneOK=new JButton("LOGIN");
		JButton bottoneCANCEL= new JButton("Annulla");
		
		bottoneOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
					loginButtonActionPerformed(event);
				
			}
		});
	
	bottoneCANCEL.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent event) {
				cancelButtonActionPerformed(event);
			
		}
	});
	
	JPanel panel5=new JPanel();//pannello aggiunto solo per centra i campi user epw nella finestra
	
	
	frameLogin.getContentPane().add(pannello);
	pannello.add(panel5);//vuoto
	pannello.add(panel1);//user
	pannello.add(panel2);//pass
	pannello.add(panel3);//bottoni
	
	panel1.add(label1);
	panel1.add(userText);
	
	panel2.add(label2);
	panel2.add(pwText);
	
	panel3.add(bottoneOK);
	panel3.add(bottoneCANCEL);
	
	frameLogin.setVisible(true);
	
	} //fine creaFinestraLogin



	protected static void cancelButtonActionPerformed(ActionEvent event) {
		frameLogin.dispose();
	}



	protected static void loginButtonActionPerformed(ActionEvent event){
		
		FileReader f;
		BufferedReader b;
		
		String user= userText.getText();
		String pass=new String(pwText.getPassword());
		String credenziali= user+pass;
		String rigaLetta;
		try {
			f = new FileReader( "src/Files/credenziali.txt");
			b= new BufferedReader(f);
			
			rigaLetta=b.readLine();
			System.out.println(rigaLetta);
			System.out.println(credenziali);
			while(rigaLetta != null){
				System.out.println(rigaLetta);
				System.out.println(credenziali);
				if(rigaLetta.equals(credenziali)){
					Ciclo c=new Ciclo(user);
					frameLogin.dispose();
					System.out.println("connesso");
					break;
					
				}else{
					rigaLetta=b.readLine();
					if(rigaLetta==null){
						System.out.println("credenziali nn valide");
						System.out.println(rigaLetta);
						System.out.println(credenziali);

						break;
						
						}
						
				}
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
		
		
		
		
		
		
	}

}
