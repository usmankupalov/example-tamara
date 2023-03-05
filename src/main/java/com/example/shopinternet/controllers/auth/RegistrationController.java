package com.example.shopinternet.controllers.auth;

import com.example.shopinternet.security.UserDetailsImpl;
import com.example.shopinternet.security.JwtProvider;
import com.example.shopinternet.controllers.body.request.AddUser;
import com.example.shopinternet.controllers.body.request.Login;
import com.example.shopinternet.controllers.body.resp.JwtResponse;
import com.example.shopinternet.controllers.body.resp.Response;
import com.example.shopinternet.model.ERole;
import com.example.shopinternet.model.Role;
import com.example.shopinternet.model.User;
import com.example.shopinternet.service.model.RoleService;
import com.example.shopinternet.service.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/v1.0")
@Validated
public class RegistrationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/users")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AddUser requestUser) {
        if (userService.existByPhoneNumber(requestUser.getPhoneNumber())) {
            return ResponseEntity.badRequest().body(new Response("User with this number exist"));
        }
        User user = new User(requestUser.getPhoneNumber(), passwordEncoder.encode(requestUser.getPassword()),
                requestUser.getFirstName(), requestUser.getLastName());
        List<String> strRoles = requestUser.getRole();
        List<Role> roles = new ArrayList<>();
        if (strRoles.isEmpty()) {
            Role role = roleService.findRoleByRoleName(ERole.ROLE_USER);
            roles.add(role);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin": Role adminRole = roleService.findRoleByRoleName(ERole.ROLE_ADMIN);
                        roles.add(adminRole);
                        break;
                    default:
                         Role userRole = roleService.findRoleByRoleName(ERole.ROLE_USER);
                        roles.add(userRole);
                }
            });
        }

        user.setUserRoles(roles);
        userService.saveUser(user);
        return ResponseEntity.ok(new Response("User added"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authUser(@Valid @RequestBody Login authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getPhoneNumber(), authRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUserId(),
                userDetails.getUsername(), userDetails.getPassword(), roles));
    }
}
