package ${groupId}.${rootArtifactId}.dao.jpa;

import ${groupId}.${rootArtifactId}.dao.UserDao;
import ${groupId}.${rootArtifactId}.model.User;

import javax.enterprise.inject.Default;

@Default
public class UserJpaDao extends BaseJpaDao implements UserDao
{
	public User findById(Long id)
	{
		return getEntityManager().find(User.class, id);
	}

	public void create(User user)
	{
		getEntityManager().persist(user);
	}
}

