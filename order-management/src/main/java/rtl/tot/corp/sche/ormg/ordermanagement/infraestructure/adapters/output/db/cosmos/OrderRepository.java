package rtl.tot.corp.sche.ormg.ordermanagement.infraestructure.adapters.output.db.cosmos;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;

import rtl.tot.corp.sche.ormg.ordermanagement.domain.model.CustomerOrder;

@Repository
public interface OrderRepository extends DocumentDbRepository<CustomerOrder, Long> {
 
}
