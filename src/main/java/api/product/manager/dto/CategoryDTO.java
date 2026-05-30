package api.product.manager.dto;

import api.product.manager.entity.ProductEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record CategoryDTO(
        @NotNull
        String name)
{
}
