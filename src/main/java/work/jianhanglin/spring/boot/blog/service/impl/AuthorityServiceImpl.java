package work.jianhanglin.spring.boot.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.jianhanglin.spring.boot.blog.domain.Authority;
import work.jianhanglin.spring.boot.blog.repository.AuthorityRepository;
import work.jianhanglin.spring.boot.blog.service.AuthorityService;

/**
 * Authority 服务.
 * 
 * @author linjianhang
 *
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public Authority getAuthorityById(Long id) {
		return authorityRepository.findOne(id);
	}

}
