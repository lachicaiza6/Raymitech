package raymitech.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import raymitech.spring.entities.Category;

public interface ICategoryRepository extends JpaRepository< Category, Long>{

}
