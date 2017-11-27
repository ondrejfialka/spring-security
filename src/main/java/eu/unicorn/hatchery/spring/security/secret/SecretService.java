package eu.unicorn.hatchery.spring.security.secret;

import org.springframework.security.access.annotation.Secured;

public interface SecretService {
	
	@Secured("ROLE_ADMIN")
	String getSecretData();

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	String getPublicData(); 

}
