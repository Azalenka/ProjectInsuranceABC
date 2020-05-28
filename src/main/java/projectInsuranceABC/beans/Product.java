package projectInsuranceABC.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Product {


    private String product;

    private int price;


//   public Product(String product, int price) {
//
//
//      this.product =product; this.price =price;
//            }
}
