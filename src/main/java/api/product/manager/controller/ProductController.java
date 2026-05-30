package api.product.manager.controller;

import api.product.manager.dto.ProductDTO;
import api.product.manager.entity.ProductEntity;
import api.product.manager.service.ProductService;
import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductEntity> postProduct(@Valid @RequestBody ProductDTO productDTO){

        ProductEntity product = productService.registerProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getByIdProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.findByIdProduct(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProduct(){
        List <ProductEntity> productList = productService.findAllProducts(); //passa as informacoes do banco de dados para a lista
        return ResponseEntity.ok(productList); //faz retornar a lista vazia ao inves de um erro, caso necessario
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.removeProduct(id); //remove
        return ResponseEntity.noContent().build(); //constroi a resposta no POSTMAN retornando noContent
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> putProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO){

        ProductEntity product = productService.updateProduct(id,productDTO);
        return ResponseEntity.ok(product);
    }

}
