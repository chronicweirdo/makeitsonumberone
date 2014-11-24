package org.chronicweirdo.patcher.fileops;

/**
 * Created by scacoveanu on 11/24/2014.
 */
public class Action {
    public void execute() {
        // action executes itself
    }

    public enum Type {
        FILE_MOVE, FILE_DELETE
    }

    private Type type;
    private String source;
    private String destination;

    public static Action move(String source, String destination) {
        Action action = new Action();
        action.setType(Type.FILE_MOVE);
        action.setSource(source);
        action.setDestination(destination);
        return action;
    }

    public static Action delete(String source) {
        Action action = new Action();
        action.setType(Type.FILE_DELETE);
        action.setSource(source);
        return action;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
