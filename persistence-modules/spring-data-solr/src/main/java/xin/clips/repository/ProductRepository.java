/*
 * Copyright 2012 - 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package xin.clips.repository;

import xin.clips.entity.Product;
import org.springframework.data.solr.repository.SolrCrudRepository;


import java.util.List;

/**
 * @author www.clips.xin
 */

public interface ProductRepository extends SolrCrudRepository<Product, String> {

	public List<Product> findByName(String name);


}	//@Query("id:*?0* OR name:*?0*")
//public Page<Product> findByCustomQuery(String searchTerm, Pageable pageable);

//	@Query(name = "Product.findByNamedQuery")
//	public Page<Product> findByNamedQuery(String searchTerm, Pageable pageable);
