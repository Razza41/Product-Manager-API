package api.product.manager.service;


import api.product.manager.dto.ProductDTO;
import api.product.manager.entity.ProductEntity;
import api.product.manager.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductEntity registerProduct(ProductDTO productDTO){ //post

        ProductEntity product = ProductEntity.builder().
                name(productDTO.name()).
                description(productDTO.description()).
                price(productDTO.price()).
                stock(productDTO.stock()).
                category_id(productDTO.category_id()).build();

        return productRepository.save(product);
    }

    public void removeProduct(Long id){ //delete

        if(!productRepository.existsById(id)){ //verifica se o produto existe
            throw new RuntimeException("Informe um produto existente!");
        }
        else{
            productRepository.deleteById(id);
        }
    }

    public List<ProductEntity> findAllProducts(){//get-todos
        return productRepository.findAll();
    }

    public ProductEntity findByIdProduct(Long id){ //get-por ID
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado.")); //trata excessao caso nao encontre o produto
    }

    public ProductEntity updateProduct(Long id, ProductDTO productDTO){ //put
        if(!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Produto nao encontrado!");
        }
            ProductEntity product = ProductEntity.builder() //constroi um novo produto com o mesmo id
                    .id(id)
                    .name(productDTO.name())
                    .description(productDTO.description())
                    .price(productDTO.price())
                    .stock(productDTO.stock())
                    .category_id(productDTO.category_id())
                    .build();

            return productRepository.save(product);
    }
}
