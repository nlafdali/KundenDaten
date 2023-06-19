package KundenBearbeiten;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.JOptionPane;


	public class StartUp{
		
		private Connection myCon;
		
		public Connection getMyCon() {
			return myCon;
		}
		public void setMyCon(Connection myCon) {
			this.myCon = myCon;
		}
		@SuppressWarnings("deprecation")
		
		public StartUp () {
			System.out.println("ini Connection");
			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				}catch (InstantiationException e){
					e.printStackTrace();
				}catch (IllegalAccessException e) {
					e.printStackTrace();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false";
			
				try {
					myCon = DriverManager.getConnection(url, "Nadia", "Passw0rd");
				}catch (SQLException e) {
					e.printStackTrace();
				}
				
				if (isDbConnected(myCon)) {
					JOptionPane.showMessageDialog(null, "Connection is OK", "Connection_check", JOptionPane.PLAIN_MESSAGE);
					try {
						DatabaseMetaData dbmd = myCon.getMetaData();
						System.out.println("dbmd:driver version = " + dbmd.getDriverVersion());
						System.out.println("dbmd:driver name = " + dbmd.getDriverName());
						System.out.println("db name = " + dbmd.getDatabaseProductName());
						System.out.println("db ver = " + dbmd.getDatabaseProductVersion());

					} catch (SQLException e) {
						e.printStackTrace();
					}
					Enumeration drivers = DriverManager.getDrivers();
					while (drivers.hasMoreElements())
						System.out.println(drivers.nextElement().getClass().getName());
				}else {
					JOptionPane.showMessageDialog(null, "Connection is not ok", "Connection_check", JOptionPane.ERROR_MESSAGE);
					
				}
			
		}
		private boolean isDbConnected(Connection con) {
			try {
				return con != null && !con.isClosed();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}

	}


