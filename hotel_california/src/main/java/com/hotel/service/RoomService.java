package com.hotel.service;


import fr.pantheonsorbonne.ufr27.miage.dto.AvailabilityDTO;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    List<AvailabilityDTO> getRooms();
    boolean isRoomAvailable(Integer roomId, LocalDate from, LocalDate to);


}
