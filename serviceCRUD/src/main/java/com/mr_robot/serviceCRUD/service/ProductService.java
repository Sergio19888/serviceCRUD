package com.mr_robot.serviceCRUD.service;

import com.mr_robot.serviceCRUD.DTO.ProductDTO;
import com.mr_robot.serviceCRUD.exception.CustomErrorException;
import com.mr_robot.serviceCRUD.mapper.ProductMapper;
import com.mr_robot.serviceCRUD.model.Product;
import com.mr_robot.serviceCRUD.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDTO create(ProductDTO productDTO) {
        if(productRepository.existsByName(productDTO.getName())){
            throw new CustomErrorException("Такой товар уже существует");
        }
        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }

    public ProductDTO update(Long id, ProductDTO productDTO){
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("продукт не найден"));
        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setPrice(productDTO.getPrice());
        Product updateProduct = productRepository.save(existingProduct);
        return productMapper.toDTO(updateProduct);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Page<ProductDTO> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable).map(productMapper :: toDTO);
    }



}
