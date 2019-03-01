package xin.clips.controller;


import xin.clips.entity.Product;
import xin.clips.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author www.clips.xin
 * @description Product solr controller 示例
 */

@RestController
@RequestMapping("/api/product")
public class ProductController   {

    @Autowired
 	private ProductRepository productRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save() {
        Product p = new Product();
        p.setId("3");
        p.setName("头孢拉定胶囊");
        productRepository.save(p);
        System.out.println("插入成功!");
        return null;
    }


    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String get() {

        List<Product> list= productRepository.findByName("头孢拉定胶囊");
        Product  p = list.get(0);

        return "id"+p.getId()+",name:"+p.getName();
    }

}
