package br.com.diogomurano.clans.api.event;

import br.com.diogomurano.clans.model.Clan;
import br.com.diogomurano.clans.model.Member;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ClanDeleteEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancellable;
    private Clan clan;
    private Member author;

    public ClanDeleteEvent(Clan clan, Member author) {
        this.clan = clan;
        this.cancellable = false;
        this.author = author;
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

    public Member getAuthor() {
        return author;
    }
}
