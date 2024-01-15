package com.hotel.dao;

import com.hotel.model.User;
import fr.pantheonsorbonne.ufr27.miage.dto.UserDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Objects;
@ApplicationScoped
public class UserDAOImpl implements UserDAO{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean doesUserExist(UserDTO userDTO) {
       try{
           User user =  entityManager.createQuery("SELECT u from User u where email = :userEmail ", User.class).setParameter("userEmail", userDTO.getEmailAddress()).getSingleResult();
           if(Objects.isNull(user)){
               return false;
           }
           return true;
       }catch (Exception e){
           return  false;
       }
    }

    @Transactional
    @Override
    public User createUser(UserDTO userDTO) {
        User user = new User(userDTO.getName(), userDTO.getLastName(), userDTO.getPhoneNumber(), userDTO.getEmailAddress());
        return entityManager.merge(user);
    }
}
