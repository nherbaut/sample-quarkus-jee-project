package fr.pantheonsorbonne.ufr27.miage.service;

public interface AccountService {

    Integer getTotalPoints (Integer client_id);

    Integer addPointToAccount (Integer account_id, Integer client_id);

    Integer useBonusPoints (Integer account_id, Integer client_id);
}
