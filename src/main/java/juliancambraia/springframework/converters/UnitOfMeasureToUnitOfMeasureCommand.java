package juliancambraia.springframework.converters;

import juliancambraia.springframework.commands.UnitOfMeasureCommand;
import juliancambraia.springframework.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author juliancambraia
 * @implNote
 */
@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {
        if (unitOfMeasure == null) {
            return null;
        }

        final UnitOfMeasureCommand measureCommand = new UnitOfMeasureCommand();
        measureCommand.setId(unitOfMeasure.getId());
        measureCommand.setDescription(unitOfMeasure.getDescription());

        return measureCommand;
    }
}
