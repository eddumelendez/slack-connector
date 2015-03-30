package org.mule.modules.slack.client;

import java.io.IOException;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public interface SlackUserClient {

	String getUsersList(String accessToken) throws IOException;

	String getUsersInfo(String accessToken, String user);
	
}