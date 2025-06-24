package com.example.gogogo.controller;

import com.example.gogogo.dto.UserDto;
import com.example.gogogo.entity.User;
import com.example.gogogo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    
    private final UserRepository userRepository;
    
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            return ResponseEntity.badRequest().build();
        }
        
        if (userRepository.existsByEmail(userDto.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        
        User user = convertToEntity(userDto);
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(convertToDto(savedUser));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setUsername(userDto.getUsername());
                    existingUser.setEmail(userDto.getEmail());
                    existingUser.setFullName(userDto.getFullName());
                    if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
                        existingUser.setPassword(userDto.getPassword());
                    }
                    User savedUser = userRepository.save(existingUser);
                    return ResponseEntity.ok(convertToDto(savedUser));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    private UserDto convertToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setStatus(user.getStatus().name());
        return dto;
    }
    
    private User convertToEntity(UserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFullName(dto.getFullName());
        return user;
    }
} 