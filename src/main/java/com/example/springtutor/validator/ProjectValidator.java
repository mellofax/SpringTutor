package com.example.springtutor.validator;


import com.example.springtutor.bean.Project;
import com.example.springtutor.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProjectValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Project DoctorDocument =(Project)o;
        if(DoctorDocument.getId()<0){
            errors.rejectValue("id","negative value");
        }
    }
}
