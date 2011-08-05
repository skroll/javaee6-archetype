package ${groupId}.${rootArtifactId}.dao.jpa;

import java.io.Serializable;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

public class BaseJpaDao implements Serializable
{
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager()
	{
		return this.entityManager;
	}
}

