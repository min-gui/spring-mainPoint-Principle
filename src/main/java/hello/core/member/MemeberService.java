package hello.core.member;

public interface MemeberService {

    void join(Member member);

    Member findMember(Long memberId);
}
