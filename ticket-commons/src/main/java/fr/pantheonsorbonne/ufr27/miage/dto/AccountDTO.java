package fr.pantheonsorbonne.ufr27.miage.dto;

import java.util.Collection;
import java.util.Date;

public class AccountDTO {

    Integer account_id;
    String customner_name;
    Float max_decouvert;
    Float plafond;
    Float solde;

    public AccountDTO(Integer account_id, String customner_name, Float max_decouvert, Float plafond, Float solde) {
        this.account_id = account_id;
        this.customner_name = customner_name;
        this.max_decouvert = max_decouvert;
        this.plafond = plafond;
        this.solde = solde;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getCustomner_name() {
        return customner_name;
    }

    public void setCustomner_name(String customner_name) {
        this.customner_name = customner_name;
    }

    public Float getMax_decouvert() {
        return max_decouvert;
    }

    public void setMax_decouvert(Float max_decouvert) {
        this.max_decouvert = max_decouvert;
    }

    public Float getPlafond() {
        return plafond;
    }

    public void setPlafond(Float plafond) {
        this.plafond = plafond;
    }

    public Float getSolde() {
        return solde;
    }

    public void setSolde(Float solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "account_id=" + account_id +
                ", customner_name='" + customner_name + '\'' +
                ", max_decouvert=" + max_decouvert +
                ", plafond=" + plafond +
                ", solde=" + solde +
                '}';
    }
}
