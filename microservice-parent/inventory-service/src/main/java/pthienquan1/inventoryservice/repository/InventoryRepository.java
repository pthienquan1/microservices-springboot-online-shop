package pthienquan1.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pthienquan1.inventoryservice.model.Inventory;

import java.util.List;
import java.util.Optional;

/**
 * Created by quan0
 * Date 6/7/2023 - 3:29 PM
 * Description: ...
 */
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

//    Optional<Inventory> findBySkuCode(String skuCode);

    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
