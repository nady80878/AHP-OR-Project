package or_project;

import java.awt.Color;
import java.beans.PropertyVetoException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class CaracteriaTable extends JInternalFrame{

	private JTable table;

	/**
	 * Create the application.
	 */
	private String alterNames[] , caracNames[];
	private String caracVals[][];
	private JScrollPane scrollPane;
	private JButton button;
	private JLabel lblRes;
	public CaracteriaTable(String alterNames[]  , String caracNames[]) {
		this.alterNames = alterNames;
		this.caracNames = caracNames;
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private DefaultTableModel initTable(){
		String header[]; 
		Object body[][];
		header = new String[caracNames.length+2];
		body = new Object[alterNames.length+1][caracNames.length+2];
		body[0][0]="periority vector";
		for (int i = 1; i < header.length-1; i++) {
			header[i]=caracNames[i-1];
			body[0][i]  = SubTablesFrame.list[SubTablesFrame.list.length-1][i-1];
		}
		int count = 1;
		
		header[header.length-1] = "goal periority";
		for (int j = 1; j < body[0].length-1; j++) {
			
			for (int i = 1; i < body.length; i++) {
				body[i][0] = alterNames[i-1];
				body[i][j] = SubTablesFrame.list[j-1][i-1];
			}	
		}
		double res = 0 , max = 0;
		int index = 0;
		for (int i = 1; i < body.length; i++) {
			res = 0;
			for (int j = 1; j < body[0].length-1; j++) {
				res += (Double.parseDouble(body[0][j].toString())*Double.parseDouble(body[i][j].toString())); 
				body[i][body[0].length-1] = res;
				if(res > max){
					max = res;
					index = i;
				}
			}		
		}
		
		lblRes.setText("The goal programming found in: " + body[index][0].toString() );
			
		DefaultTableModel model = new DefaultTableModel(body,header);
		return model;
	}
	private void initialize() {
		setBounds(100, 100, 959, 571);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setMaximizable(true);
		setResizable(true);
		setClosable(true);
		setVisible(true);
		setAutoscrolls(true);
		setIconifiable(true);
		try {
			setIcon(false);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(106, 90, 205), null), "Caracteria Table", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBounds(10, 11, 907, 432);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 887, 396);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		button = new JButton("");
		button.setIcon(new ImageIcon(getClass().getResource("solve.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				table.setModel(initTable());
				}catch(Exception e){
					JOptionPane.showMessageDialog(null , "Make sure you have done every thing correctly.", "Warning !!",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setBounds(10, 454, 97, 78);
		getContentPane().add(button);
		
		lblRes = new JLabel("");
		lblRes.setForeground(new Color(0, 128, 0));
		lblRes.setBounds(134, 454, 621, 78);
		getContentPane().add(lblRes);
	}
}
