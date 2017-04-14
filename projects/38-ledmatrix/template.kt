//
// Template for LED matrix animation
// 

import org.otfried.cs109ui.ImageCanvas
import org.otfried.cs109.Color
import java.awt.image.BufferedImage

// --------------------------------------------------------------------

// Put the student ids of all members of your team in the following list.
// It is enough if one of you submits the file.

val authors = listOf(20169999, 20168888)

// Put the speed at which your animation is designed to be enjoyed
// (in milliseconds)

val designSpeed = 100

// --------------------------------------------------------------------

// global variables to control the animation

// put your global variables here

// --------------------------------------------------------------------

// setup() is called once to set up your animation:

fun setup() {
  // setup your global variables
}

// --------------------------------------------------------------------

// loop() is called in regular intervals to compute the next frame
// of the animation.
// The argument leds is a bitmap of size 32 x 16.
// loop() needs to draw the next frame of the animation on this bitmap.
// Black means LED off, anything else means LED on.
// The bitmap is already cleared to black before loop() is called.
// If loop() returns true, then the animation ends.

fun loop(leds: BufferedImage): Boolean {
  val g = ImageCanvas(leds)
  g.setColor(Color.RED)
  // do some drawing
  g.done()

  // after drawing the current image, update global variables

  // indicate whether the animation is finished
  return false
}

// --------------------------------------------------------------------
