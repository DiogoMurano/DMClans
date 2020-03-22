package br.com.diogomurano.clans.services.clan;

import br.com.diogomurano.clans.model.Clan;
import com.google.common.collect.ImmutableList;

import java.util.UUID;

public interface ClanService {

    ImmutableList<Clan> getAll();

    void save(Clan clan);

    void remove(Clan clan);

    Clan findByName(String name);

    Clan findByTag(String tag);

    Clan findByUniqueId(UUID uniqueId);

}
