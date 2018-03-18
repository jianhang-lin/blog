package work.jianhanglin.spring.boot.blog.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.jianhanglin.spring.boot.blog.domain.Vote;
import work.jianhanglin.spring.boot.blog.repository.VoteRepository;
import work.jianhanglin.spring.boot.blog.service.VoteService;

/**
 * Vote 服务.
 * 
 * @author linjianhang
 *
 */
@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteRepository voteRepository;

	@Override
	@Transactional
	public void removeVote(Long id) {
		voteRepository.delete(id);
	}

	@Override
	public Vote getVoteById(Long id) {
		return voteRepository.findOne(id);
	}

}
