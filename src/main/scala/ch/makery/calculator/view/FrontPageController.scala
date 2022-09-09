package ch.makery.calculator.view

import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import ch.makery.calculator.MainApp
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.media.{Media, MediaPlayer}


@sfxml
class FrontPageController(private val background: ImageView){
//   val path: String = getClass.getResource("file://C:/Users/User/Assignment/resources/music/firework.mp3").toString
//  //val media = new Media("file:resources/music/firework.mp3")
//   val media = new Media(path)
//val mediaPlayer = new MediaPlayer(media)
  // mediaPlayer.setCycleCount(MediaPlayer.Indefinite)
  // mediaPlayer.play()
  background.image = new Image("file:resources/images/background.jpg")



  def handlePlay (action: ActionEvent): Unit = {
    MainApp.showGame()
  }

  def handleAbout (action: ActionEvent): Unit = {
    MainApp.showAboutPage()
  }

  def handleExit (action: ActionEvent): Unit = {
    System.exit(0)
  }
}