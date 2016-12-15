package src.Topic1.Shopping;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

    private List<Product> list;

    public ProductList(List<Product> list) {
        this.list = new ArrayList<>();
    }

    public void addProduct(Product product) {
        list.add(product);
    }

    public Product getProduct(int i) {
        return list.get(i);
    }

//    public void getCheapest() {
//        double cheapest = getProduct(0).getPrice();
//        for (Product product : list) {
//            if (product.getPrice())
//        }
//    }
}
