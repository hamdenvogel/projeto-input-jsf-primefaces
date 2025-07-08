package br.com.inputjsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("campoNaoVazioValidator")
public class CampoNaoVazioValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String valor = (String) value;
        if (valor == null || valor.trim().isEmpty()) {
            FacesMessage msg = new FacesMessage("Campo deve ser preenchido.", "Campo deve ser preenchido.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}