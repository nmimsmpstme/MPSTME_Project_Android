package com.ciao.xmpp;

import com.ciao.entities.Account;
import com.ciao.xmpp.stanzas.IqPacket;

public interface OnIqPacketReceived extends PacketReceived {
	public void onIqPacketReceived(Account account, IqPacket packet);
}
