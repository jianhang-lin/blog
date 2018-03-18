package work.jianhanglin.spring.boot.blog.service;

import work.jianhanglin.spring.boot.blog.domain.Authority;

/**
 * Authority 服务接口.
 * 
 * @author linjianhang
 *
 */
public interface AuthorityService {

	/**
	 * 根据id获取 Authority
	 * 
	 * @param id
	 * @return
	 */
	Authority getAuthorityById(Long id);
}
