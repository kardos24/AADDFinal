package validators;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("aadd.validadores.Mail")
public class ValidacionMail implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value)
			throws ValidatorException {
		String mail = (String) value;
		if(!mail.contains("@")){
			throw new ValidatorException(
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR, 
							"Error validando mail", 
							"El mail debe contener @")
					);
		}

	}

}
