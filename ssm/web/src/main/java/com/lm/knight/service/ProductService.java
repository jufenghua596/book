package com.lm.knight.service;

import com.lm.knight.domain.Product;

public interface ProductService {
	Product add(Product product);
	Product get(long id);
}
