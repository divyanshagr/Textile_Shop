package com.dbms.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbms.model.Manufacturer;
public interface Manufacturerdao {
	@Autowired
	public void delete(String name);
	public Manufacturer getManufacturer(String name);
	public void saveOrUpdateManufacturer(Manufacturer manufacturer);
	public List<Manufacturer> dispManufac();
	public void manufacupdate(Manufacturer manufacturer);
}
