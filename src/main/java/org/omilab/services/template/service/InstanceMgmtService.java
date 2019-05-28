package org.omilab.services.template.service;

public interface InstanceMgmtService {

	public Long createInstance(String psmip);

	public Boolean deleteInstance(Long instance);

	public Boolean checkAccess(String ip, Long id);

}