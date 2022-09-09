package ch.makery.calculator.view

import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import ch.makery.calculator.MainApp
import scalafx.scene.text.Text
import scalafx.scene.control.TextField
import scalafx.scene.image.{Image, ImageView}
import scala.math._
import scala.collection.mutable.ListBuffer


@sfxml
class AngleController(
     private val backgroundAngle: ImageView,
     private val imageFormula: ImageView,
     private val imageCircle: ImageView,
     private val textFieldD: TextField,
     private val textFieldR: TextField,
     private var degree: String,
     private var radian: String,
     private var convertDegree: Double,
     private var convertRadian: Double,
     private var calculation: Double,
     private var result: String,
     private var text2: Text
     ){
        var list = ListBuffer[String]()
        var count = 0
        backgroundAngle.image = new Image("file:resources/images/white2.png")
        imageFormula.image = new Image("file:resources/images/degreetoradianformula.png")
        imageCircle.image = new Image("file:resources/images/degreetoradian.png")

    def handleBack (action: ActionEvent): Unit = {
            MainApp.showGame()
    }

    def clearTextField(){
        textFieldD.setText("")
        textFieldR.setText("")
    }

     def calculate(){
            if (textFieldD.getText() != "" && textFieldR.getText() == ""){
                try{
                    degree = textFieldD.getText()
                    convertDegree = degree.toDouble
                    calculation = convertDegree * (3.142/180)
                    result = calculation.toString
                    textFieldR.setText("")
                    textFieldR.appendText(result + " rad")
                    list += convertDegree + " * (3.142/180) = " + result + "\n"
                }catch{
                    case x: NumberFormatException =>
                    textFieldR.setText("")
                    textFieldR.appendText("Error")
             }
            }
            else if (textFieldD.getText() == "" && textFieldR.getText() != ""){
                try{
                    radian = textFieldR.getText()
                    convertRadian = radian.toDouble
                    calculation = convertRadian * (180/3.142)
                    result = calculation.toString
                    textFieldD.setText("")
                    textFieldD.appendText(result + "°")
                    list += convertRadian + " * (180/3.142) = " + result + "\n"           
                }catch{
                    case x: NumberFormatException =>
                    textFieldD.setText("")
                    textFieldD.appendText("Error")
                }
            }
            text2.text = ""
            for(x <- 0 until list.length){
                    text2.text = text2.text() + list(x)
                    count = count + 1
                if (x == 1){
                    list.remove(0)
                    text2.text = text2.text() + list(x)
                    count = 0
                }
                }
            }
    }
