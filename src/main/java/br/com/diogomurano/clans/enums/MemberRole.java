package br.com.diogomurano.clans.enums;

public enum MemberRole {

    NONE("Nenhum"),
    MEMBER("Membro"),
    RECRUITER("Recrutador"),
    ADMINISTRATOR("Administrador"),
    LEADER("Líder");

    private String name;

    MemberRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static MemberRole byName(String name) {
        for (MemberRole roles : values()) {
            if (roles.getName().equalsIgnoreCase(name)) {
                return roles;
            }
        }
        return null;
    }

    public static MemberRole byId(int id) {
        for (MemberRole roles : values()) {
            if (roles.ordinal() == id) {
                return roles;
            }
        }
        return null;
    }
}
