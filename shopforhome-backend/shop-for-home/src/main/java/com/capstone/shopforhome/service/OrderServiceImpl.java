package com.capstone.shopforhome.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.shopforhome.dto.OrderDTO;
import com.capstone.shopforhome.entity.CartItem;
import com.capstone.shopforhome.entity.Orders;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;
import com.capstone.shopforhome.repository.OrderRepo;
import com.capstone.shopforhome.repository.ProductRepository;

/*
 * @Author:Rakesh
 * Modified Date:30-08-2022
 * Description:This service class is peroforming the business logic.
 */

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderRepo repo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private IProductService productService;
	
	/*
	 * @Author:rakesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for adding the order
	 * params : ArrayList<CartItem> orderItems
	 * return type : String
	 */
	
	@Override
	public String addOrder(ArrayList<CartItem> orderItems) {
		
		for(CartItem item:orderItems) {
		Orders order = new Orders();
		order.setProduct(item.getProduct());
		order.setUser(item.getUser());
		order.setOrderDate(LocalDate.now());
		order.setPrice(item.getProduct().getProductPrice()*item.getQuantity()+10);
		order.setQuantity((long) item.getQuantity());
		
		//decreasing the stock
		Product product = productService.getProductById(item.getProduct().getPid());
		product.setProductStock(product.getProductStock()-item.getQuantity());
		
		productRepo.save(product);
		
		
		repo.save(order);
		}
		
		return "order placed";
	}
	
	/*
	 * @Author:rakesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for getting all orders
	 * params : none
	 * return type : List<Orders>
	 */

	@Override
	public List<Orders> getOrder() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
	/*
	 * @Author:rakesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for getting the orders by product 
	 * params : Product prod 
	 * return type : List<Orders>
	 */
	
	@Override
	public List<Orders> getOrdersByProduct(Product prod) {
		// TODO Auto-generated method stub
		return repo.findByProduct(prod);
	}
	
	/*
	 * @Author:rakesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for listing the orders by date 
	 * params : String from, String to
	 * return type : List<Orders>
	 */
	@Override
	public List<Orders> getByDate(String from, String to) {
		// TODO Auto-generated method stub
		return repo.findByOrderDateBetween(LocalDate.parse(from), LocalDate.parse(to));
	}
	
	/*
	 * @Author:chaitanya
	 * Modified Date:30-08-2022
	 * Description:This service method used for listing the orders by date and product
	 * params : String from, String to
	 * return type : List<Orders>
	 */
	
	public List<Orders> getByDateAndProduct(String from,String to,Long pid){
		return repo.findByOrderDateBetweenAndProducts(LocalDate.parse(from),LocalDate.parse(to), pid);
	}
	
	

}
