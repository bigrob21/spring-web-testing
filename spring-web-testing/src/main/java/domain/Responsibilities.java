package domain;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
public class Responsibilities implements GrantedAuthority {

	private static final long serialVersionUID = -6088277161056027025L;
	
	@Getter @Setter
	private Long id;
	@Getter
	private String authority;
	
	
}
