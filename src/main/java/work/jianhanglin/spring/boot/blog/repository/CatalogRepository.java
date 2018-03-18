package work.jianhanglin.spring.boot.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import work.jianhanglin.spring.boot.blog.domain.Catalog;
import work.jianhanglin.spring.boot.blog.domain.User;

/**
 * Catalog 仓库.
 * 
 * @author linjianhang
 *
 */
public interface CatalogRepository extends JpaRepository<Catalog, Long> {

	/**
	 * 根据用户查询
	 * 
	 * @param user
	 * @return
	 */
	List<Catalog> findByUser(User user);

	/**
	 * 根据用户、分类名查询
	 * 
	 * @param user
	 * @param name
	 * @return
	 */
	List<Catalog> findByUserAndName(User user, String name);
}
