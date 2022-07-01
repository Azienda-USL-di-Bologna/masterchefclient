package it.bologna.ausl.primuscommanderclient;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class LogoutCommandParams extends PrimusCommandParams {

    public LogoutCommandParams() {
        super();
    }

    @Override
    public String getCommand() {
        return "logout";
    }
}
