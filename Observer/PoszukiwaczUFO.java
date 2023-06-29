package Observer;

import LiczbyPierwszeAlgorytmy.TestPierwszosci;
import NWDAlgorytmy.NWD;

public abstract class PoszukiwaczUFO {
    protected TestPierwszosci testPierwszosci;
    protected NWD nwd;

    // przeprowadza testy wykrywające i informuje o podejrzanej aktywnosci
    public abstract void doAnalyze();
}
