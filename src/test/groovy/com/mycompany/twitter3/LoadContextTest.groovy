package com.mycompany.twitter3


import com.mycompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spock.lang.Narrative;
import spock.lang.Specification;
import spock.lang.Title;

@Title("Application Specification")
@Narrative("Specification which beans are expected")
@SpringBootTest
class LoadContextTest extends Specification {

    @Autowired(required = false)
    private UserService webController;

//    def adsf() {
//        expect: "the WebController is created"
//        webController
//    }
}
