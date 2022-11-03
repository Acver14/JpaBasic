package hellojpa;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn()
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)        // movie, album, book 세 테이블 모두 찾아봐야해서 비효율적, 고려대상 x
public abstract class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
