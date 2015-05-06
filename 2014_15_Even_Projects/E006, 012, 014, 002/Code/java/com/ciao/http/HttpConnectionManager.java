package com.ciao.http;

import com.ciao.entities.Message;
import com.ciao.services.AbstractConnectionManager;
import com.ciao.services.XmppConnectionService;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class HttpConnectionManager extends AbstractConnectionManager {

	public HttpConnectionManager(XmppConnectionService service) {
		super(service);
	}

	private List<HttpConnection> connections = new CopyOnWriteArrayList<HttpConnection>();

	public HttpConnection createNewConnection(Message message) {
		HttpConnection connection = new HttpConnection(this);
		connection.init(message);
		this.connections.add(connection);
		return connection;
	}

	public void finishConnection(HttpConnection connection) {
		this.connections.remove(connection);
	}
}
