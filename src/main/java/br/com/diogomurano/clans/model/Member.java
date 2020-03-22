package br.com.diogomurano.clans.model;

import br.com.diogomurano.clans.enums.MemberRole;
import com.google.common.collect.ImmutableList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Member {

    private int id;

    private UUID uniqueId;
    private String name;

    private UUID clan;
    private MemberRole role;
    private long joinedDate;

    private Set<Invite> invites;

    public Member(int id, UUID uniqueId, String name, UUID clan, MemberRole role, long joinedDate) {
        this.id = id;
        this.uniqueId = uniqueId;
        this.name = name;
        this.clan = clan;
        this.role = role;
        this.joinedDate = joinedDate;

        this.invites = new HashSet<>();
    }

    public Member(int id, UUID uniqueId, String name) {
        this.id = id;
        this.uniqueId = uniqueId;
        this.name = name;
        this.clan = null;
        this.role = MemberRole.NONE;
        this.joinedDate = 0;

        this.invites = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public UUID getClan() {
        return clan;
    }

    protected void setClan(UUID clan) {
        this.clan = clan;
    }

    public MemberRole getRole() {
        return role;
    }

    protected void setRole(MemberRole role) {
        this.role = role;
    }

    public long getJoinedDate() {
        return joinedDate;
    }

    protected void setJoinedDate(long joinedDate) {
        this.joinedDate = joinedDate;
    }

    public ImmutableList<Invite> getInvites() {
        return ImmutableList.copyOf(invites);
    }

    public boolean isOnline() {
        return Bukkit.getPlayer(uniqueId) != null && Bukkit.getPlayer(uniqueId).isOnline();
    }

    public void sendMessage(String message) {
        if (isOnline()) {
            Bukkit.getPlayer(uniqueId).sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }

    protected void addInvite(Invite invite) {
        Objects.requireNonNull(invite, "invite can't be null.");
        this.invites.add(invite);
    }

    protected Invite findInviteByClan(Clan clan) {
        return invites.stream().filter(invite -> invite.getClan().equals(clan)).findFirst().orElse(null);
    }
}
