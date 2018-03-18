package work.jianhanglin.spring.boot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import work.jianhanglin.spring.boot.blog.domain.Vote;

/**
 * Vote 仓库.
 * 
 * @author linjianhang
 *
 */
public interface VoteRepository extends JpaRepository<Vote, Long> {

}
