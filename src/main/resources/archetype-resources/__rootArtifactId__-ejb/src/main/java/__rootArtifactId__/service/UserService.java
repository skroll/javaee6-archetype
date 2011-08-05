package ${groupId}.${rootArtifactId}.service;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.annotation.PostConstruct;

import javax.transaction.UserTransaction;

import ${groupId}.${rootArtifactId}.dao.UserDao;
import ${groupId}.${rootArtifactId}.model.User;
import ${groupId}.${rootArtifactId}.service.log.UserServiceLogger;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserService
{
	@Inject
	private UserDao userDao;

	@Inject
	private UserTransaction utx;

	@Inject
	private UserServiceLogger log;

	@Produces
	@Named
	public void createAUser() throws Exception
	{
		User user = new User();
		user.setName("username");

		try {
			try {
				utx.begin();
				userDao.create(user);
			}
			finally {
				utx.commit();
			}
		}
		catch (Exception e) {
			utx.rollback();
			throw e;
		}
	}

	@PostConstruct
	public void logInitialization()
	{
		log.logInitializing();
	}
}

