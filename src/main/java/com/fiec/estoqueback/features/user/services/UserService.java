package com.fiec.estoqueback.features.user.services;


import com.fiec.estoqueback.features.firebase.models.dto.FcmTokenRequest;
import com.fiec.estoqueback.features.user.dto.*;
import com.fiec.estoqueback.features.user.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User save(User user);
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    User update(UUID id, User updatedUser);
    CreatedUserResponseDto saveAdmin(RegisterAdminDto registerAdminDto);
    CreatedUserResponseDto saveStandard(RegisterStandardDto registerStandardDto);
    CreatedUserResponseDto saveGuest(RegisterGuestDto registerGuestDto);

    void deleteById(UUID id);

    MyUserDto getMe(User user);

    User updateFcmToken(UUID userId, FcmTokenRequest request);

    void createUsers(InputStream inputStream);
}