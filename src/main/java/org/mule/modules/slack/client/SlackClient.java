package org.mule.modules.slack.client;

import java.io.IOException;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public interface SlackClient {

	String getUserList(String accessToken) throws IOException;

}