package br.com.studio.entities.repository;

import br.org.domain.repository.Repository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RepositoryTest {

	private Repository repository;

	@Before
	public void setUp() {
		repository = new Repository();
	}

	@Test
	public void a_new_instance_of_REPOSITORY_must_contains_a_uuid() {
		Assert.assertNotNull("UUID should not be null", repository.getUuid());
	}

}
