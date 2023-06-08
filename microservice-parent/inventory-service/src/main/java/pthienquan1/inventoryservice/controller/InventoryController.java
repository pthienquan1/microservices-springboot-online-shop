package pthienquan1.inventoryservice.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pthienquan1.inventoryservice.service.InventoryService;

/**
 * Created by quan0
 * Date 6/7/2023 - 3:30 PM
 * Description: ...
 */
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isStock(@PathVariable("sku-code") String skuCode){
        return inventoryService.isStock(skuCode);

    }
}
