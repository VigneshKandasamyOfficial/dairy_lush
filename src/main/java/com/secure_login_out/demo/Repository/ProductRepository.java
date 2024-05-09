package com.secure_login_out.demo.Repository;
import org.springframework.data.repository.CrudRepository;
import com.secure_login_out.demo.Model.Product;
public interface ProductRepository extends CrudRepository<Product,Integer> {
	Long countById(Integer id);
}