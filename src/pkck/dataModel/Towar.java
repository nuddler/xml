package pkck.dataModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;


@XmlRootElement(name = "towar", namespace="http://www.pkck.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class Towar {
	
	@XmlID
	@XmlAttribute(name= "nazwa_towaru")
	private String nazwaTowaru;
	
	@XmlAttribute(name="dział")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
	private Dzial dzial;
	
	@XmlElement(name= "cena", namespace="http://www.pkck.com")
	private String cena;

	@XmlElement(name= "opis_towaru", namespace="http://www.pkck.com")
	private String opisTowaru;
	
	public String getNazwaTowaru() {
		return nazwaTowaru;
	}
	public void setNazwaTowaru(String nazwaTowaru) {
		this.nazwaTowaru = nazwaTowaru;
	}
	public Dzial getDzial() {
		return dzial;
	}
	public void setDzial(Dzial dzial) {
		this.dzial = dzial;
	}
	public String getCena() {
		return cena;
	}
	public void setCena(String cena) {
		this.cena = cena;
	}
	public String getOpisTowaru() {
		return opisTowaru;
	}
	public void setOpisTowaru(String opisTowaru) {
		this.opisTowaru = opisTowaru;
	}
	@Override
	public String toString() {
		return "Towar [nazwaTowaru=" + nazwaTowaru + ", dzial=" + dzial
				+ ", cena=" + cena + ", opisTowaru=" + opisTowaru + "]";
	}
}
