package service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import dao.IDao;
import interceptor.Audited;

@Audited
public class ServiceImpl implements IService {

	@Inject
	private IDao dao;

	@Override
	public String appelDao() {
		return dao.appelDao();
	}

	@PostConstruct
	public void loagApresConstruction() {
		System.out.println("Après création Service");
	}

	@PreDestroy
	public void logAvantDestruction() {
		System.out.println("Avant destruction Service");
	}
}
