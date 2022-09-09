package ch.makery.calculator.view

import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import ch.makery.calculator.MainApp
import scalafx.application.JFXApp.PrimaryStage




@sfxml
class RootLayoutController{

    //Menu item Close
    def handleExit (action: ActionEvent): Unit = {
        System.exit(0)
    }

    def handleBack (action: ActionEvent): Unit = {
        MainApp.showFrontPage()
        
    }

    def handleAbout (action: ActionEvent): Unit = {
       MainApp.showAboutPage()
    }
}  