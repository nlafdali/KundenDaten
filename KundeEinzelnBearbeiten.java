package KundenBearbeiten;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.Statement;

public class KundeEinzelnBearbeiten extends JFrame {

	
	private Connection TestConn;
	private ResultSet rs;
	private Statement stmt;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textStrasse;
	private JTextField textPlz;
	private JTextField textOrt;
	private JButton btnConnectDb; 
	private JButton btnMoveVor;
	private JButton btnMoveNext;
	private JButton buttonOk;
	private JButton buttonCancel;
	private JButton btnUpdate;
	private JButton btnDelete;
	
	
	 //Create the frame.
	 
	public KundeEinzelnBearbeiten() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(213, 10, 10, 10);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(10, 10, 470, 449);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(10, 20, 440, 410);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		btnConnectDb = new JButton(" Connect the Database and Table Kunden");
		btnConnectDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectToDb();
			}
		});
		btnConnectDb.setBounds(10, 10, 406, 21);
		btnConnectDb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(btnConnectDb);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(30, 43, 144, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(lblNewLabel);
		
		textName = new JTextField();
		textName.setBounds(30, 63, 350, 30);
		panel_2.add(textName);
		textName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("strasse");
		lblNewLabel_1.setBounds(30, 117, 106, 13);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(lblNewLabel_1);
		
		textStrasse = new JTextField();
		textStrasse.setBounds(30, 140, 350, 19);
		panel_2.add(textStrasse);
		textStrasse.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PLZ");
		lblNewLabel_2.setBounds(30, 184, 58, 13);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ort");
		lblNewLabel_3.setBounds(216, 183, 67, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(lblNewLabel_3);
		
		textPlz = new JTextField();
		textPlz.setBounds(30, 207, 73, 30);
		panel_2.add(textPlz);
		textPlz.setColumns(10);
		
		textOrt = new JTextField();
		textOrt.setBounds(216, 207, 70, 29);
		textOrt.setColumns(10);
		panel_2.add(textOrt);
		
		btnMoveVor = new JButton("<");
		
		btnMoveVor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPrevius();
				btnMoveNext.setEnabled(true);
				
			}
		});
		btnMoveVor.setBounds(30, 276, 45, 21);
		btnMoveVor.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(btnMoveVor);
		
		btnMoveNext = new JButton(">");
		btnMoveNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNext();
			}
		});
		btnMoveNext.setBounds(322, 277, 58, 21);
		btnMoveNext.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(btnMoveNext);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				
			}
		});
		btnUpdate.setBounds(89, 277, 85, 21);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				
			}
		});
		btnDelete.setBounds(198, 277, 85, 21);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(btnDelete);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 350, 440, 41);
		panel_3.setBackground(new Color(192, 192, 192));
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KundeEinzelnBearbeiten.this.dispose();
			
			}
		});
		buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonCancel.setBounds(330, 10, 100, 21);
		panel_3.add(buttonCancel);
		
		buttonOk = new JButton("Ok");
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonOk.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonOk.setBounds(266, 10, 54, 21);
		panel_3.add(buttonOk);
		
		JButton btnInsert = new JButton("einfügen");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnInsert.setBounds(77, 308, 85, 21);
		panel_2.add(btnInsert);
	}

private void ConnectToDb() {
		
		StartUp MakeCon = new StartUp();
		TestConn = MakeCon.getMyCon();
		GetData();
	}

private void GetData() {
	String query = "select * from mitarbeiter";
	try {
		stmt = TestConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		rs = stmt.executeQuery(query);
		rs.next();
		System.out.println(rs.getString("FamilienName"));
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
}

private void showNext() {
	
	try {
		if (rs.isLast()) {
			
			btnMoveNext.setEnabled(false);
			
		}else {
			rs.next();
			textName.setText(rs.getString("FamilienName"));
			textStrasse.setText(rs.getString("Strasse"));
			textPlz.setText(rs.getString("Plz"));
			textOrt.setText(rs.getString("Ort"));
			
		}
		

	}catch (SQLException e) {
		e.printStackTrace();
	}
}
	
	private void showPrevius() {
		
		try {
			if (rs.isFirst()) {
				
				btnMoveNext.setEnabled(false);
				
			}else {
				rs.previous();
				textName.setText(rs.getString("FamilienName"));
				textStrasse.setText(rs.getString("Strasse"));
				textPlz.setText(rs.getString("Plz"));
				textOrt.setText(rs.getString("Ort"));
				
			}
			

		}catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	private void update() {
		
		try {
			rs.updateString("FamilienName", textName.getText());
			rs.updateString("Strasse", textStrasse.getText());
			rs.updateString("Plz", textPlz.getText());
			rs.updateString("Ort", textOrt.getText());
			rs.updateRow();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	private void delete() {
		
		try {
			rs.deleteRow();
			textName.setText("");
			textStrasse.setText("");
			textPlz.setText("");
			textOrt.setText("");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
	}
	
	private void insert() {
		
		try {
			
			rs.moveToInsertRow();
			rs.updateString("FamilienName", textName.getText());
			rs.updateString("Strasse", textStrasse.getText());
			rs.updateString("Plz", textPlz.getText());
			rs.updateString("Ort", textOrt.getText());
			rs.insertRow();
			rs.moveToCurrentRow(); // aufräumen 
			
		}catch (SQLException e) {
			e.printStackTrace();
	}
		
		
				
	}
}
