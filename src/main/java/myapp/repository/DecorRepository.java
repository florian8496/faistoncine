package myapp.repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import myapp.model.Decor;

@Repository
public interface DecorRepository extends PagingAndSortingRepository<Decor, Long>{

}
