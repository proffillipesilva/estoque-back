package com.fiec.estoqueback.features.user.services.impl;

import com.fiec.estoqueback.features.firebase.models.dto.FcmTokenRequest;
import com.fiec.estoqueback.features.user.dto.*;
import com.fiec.estoqueback.features.user.models.*;
import com.fiec.estoqueback.features.user.repositories.AdminRepository;
import com.fiec.estoqueback.features.user.repositories.GuestRepository;
import com.fiec.estoqueback.features.user.repositories.StandardRepository;
import com.fiec.estoqueback.features.user.repositories.UserRepository;
import com.fiec.estoqueback.features.user.services.UserService;
import com.fiec.estoqueback.utils.PasswordEncryptor;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final GuestRepository guestRepository;
    private final StandardRepository standardRepository;


    //private final PasswordEncoder passwordEncoder;



    @Override
    public User save(User user) {
        // Criptografa a senha antes de salvar

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(UUID id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setAccessLevel(updatedUser.getAccessLevel());
            user.setPicture(updatedUser.getPicture());

            // Re-criptografa a senha apenas se uma nova for fornecida
            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                user.setPassword(PasswordEncryptor.encrypt(updatedUser.getPassword()));
            }
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    @Override
    public CreatedUserResponseDto saveAdmin(RegisterAdminDto registerAdminDto) {
        String email = registerAdminDto.getEmail();
        if(findByEmail(email).isPresent()){
            throw new RuntimeException();
        }
        User user = new User();
        user.setEmail(registerAdminDto.getEmail());
        user.setPassword(PasswordEncryptor.encrypt(registerAdminDto.getPassword()));
        user.setName(registerAdminDto.getName());
        user.setAccessLevel(UserLevel.ROLE_ADMIN);
        User savedUser = save(user);
        Admin admin = new Admin();
        admin.setUser(savedUser);
        admin.setCnpj(registerAdminDto.getCnpj());
        admin.setRamoAtuacao(registerAdminDto.getRamoAtuacao());
        admin.setNomeDaEmpresa(registerAdminDto.getNomeDaEmpresa());
        Admin savedAdmin = adminRepository.save(admin);
        return CreatedUserResponseDto.builder()
                .id(String.valueOf(savedAdmin.getId()))
                .userId(String.valueOf(savedUser.getId()))
                .build();
    }

    @Override
    public CreatedUserResponseDto saveStandard(RegisterStandardDto registerStandardDto) {
        String email = registerStandardDto.getEmail();
        if(findByEmail(email).isPresent()){
            throw new RuntimeException();
        }
        User user = new User();
        user.setEmail(registerStandardDto.getEmail());
        user.setPassword(PasswordEncryptor.encrypt(registerStandardDto.getPassword()));
        user.setName(registerStandardDto.getName());
        user.setAccessLevel(UserLevel.ROLE_STANDARD);
        User savedUser = save(user);
        Standard standard = new Standard();
        standard.setUser(savedUser);
        standard.setCnpj(registerStandardDto.getCnpj());
        standard.setRamoAtuacao(registerStandardDto.getRamoAtuacao());
        Standard savedStandard = standardRepository.save(standard);
        return CreatedUserResponseDto.builder()
                .id(String.valueOf(savedStandard.getId()))
                .userId(String.valueOf(savedUser.getId()))
                .build();
    }

    @Override
    public CreatedUserResponseDto saveGuest(RegisterGuestDto registerGuestDto) {
        String email = registerGuestDto.getEmail();
        if(findByEmail(email).isPresent()){
            throw new RuntimeException();
        }
        User user = new User();
        user.setEmail(registerGuestDto.getEmail());
        user.setPassword(PasswordEncryptor.encrypt(registerGuestDto.getPassword()));
        user.setName(registerGuestDto.getName());
        user.setAccessLevel(UserLevel.ROLE_ADMIN);
        User savedUser = save(user);
        Guest guest = new Guest();
        guest.setUser(savedUser);
        guest.setCpfOrCnpj(registerGuestDto.getCpfOrCnpj());
        guest.setName(registerGuestDto.getName());
        Guest savedGuest = guestRepository.save(guest);
        return CreatedUserResponseDto.builder()
                .id(String.valueOf(savedGuest.getId()))
                .userId(String.valueOf(savedUser.getId()))
                .build();
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public MyUserDto getMe(User user) {
        UserLevel tipoUsuario = user.getAccessLevel();
        MyUserDto myUserDto = null;
        if(UserLevel.ROLE_ADMIN.equals(tipoUsuario)){
            Admin admin = adminRepository.findByUser(user).orElseThrow();
            myUserDto = new MyUserDto();
            myUserDto.setCnpj(admin.getCnpj());
            myUserDto.setNomeDaEmpresa(admin.getNomeDaEmpresa());
            myUserDto.setTipo("ADMIN");
        } else if(UserLevel.ROLE_STANDARD.equals(tipoUsuario)){
            Standard standard = standardRepository.findByUser(user).orElseThrow();
            myUserDto = new MyUserDto();
            myUserDto.setCnpj(standard.getCnpj());
            myUserDto.setNomeDaEmpresa(standard.getNomeDaEmpresa());
            myUserDto.setTipo("STANDARD");
        } else {
            Guest guest = guestRepository.findByUser(user).orElseThrow();
            myUserDto = new MyUserDto();
            myUserDto.setCnpj(guest.getCpfOrCnpj());
            myUserDto.setNome(guest.getName());
            myUserDto.setTipo("GUEST");
        }
        myUserDto.setPicture(user.getPicture());
        myUserDto.setEmail(user.getEmail());
        return myUserDto;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow();
    }

    /**
     * Busca o usuário e atualiza seu fcmToken.
     * @param userId O ID do usuário logado.
     * @param request O DTO contendo o novo token FCM.
     * @return O User atualizado.
     * @throws RuntimeException Se o usuário não for encontrado.
     */

    public User updateFcmToken(UUID userId, FcmTokenRequest request) {

        // 1. Busca o usuário pelo ID
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + userId));

        System.out.println(userId);
        // 2. Atualiza o atributo fcmToken
        user.setFcmToken(request.getFcmToken());

        // 3. Salva a alteração (o @Transactional garante que a persistência ocorra)
        return userRepository.save(user);
    }
}