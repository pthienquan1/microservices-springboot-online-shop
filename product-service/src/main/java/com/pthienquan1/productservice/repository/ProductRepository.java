package com.pthienquan1.productservice.repository;

import com.pthienquan1.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by quan0
 * Date 6/4/2023 - 4:15 PM
 * Description: ...
 */
@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
}
