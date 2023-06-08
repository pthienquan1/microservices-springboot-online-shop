package pthienquan1.inventoryservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pthienquan1.inventoryservice.repository.InventoryRepository;

/**
 * Created by quan0
 * Date 6/7/2023 - 3:36 PM
 * Description: ...
 */
@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isStock(String skuCode){
       return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
