package ort.geekstagram_student.services.user;



import java.util.Collection;
import java.util.Optional;

import ort.geekstagram_student.domain.User;
import ort.geekstagram_student.domain.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByPseudo(String pseudo);

    Collection<User> getAllUsers();
    Collection<User> getUsersLikePseudo(String pseudo);

    User create(UserCreateForm form);

}
