package pthienquan1.inventoryservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pthienquan1.inventoryservice.dto.InventoryResponse;
import pthienquan1.inventoryservice.repository.InventoryRepository;

import java.util.List;

/**
 * Created by quan0
 * Date 6/7/2023 - 3:36 PM
 * Description: ...
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isStock(List<String> skuCode){
        log.info("Wait Starter");
        Thread.sleep(1000);
        log.info("Wait Ended");
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();
    }
}
