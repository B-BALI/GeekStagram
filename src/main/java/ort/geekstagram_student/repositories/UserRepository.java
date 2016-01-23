package ort.geekstagram_student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ort.geekstagram_student.domain.User;

import java.util.ArrayList;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
    Optional<User> findOneByPseudo(String pseudo);
    
    @Query("Select u from User u where u.pseudo like :pseudo%")
    ArrayList<User> findByPseudoContaining(@Param("pseudo")String pseudo);
}
