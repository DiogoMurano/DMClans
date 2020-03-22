package br.com.diogomurano.clans.services.clan;

import br.com.diogomurano.clans.model.Clan;
import com.google.common.collect.ImmutableList;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class ClanServiceImpl implements ClanService {

    private Set<Clan> clans;

    public ClanServiceImpl() {
        clans = new HashSet<>();
    }

    @Override
    public ImmutableList<Clan> getAll() {
        return ImmutableList.copyOf(clans);
    }

    @Override
    public void save(Clan clan) {
        Objects.requireNonNull(clan, "clan can't be null.");
        this.clans.add(clan);
    }

    @Override
    public void remove(Clan clan) {
        Objects.requireNonNull(clan, "clan can't be null.");
        this.clans.remove(clan);
    }

    @Override
    public Clan findByName(String name) {
        return clans.stream().filter(clan -> clan.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Clan findByTag(String tag) {
        return clans.stream().filter(clan -> clan.getTag().equals(tag)).findFirst().orElse(null);
    }

    @Override
    public Clan findByUniqueId(UUID uniqueId) {
        return clans.stream().filter(clan -> clan.getUniqueId().equals(uniqueId)).findFirst().orElse(null);
    }
}
