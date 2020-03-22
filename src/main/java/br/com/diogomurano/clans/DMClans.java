package br.com.diogomurano.clans;

import br.com.diogomurano.clans.services.clan.ClanService;
import br.com.diogomurano.clans.services.clan.ClanServiceImpl;
import br.com.diogomurano.clans.services.invite.InviteService;
import br.com.diogomurano.clans.services.invite.InviteServiceImpl;
import br.com.diogomurano.clans.services.member.MemberService;
import br.com.diogomurano.clans.services.member.MemberServiceImpl;
import org.bukkit.plugin.java.JavaPlugin;

public class DMClans extends JavaPlugin {

    private static DMClans instance;

    private ClanService clanService;
    private MemberService memberService;
    private InviteService inviteService;

    @Override
    public void onLoad() {
        instance = this;

        this.clanService = new ClanServiceImpl();
        this.memberService = new MemberServiceImpl();
        this.inviteService = new InviteServiceImpl();
    }

    public static DMClans getInstance() {
        return instance;
    }

    public ClanService getClanService() {
        return clanService;
    }

    public MemberService getMemberService() {
        return memberService;
    }

    public InviteService getInviteService() {
        return inviteService;
    }
}
