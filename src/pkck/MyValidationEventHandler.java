package pkck;

import javax.swing.JOptionPane;
import javax.xml.bind.ValidationEvent; 
import javax.xml.bind.ValidationEventHandler;

public class MyValidationEventHandler implements ValidationEventHandler{
	 public boolean handleEvent(ValidationEvent event){
		 JOptionPane.showMessageDialog(null, "Ojj, cos nie pyklo");
		 return true;
	 }
}