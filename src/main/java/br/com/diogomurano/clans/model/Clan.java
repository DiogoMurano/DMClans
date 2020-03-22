package br.com.diogomurano.clans.model;

import com.google.common.collect.ImmutableList;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Clan {

    private int id;

    private UUID uniqueId;
    private String name;
    private String tag;

    private UUID owner;
    private long createdDate;

    private Set<Member> members;

    public Clan(int id, UUID uniqueId, String name, String tag, UUID owner, long createdDate) {
        this.id = id;
        this.uniqueId = uniqueId;
        this.name = name;
        this.tag = tag;
        this.owner = owner;
        this.createdDate = createdDate;
        this.members = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public ImmutableList<Member> getMembers() {
        return ImmutableList.copyOf(members);
    }

    protected void addMember(Member member) {
        Objects.requireNonNull(member, "member can't be null.");
        this.members.add(member);
    }

    protected void removeMember(Member member) {
        Objects.requireNonNull(member, "member can't be null.");
        this.members.remove(member);
    }

    public Member findMemberByName(String name) {
        return members.stream().filter(member -> member.getName().equals(name)).findFirst().orElse(null);
    }

    public Member findMemberByUniqueId(UUID uniqueId) {
        return members.stream().filter(member -> member.getUniqueId().equals(uniqueId)).findFirst().orElse(null);
    }

    public void broadcastMessage(String message) {
        members.forEach(member -> member.sendMessage(message));
    }

}
