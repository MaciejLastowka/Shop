package pl.great.waw.shop1.domain;

public enum CategoryName {
    MOTORYZACJA(1L),
    ELEKTRO(2L),
    DOM(3L);

    private Long id;

    CategoryName(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
