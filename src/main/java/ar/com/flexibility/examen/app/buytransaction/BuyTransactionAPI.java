
package ar.com.flexibility.examen.app.buytransaction;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api/v1/buytransaction")
@Slf4j
@RequiredArgsConstructor
public class BuyTransactionAPI
{
	private static Logger log=LoggerFactory.getLogger(BuyTransactionAPI.class);

	@Autowired
	private BuyTransactionService buyTransactionService;

    // obtiene transacciones de compra 
    @GetMapping
    public ResponseEntity<List<BuyTransaction>> findAll() {
        
    	log.info("Buscando transacciones de compra");
    	
        return ResponseEntity.ok(buyTransactionService.findAll());
    }

    // obtiene transacciones de compra con un determinado id
    @GetMapping("/{id}")
    public ResponseEntity<BuyTransaction> findById(@PathVariable Long id) {
        
    	log.info("Buscando transaccion de compra con id: " + id);
        
        Optional<BuyTransaction> stock = buyTransactionService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " NO existe!");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }
    
    // Ingresar transaccion de compra
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody BuyTransaction buyTransaction) {
    	
        log.info("Insertando nueva transaccion de compra: " + buyTransaction.toString());

    	/*BuyTransaction b=new BuyTransaction();
    	b.setId(1L);
    	b.setIdClient(2L);
    	b.setIdProduct(4L);
    	b.setApproved(false);
    	
    	buyTransactionService.save(b);*/    	
    	
    	return ResponseEntity.ok(buyTransactionService.save(buyTransaction));
    }
    
    // Modificacion de transaccion de compra
    // Util para aprobar o desaprobar compra de un producto por un cliente
    @PutMapping("/{id}")
    public ResponseEntity<BuyTransaction> update(@PathVariable Long id, @Valid @RequestBody BuyTransaction buyTransaction) {
        
        log.info("Modificando transaccion de compra con id: " +id);
        log.info(buyTransaction.toString());

        if (!buyTransactionService.findById(id).isPresent()) {
            log.error("Id " + id + " NO existe!");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(buyTransactionService.save(buyTransaction));
    }

}
