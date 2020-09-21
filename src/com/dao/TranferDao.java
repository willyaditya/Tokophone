package com.dao;

import java.util.List;

import com.entity.Transfer;

public interface TranferDao {
	public List<Transfer> getAllTransfers();
	public Transfer getTransferById(String id);
	public int addTransfer(Transfer transfer);
	public int updateTransfer(Transfer transfer);
	public int deleteTransfer(String id);
}
