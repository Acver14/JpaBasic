package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "team")   // 읽기 전용 -> 이 값을 변경해도 디비에는 반영 X
    @OneToMany
//    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)    // 일대다 양반향 - 읽기 전용
    @JoinColumn(name = "TEAM_ID")
    private List<Member> members = new ArrayList<>();
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

    public List<Member> getMembers() {
        return members;
    }

//    // 연관관계 편의 메소드
//    public void addMembers(Member member){
//        member.setTeam(this);
//        members.add(member);
//    }
    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
