package ${groupId}.${rootArtifactId}.dao;

import ${groupId}.${rootArtifactId}.model.User;

public interface UserDao
{
	User findById(Long id);
	void create(User user);
}

