package br.com.diogomurano.clans.model;

import br.com.diogomurano.clans.enums.InviteResponse;

public class Invite {

    private int id;

    private Clan clan;
    private Member target;
    private Member author;

    private long date;
    private InviteResponse inviteResponse;

    public Invite(int id, Clan clan, Member target, Member author, long date, InviteResponse inviteResponse) {
        this.id = id;
        this.clan = clan;
        this.target = target;
        this.author = author;
        this.date = date;
        this.inviteResponse = inviteResponse;
    }

    public Invite(int id, Clan clan, Member target, Member author, long date) {
        this.id = id;
        this.clan = clan;
        this.target = target;
        this.author = author;
        this.date = date;
        this.inviteResponse = InviteResponse.WAITING;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Member getTarget() {
        return target;
    }

    public void setTarget(Member target) {
        this.target = target;
    }

    public Member getAuthor() {
        return author;
    }

    public void setAuthor(Member author) {
        this.author = author;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public InviteResponse getInviteResponse() {
        return inviteResponse;
    }

    public void setInviteResponse(InviteResponse inviteResponse) {
        this.inviteResponse = inviteResponse;
    }
}
