package com.dbms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.dbms.model.Transportentry;
public interface Transportentrydao {
	@Autowired
	public void saveEntry(Transportentry transportentry, Integer inv_id);
	public List<Transportentry> dispEntry(String transdue);
	public void updateEntry(Transportentry transportentry,String transdue);
}
