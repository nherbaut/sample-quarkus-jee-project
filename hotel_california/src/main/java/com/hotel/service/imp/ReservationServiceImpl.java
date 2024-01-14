package com.hotel.service.imp;

import com.hotel.Exception.NoAvailableReservationException;
import com.hotel.Exception.NoAvailableRoomException;
import com.hotel.dao.ReservationDAOImpl;
import com.hotel.model.Reservation;
import com.hotel.service.ReservationService;
import fr.pantheonsorbonne.ufr27.miage.dto.ReservationRequestDTO;
import jakarta.inject.Inject;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    @Inject
    ReservationDAOImpl reservationDAO;
    @Override
    public Reservation makeReservation(ReservationRequestDTO reservation) throws NoAvailableRoomException {
        return reservationDAO.makeReservation(reservation);

    }

    @Override
    public boolean cancelReservation(String cancellation) throws NoAvailableReservationException {
        return reservationDAO.cancelReservation(cancellation);
    }

    @Override
    public boolean isRoomAvailable(ReservationRequestDTO reservation) throws NoAvailableRoomException {
        return false;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return null;
    }
/*
    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    public int insertWithQuery(Reservation reservation) {

        return entityManager.createNativeQuery("INSERT INTO reservations (id, nbr_guest, user_id, room_id, start_date, end_date) VALUES (?,?, ?, ?, ?, ?)")
                .setParameter(1, reservation.getId())
                .setParameter(2, reservation.getNbrGuest())
                .setParameter(3, reservation.getUserId())
                .setParameter(4, reservation.getRoom())
                .setParameter(5, reservation.getStartDate())
                .setParameter(6, reservation.getEndDate())
                .executeUpdate();
    }
    @Override
    public Reservation saveReservation(Reservation reservation) {




        Reservation reservation1 = entityManager.createQuery("INSERT INTO Reservation r (nbr_guest, user_id, room_id, start_date, end_date) VALUES (?, ?, ?, ?, ?)",Reservation.class)
                .getSingleResult();
        String sql = "";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, reservation.getNbrGuest());
            preparedStatement.setInt(2, reservation.getUserId());
            preparedStatement.setInt(3, reservation.getRoom());
            preparedStatement.setTimestamp(4, reservation.getStartDate());
            preparedStatement.setTimestamp(5, reservation.getEndDate());

            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    reservation.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating reservation failed, no ID obtained.");
                }
            }

            return reservation;

        } catch (SQLException e) {
            throw new RuntimeException("Error saving reservation", e);
        }
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        String sql = "SELECT * FROM reservations WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, reservationId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToReservation(resultSet);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error getting reservation by ID", e);
        }

        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Reservation reservation = mapResultSetToReservation(resultSet);
                reservations.add(reservation);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error getting all reservations", e);
        }

        return reservations;
    }

    private Reservation mapResultSetToReservation(ResultSet resultSet) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setId(resultSet.getInt("id"));
        reservation.setNbrGuest(resultSet.getInt("nbr_guest"));
        reservation.setUserId(resultSet.getInt("user_id"));
        reservation.setRoom(resultSet.getInt("room_id"));
        reservation.setStartDate(resultSet.getTimestamp("start_date"));
        reservation.setEndDate(resultSet.getTimestamp("end_date"));
        return reservation;
    }


 */
}
