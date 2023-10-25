package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {


  @Test
  void fire_Success(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1);

    // Act
    boolean result = store.fire(1);

    // Assert
    assertEquals(true, result);
  }

  @Test
  void fire_uses_torpedo(){
    TorpedoStore store = new TorpedoStore(1);

    store.fire(1);
    assertEquals(0,store.getTorpedoCount());
  }

  @Test
  void negative_torpedo(){
    TorpedoStore store = new TorpedoStore(1);

    assertThrowsExactly(IllegalArgumentException.class, ()->store.fire(-1));
  }

  @Test
  void not_enough_torpedo(){
    TorpedoStore store = new TorpedoStore(1);

    assertThrowsExactly(IllegalArgumentException.class, ()->store.fire(2));
  }

  @Test
  void torpedo_empty(){
    TorpedoStore store = new TorpedoStore(0);
    assertEquals(true,store.isEmpty());
  }
    
}
