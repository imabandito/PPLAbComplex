package Audio;

import Audio.Commands.Command;
import Audio.Commands.CommandWithResult;

import java.util.List;

//Invoker
public class Client {
    private CommandWithResult<Integer> calcAudioDurationCommand;
    private CommandWithResult<List<AudioFile>> orderByGenreCommand;
    private CommandWithResult<List<AudioFile>> rangeDurationCommand;

    public Client(CommandWithResult<Integer> calcAudioDurationCommand, CommandWithResult<List<AudioFile>> orderByGenreCommand,
                  CommandWithResult<List<AudioFile>> rangeDurationCommand) {
        this.calcAudioDurationCommand = calcAudioDurationCommand;
        this.orderByGenreCommand = orderByGenreCommand;
        this.rangeDurationCommand = rangeDurationCommand;
    }

    public void setCalcAudioDurationCommand(CommandWithResult<Integer> calcAudioDurationCommand) {
        this.calcAudioDurationCommand = calcAudioDurationCommand;
    }

    public void setOrderByGenreCommand(CommandWithResult<List<AudioFile>> orderByGenreCommand) {
        this.orderByGenreCommand = orderByGenreCommand;
    }

    public void setRangeDurationCommand(CommandWithResult<List<AudioFile>> rangeDurationCommand) {
        this.rangeDurationCommand = rangeDurationCommand;
    }

    public CommandWithResult<Integer> getCalcAudioDurationCommand() { return calcAudioDurationCommand; }
    public Command getOrderByGenreCommand() { return orderByGenreCommand; }
    public CommandWithResult<List<AudioFile>> getRangeDurationCommand() { return rangeDurationCommand; }

    public Integer calculateAudioDuration (){
        calcAudioDurationCommand.execute();
        return calcAudioDurationCommand.getResult();
    }
    public void orderAudioByGenre (){
        orderByGenreCommand.execute();
    }
    public List<AudioFile> rangeByDuration(){
        rangeDurationCommand.execute();
        return rangeDurationCommand.getResult();
    }
}