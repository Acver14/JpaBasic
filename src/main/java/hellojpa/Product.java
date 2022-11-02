package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id @GeneratedValue
    private Long id;
    private String name;

//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT")
//    @JoinColumn(name = "MEMBER_ID")
//    private List<Member> members = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<MemberProduct> memberProducts = new ArrayList<>();
}
