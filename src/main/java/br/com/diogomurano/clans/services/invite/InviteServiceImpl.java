package br.com.diogomurano.clans.services.invite;

import br.com.diogomurano.clans.model.Clan;
import br.com.diogomurano.clans.model.Invite;
import br.com.diogomurano.clans.model.Member;
import com.google.common.collect.ImmutableList;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class InviteServiceImpl implements InviteService {

    private Set<Invite> invites;

    public InviteServiceImpl() {
        invites = new HashSet<>();
    }

    @Override
    public ImmutableList<Invite> getAll() {
        return ImmutableList.copyOf(invites);
    }

    @Override
    public void save(Invite invite) {
        Objects.requireNonNull(invite, "invite can't be null.");
        this.invites.add(invite);
    }

    @Override
    public void remove(Invite invite) {
        Objects.requireNonNull(invite, "invite can't be null.");
        this.invites.remove(invite);
    }

    @Override
    public Invite findByTargetAndClan(Member target, Clan clan) {
        Objects.requireNonNull(target, "target can't be null.");
        Objects.requireNonNull(clan, "clan can't be null.");
        return invites.stream().filter(invite -> invite.getTarget().equals(target) && invite.getClan().equals(clan))
                .findFirst().orElse(null);
    }

    @Override
    public Invite findByTargetAndAuthor(Member target, Member author) {
        Objects.requireNonNull(target, "target can't be null.");
        Objects.requireNonNull(author, "author can't be null.");
        return invites.stream().filter(invite -> invite.getTarget().equals(target) && invite.getAuthor().equals(author))
                .findFirst().orElse(null);
    }

    @Override
    public ImmutableList<Invite> findAllByTarget(Member target) {
        Objects.requireNonNull(target, "target can't be null.");
        return ImmutableList.copyOf(invites.stream().filter(invite -> invite.getTarget().equals(target)).collect(Collectors.toSet()));
    }

    @Override
    public ImmutableList<Invite> findAllByClan(Clan clan) {
        Objects.requireNonNull(clan, "clan can't be null.");
        return ImmutableList.copyOf(invites.stream().filter(invite -> invite.getClan().equals(clan)).collect(Collectors.toSet()));
    }
}
