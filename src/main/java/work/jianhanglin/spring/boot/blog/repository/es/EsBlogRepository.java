package work.jianhanglin.spring.boot.blog.repository.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import work.jianhanglin.spring.boot.blog.domain.es.EsBlog;

/**
 * Blog 存储库.
 * 
 * @author linjianhang
 *
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {

	/**
	 * 模糊查询(去重)
	 * 
	 * @param title
	 * @param Summary
	 * @param content
	 * @param tags
	 * @param pageable
	 * @return
	 */
	Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContainingOrTagsContaining(String title,
			String Summary, String content, String tags, Pageable pageable);

	/**
	 * 通过博客id查询
	 * 
	 * @param blogId
	 * @return
	 */
	EsBlog findByBlogId(Long blogId);
}
