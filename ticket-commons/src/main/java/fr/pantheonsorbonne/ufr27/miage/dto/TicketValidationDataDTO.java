package fr.pantheonsorbonne.ufr27.miage.dto;

public record TicketValidationDataDTO(int idTicket, int idVenue, int idVendor, long salt, String key) {
}
