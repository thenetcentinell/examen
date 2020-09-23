
package ar.com.flexibility.examen.app.buytransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyTransactionRepository extends JpaRepository<BuyTransaction, Long>
{
}
