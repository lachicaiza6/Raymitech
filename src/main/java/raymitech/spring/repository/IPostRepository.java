package raymitech.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import raymitech.spring.entities.Post;

public interface IPostRepository extends JpaRepository< Post ,Long> {

}
