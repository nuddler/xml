package pkck;

import javax.swing.JOptionPane;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class MyValidationEventHandlerInput implements ValidationEventHandler {

	@Override
	public boolean handleEvent(ValidationEvent event) {
		 JOptionPane.showMessageDialog(null, "Blad walidacji na dokumencie wejsciowym");
		return false;
	}

}
