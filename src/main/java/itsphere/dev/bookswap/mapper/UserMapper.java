package itsphere.dev.bookswap.mapper;

import itsphere.dev.bookswap.model.auth.RegisterRequest;
import itsphere.dev.bookswap.model.domain.User;
import itsphere.dev.bookswap.model.dto.UserRequest;
import itsphere.dev.bookswap.model.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    User toUser(UserRequest request);
    UserResponse toResponse(User user);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    User toUptadeEmail(UserRequest request, User user);

    @Mapping(target = "id", ignore = true)
    User registerRequestToUser(RegisterRequest request);
}

