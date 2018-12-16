package piano;

import java.util.ArrayList;
import java.util.Date;

import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.Pitch;
import music.NoteEvent;

public class PianoMachine {

    private Midi midi;

    Instrument current_ins;
    int Octave=0;
    boolean recording=false;
    ArrayList<Pitch> arrayP = new ArrayList<>();
    ArrayList<NoteEvent> events = new ArrayList<>();
    long prevEventTime = (new Date()).getTime();
    boolean firstTime = true;
    /**
     * constructor for PianoMachine.
     *
     * initialize midi device and any other state that we're storing.
     */
    public PianoMachine() {
        try {
            midi = Midi.getInstance();
            current_ins = midi.DEFAULT_INSTRUMENT;
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }

    //TODO write method spec
    public void beginNote(Pitch rawPitch) {
//    	midi.beginNote(new Pitch(0).toMidiFrequency());
        //TODO implement for question 1
        rawPitch = rawPitch.transpose(Octave);
        if( !arrayP.contains(rawPitch)){
            midi.beginNote(rawPitch.toMidiFrequency(), current_ins);
            arrayP.add(rawPitch);
        }

        recordEvent(rawPitch, current_ins, true);
    }

    //TODO write method spec
    public void endNote(Pitch rawPitch) {
//    	midi.endNote(new Pitch(0).toMidiFrequency());
        //TODO implement for question 1
        rawPitch = rawPitch.transpose(Octave);
        if(arrayP.contains(rawPitch)) {
            midi.endNote(rawPitch.toMidiFrequency(), current_ins);
            arrayP.remove(rawPitch);
        }

        recordEvent(rawPitch, current_ins, false);
    }

    //TODO write method spec
    public void changeInstrument() {
        current_ins = current_ins.next();
        //TODO: implement for question 2

    }

    //TODO write method spec
    public void shiftUp() {
        //TODO: implement for question 3
        if(Octave<=12) {
            Octave += 12;
        }

    }

    //TODO write method spec
    public void shiftDown() {
        //TODO: implement for question 3
        if(Octave>=-12) {
            Octave -= 12;
        }
    }

    //TODO write method spec
    public boolean toggleRecording() {
        //TODO: implement for question 4
        recording = !recording;
        if(recording == true) {
            events = new ArrayList<>();
            prevEventTime = (new Date()).getTime();
            firstTime = true;
        }
        return recording;

    }

    //TODO write method spec
    public void playback() {
        //TODO: implement for question 4
        for(NoteEvent n:events) {
            midi.rest(Math.round(n.getTime()/10));
            int note = n.getPitch().toMidiFrequency();
            Instrument ins = n.getInstr();
            boolean noteOn = n.getKind() == NoteEvent.Kind.start;
            if(noteOn) {
                midi.beginNote(note, ins);
            } else {
                midi.endNote(note, ins);
            }
        }
    }

    //adding function
    private void recordEvent(Pitch note, Instrument current_ins, boolean isNoteOn) {
        if(firstTime) {
            prevEventTime = (new Date()).getTime();
            firstTime = false;
        }
        long time = (new Date()).getTime();
        if(recording) {
            long duration = time-prevEventTime;
            if(isNoteOn) {
                NoteEvent n = new NoteEvent(note, duration, current_ins, NoteEvent.Kind.start);
                events.add(n);
            } else {
                NoteEvent n = new NoteEvent(note, duration, current_ins, NoteEvent.Kind.stop);
                events.add(n);
            }
            prevEventTime = time;
        }

    }
}
