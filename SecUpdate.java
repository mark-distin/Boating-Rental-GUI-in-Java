import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class SecUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField period;
	private JTextField duration;
	private JTextField boatid;
	private JComboBox combo;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecUpdate frame = new SecUpdate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 438);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Rental Period");
		lblNewLabel.setFont(new Font("Bodoni MT", Font.PLAIN, 45));
		lblNewLabel.setBounds(76, 13, 484, 95);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rental period :");
		lblNewLabel_1.setFont(new Font("Bell MT", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(119, 168, 140, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Duration :");
		lblNewLabel_2.setFont(new Font("Bell MT", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(119, 208, 99, 27);
		contentPane.add(lblNewLabel_2);
		
		period = new JTextField();
		period.setFont(new Font("Bell MT", Font.PLAIN, 20));
		period.setBounds(307, 169, 144, 27);
		contentPane.add(period);
		period.setColumns(10);
		
		duration = new JTextField();
		duration.setFont(new Font("Bell MT", Font.PLAIN, 20));
		duration.setBounds(307, 209, 144, 27);
		contentPane.add(duration);
		duration.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Boat Id :");
		lblNewLabel_3.setFont(new Font("Bell MT", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(119, 128, 99, 27);
		contentPane.add(lblNewLabel_3);
		
		boatid = new JTextField();
		boatid.setFont(new Font("Bell MT", Font.PLAIN, 20));
		boatid.setBounds(307, 127, 144, 27);
		contentPane.add(boatid);
		boatid.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Bell MT", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					String id=null;
					String rp=null;
					String d=null;
					String s= null;
					String i1 = "available";
					String i2 = "unavailable";
					id = boatid.getText();
					rp = period.getText();
					d = duration.getText();
					s = (String)combo.getSelectedItem();
			//		System.out.print("Status:" +status);

			    	String update = "update boat set rentalPeriod = ' " +rp+ " ', date = ' " + d + " ', status = ' " + s + " '  where boatID = ' " + id + " ';";
			     //	System.out.println(update);
					Enquiry.updateBoat(update);
					
				}catch(Exception ei) {
					JOptionPane.showMessageDialog(null, ei);
				}
				
			}
		});
		btnNewButton.setBounds(129, 317, 121, 33);
		contentPane.add(btnNewButton);
		
		JButton Back = new JButton("Back");
		Back.setBackground(Color.LIGHT_GRAY);
		Back.setFont(new Font("Bell MT", Font.PLAIN, 22));
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BoatQuery back = new BoatQuery();
				back.frame.setVisible(true);
				dispose();
				
			}
		});
		Back.setBounds(319, 317, 121, 33);
		contentPane.add(Back);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setFont(new Font("Bell MT", Font.PLAIN, 22));
		lblStatus.setBounds(119, 250, 99, 27);
		contentPane.add(lblStatus);
		
		combo = new JComboBox();
		combo.setFont(new Font("Bell MT", Font.PLAIN, 20));
		combo.addItem("available");
		combo.addItem("Unavailable");
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		combo.setBounds(307, 251, 144, 27);
		contentPane.add(combo);
	}

}
