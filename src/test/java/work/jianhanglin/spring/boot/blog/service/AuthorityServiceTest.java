package work.jianhanglin.spring.boot.blog.service;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import work.jianhanglin.spring.boot.blog.domain.Authority;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorityServiceTest {

	@Autowired
	private AuthorityService authorityService;

	@Test
	public void testGetAuthorityById() {
		Authority authority = authorityService.getAuthorityById(1L);
		Assert.assertThat(authority.getAuthority(), is("ROLE_ADMIN"));
	}

}
