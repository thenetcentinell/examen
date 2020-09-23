
package ar.com.flexibility.examen.app.client;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class ClientService 
{
	@Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    public Client save(Client stock) {
        return clientRepository.save(stock);
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
