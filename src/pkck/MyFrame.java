package pkck;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

	/**
	 * 
	 */
    private static final long serialVersionUID = -6750994097745179090L;
	private JTable dzialyTable;
	private JTable towaryTable;
	private JTable zamowieniaTable;

	public MyFrame() {
		super("Hello World");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		
		String[] dzialyColumnNames = {"nazwaDzialu",
                "opisDzialu"};
		
		String[] towaryColumnNames = {"nazwaTowaru",
                "dzial",
                "cena",
                "opisTowaru"};
		
		String[] zamowieniaColumnNames = {"towar",
                "klient",
                "liczbaSztuk",
                "dataZlozenia",
                "platnosc"};
		
		
		JScrollPane dzialyPane = new JScrollPane();
		dzialyPane.setBounds(270, 53, 941, 129);
		getContentPane().add(dzialyPane);
		
		dzialyTable = new JTable(data,dzialyColumnNames);
		dzialyPane.setViewportView(dzialyTable);
		
		JScrollPane towaryPane = new JScrollPane();
		towaryPane.setBounds(270, 243, 941, 129);
		getContentPane().add(towaryPane);
		
		towaryTable = new JTable(data, towaryColumnNames);
		towaryPane.setViewportView(towaryTable);
		
		JScrollPane zamowieniaPane = new JScrollPane();
		zamowieniaPane.setBounds(270, 437, 941, 129);
		getContentPane().add(zamowieniaPane);
		
		zamowieniaTable = new JTable(data,zamowieniaColumnNames);
		zamowieniaPane.setViewportView(zamowieniaTable);
		setVisible(true);
		
		JButton btn1 = new JButton("New button");
		btn1.setBounds(26, 11, 167, 39);
		getContentPane().add(btn1);
		
		JButton btn2 = new JButton("New button");
		btn2.setBounds(26, 81, 167, 39);
		getContentPane().add(btn2);
		
		JButton btn3 = new JButton("New button");
		btn3.setBounds(26, 142, 167, 39);
		getContentPane().add(btn3);
		
		JButton btn4 = new JButton("New button");
		btn4.setBounds(26, 203, 167, 33);
		getContentPane().add(btn4);
		
		JButton btn5 = new JButton("New button");
		btn5.setBounds(26, 260, 167, 39);
		getContentPane().add(btn5);
		
		JButton btn6 = new JButton("New button");
		btn6.setBounds(26, 333, 167, 39);
		getContentPane().add(btn6);
		
		JLabel lbDziały = new JLabel("Działy");
		lbDziały.setBounds(270, 5, 200, 50);
		getContentPane().add(lbDziały);
		
		JLabel lblTowary = new JLabel("Towary");
		lblTowary.setBounds(270, 188, 200, 50);
		getContentPane().add(lblTowary);
		
		JLabel lblZamwienia = new JLabel("Zamówienia");
		lblZamwienia.setBounds(270, 381, 200, 50);
		getContentPane().add(lblZamwienia);
	}
}