package or_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Frame;

public class SubTablesFrame {

	public JFrame frame;
    private String alterNames[] ,caracNames[];
    public static Object[][] list ; 
	
	/**
	 * Create the application.
	 */
	public SubTablesFrame(String alterNames[] , String caracNames[]) {
		this.alterNames=alterNames;
		this.caracNames  = caracNames;
		list = new Object[caracNames.length+1][alterNames.length+1];
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*ال 6 سطور الجايين دول بظبط فيها خصائص الفريمه
		 * اول سطر بعمل اوبجيت من الفريمه عشان يبقي فيه سهوله في التعامل معها
		 * تاني سطر بقوله فيه ان اول ما الفريمه تفتح عايزها تكون في حجم الشاشة كامله يعني متكبره جاهزه
		 * تالت سطر بظبط فيه حجم الفريمه والاحداثيات بتاع المكان بتاعها علي الشاشه الاكس والواي
		 * رابع سطر بعرف فيه وظيفه زرار القفلان انه اول مضغط عليه يقفل الفريمه
		 * خامس سطر بحدد فيه طريقة تقسيم الفريمه انه يسبني احدد مكانهم برحتي بمزاجي يعني
		 * سادس سطر بحدد ان اول لظهور الفريمه هيبقي في نص الشاشه 
		 * */
		frame = new JFrame();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setBounds(100, 100, 962, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setLocationRelativeTo(null);
		
		/*هنا عرفت الديسك توب اللي جايبه من الجافا عشان يشيل الانترنال فريم زي ماوضحنا قبل كده */
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(248, 248, 255));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		/*هنا بضيف الفريمات بتاع الكراكتريا علي الديسك توب بتاع الجافا*/
		for (int i = 0; i < caracNames.length; i++) {
			desktopPane.add(new SubTablesInternalFrame(caracNames[i],alterNames));
		}
		/*هنا بضيف تاني نوع من الجداول علي الديسك توب اللي بيجمه الكاركتريا مع بعض عشان اجيب البريورتي فيكتور*/
		desktopPane.add(new SubTablesInternalFrame("goal periority ",caracNames));
		/*هنا بضيف الجدول النهائي اللي بيوقلي الحل*/
		desktopPane.add( new CaracteriaTable(alterNames , caracNames));
	}

}
