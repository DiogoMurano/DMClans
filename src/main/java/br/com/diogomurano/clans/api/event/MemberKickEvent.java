package br.com.diogomurano.clans.api.event;

import br.com.diogomurano.clans.model.Clan;
import br.com.diogomurano.clans.model.Member;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MemberKickEvent extends Event implements Cancellable {

    private static HandlerList handlerList = new HandlerList();
    private boolean cancellable;
    private Member member;
    private Member author;
    private Clan clan;

    public MemberKickEvent(Member member, Member author, Clan clan) {
        this.member = member;
        this.author = author;
        this.clan = clan;
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

    public Member getAuthor() {
        return author;
    }

    public Clan getClan() {
        return clan;
    }
}
