package org.mule.modules.slack.client;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public interface SlackTeamClient {

	String teamAccessLogs(String accessToken, String count, String page);

	String teamInfo(String accessToken);

}
