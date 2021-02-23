package org.dp.sf.services;

import org.dp.sf.commands.RecipeCommand;
import org.dp.sf.domain.Recipe;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Flux<Recipe> getRecipes();

    Recipe findById(String id);

    RecipeCommand findCommandById(String id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    Mono<Void> deleteById(String idToDelete);
}
