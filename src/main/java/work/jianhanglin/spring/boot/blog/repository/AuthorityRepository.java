package work.jianhanglin.spring.boot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import work.jianhanglin.spring.boot.blog.domain.Authority;

/**
 * Authority 仓库.
 * 
 * @author linjianhang
 *
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
