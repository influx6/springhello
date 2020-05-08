package com.spring.cdibiz;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CDIBusiness {
	public CDIDao getCdiDao() {
		return cdiDao;
	}

	public void setCdiDao(CDIDao cdiDao) {
		this.cdiDao = cdiDao;
	}

	@Inject
	CDIDao cdiDao;

	public int findLatestCD() {
		int[] latest = this.cdiDao.getData();
		return latest[0];
	}
}
