package services.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.UserDetailsService;

import domain.AuthenticatedUser;
import domain.RequestParams;

public interface LetMeInServiceApi extends UserDetailsService {

	public RequestParams getRequestParamsFromRequest(HttpServletRequest request);
	
	public boolean isUserInDb(AuthenticatedUser user);
	
	public void setLdapService(LdapServiceApi service);
	public void setUserService(UserService service);
	public void setHttpServletRequest(HttpServletRequest request);

	
	public default RequestParams getRequestParamsFromRequest(HttpServletRequest request) {
		
	}
	
}
