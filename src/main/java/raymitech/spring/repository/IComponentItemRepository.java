package raymitech.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import raymitech.spring.entities.ComponentItem;

public interface IComponentItemRepository extends JpaRepository< ComponentItem, Long>{

}
