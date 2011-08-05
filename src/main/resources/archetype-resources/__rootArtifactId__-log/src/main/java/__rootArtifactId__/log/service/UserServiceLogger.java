package ${groupId}.${rootArtifactId}.log.service;

import org.jboss.seam.solder.logging.Log;
import org.jboss.seam.solder.logging.MessageLogger;
import org.jboss.seam.solder.messages.Message;

import static org.jboss.logging.Logger.Level.INFO;

@MessageLogger
public interface UserServiceLogger
{
	@Log(level = INFO)
	@Message("Initializing user service.")
	void logInitializing();
}

