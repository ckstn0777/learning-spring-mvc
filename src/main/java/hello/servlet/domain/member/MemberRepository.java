package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private Map<Long, Member> store = new HashMap<>();
    private Long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository(); // 싱글톤
    private MemberRepository() {} // 생성자 생성 방지

    public static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member) {
        sequence += 1;
        member.setId(sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        // store 자체를 보호하기 위해 ArrayList로 감싸줌
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
