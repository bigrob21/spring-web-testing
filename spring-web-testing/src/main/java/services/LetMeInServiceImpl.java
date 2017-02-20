package services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import domain.AuthenticatedUser;
import domain.RequestParams;
import services.api.LdapServiceApi;
import services.api.LetMeInServiceApi;

@Service("userAuthenticationService")
public class LetMeInServiceImpl implements LetMeInServiceApi {

	private LdapServiceApi ldapService;
	
	private HttpServletRequest request; 
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isUserInDb(AuthenticatedUser user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	@Autowired
	public void setLdapService(LdapServiceApi service){
		this.ldapService = service;
	}

	@Override
	@Autowired
	public void setHttpServletRequest(HttpServletRequest request){
		this.request = request;
	}
	
}
