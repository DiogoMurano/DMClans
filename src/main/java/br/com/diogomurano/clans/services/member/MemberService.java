package br.com.diogomurano.clans.services.member;

import br.com.diogomurano.clans.model.Member;
import com.google.common.collect.ImmutableList;

import java.util.UUID;

public interface MemberService {

    ImmutableList<Member> getAll();

    void save(Member member);

    void remove(Member member);

    Member findByName(String name);

    Member findByUniqueId(UUID uniqueId);

}
