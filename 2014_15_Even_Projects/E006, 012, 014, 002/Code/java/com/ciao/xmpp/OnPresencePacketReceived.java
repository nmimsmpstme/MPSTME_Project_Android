package com.ciao.xmpp;

import com.ciao.entities.Account;
import com.ciao.xmpp.stanzas.PresencePacket;

public interface OnPresencePacketReceived extends PacketReceived {
	public void onPresencePacketReceived(Account account, PresencePacket packet);
}
