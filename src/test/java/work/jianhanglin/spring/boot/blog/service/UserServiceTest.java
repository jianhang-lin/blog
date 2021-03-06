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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	@Rollback(true)
	public void testRemoveUser() {
		List<User> beforeUsers = userService.listUsers();
		int beforeSize = beforeUsers.size();
		userService.removeUser(10L);
		List<User> afterUsers = userService.listUsers();
		int afterSize = afterUsers.size();
		Assert.assertThat(beforeSize - afterSize, is(1));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testRemoveUsersInBatch() {
		List<User> users = new ArrayList<User>();
		users.add(userService.getUserById(8L));
		userService.removeUsersInBatch(users);
		User user = userService.getUserById(8L);
		Assert.assertThat(user.getId(), is(8L));
	}

	@Test
	public void testUpdateUser() {
		User user = userService.getUserById(3L);
		user.setName("Fanny");
		user = userService.updateUser(user);
		Assert.assertThat(user.getName(), is("Fanny"));
	}

	@Test
	public void testGetUserById() {
		/**
		 * 需在实体类User上加@Proxy(lazy=false)
		 */
		User user = userService.getUserById(3L);
		Assert.assertThat(user.getName(), is("Tom"));
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
