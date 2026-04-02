package com.portal.Ecommerce;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User user = new DefaultOAuth2UserService().loadUser(userRequest);

        String email = user.getAttribute("email");

        Optional<UserDTO> dbUser = userRepository.findByEmail(email);

        if (!dbUser.isPresent()) {
            throw new RuntimeException("User not authorized");
        }

        return user;
    }
}
