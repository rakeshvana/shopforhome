package com.capstone.shopforhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;
import com.capstone.shopforhome.entity.Wishlist;

import com.capstone.shopforhome.repository.WishlistRepository;

/*
 * @Author:Rakesh
 * Modified Date:30-08-2022
 * Description:This service class is peroforming the business logic.
 */

@Service
public class WishlistServiceImp implements IWishlistService{

	@Autowired
	private WishlistRepository wishlistRepo;
	
	
	/*
	 * @Author:Rakesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for listing the wishlist items 
	 * params : User Entity 
	 * return type : List<Wishlist>
	 */
	
	@Override
	public List<Wishlist> listWishlistItems(User user) {
		// TODO Auto-generated method stub
		
		return wishlistRepo.findByUser(user);
	}

	
	/*
	 * @Author:Rakesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for adding the product to wishlist
	 * params : User Entity , product entity
	 * return type :integer
	 */
	@Override
	public Integer addProductToWishlist(Product product, User user ) {
		// TODO Auto-generated method stub
		
		Wishlist wishlistItem = wishlistRepo.findByUserAndProduct(user, product);
		
		if(wishlistItem==null) {
			Wishlist wItem = new Wishlist();
			wItem.setProduct(product);
			wItem.setUser(user);
			wishlistRepo.save(wItem);
			return (int) wishlistRepo.count();
		}
		else {
			return (int) wishlistRepo.count();
		}
		
	}

	/*
	 * @Author:Rakesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for deleting the product
	 * params : User Entity , product Entity
	 * return type : integer
	 */

	@Override
	public Integer deleteByUserAndProduct(User user, Product product) {
		// TODO Auto-generated method stub
		
		Long cartId= wishlistRepo.findByUserAndProduct(user, product).getId();
		
		wishlistRepo.deleteById(cartId);
		return (int) wishlistRepo.count();
	}
	
	
	/*
	 * @Author:Rakesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for count of the cart items 
	 * params : none
	 * return type : integer
	 */
	
	public Integer getWishlistCount() {
		return (int) wishlistRepo.count();
	}
	
	
}
