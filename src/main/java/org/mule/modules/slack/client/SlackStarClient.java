package org.mule.modules.slack.client;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public interface SlackStarClient {

	String starList(String accessToken, String user, int count, int page);

}
