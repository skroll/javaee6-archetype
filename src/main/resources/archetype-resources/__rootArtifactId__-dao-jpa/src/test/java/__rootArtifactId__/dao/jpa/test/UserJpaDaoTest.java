package ${groupId}.${rootArtifactId}.dao.jpa.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.junit.runner.RunWith;
import org.junit.Test;
import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import javax.transaction.UserTransaction;

import ${groupId}.${rootArtifactId}.model.User;
import ${groupId}.${rootArtifactId}.dao.UserDao;
import ${groupId}.${rootArtifactId}.dao.jpa.BaseJpaDao;
import ${groupId}.${rootArtifactId}.dao.jpa.UserJpaDao;

@RunWith(Arquillian.class)
public class UserJpaDaoTest
{
	@Deployment
	public static Archive<?> createTestArchive()
	{
		return ShrinkWrap.create(WebArchive.class, "test.war")
			.addClasses(UserDao.class, User.class, BaseJpaDao.class, UserJpaDao.class)
			.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
			.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Inject
	private UserDao userDao;

	@Inject
	private UserTransaction utx;

	@Test
	public void testCreateUser() throws Exception
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

