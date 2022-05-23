package com.apavlidi.provider;

import static java.util.Arrays.asList;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

  public static final Music MUSIC_1 = new Music("perfectMusic1", "A1", 2001);
  public static final Music MUSIC_2 = new Music("perfectMusic2", "A2", 2002);

  public final List<Music> MUSICS = asList(MUSIC_1, MUSIC_2);

  @GetMapping(value = "/music/{musicId}", produces = "application/json")
  public ResponseEntity<Music> retrievePost(@PathVariable Integer musicId) {
    try {
      final Music music = MUSICS.get(musicId);
      return new ResponseEntity<>(music, HttpStatus.OK);
    } catch (IndexOutOfBoundsException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
