package ort.geekstagram_student.services.currentuser;

import ort.geekstagram_student.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
