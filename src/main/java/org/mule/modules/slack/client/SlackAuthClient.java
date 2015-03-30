package org.mule.modules.slack.client;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public interface SlackAuthClient {
	
	String authTest(String accessToken);

}
