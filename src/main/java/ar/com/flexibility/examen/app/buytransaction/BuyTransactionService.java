
package ar.com.flexibility.examen.app.buytransaction;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class BuyTransactionService 
{
	@Autowired
    private BuyTransactionRepository buyTransactionRepository;

    public List<BuyTransaction> findAll() {
        return buyTransactionRepository.findAll();
    }

    public Optional<BuyTransaction> findById(Long id) {
        return buyTransactionRepository.findById(id);
    }

    public BuyTransaction save(BuyTransaction stock) {
        return buyTransactionRepository.save(stock);
    }

    public void deleteById(Long id) {
    	buyTransactionRepository.deleteById(id);
    }
}
