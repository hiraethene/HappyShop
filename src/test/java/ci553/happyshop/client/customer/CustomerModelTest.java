package ci553.happyshop.client.customer;

import ci553.happyshop.catalogue.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerModelTest {

    @Test
    // Tests the merging feature for organized trolley
    void makeOrganizedTrolleyMerging() {
        CustomerModel cm = new CustomerModel();
        Product product1 = new Product("0001","TV","0001.jpg",269.00,100);
        cm.setTheProduct(product1);
        cm.makeOrganizedTrolley();
        cm.makeOrganizedTrolley();
        cm.makeOrganizedTrolley();
        ArrayList<Product> trolley = cm.getTrolley();
        assertEquals(1,trolley.size());
        assertEquals(3,trolley.get(0).getOrderedQuantity());
    }

    void makeOrganizedTrolleySorting() {
        CustomerModel cm = new CustomerModel();
        Product product1 = new Product("0001","TV","0001.jpg",269.00,100);
        Product product3 = new Product("0003", "Toaster", "0003.jpg", 19.99, 50);
        Product product5 = new Product("0005","Digital Camera","0005.jpg",89.99,100);

        // Sets the products not in order
        cm.setTheProduct(product5);
        cm.makeOrganizedTrolley();

        cm.setTheProduct(product1);
        cm.makeOrganizedTrolley();

        cm.setTheProduct(product3);
        cm.makeOrganizedTrolley();

        ArrayList<Product> trolley = cm.getTrolley();

        // Sorts by productID
        assertEquals("0001",trolley.get(0).getProductId());
        assertEquals("0003",trolley.get(1).getProductId());
        assertEquals("0005",trolley.get(5).getProductId());

    }
}