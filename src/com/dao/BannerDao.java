package com.dao;

import java.util.List;

import com.entity.Banner;

public interface BannerDao {
	public List<Banner> getAllBanners();
	public Banner getBannerById(String id);
	public int addBanner(Banner banner);
	public int updateBanner(Banner banner);
	public int deleteBanner(String id);
}
