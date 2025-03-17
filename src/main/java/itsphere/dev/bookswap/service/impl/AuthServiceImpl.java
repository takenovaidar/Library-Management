package itsphere.dev.bookswap.service.impl;

import itsphere.dev.bookswap.mapper.AuthMapper;
import itsphere.dev.bookswap.model.domain.User;
import itsphere.dev.bookswap.model.auth.AuthResponse;
import itsphere.dev.bookswap.model.auth.LoginRequest;
import itsphere.dev.bookswap.model.auth.RegisterRequest;
import itsphere.dev.bookswap.repository.UserRepository;
import itsphere.dev.bookswap.service.AuthService;
import itsphere.dev.bookswap.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthMapper authMapper;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtUtil jwtUtil,
                           AuthMapper authMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authMapper = authMapper;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Пользователь с email " + request.getEmail() + " уже существует");
        }

        // Преобразуем данные запроса в сущность пользователя с помощью AuthMapper
        User user = authMapper.registerRequestToUser(request);
        // Шифруем пароль
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        // Генерируем JWT-токен
        String token = jwtUtil.generateToken(user.getEmail());

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        return response;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Пользователь с email " + request.getEmail() + " не найден"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Неверные учетные данные");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        return response;
    }
}

