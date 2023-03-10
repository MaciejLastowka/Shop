package pl.great.waw.shop1.domain;

public enum CategoryName {
    DOM(1L),
    MOTO(2L),
    ELEKTRO(3L);

    private Long id;

    CategoryName(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
