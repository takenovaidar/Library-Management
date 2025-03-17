package itsphere.dev.bookswap.service;

import itsphere.dev.bookswap.model.auth.AuthResponse;
import itsphere.dev.bookswap.model.auth.LoginRequest;
import itsphere.dev.bookswap.model.auth.RegisterRequest;

public interface AuthService {
    /**
     * Регистрация нового пользователя.
     * @param request данные для регистрации
     * @return ответ с токеном
     */
    AuthResponse register(RegisterRequest request);

    /**
     * Аутентификация пользователя.
     * @param request данные для входа
     * @return ответ с токеном
     */
    AuthResponse login(LoginRequest request);
}

