import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;

public class SecSearch extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JLabel lblNewLabel_1;
	private JButton btnSearch;
	private JButton Back;
	private JComboBox combo;
	static JTable table;
	private JLabel lblEnterBoatId;
	private JTextField t2;
	private JButton Delete;
	private JScrollPane scrollPane;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecSearch frame = new SecSearch();
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
	public SecSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 659);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search & Delete Boat");
		lblNewLabel.setFont(new Font("Bodoni MT", Font.PLAIN, 45));
		lblNewLabel.setBounds(197, 13, 478, 93);
		contentPane.add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setFont(new Font("Bell MT", Font.PLAIN, 20));
		t1.setBounds(384, 164, 123, 29);
		contentPane.add(t1);
		t1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("The way you want to search :");
		lblNewLabel_1.setFont(new Font("Bell MT", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(77, 119, 293, 29);
		contentPane.add(lblNewLabel_1);
		
		btnSearch = new JButton("Search");
		btnSearch.setBackground(Color.LIGHT_GRAY);
		btnSearch.setFont(new Font("Bell MT", Font.PLAIN, 22));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String i1 = "All";
					String i2 = "Boat Type";
					String i3 = "Boat ID";
					String text = t1.getText();
					String search = null;
					Object com = combo.getSelectedItem();
			//		System.out.print("combobox"+com);

				for(;;)	{
					if(com.equals(i1)) {
						
						search = "select * from boat;" ;
						break;
					}
					else if(com.equals(i2)) {
						
						search = "select * from boat where boattype = '" + text + "';" ;
						break;
							
					}
					if(com.equals(i3)) {
						
						search = "select * from boat where boatid = '" + text + "';" ;
						break;

					}
					else {
						JOptionPane.showMessageDialog(null, "Please enter correctly!");
						break;
					}
					
				}
	//				System.out.println(search);
					Enquiry.searchBoat(search);
					
				}catch(Exception ei)
				{
					JOptionPane.showMessageDialog(null, ei);
				}
				
			}
		});
		btnSearch.setBounds(555, 161, 123, 33);
		contentPane.add(btnSearch);
		
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
		Back.setBounds(14, 13, 123, 33);
		contentPane.add(Back);
		
		combo = new JComboBox();
		combo.setFont(new Font("Bell MT", Font.PLAIN, 20));
		combo.addItem("All");
		combo.addItem("Boat Type");
		combo.addItem("Boat ID");
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		combo.setBounds(384, 122, 123, 29);
		contentPane.add(combo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 269, 762, 330);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		lblEnterBoatId = new JLabel("Enter Boat ID to delete :  ");
		lblEnterBoatId.setFont(new Font("Bell MT", Font.PLAIN, 22));
		lblEnterBoatId.setBounds(119, 216, 251, 25);
		contentPane.add(lblEnterBoatId);
		
		t2 = new JTextField();
		t2.setFont(new Font("Bell MT", Font.PLAIN, 20));
		t2.setBounds(384, 215, 123, 29);
		contentPane.add(t2);
		t2.setColumns(10);
		
		Delete = new JButton("Delete");
		Delete.setBackground(Color.LIGHT_GRAY);
		Delete.setFont(new Font("Bell MT", Font.PLAIN, 22));
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String text = t2.getText();
					String delete = "delete from boat where boatid = ' " + text + " ';";
					Enquiry.deleteBoat(delete);
					String all = "select * from boat;";
					Enquiry.searchBoat(all);
							
				}catch(Exception d) {
					
					JOptionPane.showMessageDialog(null, d);
					
				}
			}
		});
		Delete.setBounds(555, 212, 123, 33);
		contentPane.add(Delete);
	}
	
	
}
