package domain;

import java.io.Serializable;
import java.util.Optional;

import javax.security.cert.X509Certificate;
import javax.servlet.http.HttpServletRequest;

import lombok.Getter;
import lombok.Setter;

public class RequestParams implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private String subject; 
	@Getter @Setter
	private String issuer; 
	@Getter @Setter
	private String country;
	@Getter @Setter
	private String org; 
	@Getter @Setter
	private String ipAddress;

	
	//private static Logger logger = LoggerFactory.getLogger(RequestParams.class);
	
	public RequestParams(HttpServletRequest request){
		Optional.ofNullable(request).ifPresent(req -> {
			setCountry(req.getParameter("country"));
			setIpAddress(req.getRemoteAddr());
			setOrg(req.getParameter("org"));
			
			X509Certificate[] xCert = extractX509(request);
			if(xCert != null && xCert.length > 0){
				X509Certificate cert = xCert[0];
				setSubject(cert.getSubjectDN().getName());
				setIssuer(cert.getIssuerDN().getName());
			}
		});
	}
	
	public RequestParams(){
		this(null);
	}
	
	public static X509Certificate[] extractX509(HttpServletRequest request){
		return Optional.ofNullable(request)
				.map(r -> {
					X509Certificate[] retVal = null;
					Object o = r.getAttribute("javax.servlet.request.X509Certificate");
					if(o != null){
						retVal = (X509Certificate[])o;
					}
					return retVal;
				})
				.orElse(new X509Certificate[]{});
	}
	
}
