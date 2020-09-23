
package ar.com.flexibility.examen.app.client;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/v1/clients")
@Slf4j
@RequiredArgsConstructor
public class ClientAPI
{
	private static Logger log=LoggerFactory.getLogger(ClientAPI.class);

	@Autowired
	private ClientService clientService;

	// obtiene clientes
    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        
    	log.info("Buscando clientes");
    	
        return ResponseEntity.ok(clientService.findAll());
    }

    // obtiene cliente con un id
    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        
    	log.info("Buscando cliente con id: " + id);
        
        Optional<Client> stock = clientService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " NO existe!");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    // ingreso nuevo cliente
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Client client) {
    	
        log.info("Insertando nuevo cliente: " + client.toString());

    	Client c=new Client();
    	c.setId(1L);
    	c.setName("Ale");
    	c.setSurname("Isoba");
    	c.setCuit("20290191964");
    	c.setCreatedAt(new Date());
    	c.setUpdatedAt(new Date());
    	
    	clientService.save(c);
    	
    	
    	return ResponseEntity.ok(clientService.save(client));
    }

    // borra un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
    	
        log.info("Borrando cliente con id: " + id);

        if (!clientService.findById(id).isPresent()) {
            log.error("Id " + id + " NO existe!");
            ResponseEntity.badRequest().build();
        }

        clientService.deleteById(id);

        return ResponseEntity.ok().build();
    }

    // modifica un cliente
    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @Valid @RequestBody Client client) {
        
        log.info("Modificando cliente con id: " +id);
        log.info(client.toString());

        if (!clientService.findById(id).isPresent()) {
            log.error("Id " + id + " NO existe!");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(clientService.save(client));
    }
}

