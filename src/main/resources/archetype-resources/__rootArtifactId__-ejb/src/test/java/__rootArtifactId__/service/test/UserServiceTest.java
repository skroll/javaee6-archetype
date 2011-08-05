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
import ${groupId}.${rootArtifactId}.service.UserService;

@RunWith(Arquillian.class)
public class UserServiceTest
{
	@Deployment
	public static Archive<?> createTestArchive()
	{
		return ShrinkWrap.create(WebArchive.class, "test.war")
			.addClasses(UserService.class, UserDao.class, User.class, BaseJpaDao.class, UserJpaDao.class)
			.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
			.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Inject
	private UserService userService;

	@Test
	public void testCreateUser() throws Exception
	{
		userService.createAUser();
	}
}

