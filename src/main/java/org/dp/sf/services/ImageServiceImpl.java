package org.dp.sf.services;

import java.io.IOException;

import org.dp.sf.domain.Recipe;
import org.dp.sf.repositories.reactive.RecipeReactiveRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * Created by jt on 7/3/17.
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

	private final RecipeReactiveRepository recipeRepository;

	public ImageServiceImpl(RecipeReactiveRepository recipeService) {

		this.recipeRepository = recipeService;
	}

	@Override
	public Mono<Void> saveImageFile(String recipeId, MultipartFile file) {

		Mono<Recipe> recipeMono = recipeRepository.findById(recipeId).map(recipe -> {
			Byte[] byteObjects = new Byte[0];
			try {
				byteObjects = new Byte[file.getBytes().length];

				int i = 0;

				for (byte b : file.getBytes()) {
					byteObjects[i++] = b;
				}

				recipe.setImage(byteObjects);
				return recipe;

			} catch (IOException e) {
				// todo handle better
				log.error("Error occurred", e);
				throw (new RuntimeException());
			}
		});
		recipeRepository.save(recipeMono.block()).block();

		return Mono.empty();
	}
}
