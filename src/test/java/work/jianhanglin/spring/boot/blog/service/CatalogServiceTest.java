package work.jianhanglin.spring.boot.blog.service;

import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import work.jianhanglin.spring.boot.blog.domain.Catalog;
import work.jianhanglin.spring.boot.blog.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatalogServiceTest {

	@Autowired
	private CatalogService catalogService;

	@Autowired
	private UserService userService;

	@Test
	public void testSaveCatalog() {
	}

	@Test
	public void testRemoveCatalog() {
	}

	@Test
	public void testGetCatalogById() {
	}

	@Test
	public void testListCatalogs() {
		User user = userService.getUserById(1L);
		List<Catalog> catalogs = catalogService.listCatalogs(user);
		Assert.assertThat(catalogs.get(0).getId(), is(1L));
	}

}
