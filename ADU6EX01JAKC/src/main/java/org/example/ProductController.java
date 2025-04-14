package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.Optional;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/productes")//Ruta base para el controlador
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

//    Crea productos usando el endpoint post
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Product product) {
        Map<String, Object> response = new HashMap<>();
        try {//control de errores que muestra si ha habido algun error o si todo ha funcionado correctamente
            Product savedProduct = service.save(product);
            response.put("message", "Producto creado exitosamente");//Muestra mensaje de que todo funciona correctamente
            response.put("product", savedProduct);
            return ResponseEntity.ok(response);
        } catch (Exception e) {//Muestra mensaje de error
            response.put("error", "Error al crear el producto: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    //Endpoint que se usa para obtener todos los productos
    @GetMapping
    public ResponseEntity<?> getAll() {
        Map<String, Object> response = new HashMap<>();
        List<Product> products = service.findAll();
        //control de errores que muestra si ha habido algun error o si todo ha funcionado correctamente
        if (products.isEmpty()) {//Muestra mensaje de error
            response.put("message", "No hay productos disponibles");
            return ResponseEntity.noContent().build();
        }
        response.put("message", "Lista de productos obtenida exitosamente");//Muestra mensaje de que todo funciona correctamente
        response.put("products", products);
        return ResponseEntity.ok(response);
    }

    //Endpoint que se usa para obtener los productos
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Product> product = service.findById(id);
        if (product.isPresent()) {//Muestra mensaje de que todo funciona correctamente
            response.put("message", "Producto encontrado");
            response.put("product", product.get());
            return ResponseEntity.ok(response);
        }
        //Muestra mensaje de error
        response.put("error", "Producto no encontrado con ID: " + id);
        return ResponseEntity.status(404).body(response);
    }

    //Endpoint que sirve para actualizar un producto concreto
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Product product) {
        Map<String, Object> response = new HashMap<>();
        if (!service.findById(id).isPresent()) {
            response.put("error", "Producto no encontrado con ID: " + id);//Muestra mensaje de error al no encontrar el producto
            return ResponseEntity.status(404).body(response);
        }
        try {
            product.setId(id);
            Product updatedProduct = service.save(product);
            response.put("message", "Producto actualizado exitosamente");//Muestra mensaje de que todo funciona correctamente
            response.put("product", updatedProduct);
            return ResponseEntity.ok(response);
        } catch (Exception e) {//Muestra mensaje de error al actualizar el producto
            response.put("error", "Error al actualizar el producto: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    //Endpoint que se usa para eliminar un producto por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        if (!service.findById(id).isPresent()) {
            response.put("error", "Producto no encontrado con ID: " + id);//Muestra mensaje de error al no encontrar el producto
            return ResponseEntity.status(404).body(response);
        }
        try {
            service.deleteById(id);
            response.put("message", "Producto eliminado correctamente");//Muestra mensaje de que todo funciona correctamente
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Error al eliminar el producto: " + e.getMessage());//Muestra mensaje de error al eliminar un producto
            return ResponseEntity.badRequest().body(response);
        }
    }
}
