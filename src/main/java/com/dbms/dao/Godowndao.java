package com.dbms.dao;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.dbms.model.Godown;
public interface Godowndao {
	@Autowired
	public void delete(Long gid);
	public Godown getGodown(Long gid);
	public void saveGodown(Godown godown);
	public List<Godown> dispGodown();
	public void updateGodown(Godown godown);
}
