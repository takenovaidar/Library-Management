package itsphere.dev.bookswap.mapper;

import itsphere.dev.bookswap.model.domain.Books;
import itsphere.dev.bookswap.model.domain.User;
import itsphere.dev.bookswap.model.dto.BooksRequest;
import itsphere.dev.bookswap.model.dto.BooksResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BooksMapper {
    Books toBooks(BooksRequest request);

    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUser")
    Books toBookWithUser(BooksRequest request);
    BooksResponse toResponse(Books books);
    void updateBooks(BooksRequest request, @MappingTarget Books books);
    @Named("mapUser")
    default User mapUser(Long userId) {
        if (userId == null) {
            return null;
        }
        User user = new User();
        user.setId(userId);
        return user;
    }


}
