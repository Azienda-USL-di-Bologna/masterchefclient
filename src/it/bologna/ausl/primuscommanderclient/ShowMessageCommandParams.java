package it.bologna.ausl.primuscommanderclient;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class ShowMessageCommandParams extends PrimusCommandParams {
    public static enum Types {
        ERROR("error"),
        WARNING("warning"),
        NOTICE("notice"),
        SUCCESS("success");
        
        private final String key;

        Types(String key) {
            this.key = key;
        }

        public static Types fromString(String key) {
            return key == null
                    ? null
                    : Types.valueOf(key.toUpperCase());
        }

        public String getKey() {
            return key;
        }
    }

    public ShowMessageCommandParams(String title, String text, boolean sticky, Types type) {
        super();
        json.put("title", title);
        json.put("text", text);
        json.put("sticky", sticky);
        json.put("type", type.getKey());
    }

    @Override
    public String getCommand() {
        return "showMessage";
    }
}
