package com.naovis.salaryviewer.security;

import com.naovis.salaryviewer.entities.RoleEntity;
import com.naovis.salaryviewer.entities.UserEntity;
import com.naovis.salaryviewer.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity = userRepository.find(username);
        if (entity == null) {
            throw new UsernameNotFoundException("Username:" + username + " Not Found");
        }
        List<SimpleGrantedAuthority> authorities = getAuthorities(entity.getRoles());

        return User.withUsername(entity.getUsername()).password(entity.getPassword())
                .authorities(authorities).build();
    }


    private List<SimpleGrantedAuthority> getAuthorities(List<RoleEntity> roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity r : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + r.getName()));
        }
        return authorities;
    }

}

