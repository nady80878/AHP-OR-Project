package or_project;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/*دا الكلاس بتاع تاني فريمه*/
public class alt_car_data {

	public JFrame frame;
	private  JTextField [] txtCaracteria;
	private  JTextField [] txtAlternative;
	/*هنا عرفت اتنين بانل واحده هتشيل التكست فيلد للالترنينتفز وواحده للكاركتريا*/
    private JPanel panel;
    private JPanel panel_1;
	
	/**
	 * Create the application.
	 */
    
    /*دا الكونستركتور اللي فيه بستقبل فيه عدد الكاركتريا والالترنيتفز */
	int numOfAlternative , numOfCaracteria;
	public alt_car_data(int numOfCaracteria , int numOfAlternative) {
		this.numOfAlternative = numOfAlternative;
		this.numOfCaracteria = numOfCaracteria;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initData() {
		
		/*طبعا هنا بعرف التكست فيلد علي هيئه اراي بحيث اعرف اتعامل معاه عشان اعرف اضيفه و اجيب منه القيم */
			txtCaracteria = new JTextField[numOfCaracteria];
			txtAlternative = new JTextField[numOfAlternative];
			
			for (int i = 0; i < txtAlternative.length; i++) {
				/*هنا طبعا بعرف كل تكست فيلد علي حدي وبحطله نص افتراضي وبعدين بضيفه علي الفريمه*/
				txtAlternative[i] = new JTextField(15);
				txtAlternative[i].setText("Alternative : " + (i+1));
				panel.add(txtAlternative[i]);
			}
			for (int i = 0; i < txtCaracteria.length; i++) {
				txtCaracteria[i] = new JTextField(15);
				txtCaracteria[i].setText("Caracteria : " + (i+1));
				panel_1.add(txtCaracteria[i]);
			}
	}
	private void initialize() {
		/*ال 6 سطور الجايين دول بظبط فيها خصائص الفريمه
		 * اول سطر بعمل اوبجيت من الفريمه عشان يبقي فيه سهوله في التعامل معها
		 * تاني سطر بظبط فيه حجم الفريمه والاحداثيات بتاع المكان بتاعها علي الشاشه الاكس والواي
		 * تالت سطر بعرف فيه وظيفه زرار القفلان انه اول مضغط عليه يقفل الفريمه
		 * رابع سطر بحدد فيه طريقة تقسيم الفريمه انه يسبني احدد مكانهم برحتي بمزاجي يعني
		 * خامس سطر بحدد ان اول لظهور الفريمه هيبقي في نص الشاشه 
		 * سادس سطر بقوله فيه ان ميخيليش اي حد يقدر يتحكم في حجم الفريمه عن طريق التكبير او التصغير يعني عايز حجمها ثابت*/
		frame = new JFrame();
		frame.setBounds(100, 100, 558, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		
		/*كل اللي جاي يعتبر مفهوم وشرحينه بعد كده في الكلاسات التانيه بالتفصيل يعني الكلام بيتكرر*/
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 260, 344);
		frame.getContentPane().add(scrollPane);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Alternative Data", TitledBorder.LEADING, TitledBorder.TOP, null, Color.MAGENTA));
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(numOfAlternative, 1, 5, 5));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(276, 11, 260, 344);
		frame.getContentPane().add(scrollPane_1);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Caracteria Data", TitledBorder.LEADING, TitledBorder.TOP, null, Color.MAGENTA));
		scrollPane_1.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(numOfCaracteria, 1, 5, 5));
		
		/*هنا بعرف الزرار بتاع النيكست انه اول حاجه هيحط قيم التكست فيلد للالترنيتفز والكاركتريا في اتنين اراي منفصلين يسهل التعامل معاهم*/
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        String caracNames[] = new String[txtCaracteria.length];
		        String AlterNames[] = new String[txtAlternative.length];
		        /*بعدي بفور لوب بحيث اخد كل قيمه تكست فيلد واحطه في الاندكس المقابل ليها في الاراي التابع ليها*/
		        for (int i = 0; i < caracNames.length; i++) {
					caracNames[i] = txtCaracteria[i].getText();
				}
		        /*هنا نفس النظام*/
		        for (int j = 0; j < AlterNames.length; j++) {
		        	AlterNames[j] = txtAlternative[j].getText();
				}
		        /*هنا بعمل حاجتين بظهر الفريمه اللي عليها الدور يعني بخلي الرؤيه ليها بترو وفي نفس الوقت بعديلها القيم وبعدين بعمل ديسبوز للفريمه الحاليه*/
				new SubTablesFrame( AlterNames ,caracNames).frame.setVisible(true);
				frame.dispose();
			}
		});
		
		/*الكلام ده انا شرحه بالتفيصل قبل كده في الكلاسات التانيه يعني مجرد تكرار*/
		btnNext.setHorizontalTextPosition(SwingConstants.LEFT);
		btnNext.setIcon(new ImageIcon(getClass().getResource("Next.png")));
		btnNext.setHorizontalAlignment(SwingConstants.LEFT);
		btnNext.setBounds(276, 358, 115, 61);
		frame.getContentPane().add(btnNext);
		
		/*هنا بعرف الزرار بتاع البريفيس اللي بيرجعني ورا يعني بيظهر الفريمه السابقه وبيعمل اختفاء للفريمه الحاليه*/
		JButton btnPerivious = new JButton("Prev");
		btnPerivious.setIcon(new ImageIcon(getClass().getResource("prev.png")));
		btnPerivious.setHorizontalAlignment(SwingConstants.RIGHT);
		btnPerivious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new setData().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnPerivious.setBounds(156, 358, 115, 61);
		frame.getContentPane().add(btnPerivious);
		initData();
	}
}
