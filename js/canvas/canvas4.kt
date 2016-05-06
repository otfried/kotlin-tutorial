package canvas

import org.otfried.cs109js.JsCanvas
import org.otfried.cs109.Color

import kotlin.browser.window
import org.w3c.dom.events.*

object Controller {
  val canvas = JsCanvas("canvas")
  // change canvas size to fill entire browser window
  init {
    canvas.canvas.width = window.innerWidth.toInt() - 20
    canvas.canvas.height = window.innerHeight.toInt() - 50
  }

  var x = 30.0
  var y = 50.0
  var alpha = 45.0
  var animate = false
  var timeStamp = 0.0
  
  fun draw() {
    canvas.save()
    canvas.clear(Color.WHITE)
    canvas.setAlpha(48)
    canvas.setColor(Color.GREEN)
    canvas.drawRectangle(10.0, 10.0, 100.0, 100.0)
    canvas.setAlpha(255) // opaque
    for (i in 0 .. 5) {
      for (j in 0 .. 5) {
        canvas.setColor(Color(Math.floor(255-42.5*i), Math.floor(255-42.5*j), 0))
        canvas.drawRectangle(150.0 + j*25.0, i*25.0, 25.0, 25.0)
      }
    }
    canvas.translate(x, y)
    canvas.setAlpha(128)
    canvas.rotate(alpha)
    canvas.setColor(Color.RED)
    canvas.setFont(32.0)
    canvas.drawText("Lovely", 0.0, 0.0)
    canvas.restore()
    if (animate)
      window.requestAnimationFrame { animate(it) }
  }

  fun animate(s: Double) {
    val delta = s - timeStamp
    timeStamp = s
    x += delta / 2.0
    if (x > canvas.width)
      x = 0.0
    alpha += 0.3 * delta
    if (alpha >= 360.0)
      alpha = 0.0
    draw()
  }

  fun keyDown(e: Event) {
    val ek = e as KeyboardEvent
    var k = ek.key
    if (k === undefined)
      k = "${ek.keyCode.toChar().toLowerCase()}"
    when (k) {
    "a" -> x -= 3
    "s" -> x += 3
    "w" -> y -= 3
    "z" -> y += 3
    "j" -> alpha += 10.0
    "k" -> alpha -= 10.0
    "g" -> {
        if (!animate)
          timeStamp = window.performance.now()
        animate = !animate
    }
    else -> return
    }
    draw()
    e.preventDefault()
  }
  
  fun mouseDown(e: Event) {
    val em = e as MouseEvent
    x = em.offsetX
    y = em.offsetY
    draw()
  }
}

fun start() {
  println("Canvas3 starting...")
  println("Active keys are aswzjk and g for animation")
  Controller.draw()
  window.addEventListener("keydown", { Controller.keyDown(it) }, true)
  window.addEventListener("mousedown", { Controller.mouseDown(it) }, true)
}
