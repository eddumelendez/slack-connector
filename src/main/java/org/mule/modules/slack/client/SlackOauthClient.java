package org.mule.modules.slack.client;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public interface SlackOauthClient {

	String oauthAccess(String clientId, String clientSecret, String code,
			String redirectUri);

}
