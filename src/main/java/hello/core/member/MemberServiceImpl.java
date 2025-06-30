package hello.core.member;

// 회원 서비스 - 회원 서비스 구현체
public class MemberServiceImpl implements MemberService{

    // 구현 객체 선택
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
