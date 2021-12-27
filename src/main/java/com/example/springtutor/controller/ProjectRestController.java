package com.example.springtutor.controller;

import com.example.springtutor.bean.Project;
import com.example.springtutor.controller.dto.NameRequest;
import com.example.springtutor.controller.dto.ProjectNoIdRequest;
import com.example.springtutor.controller.dto.ProjectRequest;
import com.example.springtutor.exception.ControllerException;
import com.example.springtutor.exception.ServiceException;
import com.example.springtutor.service.ProjectService;
import com.example.springtutor.validator.ProjectValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectRestController
{

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectValidator projectValidator;

    private static final Logger logger = Logger.getLogger(MainController.class);

    @PostMapping("/admin/isProjectExist")
    public ResponseEntity<?> isProjectExist(@RequestBody NameRequest nameRequest) throws ControllerException {
        try {
            if (!projectService.existsByName(nameRequest.getName())) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.FOUND);
        } catch (ServiceException e) {
            logger.error("isProjectExist");
            throw new ControllerException(e);
        }
    }

    @DeleteMapping("/admin/deleteProjectByName")
    public ResponseEntity<?> deleteProjectByName(@RequestBody NameRequest nameRequest) throws ControllerException {
        try
        {
            Project retProejct =  projectService.getByName(nameRequest.getName());
            projectService.deleteByName(nameRequest.getName());
            return new ResponseEntity<>(retProejct, HttpStatus.OK);
        }
        catch (ServiceException e)
        {
            logger.error("deleteProjectByName");
            throw new ControllerException(e);
        }
    }

    @PostMapping("/admin/createProject")
    public ResponseEntity<?> createProject(@RequestBody @Validated ProjectNoIdRequest projectNoIdRequest, BindingResult bindingResult) throws ControllerException {
        try
        {
            if (!bindingResult.hasErrors())
            {
                Project project = new Project(
                        projectNoIdRequest.getName(),
                        projectNoIdRequest.getDescription()
                );
                projectValidator.validate(project, bindingResult);
                if (!bindingResult.hasErrors())
                {
                    projectService.create(project);
                    logger.debug("created project");
                    return new ResponseEntity<>(project, HttpStatus.OK);
                }
                else
                {
                    logger.error("project wasn't validated");
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

                }

            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (ServiceException e) {
            logger.error("isProjectExist");
            throw new ControllerException(e);
        }
    }

    @PutMapping("/admin/updateProduct")
    public ResponseEntity<?> updateProduct(@RequestBody ProjectRequest projectRequest) throws ControllerException
    {
        try
        {
            projectService.setProjectById(
                    projectRequest.getId(),
                    projectRequest.getName(),
                    projectRequest.getDescription()
            );
            Project retProejct =  projectService.getByName(projectRequest.getName());
            return new ResponseEntity<>(retProejct, HttpStatus.OK);
        }
        catch (ServiceException e)
        {
            logger.error("updateProduct");

            throw new ControllerException(e);
        }
    }

    @GetMapping("/admin/getProductByName/{data}")
    public ResponseEntity<?> getProductByName(@PathVariable(name = "data") String data) throws ControllerException {

        try {
            return new ResponseEntity<>(projectService.getByName(data), HttpStatus.OK);
        } catch (ServiceException e) {
            logger.error("getProductByName");

            throw new ControllerException(e);
        }
    }

    @GetMapping("/admin/getAllProjectsAdmin")
    public ResponseEntity<?> getAllProjectsAdmin() throws ControllerException {

        try {
            return new ResponseEntity<>(projectService.findAll(), HttpStatus.OK);
        } catch (ServiceException e) {
            logger.error("getAllProjectsAdmin");

            throw new ControllerException(e);
        }
    }

    @GetMapping("/user/getAllProjectsUser")
    public ResponseEntity<?> getAllProjectsUser() throws ControllerException {

        try {
            return new ResponseEntity<>(projectService.findAll(), HttpStatus.OK);
        } catch (ServiceException e) {
            logger.error("getAllProjectsUser");

            throw new ControllerException(e);
        }
    }
}
