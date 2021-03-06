package com.yi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.Plan;
import com.yi.domain.PlanDate;
import com.yi.domain.PlanList;
import com.yi.persistence.PlanDao;

@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	private PlanDao planDao;

	@Override
	public void insert(Plan plan) {
		planDao.insert(plan);
	}

	@Override
	public void update(Plan plan) {
		planDao.update(plan);
	}

	@Override
	public void delete(int pno) {
		planDao.delete(pno);
	}

	@Override
	public Plan selectByPno(int pno) {
		return planDao.selectByPno(pno);
	}

	@Override
	public List<Plan> selectByAll(int mno) {
		return planDao.selectByAll(mno);
	}

	@Override
	public void insertPlanList(PlanList planList) {
		// TODO Auto-generated method stub
		planDao.insertPlanList(planList);
	}

	@Override
	public List<PlanList> selectPlanListByPno(int pno) {
		// TODO Auto-generated method stub
		return planDao.selectPlanListByPno(pno);
	}

	@Override
	public List<PlanDate> insertPlanDate(PlanDate planDate) {
		// TODO Auto-generated method stub
		return planDao.insertPlanDate(planDate);
	}

	@Override
	public List<PlanDate> selectPlanDateByAppDate(Date appDate) {
		// TODO Auto-generated method stub
		return planDao.selectPlanDateByAppDate(appDate);
	}

	@Override
	public List<PlanDate> selectPlanByAppDate(int mno, Date appDate) {
		// TODO Auto-generated method stub
		return planDao.selectPlanByAppDate(mno, appDate);
	}

	@Override
	public List<PlanDate> selectPlanDateByMonth(int mno, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return planDao.selectPlanDateByMonth(mno, startDate, endDate);
	}

	@Override
	public void updatePlanDate(PlanDate planDate) {
		// TODO Auto-generated method stub
		planDao.updatePlanDate(planDate);
	}

	@Override
	public void deletePlanDate(PlanDate planDate) {
		// TODO Auto-generated method stub
		planDao.deletePlanDate(planDate);
	}

	@Override
	public PlanDate selectPlanDate(int pdno) {
		// TODO Auto-generated method stub
		return planDao.selectPlanDate(pdno);
	}

	@Override
	public void removePlanList(int pno) {
		// TODO Auto-generated method stub
		planDao.removePlanList(pno);
	}

	@Override
	public void removePlanDate(int pno) {
		// TODO Auto-generated method stub
		planDao.removePlanDate(pno);
	}

}
