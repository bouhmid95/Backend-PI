package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Whishlist;

public interface IWishlistService {

	
	public int addWishList(Whishlist wishlist);

	public Whishlist deleteWishList(int idWhishlist);

	public int updateWishList(Whishlist wishlist);

	public Whishlist findWishList(int idWhishlist);
	
	public List<Whishlist> findAllWishList();
}
