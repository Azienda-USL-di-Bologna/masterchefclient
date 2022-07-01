package it.bologna.ausl.primuscommanderclient;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class RefreshActivitiesCommandParams extends PrimusCommandParams {

    public RefreshActivitiesCommandParams() {
        super();
    }

    @Override
    public String getCommand() {
        return "refreshActivities";
    }
}
