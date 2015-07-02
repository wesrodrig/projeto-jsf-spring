package br.com.triadworks.bugtracker.controller.validator;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("senhaForte")
public class SenhaForteValidator implements Validator {

	@Override
	public void validate(FacesContext ctx, UIComponent component, Object value)
			throws ValidatorException {
		// TODO Auto-generated method stub
		String valor = value.toString();
		System.out.println(valor);
		if(!valor.contains("@")){
			throw new ValidatorException( new FacesMessage(FacesMessage.SEVERITY_ERROR,"O campo senha não e forte o Bastante ", "A senha de conter @"));
			
		}
		
	}
	
	
	
	
	

}
