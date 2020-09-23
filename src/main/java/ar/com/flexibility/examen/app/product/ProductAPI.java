
package ar.com.flexibility.examen.app.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@RequiredArgsConstructor
public class ProductAPI
{
	private static Logger log=LoggerFactory.getLogger(ProductAPI.class);

	@Autowired
	private ProductService productService;

	// obtiene productos
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        
    	log.info("Buscando productos");
    	
        return ResponseEntity.ok(productService.findAll());
    }

    // obtiene producto con un id
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        
    	log.info("Buscando producto con id: " + id);
        
        Optional<Product> stock = productService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " NO existe!");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    // ingresa producto
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Product product) {
    	
        log.info("Insertando nuevo producto: " + product.toString());

    	/*Product p=new Product();
    	p.setId(1L);
    	p.setCreatedAt(new Date());
    	p.setDescription("product1");
    	p.setName("product1");
    	p.setPrice(new BigDecimal(1));
    	p.setUpdatedAt(new Date());
    	
    	productService.save(p);
    	*/
    	
    	return ResponseEntity.ok(productService.save(product));
    }

    // borra producto
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
    	
        log.info("Borrando producto con id: " + id);

        if (!productService.findById(id).isPresent()) {
            log.error("Id " + id + " NO existe!");
            ResponseEntity.badRequest().build();
        }

        productService.deleteById(id);

        return ResponseEntity.ok().build();
    }

    // modifica producto
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product product) {
        
        log.info("Modificando producto con id: " +id);
        log.info(product.toString());

        if (!productService.findById(id).isPresent()) {
            log.error("Id " + id + " NO existe!");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(productService.save(product));
    }
}
