package br.org.domain.repository.dao;

import br.org.domain.dao.GenericDaoBean;
import br.org.domain.repository.Repository;
import br.org.domain.user.User;

import javax.persistence.NoResultException;
import java.util.List;

public class RepositoryDao extends GenericDaoBean{

	public List<Repository> fetch(String name) {
		String query = String.format("db.%s.find({ 'database' : '%s' })", "Repository", name);
		return (List<Repository>) notWaitingEmpty(getListResult(query, Repository.class));
	}

	public List<Repository> fetchAll() {
		String query = String.format("db.%s.find({})", "Repository");
		return (List<Repository>) notWaitingEmpty(getListResult(query, Repository.class));
	}

	public Repository fetchRepositoryByUser(User user) {
		String query = String.format("db.%s.find({'user_id' : ObjectId('%s') })", "Repository", user.getId());
		return (Repository) notWaitingEmpty(getSingleResult(query, Repository.class));
	}

	public boolean userHasRepository(User user) {
		try {
			fetchRepositoryByUser(user);
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
}
