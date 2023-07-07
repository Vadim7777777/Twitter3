package com.mycompany;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spock.lang.Narrative;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Twitter3Application.class)
@Narrative("")
public class SpringContextTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
