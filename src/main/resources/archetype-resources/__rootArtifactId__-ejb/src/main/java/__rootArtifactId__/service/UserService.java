package ${groupId}.${rootArtifactId}.service;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import javax.transaction.UserTransaction;

import ${groupId}.${rootArtifactId}.dao.UserDao;
import ${groupId}.${rootArtifactId}.model.User;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserService
{
	@Inject
	private UserDao userDao;

	@Inject
	private UserTransaction utx;

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
}

