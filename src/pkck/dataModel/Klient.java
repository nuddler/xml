package pkck.dataModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "klient", namespace="http://www.pkck.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class Klient {
	
	@XmlElement(name= "imię_klienta", namespace="http://www.pkck.com")
	private String imieKlienta;
	
	@XmlElement(name= "nazwisko_klienta", namespace="http://www.pkck.com")
	private String nazwiskoKlienta;
	
	@XmlElement(name= "telefon", namespace="http://www.pkck.com")
	private String telefon;
	
	public String getImieKlienta() {
		return imieKlienta;
	}
	public void setImieKlienta(String imieKlienta) {
		this.imieKlienta = imieKlienta;
	}
	public String getNazwiskoKlienta() {
		return nazwiskoKlienta;
	}
	public void setNazwiskoKlienta(String nazwiskoKlienta) {
		this.nazwiskoKlienta = nazwiskoKlienta;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	@Override
	public String toString() {
		return "Klient [imieKlienta=" + imieKlienta + ", nazwiskoKlienta="
				+ nazwiskoKlienta + ", telefon=" + telefon + "]";
	}
	
	public String toTable() {
		return "imieKlienta=" + imieKlienta + ", nazwiskoKlienta="
				+ nazwiskoKlienta + ", telefon=" + telefon ;
	}
}
