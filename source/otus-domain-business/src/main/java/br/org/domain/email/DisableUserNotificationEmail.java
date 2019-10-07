package br.org.domain.email;

import br.org.domain.user.User;
import br.org.owail.sender.email.Email;
import br.org.owail.sender.email.Mailer;

import java.util.HashMap;
import java.util.Map;

public class DisableUserNotificationEmail extends Email implements StudioEmail {

	private final String TEMPLATE = "/template/disable-user-notification-template.html";
	private final String SUBJECT = "Alerta - Cadastro desabilitado Otus Domain";
	private Map<String, String> dataMap;

    public DisableUserNotificationEmail() {
        dataMap = new HashMap<>();
        defineSubject();
    }

    @Override
	public String getTemplatePath() {
		return TEMPLATE;
	}

	@Override
	public Map<String, String> getContentDataMap() {
		return dataMap;
	}

	@Override
	public String getContentType() {
		return Mailer.HTML;
	}

	public void defineRecipient(User user){
		addTORecipient("recipient", user.getEmail());
	}

    private void defineSubject(){
    	setSubject(SUBJECT);
    }

}
