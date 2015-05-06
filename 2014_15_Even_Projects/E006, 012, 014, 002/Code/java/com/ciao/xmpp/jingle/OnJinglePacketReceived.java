package com.ciao.xmpp.jingle;

import com.ciao.entities.Account;
import com.ciao.xmpp.PacketReceived;
import com.ciao.xmpp.jingle.stanzas.JinglePacket;

public interface OnJinglePacketReceived extends PacketReceived {
	public void onJinglePacketReceived(Account account, JinglePacket packet);
}
