package br.com.diogomurano.clans.services.invite;

import br.com.diogomurano.clans.model.Clan;
import br.com.diogomurano.clans.model.Invite;
import br.com.diogomurano.clans.model.Member;
import com.google.common.collect.ImmutableList;

public interface InviteService {

    ImmutableList<Invite> getAll();

    void save(Invite invite);

    void remove(Invite invite);

    Invite findByTargetAndClan(Member target, Clan clan);

    Invite findByTargetAndAuthor(Member target, Member author);

    ImmutableList<Invite> findAllByTarget(Member target);

    ImmutableList<Invite> findAllByClan(Clan clan);

}
