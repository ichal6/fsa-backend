package pl.aogiri.hhu.fsa.backend.auth.user.enums;

import java.util.List;

public enum Privilege {
    DEFAULT;

    public static List<Privilege> getDefaults() {
        return List.of(DEFAULT);
    }
}
