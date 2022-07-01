package it.bologna.ausl.primuscommanderclient;

/**
 *
 * @author Giuseppe De Marco (gdm)
 */
public class RefreshBoxDatiDiArchivioCommandParams extends PrimusCommandParams {

    public RefreshBoxDatiDiArchivioCommandParams() {
        super();
    }

    @Override
    public String getCommand() {
        return "refreshBoxDatiDiArchivio";
    }
}
