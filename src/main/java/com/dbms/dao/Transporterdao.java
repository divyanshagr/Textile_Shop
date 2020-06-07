package com.dbms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.dbms.model.Transporter;

public interface Transporterdao {
	@Autowired
	public void saveTransporter(Transporter transporter);
	public List<Transporter> dispTrans();
	public void delete(Long tid);
	public void update(Transporter transporter);
	public Transporter getTransporter(Long tid);
}
