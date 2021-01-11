package Audio.Commands;

public interface CommandWithResult<TResult> extends Command {

    public TResult getResult();
}
