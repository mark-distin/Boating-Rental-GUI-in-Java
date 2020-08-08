import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Window;
import javax.swing.JComboBox;
import java.awt.Color;

public class SecCreate extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecCreate frame = new SecCreate();
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
	
	Enquiry enquiry=null;
	private JTable table;
	private JTextField ID;
	private JTextField PRICE;
	private JTextField RPRICE;
	private JTextField PERIOD;
	private JTextField DATE;
	private JLabel boatId;
	private JLabel boatType;
	private JLabel price;
	private JLabel status;
	private JLabel rentalPeriod;
	private JLabel date;
	private JLabel lblNewLabel_7;
	private JComboBox combot;
	private JComboBox combos;
	private JButton Back;
	private JLabel lblNewLabel;
	
	public SecCreate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 632);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Bell MT", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id, p , rp;
				String t=null;
				String s=null;
				String period=null;
				String d=null;
				
				try {
					
					id = Integer.parseInt(ID.getText());
					p = Integer.parseInt(PRICE.getText());
					rp = Integer.parseInt(RPRICE.getText());
					t = (String)combot.getSelectedItem();
					s = (String)combos.getSelectedItem();
					period = PERIOD.getText();
					d = DATE.getText();
						
					Enquiry.createBoat(id, t, p, rp, s, period, d);
					
				}catch(Exception ei)
				{
					JOptionPane.showMessageDialog(null, ei);
				}
				
			}
		});
		btnNewButton.setBounds(139, 513, 128, 33);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(433, 335, 1, 1);
		contentPane.add(table);
		
		ID = new JTextField();
		ID.setFont(new Font("Bell MT", Font.PLAIN, 20));
		ID.setBounds(350, 146, 143, 27);
		contentPane.add(ID);
		ID.setColumns(10);
		
		PRICE = new JTextField();
		PRICE.setFont(new Font("Bell MT", Font.PLAIN, 20));
		PRICE.setBounds(350, 246, 143, 27);
		contentPane.add(PRICE);
		PRICE.setColumns(10);
		
		RPRICE = new JTextField();
		RPRICE.setFont(new Font("Bell MT", Font.PLAIN, 20));
		RPRICE.setBounds(350, 292, 143, 27);
		contentPane.add(RPRICE);
		RPRICE.setColumns(10);
		
		PERIOD = new JTextField();
		PERIOD.setFont(new Font("Bell MT", Font.PLAIN, 20));
		PERIOD.setBounds(350, 395, 143, 27);
		contentPane.add(PERIOD);
		PERIOD.setColumns(10);
		
		DATE = new JTextField();
		DATE.setFont(new Font("Bell MT", Font.PLAIN, 20));
		DATE.setBounds(350, 446, 143, 27);
		contentPane.add(DATE);
		DATE.setColumns(10);
		
		boatId = new JLabel("Boat ID :");
		boatId.setFont(new Font("Bell MT", Font.PLAIN, 22));
		boatId.setBounds(173, 146, 128, 27);
		contentPane.add(boatId);
		
		boatType = new JLabel("Boat Type :");
		boatType.setFont(new Font("Bell MT", Font.PLAIN, 22));
		boatType.setBounds(173, 195, 128, 27);
		contentPane.add(boatType);
		
		price = new JLabel("Price :");
		price.setFont(new Font("Bell MT", Font.PLAIN, 22));
		price.setBounds(173, 248, 72, 21);
		contentPane.add(price);
		
		status = new JLabel("Status :");
		status.setFont(new Font("Bell MT", Font.PLAIN, 22));
		status.setBounds(173, 345, 84, 21);
		contentPane.add(status);
		
		rentalPeriod = new JLabel("Rental Period :");
		rentalPeriod.setFont(new Font("Bell MT", Font.PLAIN, 22));
		rentalPeriod.setBounds(173, 396, 143, 23);
		contentPane.add(rentalPeriod);
		
		date = new JLabel("Duration :");
		date.setFont(new Font("Bell MT", Font.PLAIN, 22));
		date.setBounds(173, 447, 109, 23);
		contentPane.add(date);
		
		lblNewLabel_7 = new JLabel("Create New Boat");
		lblNewLabel_7.setFont(new Font("Bodoni MT", Font.PLAIN, 50));
		lblNewLabel_7.setBounds(155, 24, 380, 109);
		contentPane.add(lblNewLabel_7);
		
		combot = new JComboBox();
		combot.setFont(new Font("Bell MT", Font.PLAIN, 20));
		combot.addItem("small");
		combot.addItem("medium");
		combot.addItem("large");
		combot.setBounds(350, 196, 143, 27);
		contentPane.add(combot);
		
		combos = new JComboBox();
		combos.setFont(new Font("Bell MT", Font.PLAIN, 20));
		combos.addItem("available");
		combos.addItem("unavailable");
		combos.setBounds(350, 343, 143, 27);
		contentPane.add(combos);
		
		Back = new JButton("Back");
		Back.setBackground(Color.LIGHT_GRAY);
		Back.setFont(new Font("Bell MT", Font.PLAIN, 22));
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BoatQuery back = new BoatQuery();
				back.frame.setVisible(true);
				dispose();

			}
		});
		Back.setBounds(380, 513, 123, 33);
		contentPane.add(Back);
		
		lblNewLabel = new JLabel("Rental Price :");
		lblNewLabel.setFont(new Font("Bell MT", Font.PLAIN, 22));
		lblNewLabel.setBounds(173, 298, 128, 21);
		contentPane.add(lblNewLabel);
	}
}
