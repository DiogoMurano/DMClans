package br.com.diogomurano.clans.api.event;

import br.com.diogomurano.clans.model.Clan;
import br.com.diogomurano.clans.model.Member;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MemberQuitEvent extends Event implements Cancellable {

    private static HandlerList handlerList = new HandlerList();
    private boolean cancellable;
    private Member member;
    private Clan clan;

    public MemberQuitEvent(Member member, Clan clan) {
        this.member = member;
        this.clan = clan;
        this.cancellable = false;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    @Override
    public boolean isCancelled() {
        return cancellable;
    }

    @Override
    public void setCancelled(boolean cancellable) {
        this.cancellable = cancellable;
    }

    public Member getMember() {
        return member;
    }

    public Clan getClan() {
        return clan;
    }
}
