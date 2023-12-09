package mai.team5.lab3;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import junit.framework.TestCase;

import org.junit.Test;

public class SoundViewModelTest extends TestCase {
    private BeatBox mBeatBox;
    private Sound mSound;
    private SoundViewModel mSubject;

    public void setUp() throws Exception {
        super.setUp();
        mBeatBox = mock(BeatBox.class);
        mSound = new Sound("assetPath");
        mSubject = new SoundViewModel(mBeatBox);
        mSubject.setSound(mSound);
    }
    @Test
    public void exposesSoundNameAsTitle() {
        assertThat(mSubject.getTitle(), is(mSound.getName()));
    }
    @Test
    public void callsBeatBoxPlayOnButtonClicked() {
        mSubject.onButtonClicked();

        verify(mBeatBox).play(mSound);
    }
}