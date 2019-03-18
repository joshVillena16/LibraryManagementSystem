/* bcabcl
 *
 * Copyright (c) 2018 Tushar Girase All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ecabcl
 */
package com.abcl.libmgmt.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abcl.libmgmt.repository.UserRepository;

/**
 *
 */
@Service
public class UserService implements IUserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;

    /*
     * (non-Javadoc)
     *
     * @see com.abcl.libmgmt.service.IUserService#findUserByName()
     */
    @Override
    public User findUserByName(String userName) {
        com.abcl.libmgmt.models.User userFromDb = userRepository.findByUsername(userName);
        if (userFromDb == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new User(userName, userFromDb.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ADMIN")));
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        return findUserByName(username);
    }

}
