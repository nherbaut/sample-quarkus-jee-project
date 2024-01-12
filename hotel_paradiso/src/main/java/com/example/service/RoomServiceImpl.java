package com.example.service;

import com.example.model.Room;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.common.hotel.model.RoomEntity;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class RoomServiceImpl implements RoomService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<RoomEntity> getRooms() {
        List<Room> roomList =  entityManager.createQuery("Select r from Room r", Room.class).getResultList();
        return new ArrayList<>(roomList);
    }
}
