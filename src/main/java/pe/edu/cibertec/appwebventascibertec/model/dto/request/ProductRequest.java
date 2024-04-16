package pe.edu.cibertec.appwebventascibertec.model.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductRequest {
    private Integer productid;
    private String productname;
    private Double unitprice;
    private boolean discontinued;
    private Integer supplierid;
    private Integer categoryid;
}
