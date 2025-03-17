package itsphere.dev.bookswap.mapper;

import itsphere.dev.bookswap.model.domain.User;
import itsphere.dev.bookswap.model.auth.RegisterRequest;

/**
 * Интерфейс для маппинга данных из запроса регистрации в сущность пользователя.
 */
public interface AuthMapper {
    /**
     * Преобразует объект RegisterRequest в объект User.
     *
     * @param request запрос регистрации
     * @return сущность пользователя
     */
    User registerRequestToUser(RegisterRequest request);
}

