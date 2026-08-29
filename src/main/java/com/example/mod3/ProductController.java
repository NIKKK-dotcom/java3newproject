package com.example.mod3;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Products",description = "Работа с продуктами")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service){
        this.service = service;
    }
    @Operation(summary = "Создать продукт",description = "Создаёт новый продукт")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Продукт успешно создан"),
            @ApiResponse(responseCode = "400",description = "Ошибка при создании продукта")
    })
    @PostMapping
    public Product create(@RequestBody Product product){
        return service.create(product);
    }
    @Operation(summary = "Получить все продукты",description = "Возвращает список всех продуктов")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Список продуктов успешно получен")
    })
    @GetMapping
    public List<Product> getAll(){
        return service.getAll();
    }
    @Operation(summary = "Обновить продукт",description = "Изменяет данные продукта")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Продукт успешно обновлён"),
            @ApiResponse(responseCode = "404",description = "Продукт не найден")
    })
    @PutMapping("/{id}")
    @Parameter(description = "ID продукта",example = "1",required = true)
    public Product update(@PathVariable Long id, @RequestBody Product product){
        return service.update(id, product);
    }
    @Operation(summary = "Удалить продукт",description = "Удаляет продукт по ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Продукт успешно удалён"),
            @ApiResponse(responseCode = "404",description = "Продукт не найден")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
