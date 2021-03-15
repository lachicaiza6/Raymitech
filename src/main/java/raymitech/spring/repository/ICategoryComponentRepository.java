package raymitech.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import raymitech.spring.entities.CategoryComponent;

public interface ICategoryComponentRepository extends JpaRepository<CategoryComponent,Long>  {

}
