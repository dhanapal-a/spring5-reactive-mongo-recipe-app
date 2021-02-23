package org.dp.sf.repositories.reactive;

import org.dp.sf.domain.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
/**
 * 
 * @author dp
 *
 */
public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {
}
