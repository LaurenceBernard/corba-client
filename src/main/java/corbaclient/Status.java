package corbaclient;

public enum Status {
    NOT_REGISTERED((short) 1),
    GUESSED_CORRECTLY((short) 2),
    GUESSED_WRONGLY((short) 3),
    GAME_OVER((short) 4),
    WON_THE_GAME((short) 5);

    private short code;

    private Status(short code) {
        this.code = code;
    }

    public short getCode() {
        return code;
    }

    public static Status getByCode(short code) {
        Status[] statuses = Status.values();
        for (Status s : statuses) {
            if (s.getCode() == code) {
                return s;
            }
        }
        return null;
    }
}