package network.message.event;

import network.message.MessageConversationOpened;
import network.message.MessageIdAssigned;
import network.message.MessageUserChanged;
import network.message.MessageUserDisconnected;

public interface MessageListener
{
	public void idAssigned(MessageIdAssigned message);
	public void userChanged(MessageUserChanged message);
	public void userDisconnected(MessageUserDisconnected message);
	public void conversationOpened(MessageConversationOpened message);
}