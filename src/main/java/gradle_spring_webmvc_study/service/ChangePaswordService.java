package gradle_spring_webmvc_study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gradle_spring_webmvc_study.dto.Member;
import gradle_spring_webmvc_study.exception.MemberNotFoundException;
import gradle_spring_webmvc_study.spring.MemberDao;

@Component
public class ChangePaswordService {
	private MemberDao memberDao;
	
	@Transactional
	public void changePassword(String email,String oldPwd,String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member==null) {
			throw new MemberNotFoundException(null);
		}
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
