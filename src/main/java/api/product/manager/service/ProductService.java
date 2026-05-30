package api.product.manager.service;


import api.product.manager.dto.ProductDTO;
import api.product.manager.entity.ProductEntity;
import api.product.manager.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductEntity registerProduct(ProductDTO productDTO){

        ProductEntity product = ProductEntity.builder().
                name(productDTO.name()).
                description(productDTO.description()).
                price(productDTO.price()).
                stock(productDTO.stock()).
                category_id(productDTO.category_id()).build();

        return productRepository.save(product);
    }

    public void removeProduct(Long id){

        if(!productRepository.existsById(id)){ //verifica se o produto existe
            throw new RuntimeException("Informe um produto existente!");
        }
        else{
            productRepository.deleteById(id);
        }

    }


}
