package api.product.manager.dto;

import api.product.manager.entity.CategoryEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductDTO(

        @NotNull
        @Column(nullable = false, unique = true)
         String name,

        String description,

         @DecimalMin(value = "0.0", inclusive = false)
         BigDecimal price,

         @NotNull
         @Min(0)
         Integer stock,

        @ManyToOne
        @JoinColumn(name = "category_id", nullable = false) //insere o id na tabela de produtos
         CategoryEntity category_id
) {
}
