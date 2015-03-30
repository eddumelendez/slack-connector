package org.mule.modules.slack.client;

/**
 * 
 * @author Eddú Meléndez
 *
 */
public class SlackClient {

	public SlackApiClient getSlackApiClient() {
		return new SlackApiClientImpl();
	}

	public SlackAuthClient getSlackAuthClient() {
		return new SlackAuthClientImpl();
	}

	public SlackChannelClient getSlackChannelClient() {
		return new SlackChannelClientImpl();
	}

	public SlackChatClient getSlackChatClient() {
		return new SlackChatClientImpl();
	}

	public SlackEmojiClient geSlackEmojiClient() {
		return new SlackEmojiClientImpl();
	}

	public SlackFileClient geSlackFileClient() {
		return new SlackFileClientImpl();
	}

	public SlackGroupClient geSlackGroupClient() {
		return new SlackGroupClientImpl();
	}

	public SlackIMClient geSlackIMClient() {
		return new SlackIMClientImpl();
	}

	public SlackOauthClient geSlackOauthClient() {
		return new SlackOauthClientImpl();
	}

	public SlackRTMClient getSlackRTMClient() {
		return new SlackRTMClientImpl();
	}

	public SlackSearchClient getSlackSearchClient() {
		return new SlackSearchClientImpl();
	}

	public SlackTeamClient getSlackTeamClient() {
		return new SlackTeamClientImpl();
	}

	public SlackUserClient getSlackUserClient() {
		return new SlackUserClientImpl();
	}

}
