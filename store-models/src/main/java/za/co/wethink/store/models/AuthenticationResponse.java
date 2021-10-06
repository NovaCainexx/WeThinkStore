package za.co.wethink.store.models;

import java.util.List;

public class AuthenticationResponse {

	private Boolean renewable;
	private String authClientToken;
	private String tokenAccessor;
	private List<String> authPolicies;
	private long authLeaseDuration;
	private boolean authRenewable;
	private String appId;
	private String userId;
	private String username;
	private String nonce;

	public AuthenticationResponse() {
		super();
	}

	public Boolean getRenewable() {
		return renewable;
	}

	public void setRenewable(Boolean renewable) {
		this.renewable = renewable;
	}

	public String getAuthClientToken() {
		return authClientToken;
	}

	public void setAuthClientToken(String authClientToken) {
		this.authClientToken = authClientToken;
	}

	public String getTokenAccessor() {
		return tokenAccessor;
	}

	public void setTokenAccessor(String tokenAccessor) {
		this.tokenAccessor = tokenAccessor;
	}

	public List<String> getAuthPolicies() {
		return authPolicies;
	}

	public void setAuthPolicies(List<String> authPolicies) {
		this.authPolicies = authPolicies;
	}

	public long getAuthLeaseDuration() {
		return authLeaseDuration;
	}

	public void setAuthLeaseDuration(long authLeaseDuration) {
		this.authLeaseDuration = authLeaseDuration;
	}

	public boolean isAuthRenewable() {
		return authRenewable;
	}

	public void setAuthRenewable(boolean authRenewable) {
		this.authRenewable = authRenewable;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

}
