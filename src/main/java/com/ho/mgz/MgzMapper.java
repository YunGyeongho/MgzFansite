package com.ho.mgz;

import java.util.List;

import com.ho.mgz.login.Member;

public interface MgzMapper {
	public abstract int join(Member m); 
	public abstract Member getMemberByID(Member inputMember);
	public abstract int deleteAcount(Member m);
	public abstract int updateMyInfo(Member m);
	public abstract List<Member> getMemberByIDList(Member inputMember);
	
}
