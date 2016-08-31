package org.codingsills.service;

import java.util.Map;
import java.util.Set;

import org.codingsills.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

/**
 * 类功能描述
 * UserServiceImplTest.java
 *
 * @date 2016年7月21日
 * 
 * @author Saber
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-config.xml")
@ActiveProfiles("dev")
public class UserServiceImplTest {
    
    @Autowired
    private UserService userService;
    
    @Test
    public void testFindPerms(){
        Map<String,Set<String>> map = userService.findRolesAndPermissions("admin");
        Set<String> perms = map.get(UserService.PERMS);
        System.out.println(new Gson().toJson(perms));
    }
    
}
