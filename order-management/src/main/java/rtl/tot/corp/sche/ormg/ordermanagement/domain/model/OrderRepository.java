package rtl.tot.corp.sche.ormg.ordermanagement.domain.model;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.documentdb.repository.DocumentDbRepository;

@Repository
public interface OrderRepository extends DocumentDbRepository<CustomerOrder, Long> {
  
}
