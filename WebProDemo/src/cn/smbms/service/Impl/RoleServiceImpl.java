package cn.smbms.service.Impl;

import java.sql.Connection;
import java.util.List;

import cn.smbms.dao.BaseDao;
import cn.smbms.dao.RoleDao;
import cn.smbms.dao.RoleDaoImpl;
import cn.smbms.pojo.Role;
import cn.smbms.service.RoleService;

public class RoleServiceImpl implements RoleService {
	
	private RoleDao roleDao;
	
	public RoleServiceImpl(){
		roleDao = new RoleDaoImpl();
	}
	
	@Override
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		Connection connection = null;
		List<Role> roleList = null;
		try {
			connection = BaseDao.getConnection();
			roleList = roleDao.getRoleList(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return roleList;
	}
	
}
