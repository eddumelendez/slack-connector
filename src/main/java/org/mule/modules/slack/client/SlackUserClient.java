package org.mule.modules.slack.client;

import java.io.IOException;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public interface SlackUserClient {

	String usersList(String accessToken) throws IOException;

	String usersInfo(String accessToken, String user);
	
}