package or_project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.TitledBorder;


/*ده الكلاس بتاع اول فريمه اللي بنحدد فية عدد الكاركتريا والالترنيتفز*/
public class setData {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		/*هنا انا بعمل السيمز بتاع البرنامج اللي اسمه نيمبص في 5 سطور الجايين*/
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
		    	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		    	        if ("Nimbus".equals(info.getName())) {
		    	            UIManager.setLookAndFeel(info.getClassName());
		    	            break;
		    	        }
		    	    }
		    	   }
		     catch (Exception e) {
		        System.out.println("can't set look and feel");
		     }
	/*هنا بعمل اوبجيكت من الكلاس وبخلي الرؤيه بتاعته ترو عشان امكن ان الفرينه تظهر*/
		new setData().frame.setVisible(true);;
	}
});
	}

	/**
	 * Create the application.
	 */
	public setData() {
		/*دي الميثود اللي فيها الكود بتاع الازرار و الكومبو بوكس وغيره يعني الكود اللي بيشغل البرنامج*/
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		/*ال 6 سطور الجايين دول بظبط فيها خصائص الفريمه
		 * اول سطر بعمل اوبجيت من الفريمه عشان يبقي فيه سهوله في التعامل معها
		 * تاني سطر بظبط فيه حجم الفريمه والاحداثيات بتاع المكان بتاعها علي الشاشه الاكس والواي
		 * تالت سطر بعرف فيه وظيفه زرار القفلان انه اول مضغط عليه يقفل الفريمه
		 * رابع سطر بحدد فيه طريقة تقسيم الفريمه انه يسبني احدد مكانهم برحتي بمزاجي يعني
		 * خامس سطر بحدد ان اول لظهور الفريمه هيبقي في نص الشاشه 
		 * سادس سطر بقوله فيه ان ميخيليش اي حد يقدر يتحكم في حجم الفريمه عن طريق التكبير او التصغير يعني عايز حجمها ثابت*/
		frame = new JFrame();
		frame.setBounds(100, 100, 467, 206);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		/*هنا بعرف البانل اللي هينحط عليها الكومبو بوكس واللابلات والازرار وغيرها
		 * تاني سطر بقوله فيه اعملها اطار بعنوان وسميه AHP Info. 
		 * تالت سطر معروف
		 * رابع سطر بضيف البانل دي علي الفريمه 
		 *  خامس سطر بحدد فيه طريقة تقسيم البانل انه يسبني احدد مكانهم برحتي بمزاجي يعني*/
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "AHP Info.", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_1.setBounds(10, 11, 441, 96);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		/*هنا بعمل لابل وعامله نص اسمه alternatives
		 * عشان يوضح مهمة الكومبو بوكس
		 * السطر التاني بقوله فيه ان عايز محازاة النص ده يبقي في المنتصف
		 * وبعدين بحدد الحجم والمكان علي البانل وبعدين بضيفه علي البانل */
		JLabel label = new JLabel("Alternatives");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 33, 108, 27);
		panel_1.add(label);
		
		/*هنا بعرف الكومبو بوكس وبدخله القيم علي هيئة موديل وطبعا شرحنا يعني ايه موديل 
		 * وبعدين بحدد الحجم و المكان علي البانل و بعدين بضيفه عليها*/
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.setBounds(116, 36, 75, 20);
		panel_1.add(comboBox);
		/*زي اللابل اللي فوق */
		JLabel label_1 = new JLabel("caracteria ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(234, 33, 108, 27);
		panel_1.add(label_1);
		/* زي الكومبوبوكس اللي فوق*/
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_1.setBounds(333, 36, 75, 20);
		panel_1.add(comboBox_1);
	
		/*هنا عرفت الزرار بتاع الجينيرات وعملتله الحدث الخاص بيه عشان يشغله 
		 * اللي مفروض وظيفته هنا انه اول حاجه هيجيب القيم اللي اخترتها من الكومبوبوكس وهيعديها للفريمه التانيه
		 * تاني حاجه هيعملها هنا انه هيظهر الفريمه التانيه يعني هيخلي رؤيتها بترو
		 * ياريت متنسوش الطريقه اللي هيحول بيها قيم الكومبوبوكس الي انتيجر اول حاجه بيحول من الاوبجيت للاسترينج وبعدين للانتيجر
		 * تالت حاجه هيعملها هنا انه هيقفل الفريمه بتاعته الحاليه يعني هيعملها ديسبوز */
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alt_car_data ob = new alt_car_data(Integer.parseInt(comboBox_1.getSelectedItem().toString()), Integer.parseInt(comboBox.getSelectedItem().toString()));
			    ob.frame.setVisible(true);
			    frame.dispose();
			}
		});
		
		
		/*هنا بعمل للزرار بتاع الجينيرات ايكون علي هيئه صوره فلازم الاول قبل مااديله مساره الصورة 
		 * لازم الاول اعرفه ان المسار ده هيكون لصورة عشان كده جيبت كلاس جاهز من الجافا اللي اسمه ايميدج ايكون 
		 * واللي عن طريقه هاعرف الكومبيلر ان المسار ده هيكون مسار صوره 
		 * تالت حاجه بحددله المجازاه للنص عشان يبقي النص علي اليمين والصورة علي الشمال 
		 * رابع حاجه ضيفته علي الفريمه*/
		btnGenerate.setIcon(new ImageIcon(getClass().getResource("Generate.png")));
		btnGenerate.setHorizontalAlignment(SwingConstants.RIGHT);
		btnGenerate.setBounds(315, 114, 136, 53);
		frame.getContentPane().add(btnGenerate);
		
		/*نفس اللي عاملته في الزرار بتاع الجينيرات */
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button.setIcon(new ImageIcon(getClass().getResource("remove.png")));
		button.setBounds(268, 114, 51, 53);
		frame.getContentPane().add(button);
	}
}
