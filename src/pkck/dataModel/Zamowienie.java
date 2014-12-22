package pkck.dataModel;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;

@XmlRootElement(name = "zamówienie", namespace = "http://www.pkck.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class Zamowienie {

	@XmlAttribute(name = "id_zam�wienia")
	private String idZamowienia;

	@XmlAttribute(name = "towar")
	@XmlIDREF
	@XmlSchemaType(name = "IDREF")
	private Towar towar;

	@XmlElement(name = "klient", namespace = "http://www.pkck.com")
	private Klient klient;

	@XmlElement(name = "liczba_sztuk", namespace = "http://www.pkck.com")
	private int liczbaSztuk;

	@XmlElement(name = "data_złożenia", namespace = "http://www.pkck.com")
	private Date dataZlozenia;

	@XmlElement(name = "płatność", namespace = "http://www.pkck.com")
	private Platnosc platnosc;

	public Zamowienie() {
	}

	public String getIdZamowienia() {
		return idZamowienia;
	}

	public void setIdZamowienia(String idZamowienia) {
		this.idZamowienia = idZamowienia;
	}

	public Towar getTowar() {
		return towar;
	}

	public void setTowar(Towar towar) {
		this.towar = towar;
	}

	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public int getLiczbaSztuk() {
		return liczbaSztuk;
	}

	public void setLiczbaSztuk(int liczbaSztuk) {
		this.liczbaSztuk = liczbaSztuk;
	}

	public Date getDataZlozenia() {
		return dataZlozenia;
	}

	public void setDataZlozenia(Date dataZlozenia) {
		this.dataZlozenia = dataZlozenia;
	}

	public Platnosc getPlatnosc() {
		return platnosc;
	}

	public void setPlatnosc(Platnosc platnosc) {
		this.platnosc = platnosc;
	}

	@Override
	public String toString() {
		return "Zamowienie [idZamowienia=" + idZamowienia + ", towar=" + towar
				+ ", klient=" + klient + ", liczbaSztuk=" + liczbaSztuk
				+ ", dataZlozenia=" + dataZlozenia + ", platnosc=" + platnosc
				+ "]";
	}
}
