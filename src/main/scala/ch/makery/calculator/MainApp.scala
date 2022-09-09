package ch.makery.calculator

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.application.JFXApp.PrimaryStage
import scalafxml.core.{FXMLLoader, NoDependencyResolver}
import scalafx.Includes._
import scalafx.scene.image.Image
import javafx.{scene => jfxs}
import scalafx.animation.PauseTransition
import scalafx.util.Duration
import java.net.URL


object MainApp extends JFXApp{
  val rootResource = getClass.getResource("view/RootLayout.fxml")
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  loader.load()
  val roots = loader.getRoot[jfxs.layout.BorderPane]

  // initialize stage
  stage = new PrimaryStage {
    title = "Scientific Calculator "
    icons += new Image("file:resources/images/calculator.jpg")
    scene = new Scene(700,500) {
      root = roots
    }
  }

   def showFrontPage() = {
    val resource = getClass.getResource("view/FrontPage.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showLoadingScreen(): Unit = {
    val resource = getClass.getResource("view/LoadingScreen.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
    new PauseTransition(Duration(3000)){
      onFinished = handle {
        showFrontPage()
      }
    }.play()
  }

   def showGame(): Unit = {
    val resource = getClass.getResource("view/Calculator.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

    def showAboutPage(): Unit = {
    val resource = getClass.getResource("view/AboutPage.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  
    def showPythagoreanPage(): Unit = {
    val resource = getClass.getResource("view/PythagoreanConverter.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  }

  def showAnglePage(): Unit = {
      val resource = getClass.getResource("view/AngleConverter.fxml")
      val loader = new FXMLLoader(resource, NoDependencyResolver)
      loader.load()
      val roots = loader.getRoot[jfxs.layout.AnchorPane]
      this.roots.setCenter(roots)
    }

   def showMassPage(): Unit = {
      val resource = getClass.getResource("view/MassConverter.fxml")
      val loader = new FXMLLoader(resource, NoDependencyResolver)
      loader.load()
      val roots = loader.getRoot[jfxs.layout.AnchorPane]
      this.roots.setCenter(roots)
    }

showLoadingScreen()
}