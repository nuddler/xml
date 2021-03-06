package pkck.dataModel;

import java.util.Iterator;
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
	
	public List<Autor> getAutorzy() {
		return autorzy;
	}

	public void setAutorzy(List<Autor> autorzy) {
		this.autorzy = autorzy;
	}

	public List<Dzial> getDzialy() {
		return dzialy;
	}

	public void setDzialy(List<Dzial> dzialy) {
		this.dzialy = dzialy;
	}

	public List<Towar> getTowary() {
		return towary;
	}

	public void setTowary(List<Towar> towary) {
		this.towary = towary;
	}

	public List<Zamowienie> getZamowienia() {
		return zamowienia;
	}

	public void setZamowienia(List<Zamowienie> zamowienia) {
		this.zamowienia = zamowienia;
	}

	public String[] zwrocTabliceNazwTowarow() {
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
		String[][] tablica = new String[zamowienia.size()][6];
		int i = 0;
		
		for (Zamowienie zamowienie : zamowienia) {
			tablica[i][0] = Integer.toString(zamowienie.getIdZamowienia());
			tablica[i][1] = zamowienie.getTowar().getNazwaTowaru();
			tablica[i][2] = zamowienie.getKlient().toTable();
			tablica[i][3] = Integer.toString(zamowienie.getLiczbaSztuk());
			tablica[i][4] = zamowienie.getDataZlozenia().toString();
			tablica[i][5] = zamowienie.getPlatnosc().toTable();
			i++;

		}
		return tablica;

	}
	
	public String[] zwrocTabliceIdZamowien() {
		String[] tablica = new String[zamowienia.size()];
		int i = 0;
		
		for (Zamowienie zamowienie : zamowienia) {
			tablica[i] = Integer.toString(zamowienie.getIdZamowienia());
			i++;

		}
		return tablica;

	}
	
	/**
	 * Zwraca dział jak znalazł o takiej nazwi, inaczej null;
	 * 
	 * @param dzial
	 * @return
	 */
	public Dzial zwrocDzial(String dzial) {

		for (Dzial dzialC : dzialy) {
			if (dzialC.getNazwaDzialu().equals(dzial)) {
				return dzialC;
			}
		}
		return null;

	}

	/**
	 * Zwraca towar jak znalazł o takiej nazwie, inaczej null;
	 * @param towar
	 * @return
	 */
	public Towar zwrocTowar(String towar) {
		for (Towar towarC : towary) {
			if (towarC.getNazwaTowaru().equals(towar)) {
				return towarC;
			}
		}
		return null;
	}
	public int następnyId() {
		return zamowienia.get(zamowienia.size()-1).getIdZamowienia()+1;
		
	}
	
	public void usunZamowienie(int id){
		for (Iterator<Zamowienie> iter = zamowienia.listIterator(); iter.hasNext(); ) {
		    Zamowienie zamowienie = iter.next();
		    if (zamowienie.getIdZamowienia()==id) {
		        iter.remove();
		    }
		}
	}
	
	public void usunTowar(String id){
		for (Iterator<Towar> iter = towary.listIterator(); iter.hasNext(); ) {
		    Towar towar = iter.next();
		    if (towar.getNazwaTowaru()==id) {
		        iter.remove();
		    }
		}
	}
	
	public void usunDzial(String id){
		for (Iterator<Dzial> iter = dzialy.listIterator(); iter.hasNext(); ) {
		    Dzial dzial = iter.next();
		    if (dzial.getNazwaDzialu()==id) {
		        iter.remove();
		    }
		}	
	}
	
	public void edytujDzial(String id, Dzial zmianaDzial){
		Dzial nowyDzial=null;
		for (Dzial dzial: dzialy) {
			if (dzial.getNazwaDzialu()==id)
				nowyDzial=dzial;
		}
		
		if (!zmianaDzial.getNazwaDzialu().isEmpty())
			nowyDzial.setNazwaDzialu(zmianaDzial.getNazwaDzialu());
		
		if (!zmianaDzial.getOpisDzialu().isEmpty())
			nowyDzial.setOpisDzialu(zmianaDzial.getNazwaDzialu());
	}
	
	public void edytujTowar(String id, Towar zmianaTowar){
		Towar nowyTowar=null;
		for (Towar towar : towary) {
			if (towar.getNazwaTowaru()==id)
				nowyTowar=towar;
		}
		
		if (!zmianaTowar.getNazwaTowaru().isEmpty())
			nowyTowar.setNazwaTowaru(zmianaTowar.getNazwaTowaru());
		
		if(!zmianaTowar.getCena().isEmpty())
			nowyTowar.setCena(zmianaTowar.getCena());
		
		if (!zmianaTowar.getOpisTowaru().isEmpty())
			nowyTowar.setOpisTowaru(zmianaTowar.getOpisTowaru());
		
		nowyTowar.setDzial(zmianaTowar.getDzial());
	}
	
	public void edytujZamowienie(int id, Zamowienie zmianaZamowienie){
		Zamowienie noweZamowienie=null;
		
		for (Zamowienie zamowienie : zamowienia) {
			if (zamowienie.getIdZamowienia()==id)
				noweZamowienie=zamowienie;
		}
		
		Klient klient=new Klient();
		boolean zmianaK=false;
		
		if (!zmianaZamowienie.getKlient().getImieKlienta().isEmpty()){
			klient.setImieKlienta(zmianaZamowienie.getKlient().getImieKlienta());
			zmianaK=true;
		}
		
		if (!zmianaZamowienie.getKlient().getNazwiskoKlienta().isEmpty()){
			klient.setNazwiskoKlienta(zmianaZamowienie.getKlient().getNazwiskoKlienta());
			zmianaK=true;
		}
		
		if (!zmianaZamowienie.getKlient().getTelefon().isEmpty()){
			klient.setTelefon(zmianaZamowienie.getKlient().getTelefon());
			zmianaK=true;
		}
		
		if (zmianaK)
			noweZamowienie.setKlient(klient);
		
		noweZamowienie.setDataZlozenia(zmianaZamowienie.getDataZlozenia());
		
		noweZamowienie.setLiczbaSztuk(zmianaZamowienie.getLiczbaSztuk());
		
		noweZamowienie.setPlatnosc(zmianaZamowienie.getPlatnosc());
		
		
		Towar towar=new Towar();
		boolean zmianaT=false;
		
		if (!zmianaZamowienie.getTowar().getCena().isEmpty()){
			towar.setCena(zmianaZamowienie.getTowar().getCena());
			zmianaT=true;
		}
		
		if (!zmianaZamowienie.getTowar().getNazwaTowaru().isEmpty()){
			towar.setNazwaTowaru(zmianaZamowienie.getTowar().getNazwaTowaru());
			zmianaT=true;
		}
		
		if (!zmianaZamowienie.getTowar().getOpisTowaru().isEmpty()){
			towar.setNazwaTowaru(zmianaZamowienie.getTowar().getOpisTowaru());
			zmianaT=true;
		}
		
		if (zmianaT){
			towar.setDzial(zmianaZamowienie.getTowar().getDzial());
			noweZamowienie.setTowar(towar);
		}
	}
}
