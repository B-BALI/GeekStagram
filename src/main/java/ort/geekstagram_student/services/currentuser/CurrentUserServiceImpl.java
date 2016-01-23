package ort.geekstagram_student.services.currentuser;

import org.springframework.stereotype.Service;

import ort.geekstagram_student.domain.CurrentUser;
import ort.geekstagram_student.domain.Role;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {


    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        return currentUser != null
                && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
    }

}
