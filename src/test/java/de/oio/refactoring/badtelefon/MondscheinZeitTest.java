package de.oio.refactoring.badtelefon;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Falk Sippach, falk@jug-da.de, @sippsack
 */
public class MondscheinZeitTest {
    @Test
    public void testMondscheinZeit() {
        Assert.assertTrue(Kunde.isMondschein(8));
        Assert.assertTrue(Kunde.isMondschein(19));
    }
}
