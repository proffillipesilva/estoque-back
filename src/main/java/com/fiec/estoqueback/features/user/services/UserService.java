package com.fiec.estoqueback.features.user.services;


import com.fiec.estoqueback.features.user.dto.CreatedUserResponseDto;
import com.fiec.estoqueback.features.user.dto.RegisterAdminDto;
import com.fiec.estoqueback.features.user.dto.RegisterGuestDto;
import com.fiec.estoqueback.features.user.dto.RegisterStandardDto;
import com.fiec.estoqueback.features.user.models.User;

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
    void saveStandard(RegisterStandardDto registerStandardDto);
    void saveGuest(RegisterGuestDto registerGuestDto);

    void deleteById(UUID id);
}