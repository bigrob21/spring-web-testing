package services.api;

import domain.AuthenticatedUser;

public interface UserService {

	public AuthenticatedUser lookupById(Long id);
	public AuthenticatedUser lookupByUserId(String id);
	public AuthenticatedUser lookupBySubjectAndIssuerDns(String subject, String issuer);
	
}
