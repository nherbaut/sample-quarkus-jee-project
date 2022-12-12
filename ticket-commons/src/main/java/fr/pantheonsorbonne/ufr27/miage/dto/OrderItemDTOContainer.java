package fr.pantheonsorbonne.ufr27.miage.dto;

import java.util.Collection;

public class OrderItemDTOContainer {
    Collection<OrderItemDTO> container;

    public OrderItemDTOContainer(Collection<OrderItemDTO> container) {
        this.container = container;
    }

    public OrderItemDTOContainer() {
    }

    public Collection<OrderItemDTO> getContainer() {
        return container;
    }

    public void setContainer(Collection<OrderItemDTO> container) {
        this.container = container;
    }
}
