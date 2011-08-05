package ${groupId}.${rootArtifactId}.service.log;

import org.jboss.seam.solder.logging.Log;
import org.jboss.seam.solder.logging.MessageLogger;
import org.jboss.seam.solder.messages.Message;

import static org.jboss.logging.Logger.Level.DEBUG;

@MessageLogger
public interface UserServiceLogger
{
	@Log(level = DEBUG)
	@Message("Initializing user service.")
	void logInitializing();
}

