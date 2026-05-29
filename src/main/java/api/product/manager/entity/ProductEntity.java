package api.product.manager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "produtos")
public class ProductEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true) //unique faz com que o nome nao possa ser repetido
    private String name;

    @NotNull
    private String description;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false, //faz com o valor seja maior que seja obrigatoriamente
            message = "Preço deve ser maior do que zero.")
    private BigDecimal price;

    @Min(value = 0)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category_id;




}
