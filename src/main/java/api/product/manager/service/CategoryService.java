package api.product.manager.service;

import api.product.manager.dto.CategoryDTO;
import api.product.manager.entity.CategoryEntity;
import api.product.manager.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryEntity registerCategory(CategoryDTO categoryDTO){
        CategoryEntity category = CategoryEntity.builder()
                .name(categoryDTO.name()).build();

        return categoryRepository.save(category);
    }

    public List<CategoryEntity> listAllCategories(){
        return categoryRepository.findAll();
    }

    public void removeCategory(Long id){

        if(!categoryRepository.existsById(id)){
            throw new EntityNotFoundException("Informe uma categoria existente");
        }
        categoryRepository.deleteById(id);
    }


}
