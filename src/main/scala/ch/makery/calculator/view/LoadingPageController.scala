package ch.makery.calculator.view

import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import ch.makery.calculator.MainApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.image.{Image, ImageView}



@sfxml 
class LoadingPageController(
    private val backgroundLoading: ImageView
    ){
    backgroundLoading.image = new Image("file:resources/images/background.jpg")
}