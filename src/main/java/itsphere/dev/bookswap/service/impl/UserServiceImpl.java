package itsphere.dev.bookswap.service.impl;

import itsphere.dev.bookswap.mapper.UserMapper;
import itsphere.dev.bookswap.model.domain.User;
import itsphere.dev.bookswap.model.dto.UserRequest;
import itsphere.dev.bookswap.repository.UserRepository;
import itsphere.dev.bookswap.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public User createUser(UserRequest request) {
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUserByEmail(String email, UserRequest request) {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        user = userMapper.toUptadeEmail(request, user);
        return userRepository.save(user);
    }


    @Override
    @Transactional()
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
