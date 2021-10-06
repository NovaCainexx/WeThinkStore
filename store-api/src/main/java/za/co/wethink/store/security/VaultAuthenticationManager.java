package za.co.wethink.store.security;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import za.co.wethink.store.models.AuthenticationResponse;

/**
 * 
 * @author ebe
 * za.co.africanbank.secret.service.impl.VaultAuthenticationManager
 *
 */

public class VaultAuthenticationManager implements AuthenticationProvider{

	private static final Logger LOGGER = Logger.getLogger(VaultAuthenticationManager.class.getName());
	
	public VaultAuthenticationManager() {
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		AuthenticationResponse response = null;
		LOGGER.info(MessageFormat.format("** custom authentication provider request {0} **",authentication.getDetails()));
		try {
			LOGGER.info(MessageFormat.format("{0} {1}",authentication.getPrincipal(), authentication.getCredentials()));
			/**
			 * Authenticate your user using whatever backend you want here...
			 * for now create a dummy user profile  
			 */
			response = new AuthenticationResponse();
			response.setAppId("appID");
			response.setAuthClientToken("a_token_goes_here");
			response.setAuthLeaseDuration(1000l);
			response.setAuthPolicies(
					Arrays.asList(new String[] {"APP","LOGIN","ADMIN"}
					));
			response.setNonce("a_security_nonce");
			response.setUserId("user_id");
			response.setUsername("user");
			
			
			LOGGER.info(MessageFormat.format("completed auth {0}",new JSONObject(response).toString(2)));
		} catch (Exception e) {
			LOGGER.info(MessageFormat.format("exception when attempting authenticate {0}",e.getMessage()));
			throw new RuntimeException(e);
		}
		LOGGER.info("** completed custom authentication provider task **");
		return new UsernamePasswordAuthenticationToken(
				authentication.getPrincipal().toString(), 
				null, 
				response.getAuthPolicies().stream()
					.map(x -> new SimpleGrantedAuthority(x))
					.collect(Collectors.toList()));
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return false;
	}

}
