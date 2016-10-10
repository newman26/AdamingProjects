package fr.adaming.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class ValodatorMail implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		//1. recup la saisie du user 
        String saisie = (String) value;

        //2.implementation de la logique de  validation 
        try {

            if (!saisie.isEmpty()) {
                if (!saisie.contains("@")) {
                    throw new Exception("Le Login doit avoir un @ !!!!");
                }

            } else {
                //saisie vide 
                throw new Exception("Attention, saisie vide !!!!");
            }
        } catch (Exception e) {
            //FacesMessage : vehicule des infos jusqu'a la vue 
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
		
	}

}
