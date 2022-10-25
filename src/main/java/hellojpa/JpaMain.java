package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//              Member member= new Member();
//              member.setId(2L);
//              member.setName("HelloB");
//              em.persist(member);

//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("helloJPA");
////              em.remove(findMember);
//
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                            .setFirstResult(5)
//                            .setMaxResults(8)
//                            .getResultList();
//            for (Member member: result){
//                System.out.println("member.name = " + member.getName());
//
//            }
//

            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            // 영속
//            em.persist(member);

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");

//            em.persist(member1);
//            em.persist(member2);

//            Member findMember = em.find(Member.class, 150L);
//            findMember.setName("ZZZZZ");

//            Member member = new Member(200L, "member200");
//            em.persist(member);

//            em.flush();   // 쓰기 지연 SQL에 있는 쿼리만 반영 - 1차 캐시가 비워지지 않음

//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");
//
//            em.detach(member);  // 해당 엔티티를 영속성 컨텍스트에서 관리하지 않도록 설정 -> 준영속 상태
//            em.clear();         // 영속성 컨텍스트를 비움

//            Member member = new Member();
////            member.setId(1L);
//            member.setUsername("AC");
//            member.setRoleType(RoleType.USER);

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");

            // 연관관계 편의 메소드 택 1
//            member.changeTeam(team);    // 연관관계 편의 메소드 vs setTeam(Team)
            team.addMembers(member);
            em.persist(member);

            // 객체지향적으로도, 안정성 측면에서도 양측 다 추가해주는 것이 좋다.
            // 실수를 막기 위해 Member Class에 연관관게 편의 메소드를 생성하자.
//            team.getMembers().add(member);
//            em.flush();
//            em.clear();

            Member findMember = em.find(Member.class, member.getId());

            Team findTeam = findMember.getTeam();
            List<Member> members = findMember.getTeam().getMembers();
            for (Member m : members){
                System.out.println("m = " + m.getUsername());
            }

            System.out.println("findTeam = " + findTeam.getName());

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.clear();
        }
        emf.close();

    }
}
