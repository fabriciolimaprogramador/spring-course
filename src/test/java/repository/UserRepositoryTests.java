package repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springcourse.domain.User;
import com.springcourse.domain.enums.Role;
import com.springcourse.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void saveTest() {
		User user = new User(null, "Fabricio", "fabricio@gmail.com", "123", Role.ADMINISTRATOR, null, null);
		User createdUser = userRepository.save(user);

		assertThat(createdUser.getId()).isEqualTo(1L);

	}

}
