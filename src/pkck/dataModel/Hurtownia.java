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
}
