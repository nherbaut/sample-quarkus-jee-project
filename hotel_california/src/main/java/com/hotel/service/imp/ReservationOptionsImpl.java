package com.hotel.service.imp;

import com.hotel.model.ReservationOptions;
import com.hotel.service.ReservationOptionsService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class ReservationOptionsImpl implements ReservationOptionsService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<ReservationOptions> getRoomOptions() {
        List<ReservationOptions> roomOptionList =  entityManager.createQuery("Select o from ReservationOptions o", ReservationOptions.class).getResultList();
        return new ArrayList<>(roomOptionList);
    }
}
