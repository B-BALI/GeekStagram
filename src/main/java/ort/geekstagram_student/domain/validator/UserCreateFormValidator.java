package ort.geekstagram_student.domain.validator;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ort.geekstagram_student.domain.UserCreateForm;
import ort.geekstagram_student.services.user.UserService;

/**
 * Gestion de la validation du formulaire d'inscription
 */
@Component
public class UserCreateFormValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserCreateFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    /**
     * Validation général du formulaire d'inscription
     */
    @Override
    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors, form);
        validateEmail(errors, form);
        validateEmail(errors, form);
        validatePseudo(errors, form);
    }

    /**
     * Validation du password
     */
    private void validatePasswords(Errors errors, UserCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    /**
     * Validation du mail
     */
    private void validateEmail(Errors errors, UserCreateForm form) {
        if (userService.getUserByEmail(form.getEmail()).isPresent()) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }
    
    /**
     * Validation du pseudo
     */
    private void validatePseudo(Errors errors, UserCreateForm form) {
        if (userService.getUserByPseudo(form.getPseudo()).isPresent()) {
            errors.reject("pseudo.exists", "User with this pseudo already exists");
        }
    }
}
