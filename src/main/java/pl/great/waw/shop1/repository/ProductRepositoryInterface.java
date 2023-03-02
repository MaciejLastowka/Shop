package pl.great.waw.shop1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.great.waw.shop1.domain.Product;

public interface ProductRepositoryInterface {

    public interface ProductRepository extends JpaRepository<Product, Long> {
    }
}
