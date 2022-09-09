package ch.makery.calculator.view

import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import ch.makery.calculator.MainApp
import scalafx.scene.image.{Image, ImageView}


@sfxml
class AboutPageController(
  private val backgroundAbout: ImageView,
  ){

  backgroundAbout.image = new Image("file:resources/images/about.png")

  def handleBack (action: ActionEvent): Unit = {
    MainApp.showFrontPage()
  }
}