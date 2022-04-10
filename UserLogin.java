/***
 * @author maia ocampo
 * 
 * @version 1.8
 * 
 */


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel; 

public class UserLogin implements ActionListener
{
	//private fields
	private static JLabel userlabel; 
	private static JTextField EmailField; 
	private static JLabel passwordLabel; 
	private static JPasswordField passwordChars; 
	private static JButton loginButton; 
	private static JButton createUser; 
	private static JTextField userPassword;
	
	
	
	private static JLabel pageStockHeader; 
	private static JLabel pageStockinfo;

	public static void main (String [] args)
	{
		
		EventQueue.invokeLater(new Runnable () 
				{
		public void run()
		{
			try {
				UserLogin frame = new UserLogin();
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
				});
		
	}
	
	
	
	/**
	 * making the frame
	 */
	public UserLogin()
	{
		//panel to make actual login window 
		JPanel panel = new JPanel(); 
		JFrame frame = new JFrame("Stocks Email Login");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		//make the user test and login text field
		userlabel = new JLabel("E-mail");
		userlabel.setForeground(Color.BLACK);
		userlabel.setFont(new Font ("Times New Roman", Font.PLAIN, 16));
		userlabel.setBounds(10,20,80,25);
		panel.add(userlabel);
		
		EmailField = new JTextField(20);
		EmailField.setBounds(100,20,165,25);
		panel.add(EmailField);
		
		
		//same for password
		passwordLabel = new JLabel ("Password");
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setFont(new Font ("Times New Roman", Font.PLAIN, 16));
		passwordLabel.setBounds(10, 50,80,25);
		panel.add(passwordLabel);
		
		
		//add in password field - looks like dots instead of characters
		 passwordChars = new JPasswordField();
		passwordChars.setBounds(100,50,165,25);
		panel.add(passwordChars);
		
		
		//add button for login
		loginButton = new JButton("Login");
		loginButton.setForeground(Color.BLACK);
		loginButton.setFont(new Font ("Times New Roman", Font.PLAIN, 13));
		loginButton.setBounds(10,80,80,25);
		
		loginButton.addActionListener(new ActionListener() 
		{
			/***
			 * for now, until we figure out SQL serve, only this password is 
			 * able to login 
			 * 
			 * email: mocampo5@gmu.edu
			 * Password: CS211
			 * 
			 * With a successful login - code will bring to new JPanel which will 
			 * contain the user's own personalized page of their stocks
			 * 
			 * for now, there is a visual stand in, the code below is for testing & visual 
			 * purposes 
			 * 
			 */
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String email = EmailField.getText(); 
				String password = passwordChars.getText();
				
				if(email.equals("mocampo5@gmu.edu") && password.equals("CS211"))
				{
					System.out.println("Login Successful! -- this will not be the actual login action result.");
					
					JPanel panel = new JPanel(); 
					JFrame frame = new JFrame("Your Stocks Page!!");
					frame.setSize(600,600);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.add(panel);
					
					panel.setLayout(null);
					
					
					pageStockHeader = new JLabel("Stock Information: ");
					pageStockHeader.setBounds(10, 50, 165, 25);
					pageStockHeader.setForeground(Color.RED);
					pageStockHeader.setFont(new Font ("Times New Roman", Font.PLAIN, 20));
					panel.add(pageStockHeader);
					
					
					pageStockinfo = new JLabel("~~place holder text~~~ ");
					pageStockinfo.setBounds(10, 50, 165, 100);
					pageStockinfo.setForeground(Color.BLACK);
					pageStockinfo.setFont(new Font ("Times New Roman", Font.PLAIN, 20));
					panel.add(pageStockinfo);
					
					
					frame.setVisible(true);
					
				}
				
			}
			
		});
		panel.add(loginButton);
		
		
		
		
		/**
		 * create user button
		 * 
		 * for now, this button will not enact an action but will redirect to a new page
		 */
		createUser = new JButton("New user");
		createUser.setForeground(Color.BLACK);
		createUser.setFont(new Font ("Times New Roman", Font.PLAIN, 13));
		createUser.setBounds(150,80,80,25);
		createUser.addActionListener(new ActionListener() 
		{
			/***
			 * this will pull up the option to create a new user
			 * until SQL server is established, no further action from here
			 * 
			 * 
			 * the action will eventually allow for the user to go back to login page 
			 * and go from there. 
			 * 
			 */
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JPanel panel = new JPanel(); 
				JFrame frame = new JFrame("Create New User!");
				frame.setSize(300,200);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(panel);
				
				panel.setLayout(null);
				
				userlabel = new JLabel("E-mail");
				userlabel.setForeground(Color.BLACK);
				userlabel.setFont(new Font ("Times New Roman", Font.PLAIN, 16));
				userlabel.setBounds(10,20,80,25);
				panel.add(userlabel);
				
				EmailField = new JTextField(20);
				EmailField.setBounds(100,20,165,25);
				panel.add(EmailField);
				
				
			
				passwordLabel = new JLabel ("Password");
				passwordLabel.setForeground(Color.BLACK);
				passwordLabel.setFont(new Font ("Times New Roman", Font.PLAIN, 16));
				passwordLabel.setBounds(10, 50,80,25);
				panel.add(passwordLabel);
				
				userPassword = new JTextField(20);
				passwordChars.setBounds(100,50,165,25);
				panel.add(passwordChars);
				
				
				frame.setVisible(true);
				
				
				
			}
			
		});
		panel.add(createUser); 
		
		
		frame.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	

	
	
	
	
	
	
}
