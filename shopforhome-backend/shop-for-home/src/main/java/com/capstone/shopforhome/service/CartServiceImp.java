package com.capstone.shopforhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.shopforhome.entity.CartItem;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;
import com.capstone.shopforhome.repository.CartRepository;
import com.capstone.shopforhome.service.ICartService;

/*
 * @Author:Rakesh
 * Modified Date:30-08-2022
 * Description:This service class is peroforming the business logic.
 */


@Service
public class CartServiceImp implements ICartService{
	
	
	@Autowired
	private CartRepository cartRepo;
	

/*
 * @Author:Rakesh
 * Modified Date:30-08-2022
 * Description:This service method used for listing the cart items 
 * params : User Entity 
 * return type : List<CartItem>
 */

	@Override
	public List<CartItem> listCartItems(User user) {
		// TODO Auto-generated method stub
		
		return cartRepo.findByUser(user);
	}


	/*
	 * @Author:Rakesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for adding the products to cart
	 * params : User Entity , product Entity, int quantity
	 * return type : integer
	 */
	
	@Override
	public Integer addProductToCart(Product product, User user, int quantity ) {
		// TODO Auto-generated method stub
		
		int finalQuantity =quantity;
		CartItem cartItem = cartRepo.findByUserAndProduct(user, product);
		if(cartItem==null) {
			CartItem cItem = new CartItem();
			cItem.setQuantity(quantity);
			cItem.setProduct(product);
			cItem.setUser(user);
			cartRepo.save(cItem);
		}
		else {
			finalQuantity = cartItem.getQuantity()+quantity;
			cartItem.setQuantity(finalQuantity);
			cartRepo.save(cartItem);
		}
		
		
	
		return (int) cartRepo.count();
		
	}

	/*
	 * @Author:Amit
	 * Modified Date:30-08-2022
	 * Description:This service method used for deleting the product of a specified user
	 * params : User Entity, Product Entity
	 * return type : Integer
	 */
	@Override
	public Integer deleteByUserAndProduct(User user, Product product) {
		// TODO Auto-generated method stub
		
		Long cartId= cartRepo.findByUserAndProduct(user, product).getCart_Id();
		
		cartRepo.deleteById(cartId);
		return (int) cartRepo.count();
	}
	
	/*
	 * @Author:Rakesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for deleting the product by id
	 * params : Long cartId
	 * return type : void
	 */
	
	@Override
	public void deleteById(Long cartId) {
		cartRepo.deleteById(cartId);
	}
	

	/*
	 * @Author:Chaitanya
	 * Modified Date:30-08-2022
	 * Description:This service method used for get the count of cart items
	 * params : none
	 * return type : integer
	 */
	
	
	public Integer getCartCount() {
		return (int) cartRepo.count();
	}
	
	

}
