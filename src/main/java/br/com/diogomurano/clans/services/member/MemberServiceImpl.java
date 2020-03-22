package br.com.diogomurano.clans.services.member;

import br.com.diogomurano.clans.model.Member;
import com.google.common.collect.ImmutableList;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class MemberServiceImpl implements MemberService {

    private Set<Member> members;

    public MemberServiceImpl() {
        members = new HashSet<>();
    }

    @Override
    public ImmutableList<Member> getAll() {
        return ImmutableList.copyOf(members);
    }

    @Override
    public void save(Member member) {
        Objects.requireNonNull(member, "member can't be null.");
        this.members.add(member);
    }

    @Override
    public void remove(Member member) {
        Objects.requireNonNull(member, "member can't be null.");
        this.members.remove(member);
    }

    @Override
    public Member findByName(String name) {
        return members.stream().filter(member -> member.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Member findByUniqueId(UUID uniqueId) {
        return members.stream().filter(member -> member.getUniqueId().equals(uniqueId)).findFirst().orElse(null);
    }
}
