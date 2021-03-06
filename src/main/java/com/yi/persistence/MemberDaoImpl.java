package com.yi.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.yi.mapper.MemberMapper";

	@Override
	public void insert(Member member) {
		sqlSession.insert(namespace + ".insert", member);
	}

	@Override
	public Member read(String id, String pw) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);

		return sqlSession.selectOne(namespace + ".read", map);
	}

	@Override
	public void update(Member member) {
		sqlSession.update(namespace + ".update", member);
	}

	@Override
	public void delete(Member member) {
		sqlSession.update(namespace + ".delete", member);
	}

	@Override
	public List<Member> selectByAll() {
		return sqlSession.selectList(namespace + ".selectByAll");
	}

	@Override
	public Member selectById(Member member) {
		return sqlSession.selectOne(namespace + ".selectById", member);
	}
	
	@Override
	public Member selectByMno(int mno) {
		return sqlSession.selectOne(namespace + ".selectByMno", mno);
	}

}
