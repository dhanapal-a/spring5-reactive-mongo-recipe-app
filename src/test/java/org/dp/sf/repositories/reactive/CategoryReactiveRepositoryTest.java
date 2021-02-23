package org.dp.sf.repositories.reactive;

import static org.junit.Assert.*;

import org.dp.sf.domain.Category;
import org.dp.sf.repositories.reactive.CategoryReactiveRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryReactiveRepositoryTest {

	@Autowired
	CategoryReactiveRepository categoryReactiveRepository;

	@Before
	public void setUp() throws Exception {
		categoryReactiveRepository.deleteAll().block();
	}

	@Test
	public void testSave() {

		Category category = new Category();
		category.setDescription("Foo");

		categoryReactiveRepository.save(category).block();
		assertEquals(Long.valueOf(1L), categoryReactiveRepository.count().block());
	}

	@Test
	public void testFindByDescription() {
		Category category = new Category();
		category.setDescription("Foo");

		categoryReactiveRepository.save(category).block();

		Category getCat = categoryReactiveRepository.findByDescription("Foo").block();
		assertNotNull(getCat.getId());
	}

}
