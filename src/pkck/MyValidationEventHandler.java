package pkck;

import javax.xml.bind.ValidationEvent; 
import javax.xml.bind.ValidationEventHandler;

public class MyValidationEventHandler implements ValidationEventHandler{
	 public boolean handleEvent(ValidationEvent event){
		 return true;
	 }
}