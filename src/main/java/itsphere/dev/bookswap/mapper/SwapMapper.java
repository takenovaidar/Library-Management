package itsphere.dev.bookswap.mapper;

import itsphere.dev.bookswap.model.domain.Swap;
import itsphere.dev.bookswap.model.dto.SwapRequest;
import itsphere.dev.bookswap.model.dto.SwapResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SwapMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)

    Swap toEntity(SwapRequest swapRequest);
    SwapResponse toResponse(Swap swap);
}
