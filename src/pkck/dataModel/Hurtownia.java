package pkck.dataModel;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "hurtownia", namespace="http://www.pkck.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hurtownia {
	
	
	@XmlElementWrapper(name="autorzy", namespace="http://www.pkck.com")
    @XmlElement(name="autor", namespace="http://www.pkck.com")
	List <Autor> autorzy;
	
	@XmlElementWrapper(name="działy", namespace="http://www.pkck.com")
    @XmlElement(name="dział", namespace="http://www.pkck.com")
	List<Dzial> dzialy;
	
	@XmlElementWrapper(name="towary", namespace="http://www.pkck.com")
    @XmlElement(name="towar", namespace="http://www.pkck.com")	
	List<Towar> towary;
	
	@XmlElementWrapper(name="zamówienia", namespace="http://www.pkck.com")
    @XmlElement(name="zamówienie", namespace="http://www.pkck.com")	
	List<Zamowienie> zamowienia;
	
	@Override
	public String toString() {
		return "Hurtownia [autorzy=" + autorzy + ", dzialy=" + dzialy
				+ ", towary=" + towary + ", zamowienia=" + zamowienia + "]";
	}
	
	public void dodajZamowienie(Zamowienie zamowienie){
		zamowienia.add(zamowienie);
	}
	
	public void dodajTowar(Towar towar){
		towary.add(towar);
	}
	
	public void dodajDzial(Dzial dzial){
		dzialy.add(dzial);
	}
	
	public String[][] zwrocTabliceDzialow() {
		String[][] tablica = new String[dzialy.size()][2];
		int i = 0;
		
		for (Dzial dzial : dzialy) {
			
			tablica[i][0] = dzial.getNazwaDzialu();
			tablica[i][1] = dzial.getOpisDzialu();
			i++;

		}
		return tablica;

	}
	
	public String[] zwrocTabliceNazwDzialow() {
		String[] tablica = new String[dzialy.size()];
		int i = 0;
		
		for (Dzial dzial : dzialy) {
			
			tablica[i] = dzial.getNazwaDzialu();
			i++;

		}
		return tablica;

	}
	
	public String[] zwrocTabliceNazwTowarów() {
		String[] tablica = new String[towary.size()];
		int i = 0;
		
		for (Towar towar : towary) {
			
			tablica[i] = towar.getNazwaTowaru();
			i++;

		}
		return tablica;

	}
	
	public String[][] zwrocTabliceTowarow() {
		String[][] tablica = new String[towary.size()][4];
		int i = 0;
		
		for (Towar towar : towary) {
			tablica[i][0] = towar.getNazwaTowaru();
			tablica[i][1] = towar.getDzial().getNazwaDzialu();
			tablica[i][2] = towar.getCena();
			tablica[i][3] = towar.getOpisTowaru();
			i++;

		}
		return tablica;

	}
	
	public String[][] zwrocTabliceZamowien() {
		String[][] tablica = new String[zamowienia.size()][5];
		int i = 0;
		
		for (Zamowienie zamowienie : zamowienia) {
			tablica[i][0] = zamowienie.getTowar().getNazwaTowaru();
			tablica[i][1] = zamowienie.getKlient().toString();
			tablica[i][2] = Integer.toString(zamowienie.getLiczbaSztuk());
			tablica[i][3] = zamowienie.getDataZlozenia().toString();
			tablica[i][4] = zamowienie.getPlatnosc().toString();
			i++;

		}
		return tablica;

	}
}
