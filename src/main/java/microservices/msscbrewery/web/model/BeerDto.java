package microservices.msscbrewery.web.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
@Builder
public class BeerDto {
    @Null
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String style;
    @Positive
    private Long upc;
}
