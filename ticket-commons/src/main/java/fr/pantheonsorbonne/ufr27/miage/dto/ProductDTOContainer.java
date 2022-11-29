package fr.pantheonsorbonne.ufr27.miage.dto;

import java.util.Collection;

public class ProductDTOContainer {
    Collection<ProductDTO> container;

    public ProductDTOContainer(Collection<ProductDTO> container) {
        this.container = container;
    }

    public ProductDTOContainer() {
    }

    public Collection<ProductDTO> getContainer() {
        return container;
    }

    public void setContainer(Collection<ProductDTO> container) {
        this.container = container;
    }
}
