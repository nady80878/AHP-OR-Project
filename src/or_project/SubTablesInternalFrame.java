package or_project;

import java.awt.BorderLayout;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;

public class SubTablesInternalFrame extends JInternalFrame {
public SubTablesInternalFrame(String tableName ,String alterNames[]) {
	setTitle(tableName+" Table");
	setToolTipText(tableName+" Table");
	setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
	getContentPane().setLayout(new BorderLayout());
	add(new SubTables(tableName,alterNames),BorderLayout.CENTER);
	setSize(1200, 600);
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
	// TODO Auto-generated constructor stub
}
}
