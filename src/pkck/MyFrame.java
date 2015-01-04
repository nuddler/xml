package pkck;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import pkck.dataModel.Hurtownia;

public class MyFrame extends JFrame  {

	/**
	 * 
	 */
    private static final long serialVersionUID = -6750994097745179090L;
	private JTable dzialyTable;
	private JTable towaryTable;
	private JTable zamowieniaTable;
	
	private Hurtownia hurtownia;
	


	public MyFrame() throws JAXBException {
		super("Hello World");
		this.setSize(1300,680);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		hurtownia = initailizeHurtownia();
		 
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
		
		dzialyTable = new JTable(hurtownia.zwrocTabliceDzialow(),dzialyColumnNames);
		dzialyPane.setViewportView(dzialyTable);
		
		JScrollPane towaryPane = new JScrollPane();
		towaryPane.setBounds(270, 243, 941, 129);
		getContentPane().add(towaryPane);
		
		towaryTable = new JTable(hurtownia.zwrocTabliceTowarow(), towaryColumnNames);
		towaryPane.setViewportView(towaryTable);
		
		JScrollPane zamowieniaPane = new JScrollPane();
		zamowieniaPane.setBounds(270, 437, 941, 129);
		getContentPane().add(zamowieniaPane);
		
		zamowieniaTable = new JTable(hurtownia.zwrocTabliceZamowien(),zamowieniaColumnNames);
		zamowieniaPane.setViewportView(zamowieniaTable);
		setVisible(true);
		
		JButton btn1 = new JButton("Dodaj dział");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showInputDialog("Nazwa działu", null);
				JOptionPane.showInputDialog("Opis działu", null);
				
			}
		});
		btn1.setBounds(26, 11, 167, 39);
		getContentPane().add(btn1);
		
		JButton btn2 = new JButton("Dodaj towar");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showInputDialog("Nazwa towaru", null);
				JOptionPane.showInputDialog("Cena", null);
				JOptionPane.showInputDialog("Opis towaru", null);
				
				String[] tablicaNazwDzialow = hurtownia.zwrocTabliceNazwDzialow();
				
				String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
				        "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null,
				        tablicaNazwDzialow, // Array of choices
				        tablicaNazwDzialow[0]); // Initial choice
			}
		});
		btn2.setBounds(26, 81, 167, 39);
		getContentPane().add(btn2);
		
		JButton btn3 = new JButton("Dodaj zamówienie");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] tablicaNazwTowarow = hurtownia.zwrocTabliceNazwTowarów();
				
				String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
						"Wybierz towar", JOptionPane.QUESTION_MESSAGE, null, 
						tablicaNazwTowarow, // Array of choices
						tablicaNazwTowarow[0]); // Initial choice
				
				JOptionPane.showInputDialog("Liczba sztuk", null);
				
				JOptionPane.showInputDialog("Płatnosć kanał", null);
				JOptionPane.showInputDialog("Płatnosć raty", null);
				
				JOptionPane.showInputDialog("Data złożenia", null);
				JOptionPane.showInputDialog("Imie klienta", null);
				JOptionPane.showInputDialog("Nazwisko klienta", null);
				JOptionPane.showInputDialog("Telefon do klienta", null);
				
				
			}
		});
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

	private Hurtownia initailizeHurtownia() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Hurtownia.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return (Hurtownia) jaxbUnmarshaller.unmarshal(new File("src/hurtownia.xml"));
    }

	public Hurtownia getHurtownia() {
	    return hurtownia;
    }



	public void setHurtownia(Hurtownia hurtownia) {
	    this.hurtownia = hurtownia;
    }
}