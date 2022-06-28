package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {


    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**회원 가입**/
    public Long join(Member member){
        //중복회원 x
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.")
        });


        memberRepository.save(member);
        return member.getId();
    }

}
