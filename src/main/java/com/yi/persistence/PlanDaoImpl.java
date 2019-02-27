package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.Plan;

@Repository
public class PlanDaoImpl implements PlanDao {
	private static final String namespace = "com.yi.mapper.PlanMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(Plan plan) {
		sqlSession.insert(namespace + ".insert", plan);
	}

	@Override
	public void update(Plan plan) {
		sqlSession.update(namespace + ".updatePlan", plan);
	}

	@Override
	public void delete(int pno) {
		sqlSession.delete(namespace + ".deletePlan", pno);
	}

	@Override
	public Plan selectByPno(int pno) {
		return sqlSession.selectOne(namespace + ".selectByPno", pno);
	}

	@Override
	public List<Plan> selectByAll() {
		return sqlSession.selectList(namespace + ".selectPlanAll");
	}

}