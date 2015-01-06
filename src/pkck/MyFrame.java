package pkck;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import pkck.dataModel.Dzial;
import pkck.dataModel.Hurtownia;
import pkck.dataModel.Klient;
import pkck.dataModel.Platnosc;
import pkck.dataModel.Towar;
import pkck.dataModel.Zamowienie;

public class MyFrame extends JFrame  {

	/**
	 * 
	 */
    private static final long serialVersionUID = -6750994097745179090L;
	private JTable dzialyTable;
	private JTable towaryTable;
	private JTable zamowieniaTable;
	
	private Hurtownia hurtownia;
	


	public MyFrame() throws JAXBException, SAXException {
		super("Hurtownia");
		this.setSize(1700,680);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		hurtownia = initailizeHurtownia();
		 
		final String[] dzialyColumnNames = {"nazwaDzialu",
                "opisDzialu"};
		
		final String[] towaryColumnNames = {"nazwaTowaru",
                "dzial",
                "cena",
                "opisTowaru"};
		
		final String[] zamowieniaColumnNames = {"id","towar",
                "klient",
                "liczbaSztuk",
                "dataZlozenia",
                "platnosc"};
		
		
		final JScrollPane dzialyPane = new JScrollPane();
		dzialyPane.setBounds(270, 53, 941, 129);
		getContentPane().add(dzialyPane);
		
		dzialyTable = new JTable(hurtownia.zwrocTabliceDzialow(),dzialyColumnNames);
		dzialyPane.setViewportView(dzialyTable);
		
		final JScrollPane towaryPane = new JScrollPane();
		towaryPane.setBounds(270, 243, 1200, 129);
		getContentPane().add(towaryPane);
		
		towaryTable = new JTable(hurtownia.zwrocTabliceTowarow(), towaryColumnNames);
		towaryPane.setViewportView(towaryTable);
		
		final JScrollPane zamowieniaPane = new JScrollPane();
		zamowieniaPane.setBounds(270, 437, 1400, 129);
		getContentPane().add(zamowieniaPane);
		
		zamowieniaTable = new JTable(hurtownia.zwrocTabliceZamowien(),zamowieniaColumnNames);
		zamowieniaPane.setViewportView(zamowieniaTable);
		setVisible(true);
		
		JButton btn1 = new JButton("Dodaj dział");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nazwaDzialu = JOptionPane.showInputDialog("Nazwa działu", null);
				String opisDzialu = JOptionPane.showInputDialog("Opis działu", null);
				
				Dzial dzial = new Dzial();
				dzial.setNazwaDzialu(nazwaDzialu);
				dzial.setOpisDzialu(opisDzialu);
				hurtownia.dodajDzial(dzial);
				
				dzialyTable = new JTable(hurtownia.zwrocTabliceDzialow(),dzialyColumnNames);
				dzialyPane.setViewportView(dzialyTable);
			}
		});
		btn1.setBounds(26, 11, 167, 39);
		getContentPane().add(btn1);
		
		JButton btn2 = new JButton("Dodaj towar");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nazwaTowaru = JOptionPane.showInputDialog("Nazwa towaru", null);
				String cenaTowaru = JOptionPane.showInputDialog("Cena", null);
				String opisTowaru = JOptionPane.showInputDialog("Opis towaru", null);
				
				String[] tablicaNazwDzialow = hurtownia.zwrocTabliceNazwDzialow();
				
				String dzial = (String) JOptionPane.showInputDialog(null, "Wybierz dział",
				        "Wybór", JOptionPane.QUESTION_MESSAGE, null,
				        tablicaNazwDzialow, // Array of choices
				        tablicaNazwDzialow[0]); // Initial choice
				
				Towar towar = new Towar();
				towar.setCena(cenaTowaru);
				towar.setNazwaTowaru(nazwaTowaru);
				towar.setOpisTowaru(opisTowaru);
				towar.setDzial(hurtownia.zwrocDzial(dzial));
				hurtownia.dodajTowar(towar);
				
				towaryTable = new JTable(hurtownia.zwrocTabliceTowarow(), towaryColumnNames);
				towaryPane.setViewportView(towaryTable);
				
			}
		});
		btn2.setBounds(26, 81, 167, 39);
		getContentPane().add(btn2);
		
		JButton btn3 = new JButton("Dodaj zamówienie");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] tablicaNazwTowarow = hurtownia.zwrocTabliceNazwTowarow();
				
				String towar = (String) JOptionPane.showInputDialog(null, "Wybierz towar",
						"Wybór", JOptionPane.QUESTION_MESSAGE, null, 
						tablicaNazwTowarow, // Array of choices
						tablicaNazwTowarow[0]); // Initial choice
				
				String liczbaSztuk = JOptionPane.showInputDialog("Liczba sztuk", null);
				
				String[] kanalWartosci = {"przelew","gotówka","karta"};
				String[] ratyWartosci = {"tak","nie"};
				
				String kanalPlatnosci = (String) JOptionPane.showInputDialog(null, "Wybierz kanał płatności",
				        "Wybór", JOptionPane.QUESTION_MESSAGE, null,
				        kanalWartosci, // Array of choices
				        kanalWartosci[0]); // Initial choice
				
				String raty = (String) JOptionPane.showInputDialog(null, "Czy sprzedarz była ratalna?",
				        "Wybór", JOptionPane.QUESTION_MESSAGE, null,
				        ratyWartosci, // Array of choices
				        ratyWartosci[0]); // Initial choice
				
				Date data = dajData();
			
				String imieKlienta = JOptionPane.showInputDialog("Imie klienta", null);
				String nazwiskoKlienta = JOptionPane.showInputDialog("Nazwisko klienta", null);
				String telefonKlienta = JOptionPane.showInputDialog("Telefon do klienta", null);
				
				Zamowienie zamowienie = new Zamowienie();
				
				Klient klient = new Klient();
				klient.setImieKlienta(imieKlienta);
				klient.setNazwiskoKlienta(nazwiskoKlienta);
				klient.setTelefon(telefonKlienta);
				zamowienie.setKlient(klient);
				zamowienie.setLiczbaSztuk(Integer.parseInt(liczbaSztuk));
				
				Platnosc platnosc = new Platnosc();
				platnosc.setKanal(kanalPlatnosci);
				platnosc.setRaty(raty);
				zamowienie.setPlatnosc(platnosc);
				
				zamowienie.setTowar(hurtownia.zwrocTowar(towar));
				
				zamowienie.setDataZlozenia(data);
				zamowienie.setIdZamowienia(hurtownia.następnyId());
				hurtownia.dodajZamowienie(zamowienie);
				
				zamowieniaTable = new JTable(hurtownia.zwrocTabliceZamowien(),zamowieniaColumnNames);
				zamowieniaPane.setViewportView(zamowieniaTable);
			}
		});
		btn3.setBounds(26, 142, 167, 39);
		getContentPane().add(btn3);
		
		JButton btn4 = new JButton("Usuń dział");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Usuwanie Dzialu");
				
				String[] nazwyDzialow = hurtownia.zwrocTabliceNazwDzialow();
				String nazwaDzialu = (String) JOptionPane.showInputDialog(null, "Wybierz dzial który chcesz usunąć",
				        "Wybór", JOptionPane.QUESTION_MESSAGE, null,
				        nazwyDzialow , // Array of choices
				        nazwyDzialow[0]); // Initial choice
				hurtownia.usunDzial(nazwaDzialu);
				dzialyTable = new JTable(hurtownia.zwrocTabliceDzialow(),dzialyColumnNames);
				dzialyPane.setViewportView(dzialyTable);
			}
		});
			
		btn4.setBounds(26, 203, 167, 33);
		getContentPane().add(btn4);
		
		JButton btn5 = new JButton("Usuń towar");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Usuwanie Towaru");
				
				String[] nazwayTowarow = hurtownia.zwrocTabliceNazwTowarow();
				String nazwaTowaru = (String) JOptionPane.showInputDialog(null, "Wybierz towar który chcesz usunąć",
				        "Wybór", JOptionPane.QUESTION_MESSAGE, null,
				        nazwayTowarow , // Array of choices
				        nazwayTowarow[0]); // Initial choice
				hurtownia.usunTowar(nazwaTowaru);
				towaryTable = new JTable(hurtownia.zwrocTabliceTowarow(), towaryColumnNames);
				towaryPane.setViewportView(towaryTable);
			}
		});
		btn5.setBounds(26, 260, 167, 39);
		getContentPane().add(btn5);
		
		JButton btn6 = new JButton("Usuń zamówienie");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Usuwanie zamówienia");
				
				String[] idZamowien = hurtownia.zwrocTabliceIdZamowien();
				String idZamowienia = (String) JOptionPane.showInputDialog(null, "Wybierz zamówienie które chcesz usunąć",
				        "Wybór", JOptionPane.QUESTION_MESSAGE, null,
				        idZamowien , // Array of choices
				        idZamowien[0]); // Initial choice
				int id = Integer.parseInt(idZamowienia);
				hurtownia.usunZamowienie(id);
				zamowieniaTable = new JTable(hurtownia.zwrocTabliceZamowien(),zamowieniaColumnNames);
				zamowieniaPane.setViewportView(zamowieniaTable);
			}
		});
		btn6.setBounds(26, 333, 167, 39);
		getContentPane().add(btn6);
		
		JButton btn7 = new JButton("Zapis");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Zapis");
				try {
	                saveHurtownia();
				} catch (JAXBException | SAXException e) {
                	JOptionPane.showMessageDialog(null, "Problem z zapisem");
	                e.printStackTrace();
                }
			}
		});
		btn7.setBounds(26, 400, 167, 39);
		getContentPane().add(btn7);
		
		JButton btn8 = new JButton("Edytuj  dział");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Edytowanie Dzialu");
				
				String[] nazwyDzialow = hurtownia.zwrocTabliceNazwDzialow();
				String nazwaDzialu = (String) JOptionPane.showInputDialog(null, "Wybierz dzial który chcesz edytować",
				        "Wybór", JOptionPane.QUESTION_MESSAGE, null,
				        nazwyDzialow , // Array of choices
				        nazwyDzialow[0]); // Initial choice
				
				String nowaNazwaDzialu = JOptionPane.showInputDialog("Nazwa działu", null);
				String nowyOpisDzialu = JOptionPane.showInputDialog("Opis działu", null);
				
				Dzial dzial = new Dzial();
				dzial.setNazwaDzialu(nowaNazwaDzialu);
				dzial.setOpisDzialu(nowyOpisDzialu);
				
				
				dzialyTable = new JTable(hurtownia.zwrocTabliceDzialow(),dzialyColumnNames);
				dzialyPane.setViewportView(dzialyTable);
			}
		});
		
		JButton btn9 = new JButton("Edytuj towar");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Edycja Towaru");
				
				String[] nazwayTowarow = hurtownia.zwrocTabliceNazwTowarow();
				String nazwaTowaru = (String) JOptionPane.showInputDialog(null, "Wybierz towar który chcesz edytować",
				        "Wybór", JOptionPane.QUESTION_MESSAGE, null,
				        nazwayTowarow , // Array of choices
				        nazwayTowarow[0]); // Initial choice
				
				
				towaryTable = new JTable(hurtownia.zwrocTabliceTowarow(), towaryColumnNames);
				towaryPane.setViewportView(towaryTable);
			}
		});
		
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

	private Date dajData() {
		String temp = JOptionPane.showInputDialog("Podaj date zakupu ( HH:mm:ss mm-dd-yyyy  ) : ");

	       SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss MM-dd-yyyy");
	        Date date = null;
	        try {
	            date = sdf.parse(temp);
	            sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
	            JOptionPane.showMessageDialog(null, "Wprowadzona zostanie data " + sdf.format(date));
	        } catch (ParseException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Podałeś błedną date, spróbuj ponownie.");
	            dajData();
	        }
	        return date;
	}
	
	private Hurtownia initailizeHurtownia() throws JAXBException, SAXException {
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema=sf.newSchema(new File("src/hurtownia.xsd"));
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Hurtownia.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		jaxbUnmarshaller.setSchema(schema);
		jaxbUnmarshaller.setEventHandler(new MyValidationEventHandlerInput());
		return (Hurtownia) jaxbUnmarshaller.unmarshal(new File("src/hurtownia.xml"));
    }

	private void saveHurtownia() throws JAXBException, SAXException {
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema=sf.newSchema(new File("src/hurtownia.xsd"));
		
		//hurtownia.getAutorzy().get(0).setNumerIndeksu("sadas");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Hurtownia.class);
		Marshaller jaxbMarshaller=jaxbContext.createMarshaller();
		jaxbMarshaller.setSchema(schema);
		jaxbMarshaller.setEventHandler(new MyValidationEventHandlerOutput());
		jaxbMarshaller.marshal( hurtownia, new File( "src/wygenerowany.xml" ) );
	}
	
	public Hurtownia getHurtownia() {
	    return hurtownia;
    }



	public void setHurtownia(Hurtownia hurtownia) {
	    this.hurtownia = hurtownia;
    }
}