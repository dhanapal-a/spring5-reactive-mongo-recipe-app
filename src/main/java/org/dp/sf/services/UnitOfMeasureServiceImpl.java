package org.dp.sf.services;

import org.dp.sf.commands.UnitOfMeasureCommand;
import org.dp.sf.converters.UnitOfMeasureToUnitOfMeasureCommand;
import org.dp.sf.repositories.reactive.UnitOfMeasureReactiveRepository;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

/**
 * Created by jt on 6/28/17.
 */
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureReactiveRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureReactiveRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Flux<UnitOfMeasureCommand> listAllUoms() {

        return unitOfMeasureRepository.findAll()
                .map(unitOfMeasureToUnitOfMeasureCommand::convert);
    }
}
