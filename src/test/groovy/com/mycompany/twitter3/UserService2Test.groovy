package com.mycompany.twitter3

import com.mycompany.model.Post
import com.mycompany.model.User
import com.mycompany.model.Wall
import com.mycompany.service.PostService
import com.mycompany.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title("Application Specification")
@Narrative("Specification which beans are expected")
@SpringBootTest
class UserService2Test extends Specification {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    def "add user to service test"() {
        User user = new User();
        user.setProperty("firstName", "Ihor");

        userService.addUser(user);

        String id = user.getProperty("id");

        expect:
            userService.findById(id).isPresent();
    }

    def "subscribe to user test"() {
        User user = new User();
        user.setProperty("firstName", "Stepan");

        User userTarget = new User();
        userTarget.setProperty("firstName", "Ivan");

        user.subscribeTo(userTarget);

        userService.addUser(user);
        userService.addUser(userTarget);

        boolean result = userService.isUserSubscribedTo(user, userTarget);

        expect:
            result == true;
    }

    def "User wall subscription test"() {

        User user = new User();
        user.setProperty("firstName", "Stepan2");

        Post post = new Post();
        post.setProperty("message", "Hello, this is my first post");
        user.addPost(post);
        post.setAuthor(user);

        User userTarget = new User();
        userTarget.setProperty("firstName", "Ivan2");

        Post post2 = new Post();
        post2.setProperty("message", "Hello, my name is Ivan2");
        post2.setAuthor(userTarget);
        userTarget.addPost(post2);

        Post post3 = new Post();
        post3.setProperty("message", "Hello AGAIN");
        post3.setAuthor(userTarget);
        userTarget.addPost(post3);

        user.subscribeTo(userTarget);

        userService.addUser(user);
        postService.addPost(post);
        userService.addUser(userTarget);
        postService.addPost(post2);
        postService.addPost(post3);

        Wall wall = userService.getUserWall(user);

        int postCount = wall.getPosts().size();

        expect:
            postCount == 3;
    }
}
