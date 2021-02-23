package org.dp.sf.repositories.reactive;

import static org.junit.Assert.*;

import org.dp.sf.domain.Recipe;
import org.dp.sf.repositories.reactive.RecipeReactiveRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
public class RecipeReactiveRepositoryTest {

	@Autowired
	RecipeReactiveRepository recipeReactiveRepository;

	@Before
	public void setUp() throws Exception {
		recipeReactiveRepository.deleteAll().block();
	}

	@Test
	public void testRecipeSave() {
		Recipe recipe = new Recipe();
		recipe.setDescription("Yum.");

		recipeReactiveRepository.save(recipe).block();

		assertEquals(Long.valueOf(1L), recipeReactiveRepository.count().block());
	}

}
