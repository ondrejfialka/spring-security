package eu.unicorn.hatchery.spring.security.secret;

import org.springframework.stereotype.Component;

@Component
public class SecretServiceImpl implements SecretService {

	@Override	
	public String getSecretData() {
		return "Top Secret!";
	}

	@Override
	public String getPublicData() {
		return "Bananas are yellow";
	}
	
}
