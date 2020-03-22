package br.com.diogomurano.clans.api;

import br.com.diogomurano.clans.DMClans;
import br.com.diogomurano.clans.api.exceptions.ClanAlreadyExistsException;
import br.com.diogomurano.clans.api.exceptions.ClanNotExistsException;
import br.com.diogomurano.clans.api.exceptions.InvalidMemberException;
import br.com.diogomurano.clans.model.Clan;
import br.com.diogomurano.clans.model.Invite;
import br.com.diogomurano.clans.model.Member;
import br.com.diogomurano.clans.services.clan.ClanService;
import br.com.diogomurano.clans.services.invite.InviteService;
import br.com.diogomurano.clans.services.member.MemberService;

import java.util.UUID;

public class ClansAPI {

    private static ClanService clanService;
    private static MemberService memberService;
    private static InviteService inviteService;

    static {
        final DMClans plugin = DMClans.getInstance();

        clanService = plugin.getClanService();
        memberService = plugin.getMemberService();
        inviteService = plugin.getInviteService();
    }

    public static Clan getClanByName(String name) {
        return clanService.findByName(name);
    }

    public static Clan getClanByTag(String tag) {
        return clanService.findByTag(tag);
    }

    public static Clan getClanByUniqueId(UUID uniqueId) {
        return clanService.findByUniqueId(uniqueId);
    }

    public static Member getMemberByName(String name) {
        return memberService.findByName(name);
    }

    public static Member getMemberByUniqueId(UUID uniqueId) {
        return memberService.findByUniqueId(uniqueId);
    }

    public static Invite getInviteByTargetAndClan(Member target, Clan clan) {
        return inviteService.findByTargetAndClan(target, clan);
    }

    public static Invite getInviteByTargetAndAuthor(Member target, Member author) {
        return inviteService.findByTargetAndAuthor(target, author);
    }

    public void createClan() throws ClanAlreadyExistsException {

    }

    public void deleteClan(Clan clan) throws ClanNotExistsException {

    }

    public void promoteMember(Member member) throws InvalidMemberException {

    }

    public void demoteMember(Member member) throws InvalidMemberException {

    }

    public void kickPlayer(Member member) throws InvalidMemberException {
    }
}
