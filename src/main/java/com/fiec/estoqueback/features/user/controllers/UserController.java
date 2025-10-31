package com.fiec.estoqueback.features.user.controllers;

import com.fiec.estoqueback.features.user.dto.*;
import com.fiec.estoqueback.features.user.models.Admin;
import com.fiec.estoqueback.features.user.models.RegisterState;
import com.fiec.estoqueback.features.user.models.User;
import com.fiec.estoqueback.features.user.models.UserLevel;
import com.fiec.estoqueback.features.user.services.UserService;
import com.fiec.estoqueback.shared.service.S3Service;
import com.fiec.estoqueback.utils.ImageUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/v1/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final S3Service s3Service;



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

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/csv")
    public void createUsers(@RequestParam("inputFile") MultipartFile file) throws IOException {
        userService.createUsers(file.getInputStream());
    }

    @GetMapping("/me")
    public MyUserDto getMe(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        return userService.getMe(user);
    }

    @PutMapping("/photo")
    public void insertUserImage(@RequestParam("image") MultipartFile image, Authentication authentication) throws IOException {
        User user = (User) authentication.getPrincipal();
        //String imageName = ImageUtils.saveImage(image);
        String imageName = s3Service.uploadFile(image);
        user.setPicture(imageName);
        user.setState(RegisterState.IMAGE_CREATED);
        userService.save(user);
    }


}
