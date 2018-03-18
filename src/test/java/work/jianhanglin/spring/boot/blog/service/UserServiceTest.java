package work.jianhanglin.spring.boot.blog.service;

import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import work.jianhanglin.spring.boot.blog.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testSaveUser() {
		User user = userService.saveUser(new User("Tom", "11@qq.com", "John", "123456"));
		Assert.assertThat(user.getName(), is("Tom"));
	}

	@Test
	public void testRemoveUser() {
	}

	@Test
	public void testRemoveUsersInBatch() {
	}

	@Test
	public void testUpdateUser() {
	}

	@Test
	public void testGetUserById() {
	}

	@Test
	public void testListUsers() {
		List<User> users = userService.listUsers();
		Assert.assertThat(users.get(0).getId(), is(1L));
	}

	@Test
	public void testListUsersByNameLike() {
	}

	@Test
	public void testListUsersByUsernames() {
	}

}
