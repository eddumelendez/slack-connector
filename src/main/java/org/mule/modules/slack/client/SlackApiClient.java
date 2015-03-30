package org.mule.modules.slack.client;

import java.io.IOException;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public interface SlackApiClient {

	public String apiTest(String error, String foo) throws IOException;

}
