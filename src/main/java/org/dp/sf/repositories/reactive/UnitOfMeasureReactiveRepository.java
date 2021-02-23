package org.dp.sf.repositories.reactive;

import org.dp.sf.domain.UnitOfMeasure;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by jt on 8/17/17.
 */
public interface UnitOfMeasureReactiveRepository extends ReactiveMongoRepository<UnitOfMeasure, String> {
}
