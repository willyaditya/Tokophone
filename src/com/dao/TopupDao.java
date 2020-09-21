package com.dao;

import java.util.List;

import com.entity.Topup;

public interface TopupDao {
	public List<Topup> getAllTopups();
	public Topup getTopupById(String id);
	public int addTopup(Topup topup);
	public int updateTopup(Topup topup);
	public int deleteTopup(String id);
}
