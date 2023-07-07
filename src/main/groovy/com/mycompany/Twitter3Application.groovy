package com.mycompany

import com.mycompany.model.Post
import com.mycompany.model.User
import com.mycompany.repository.PostRepository
import com.mycompany.repository.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.context.annotation.Bean

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
class Twitter3Application {

	public final Logger LOGGER = LoggerFactory.getLogger(getClass());

	static void main(String[] args) {
		SpringApplication.run(Twitter3Application, args)
	}

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public PostRepository postRepository;

	@Bean
	CommandLineRunner runner() {
		return  {
			List<User> employees = userRepository.findAll();
			if (employees.size() < 10) {
				LOGGER.info("******* Inserting User to DB *******");
				//employeeRepository.saveAll(HelperUtil.employeeSupplier.get());

				User user = new User();
				LOGGER.info("******* Inserting User to DB 2*******");
				user.setProperty("firstName", "vadimxx");
				LOGGER.info("******* Inserting User to DB 3*******");
				user.setProperty("lastName", "drokov");
				LOGGER.info("******* Inserting User to DB 4*******");

				LOGGER.info("******* Inserting Post to DB 5*******");
				Post post = new Post();
				post.setAuthor(user);
				post.setProperty("message", "Hi there this is my first post");

				userRepository.save(user);
				postRepository.save(post);

			} else {
				LOGGER.info("******* Users stored in DB Size :: {}", employees.size());
				LOGGER.info("******* Users stored in DB :: {}", employees);
			}
		};
	}


}
