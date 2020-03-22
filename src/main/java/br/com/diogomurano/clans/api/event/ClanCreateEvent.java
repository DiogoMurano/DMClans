package br.com.diogomurano.clans.api.event;

import br.com.diogomurano.clans.model.Clan;
import br.com.diogomurano.clans.model.Member;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ClanCreateEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancellable;
    private Clan clan;
    private Member owner;

    public ClanCreateEvent(Clan clan, Member owner) {
        this.clan = clan;
        this.cancellable = false;
        this.owner = owner;
    }


    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancellable;
    }

    @Override
    public void setCancelled(boolean cancellable) {
        this.cancellable = cancellable;
    }

    public Clan getClan() {
        return clan;
    }

    public Member getOwner() {
        return owner;
    }
}
