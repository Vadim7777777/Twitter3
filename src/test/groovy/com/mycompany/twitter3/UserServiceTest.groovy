package com.mycompany.twitter3

import com.mycompany.model.User;
import com.mycompany.service.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title("UserService test")
@Narrative("The Specification of the behaviour of the UserService service.'")
@SpringBootTest
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude= SecurityAutoConfiguration.class)
class UserServiceTest extends Specification {

    @Autowired
    private UserService userService;

    def "Save user to db"() {
        User user = new User();
        user.setProperty("firstName", "Ivan");

        userService.addUser(user);

        expect userService.findAll().size() > 0;
    }

}
