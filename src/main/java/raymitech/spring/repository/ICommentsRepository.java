package raymitech.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import raymitech.spring.entities.Comments;

public interface ICommentsRepository extends JpaRepository< Comments, Long>{

}
