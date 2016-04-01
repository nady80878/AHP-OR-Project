package or_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


/*دا الكلاس بتاع النوع الاول من الجداول يعني الفريمه التالته*/

public class SubTables extends JPanel {
	private JTable table;
	private int rowCount = 0 , colCount = 0;
	double sum=0 , multi=1;
	public static int count  = 0;
	/*دا متغير عن طريقه هحدد رقم الجدول عشان وانا بحط القيم في الجدول الاخير يبقي سهل عليا اعرف اجيب القيم من كل جدول*/
	private int index ;
	
	/*دا الكونستركتور بتاع الكلاس اللي هعدي منه اسم الجدول واسماء الكاركتريا*/
	public SubTables(String tableName ,final String alterNames[]) {
		setLayout(null);
		index = count;
		
		count++;
		
		/*هنا بعمل شريط ازاحة للجدول و بعمله اطار بعنوان يحمل اسم الجدول
		 * تاني بحدد حجم الجدول و مكانه فين علي الفريمه 
		 * وبعدين بضيفه عليها*/
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 0, 128), new Color(255, 140, 0), new Color(0, 255, 255), new Color(186, 85, 211)), tableName+" Table", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
		scrollPane.setBounds(24, 11, 907, 402);
		add(scrollPane);
		
		/*هنا عملت اتنين اراي اول واحد اراي ذات بعد واحد ودي هتشيل اسماء كل عمود في الجدول والتانيه ذات بعدين عشان تشيل البيانات بتاع البدي +3 وحته +1*/
		final String header[]  = new String[alterNames.length+3];
		final Object body [][] = new Object[alterNames.length+1][alterNames.length+3];
		
		/*هنا بدئت من واحد عشان متنسوش اني سايب عمود فاضي في الاول وطبعا دي الفور لوب بتاع ادخال اسماء الالترناتفز داخل الاراي بتاع الهيدر*/
		for (int i = 1; i < header.length-2; i++) {
			header[i] = alterNames[i-1];
		}
		
		/*هنا الاسمين بتوع اخر عمودين دخلتيهم منفصلين */
		header[header.length-2] = "Geometric Mean";
		header[header.length-1] = "Normalization";
		
		/*هنا الاتنين لوب اللي هيعدوا علي الاراي بتاع البدي للجدول عشان تعمل الدايوجنال بواحد وكمان عشان تسمي كل صف باسم من الالترنيتفز */
		for (int i = 0; i < body.length-1; i++) {
			/*هنا عشان اسمي كل صف باسم ثبت العمود واتحركت علي الصفوف وطبعا وضحنا ليه*/
			body[i][0] = alterNames[i];
			for (int j = 1; j < body[i].length-2; j++) {
				/*هنا شرط الدايوجنال ان يكون رقم الصف مساوي لرقم العمود بس ماتنسوش ان هنا سايب عمود في الاول فاضي عشان كده عامل جاي - 1*/
				if(j-1==i){
				body[i][j] = "1";
				}
				else{
					body[i][j] = "";
				}
			}			
		}
		
		/*هنا بسمي اخر صف في الجدول */
		body[body.length-1][0] = "Sum";
		
		/*هنا عرفت الجدول وطبعا دخلته البيانات بطريقه غير مباشرة زي كنا موضحين اني هدخلوها ليه عن طريق موديل */
		table = new JTable();
		final DefaultTableModel model = new DefaultTableModel(body,header){
			
			/*هنا عدليت علي ميثود جاهزه في الجافا مهمتها انها بتخلي خانات الجدول لايتم التعديل عليها */
			public boolean isCellEditable(int row, int column)     
		    {
				
				/*هنا بقولها لو كان رقم العمود اكبر من رقم الصف خليني اعرف اعدل عادي غير كده خليه ممنوع من التعديل يعني المثلت العلوي من الجدول هو بس اللي هقدر اعدل عليه*/
				if(column-1 > row)
				return true;
		        return false;
				
		    }
		};
		table.setModel(model);
		
		/*هنا بقوله خليلي ان خانات الجدول بدل ما هي مربع نصي لا خلليه كومبوبوكس اقدر اختار منه وفي نفس الوقت اديني امكانيه التعديل برده عشان لو دخلت قيمه مش من ضمن القيم المتعارف عليها*/
		scrollPane.setViewportView(table);
		for (int i = 0; i < body.length-1; i++) {
			for (int j = 1; j < body[i].length-2; j++) {
				if(j-1>i){	
					JComboBox combo = new JComboBox(new Object[]{"1","2","3","4","5","6","7","8","9","1/2","1/3","1/4","1/5","1/6","1/7","1/8","1/9"});
					combo.setEditable(true);
					table.getColumnModel().getColumn(j).setCellEditor(new DefaultCellEditor(combo));
					}
			}			
		}

		/*هنا عملت اللابل بتاع السي ار 
		 * وحددتيه لون للخط ونوع الخط والمكان علي الفريمه والحازاة للنص وبعدين ضيفته علي الفريمه */
		final JLabel lblCr = new JLabel("C.R:");
		lblCr.setForeground(new Color(255, 0, 255));
		lblCr.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		lblCr.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCr.setHorizontalAlignment(SwingConstants.CENTER);
		lblCr.setBounds(24, 424, 88, 22);
		add(lblCr);
		
		/*هنا عملت اللابل بتاع اللامدا ماكس 
		 * وحددتيه لون للخط ونوع الخط والمكان علي الفريمه والحازاة للنص وبعدين ضيفته علي الفريمه */
		JLabel lblLamdaMax = new JLabel("Lambda Max:");
		lblLamdaMax.setForeground(new Color(255, 0, 0));
		lblLamdaMax.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLamdaMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblLamdaMax.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		lblLamdaMax.setBounds(24, 452, 88, 22);
		add(lblLamdaMax);
		
		/*هنا عملت اللابل بتاع السي اي 
		 * وحددتيه لون للخط ونوع الخط والمكان علي الفريمه والحازاة للنص وبعدين ضيفته علي الفريمه */
		JLabel lblCi_1 = new JLabel("C.I:");
		lblCi_1.setForeground(new Color(30, 144, 255));
		lblCi_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCi_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCi_1.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		lblCi_1.setBounds(24, 480, 88, 22);
		add(lblCi_1);
		
		/*اللابل اللي هيشيل قيمة السي ار*/
		final JLabel lblCr_1 = new JLabel("");
		lblCr_1.setForeground(new Color(0, 0, 255));
		lblCr_1.setBounds(116, 424, 250, 22);
		add(lblCr_1);
		/*اللابل اللي هيشيل قيمة اللامدا ماكس*/
		final JLabel lblLamda = new JLabel("");
		lblLamda.setForeground(new Color(0, 0, 255));
		lblLamda.setBounds(116, 452, 250, 22);
		add(lblLamda);
		/*اللابل اللي هيشيل قيمة السي اي*/
		final JLabel lblCi = new JLabel("");
		lblCi.setForeground(new Color(0, 0, 255));
		lblCi.setBounds(116, 480, 250, 22);
		add(lblCi);
		
		
		/*هنا بعرف الزرار بتاع السولف وعملتله الحدث بتاعه اللي هيشغله*/
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{

			// check , complete table , find geometric mean
			initTable();
				
			//find sum
			findSum();
			
			//find normalization
			findNorm();
		
			//find lambda max
			double lam = findLambdaMax();
		
			lblLamda.setText(""+lam);
			//find CI
			double CI = findCI(lam);
			
			lblCi.setText(""+CI); 
			//find CR
			double CR = 0;
			CR = findCR(CI);
			
			lblCr_1.setText(""+CR);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null , "Complete The rest of table in order to get a solution.", "Warning !!",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setIcon(new ImageIcon(getClass().getResource("solve.png")));
		button.setBounds(739, 424, 97, 78);
		add(button);
		
		/*هنا الزرار بتاع المسح من الاخر هو نفس الكود اللي شرحناه فوق بس ركزوا كده وانتم تلاحظوا*/
		JButton btnClear = new JButton("");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				lblLamda.setText("");
				lblCi.setText("");
				lblCr_1.setText("");
				model.setDataVector(body, header);
				table.setModel(model);
				for (int i = 0; i < body.length-1; i++) {
					for (int j = 1; j < body[i].length-2; j++) {
						if(j-1>i){	
							JComboBox combo = new JComboBox(new Object[]{"1","2","3","4","5","6","7","8","9","1/2","1/3","1/4","1/5","1/6","1/7","1/8","1/9"});
							combo.setEditable(true);
							table.getColumnModel().getColumn(j).setCellEditor(new DefaultCellEditor(combo));
						}
					}			
				}
			}
		});
		btnClear.setIcon(new ImageIcon(getClass().getResource("erase.png")));
		btnClear.setBounds(834, 424, 97, 78);
		add(btnClear);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("importance.PNG")));
		label.setBounds(928, 21, 275, 237);
		add(label);
		
		
		}
	void initTable(){
		rowCount = 0 ; colCount = 0;
	 rowCount  =table.getModel().getRowCount();
	 colCount = table.getModel().getColumnCount();		
	for(int i=0; i < rowCount-1;++i){
		multi = 1;
		for(int j=1;j<colCount-2;++j){
			 if(j-1 == i) continue;
			String value = table.getModel().getValueAt(i, j).toString();
			String value_ops = table.getModel().getValueAt(j-1,i+1).toString();
				if(value.contains("/")){
					String [] num = value.split("/");
				table.getModel().setValueAt(Double.parseDouble(num[1])/Double.parseDouble(num[0]),j-1,i+1);
				}
				else{
					table.getModel().setValueAt(Math.pow(Double.parseDouble(value), -1),j-1,i+1);
				}
			if(!value.contains("/")){
			multi *= Double.parseDouble(value);
			}else{
				String [] num = value.split("/");
				multi *= (Double.parseDouble(num[0])/Double.parseDouble(num[1])); 
			}			
	}
		table.getModel().setValueAt( ""+Math.pow(multi,1.00000000/(table.getModel().getColumnCount()-3)), i,table.getModel().getColumnCount()-2 );
	}
		}
	
	void findNorm(){
		double gmTot = Double.parseDouble(table.getModel().getValueAt( rowCount-1,colCount-2).toString());
		Object[] arr = new Object[rowCount-1];
		for(int i = 0 ; i < rowCount-1;++i){
		double gm = Double.parseDouble(table.getModel().getValueAt(i, colCount-2).toString());
		double res = gm/gmTot;
		arr[i] = res;
		table.getModel().setValueAt(res, i,colCount-1 );
		}
		SubTablesFrame.list[index] = arr;
		}
	
	void findSum(){
		for(int j=1;j<table.getModel().getColumnCount()-1;++j){
			 sum=0;
		for(int i=0; i < table.getModel().getRowCount()-1;++i){
			String value = table.getModel().getValueAt(i, j).toString();
			if(!value.contains("/")){
			sum += Double.parseDouble(value);
			}else{
				String [] num = value.split("/");
			sum += (Double.parseDouble(num[0])/Double.parseDouble(num[1]));
			}
			table.getModel().setValueAt(sum, table.getModel().getRowCount()-1,j );
			}
		}
			
		}
	
	double findLambdaMax(){
		double lam = 0;
		for(int i = 0; i < rowCount-1;++i){
			lam += (Double.parseDouble(table.getModel().getValueAt(i, colCount-1).toString())*Double.parseDouble(table.getModel().getValueAt(rowCount-1,i+1).toString()));
		}
		return lam;
		}
	
	    double findCI(double lam){
		double CI= (lam-(table.getModel().getRowCount()-1))/(table.getModel().getRowCount()-2);
		return CI;
		}
	
		double findCR(double CI){
		    double arr1[] = new double[]{0,0,0.58,0.9,1.12,1.24,1.32,1.41,1.45,1.49,1.51,1.48};
		    return (CI/arr1[table.getModel().getRowCount()-1]);
		}
	
}
