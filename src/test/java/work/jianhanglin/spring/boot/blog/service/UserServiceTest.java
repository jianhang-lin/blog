package work.jianhanglin.spring.boot.blog.service;

import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		Pageable pageable = new PageRequest(0, 5);
		Page<User> users = userService.listUsersByNameLike("Tom", pageable);
		Assert.assertThat(users.getTotalElements(), is(1L));
	}

	@Test
	public void testListUsersByUsernames() {
		List<String> userNames = new ArrayList<String>();
		userNames.add("Jianhang");
		userNames.add("Tom");
		List<User> users = userService.listUsersByUsernames(userNames);
		Assert.assertNotNull(users);
	}

}
