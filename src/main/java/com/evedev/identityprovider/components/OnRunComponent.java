package com.evedev.identityprovider.components;

import com.evedev.identityprovider.models.group_scheme.Authority;
import com.evedev.identityprovider.models.group_scheme.Group;
import com.evedev.identityprovider.models.group_scheme.User;
import com.evedev.identityprovider.repositories.AuthorityRepository;
import com.evedev.identityprovider.repositories.GroupRepository;
import com.evedev.identityprovider.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * Creates test user with following credentials:
 * email - test
 * pass - test
 *
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 04.11.17
 */
@Component
public class OnRunComponent {

    private static final String GROUP_ADMINS = "GROUP_ADMINS";
    private static final String ROLE_ADMIN = "ROLE_ADMIN";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @PostConstruct
    public void init() {
        System.out.println("ReconTool#run ==> started");
        initGroups();
        initAuthorities();
        initUsers();
    }

    private void initGroups() {
        Group group = new Group(GROUP_ADMINS);
        groupRepository.save(group);
    }

    private void initAuthorities() {
        Group group = groupRepository.findByName(GROUP_ADMINS);
        Authority authority = new Authority(ROLE_ADMIN, group);
        authorityRepository.save(authority);
    }

    private void initUsers() {
        Group group = groupRepository.findByName(GROUP_ADMINS);
        Set<Group> groups = new HashSet<>();
        groups.add(group);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("test");
        User user = User.builder()
                .email("test")
                .password(encodedPassword)
                .enabled(true)
                .name("Eve")
                .surname("Dev")
                .groups(groups)
                .build();
        userRepository.save(user);
    }
}
