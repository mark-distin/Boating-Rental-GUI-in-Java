import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;

public class BoatQuery {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoatQuery window = new BoatQuery();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BoatQuery() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 620, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administration System");
		lblNewLabel.setFont(new Font("Bodoni MT", Font.PLAIN, 55));
		lblNewLabel.setBounds(29, 93, 547, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JButton create = new JButton("Create Boat");
		create.setBackground(new Color(192, 192, 192));
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.dispose();
				SecCreate createb = new SecCreate();
				createb.setVisible(true);
				
			}
		});
		create.setFont(new Font("Bell MT", Font.PLAIN, 26));
		create.setBounds(152, 195, 301, 41);
		frame.getContentPane().add(create);
		
		JButton search = new JButton("Search & Delete Boat");
		search.setBackground(new Color(192, 192, 192));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				SecSearch searchb = new SecSearch();
				searchb.setVisible(true);
				
			}
		});
		search.setFont(new Font("Bell MT", Font.PLAIN, 28));
		search.setBounds(152, 269, 301, 41);
		frame.getContentPane().add(search);
		
		JButton update = new JButton("Update Boat Period");
		update.setBackground(new Color(192, 192, 192));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				SecUpdate updateb = new SecUpdate();
				updateb.setVisible(true);
				
			}
		});
		update.setFont(new Font("Bell MT", Font.PLAIN, 28));
		update.setBounds(152, 345, 300, 41);
		frame.getContentPane().add(update);
		
		JLabel lblBoat = new JLabel("Boat");
		lblBoat.setFont(new Font("Bodoni MT", Font.PLAIN, 55));
		lblBoat.setBounds(241, 34, 118, 53);
		frame.getContentPane().add(lblBoat);
	}
}
