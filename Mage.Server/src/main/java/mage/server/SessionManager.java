/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
*/

package mage.server;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import mage.interfaces.MageException;
import org.apache.log4j.Logger;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class SessionManager {

	private final static Logger logger = Logger.getLogger(SessionManager.class);
	private final static SessionManager INSTANCE = new SessionManager();
	private static ScheduledExecutorService sessionExecutor;

	public static SessionManager getInstance() {
		return INSTANCE;
	}

	protected SessionManager() {
		sessionExecutor = Executors.newScheduledThreadPool(1);
		sessionExecutor.scheduleWithFixedDelay(new SessionChecker(), 30, 10, TimeUnit.SECONDS);
	}

	private ConcurrentHashMap<UUID, Session> sessions = new ConcurrentHashMap<UUID, Session>();

	public Session getSession(UUID sessionId) {
		return sessions.get(sessionId);
	}

	public UUID createSession(String userName, UUID clientId) throws MageException {
		for (Session session: sessions.values()) {
			if (session.getUsername().equals(userName)) {
				if (session.getClientId().equals(clientId)) {
					logger.info("Reconnecting session " + session.getId() + " for " + userName);
					return session.getId();
				}
				else {
					throw new MageException("User name already in use");
				}
			}
		}
		Session session = new Session(userName, clientId);
		sessions.put(session.getId(), session);
		logger.info("Session " + session.getId() + " created for user " + userName);
		return session.getId();
	}

	public void removeSession(UUID sessionId) {
		sessions.remove(sessionId);
	}

	public void checkSessions() {
		for (Session session: sessions.values()) {
			if (!session.stillAlive()) {
				logger.info("Client for user " + session.getUsername() + " timed out - releasing resources");
				session.kill();
				sessions.remove(session.getId());
			}
		}
	}

	class SessionChecker implements Runnable {

		@Override
		public void run() {
			checkSessions();
		}

	}
}

