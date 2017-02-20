package services.api;

import domain.AuthenticatedUser;

public interface LdapServiceApi {

	public AuthenticatedUser lookupBySubjectAndIssuerDns(String subject, String issuer);
	
}
