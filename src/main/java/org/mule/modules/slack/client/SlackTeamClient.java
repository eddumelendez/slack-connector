package org.mule.modules.slack.client;

import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public interface SlackTeamClient {

	String teamAccessLogs(String accessToken,
			@Optional @Default("100") int count,
			@Optional @Default("2") int page);

	String teamInfo(String accessToken);

}
