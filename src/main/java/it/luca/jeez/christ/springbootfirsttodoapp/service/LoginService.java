package it.luca.jeez.christ.springbootfirsttodoapp.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validateUser(String userid, String password) {
		//valid combination: luca / lucapwd
		//per il momento hard-coded. Verosimilmente ci sarà una chiamata al auth server
		return userid.equalsIgnoreCase("luca") && password.equalsIgnoreCase("lucapwd");
	}
}
