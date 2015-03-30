/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.slack;

import java.io.IOException;

import org.mule.api.annotations.ConnectionStrategy;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.oauth.OAuthProtected;
import org.mule.api.annotations.param.Optional;
import org.mule.api.annotations.rest.RestQueryParam;
import org.mule.modules.connection.strategy.SlackOauthStrategy;
import org.mule.modules.slack.client.SlackClient;

/**
 * OAuth2 Connection Strategy
 *
 * @author MuleSoft, Inc.
 */
@Connector(name = "slack", friendlyName = "Slack")
public class SlackConnector {

	@ConnectionStrategy
	private SlackOauthStrategy slackOauthStrategy;

	public void setSlackOauthStrategy(SlackOauthStrategy slackOauthStrategy) {
		this.slackOauthStrategy = slackOauthStrategy;
	}

	public SlackOauthStrategy getSlackOauthStrategy() {
		return slackOauthStrategy;
	}

	private SlackClient slackClient;

	public SlackConnector() {
		this.slackClient = new SlackClient();
	}

	@Processor
	public String apiTest(@RestQueryParam("error") @Optional String error,
			@RestQueryParam("foo") @Optional String foo) throws IOException {
		return this.slackClient.getSlackApiClient().apiTest(error, foo);
	}

	@Processor
	@OAuthProtected
	public String authTest() throws IOException {
		return this.slackClient.getSlackAuthClient().authTest(
				this.slackOauthStrategy.getAccessToken());
	}

	@Processor
	@OAuthProtected
	public String usersInfo(@RestQueryParam("user") String user)
			throws IOException {
		return this.slackClient.getSlackUserClient().usersInfo(
				this.slackOauthStrategy.getAccessToken(), user);
	}

	@Processor
	@OAuthProtected
	public String usersList() throws IOException {
		return this.slackClient.getSlackUserClient().usersList(
				this.slackOauthStrategy.getAccessToken());
	}

}