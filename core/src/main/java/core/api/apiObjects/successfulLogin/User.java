package core.api.apiObjects.successfulLogin;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class User {
	private List<Object> sessionContext;
	private Object lastName;
	private String obfuscatedUserId;
	private Integer authExpiry;
	private Boolean hasAgreedToTOS;
	private Boolean userEmailConfirmed;
	private String displayName;
	private Object roles;
	private Boolean isSecure;
	private Boolean isRecognized;
	private Boolean isAuthenticated;
	private Boolean isConvertedPortfolioUser;
	private Boolean hasAgreedToTlhTos;
	private Object firstName;
	private Boolean pendingRegistration;
	private Boolean hasSyncedPortfolios;
	private String userEmail;
	private String obfuscated;
	private String hash;
	private Boolean multipleSessions;
	private String username;

	public List<Object> getSessionContext() {
		return sessionContext;
	}

	public void setSessionContext(List<Object> sessionContext) {
		this.sessionContext = sessionContext;
	}

	public Object getLastName() {
		return lastName;
	}

	public void setLastName(Object lastName) {
		this.lastName = lastName;
	}

	public String getObfuscatedUserId() {
		return obfuscatedUserId;
	}

	public void setObfuscatedUserId(String obfuscatedUserId) {
		this.obfuscatedUserId = obfuscatedUserId;
	}

	public Integer getAuthExpiry() {
		return authExpiry;
	}

	public void setAuthExpiry(Integer authExpiry) {
		this.authExpiry = authExpiry;
	}

	public Boolean getHasAgreedToTOS() {
		return hasAgreedToTOS;
	}

	public void setHasAgreedToTOS(Boolean hasAgreedToTOS) {
		this.hasAgreedToTOS = hasAgreedToTOS;
	}

	public Boolean getUserEmailConfirmed() {
		return userEmailConfirmed;
	}

	public void setUserEmailConfirmed(Boolean userEmailConfirmed) {
		this.userEmailConfirmed = userEmailConfirmed;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Object getRoles() {
		return roles;
	}

	public void setRoles(Object roles) {
		this.roles = roles;
	}

	public Boolean getSecure() {
		return isSecure;
	}

	public void setisSecure(Boolean secure) {
		isSecure = secure;
	}

	public Boolean getRecognized() {
		return isRecognized;
	}

	public void setisRecognized(Boolean recognized) {
		isRecognized = recognized;
	}

	public Boolean getAuthenticated() {
		return isAuthenticated;
	}

	public void setisAuthenticated(Boolean authenticated) {
		this.isAuthenticated = authenticated;
	}

	public Boolean getConvertedPortfolioUser() {
		return isConvertedPortfolioUser;
	}

	public void setisConvertedPortfolioUser(Boolean convertedPortfolioUser) {
		isConvertedPortfolioUser = convertedPortfolioUser;
	}

	public Boolean getHasAgreedToTlhTos() {
		return hasAgreedToTlhTos;
	}

	public void setHasAgreedToTlhTos(Boolean hasAgreedToTlhTos) {
		this.hasAgreedToTlhTos = hasAgreedToTlhTos;
	}

	public Object getFirstName() {
		return firstName;
	}

	public void setFirstName(Object firstName) {
		this.firstName = firstName;
	}

	public Boolean getPendingRegistration() {
		return pendingRegistration;
	}

	public void setPendingRegistration(Boolean pendingRegistration) {
		this.pendingRegistration = pendingRegistration;
	}

	public Boolean getHasSyncedPortfolios() {
		return hasSyncedPortfolios;
	}

	public void setHasSyncedPortfolios(Boolean hasSyncedPortfolios) {
		this.hasSyncedPortfolios = hasSyncedPortfolios;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getObfuscated() {
		return obfuscated;
	}

	public void setObfuscated(String obfuscated) {
		this.obfuscated = obfuscated;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Boolean getMultipleSessions() {
		return multipleSessions;
	}

	public void setMultipleSessions(Boolean multipleSessions) {
		this.multipleSessions = multipleSessions;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
