package work.jianhanglin.spring.boot.blog.service;

import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import work.jianhanglin.spring.boot.blog.domain.es.EsBlog;
import work.jianhanglin.spring.boot.blog.vo.TagVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogServiceTest {

	Pageable pageable = null;

	@Autowired
	private EsBlogService esBlogService;

	@Before
	public void testBefore() {
		pageable = new PageRequest(0, 5);
	}

	@Test
	public void testRemoveEsBlog() {
		// fail("Not yet implemented");
	}

	@Test
	public void testUpdateEsBlog() {
		EsBlog esBlog = esBlogService.updateEsBlog(new EsBlog("EsBlog标题", "EsBlog内容"));
		Assert.assertThat(esBlog.getTitle(), is("EsBlog标题"));
	}

	@Test
	public void testGetEsBlogByBlogId() {
		// fail("Not yet implemented");
	}

	@Test
	public void testListNewestEsBlogs() {
		Page<EsBlog> pages = esBlogService.listNewestEsBlogs("EsBlog", pageable);
		Assert.assertThat(pages.getTotalPages(), is(1));
	}

	@Test
	public void testListHotestEsBlogs() {
		Page<EsBlog> pages = esBlogService.listHotestEsBlogs("EsBlog", pageable);
		Assert.assertThat(pages.getTotalPages(), is(1));
	}

	@Test
	public void testListEsBlogs() {
		Page<EsBlog> pages = esBlogService.listEsBlogs(pageable);
		Assert.assertThat(pages.getTotalPages(), is(1));
	}

	@Test
	public void testListTop5NewestEsBlogs() {
		List<EsBlog> pages = esBlogService.listTop5NewestEsBlogs();
		Assert.assertThat(pages.size(), is(2));
	}

	@Test
	public void testListTop5HotestEsBlogs() {
		List<EsBlog> pages = esBlogService.listTop5HotestEsBlogs();
		Assert.assertThat(pages.size(), is(2));
	}

	@Test
	public void testListTop30Tags() {
		List<TagVO> tags = esBlogService.listTop30Tags();
		Assert.assertThat(tags.size(), is(1));
	}

	@Test
	public void testListTop12Users() {
		// fail("Not yet implemented");
	}

}
