package com.mycompany.twitter3;

import com.mycompany.Twitter3Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spock.lang.Narrative;
import spock.lang.Specification;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Twitter3Application.class)
@Narrative("")
public class SpringContextTest extends Specification {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }

}
