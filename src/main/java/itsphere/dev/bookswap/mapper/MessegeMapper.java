package itsphere.dev.bookswap.mapper;

import itsphere.dev.bookswap.model.domain.Messege;
import itsphere.dev.bookswap.model.dto.MessegeRequest;
import itsphere.dev.bookswap.model.dto.MessegeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MessegeMapper {
    MessegeMapper INSTANCE = Mappers.getMapper(MessegeMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Messege toMessege(MessegeRequest request);
    MessegeResponse toResponse(Messege messege);
}
