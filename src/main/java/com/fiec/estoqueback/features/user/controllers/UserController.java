package com.fiec.estoqueback.features.user.controllers;

import com.fiec.estoqueback.features.user.dto.CreatedUserResponseDto;
import com.fiec.estoqueback.features.user.dto.RegisterAdminDto;
import com.fiec.estoqueback.features.user.dto.RegisterGuestDto;
import com.fiec.estoqueback.features.user.dto.RegisterStandardDto;
import com.fiec.estoqueback.features.user.models.Admin;
import com.fiec.estoqueback.features.user.models.User;
import com.fiec.estoqueback.features.user.models.UserLevel;
import com.fiec.estoqueback.features.user.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/admin")
    public CreatedUserResponseDto registerAdmin(@Valid @RequestBody RegisterAdminDto registerAdminDto) throws Exception {
        return userService.saveAdmin(registerAdminDto);
    }

    @PostMapping("/standard")
    public CreatedUserResponseDto registerStandard(@Valid @RequestBody RegisterStandardDto registerStandardDto){
        return userService.saveStandard(registerStandardDto);
    }

    @PostMapping("/guest")
    public void registerGuest(@Valid @RequestBody RegisterGuestDto registerGuestDto){

    }
}
