package com.ciao.xmpp;

import com.ciao.entities.Account;
import com.ciao.xmpp.stanzas.MessagePacket;

public interface OnMessagePacketReceived extends PacketReceived {
	public void onMessagePacketReceived(Account account, MessagePacket packet);
}
